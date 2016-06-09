/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_with_pooka;

  import javax.mail.BodyPart;
  import javax.mail.Message;
  import javax.mail.internet.MimeMultipart;
  import org.jsoup.Jsoup;

import net.zemberek.islemler.KelimeUretici;
import net.zemberek.araclar.JaroWinkler;
import net.zemberek.araclar.MetinAraclari;
import net.zemberek.araclar.TimeTracker;
import net.zemberek.araclar.turkce.TurkceMetinOkuyucu;
import net.zemberek.erisim.Zemberek;
import net.zemberek.istatistik.DosyaRaporlayici;
import net.zemberek.istatistik.HeceIstatistikleri;
import net.zemberek.istatistik.Istatistikler;
import net.zemberek.istatistik.KonsolRaporlayici;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Alfabe;
import net.zemberek.yapi.DilBilgisi;
import net.zemberek.yapi.ek.Ek;
import net.zemberek.yapi.ek.EkYonetici;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.KelimeTipi;
import net.zemberek.yapi.Kok;
import net.zemberek.yapi.TurkceDilBilgisi;

import java.util.*;
import java.util.regex.*;

import java.io.*;

/**
 *
 * @author Kenan Savas
 */
public class util {
    
    /**
     * Message tipindeki parametre olarak verilen email bilgisinden metin, html 
     * ya da multipart yapida olmasina gore eposta icerik bilgisini icinden 
     * cikararak String tipinde geriye dondurur.
     * @param message Message tipinde eposta parametre bilgisi
     * @return String tipinde geri donus degeri
     * @throws Exception 
     */
    public static String getTextFromMessage(Message message) 
        throws Exception {
        if (message.isMimeType("text/plain")){
            return message.getContent().toString();
        }else if (message.isMimeType("multipart/*")) {
            String result = "";
            MimeMultipart mimeMultipart = (MimeMultipart)message.getContent();
            int count = mimeMultipart.getCount();
            for (int i = 0; i < count; i ++){
                BodyPart bodyPart = mimeMultipart.getBodyPart(i);
                if (bodyPart.isMimeType("text/plain")){
                    result = result + "\n" + bodyPart.getContent();
                    break;  //without break same text appears twice in my tests
                } else if (bodyPart.isMimeType("text/html")){
                    String html = (String) bodyPart.getContent();
                    result = result + "\n" + Jsoup.parse(html).text();

                }
            }
            return result;
        }
        return "";
    }
    
    /**
     * String tipinde parametre olarak verilen bir bilginin icinde yer alan tum 
     * URL bilgilerini (http, ftp gibi) List<String> tipinde bir liste olarak geriye dondurur. 
     * @param text String tipinde icinden URL bilgileri ayıklanacak parametre bilgisi
     * @return List<String> tipinde liste olarak veriler iceren geri donus bilgisi
     */
    public static List<String> extractUrls(String text)
    {
        /*
        
        // Pattern for recognizing a URL, based off RFC 3986
        private static final Pattern urlPattern = Pattern.compile(
                "(?:^|[\\W])((ht|f)tp(s?):\\/\\/|www\\.)"
                        + "(([\\w\\-]+\\.){1,}?([\\w\\-.~]+\\/?)*"
                        + "[\\p{Alnum}.,%_=?&#\\-+()\\[\\]\\*$~@!:/{};']*)",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
        
        Matcher matcher = urlPattern.matcher("foo bar http://example.com baz");
        while (matcher.find()) {
            int matchStart = matcher.start(1);
            int matchEnd = matcher.end();
            // now you have the offsets of a URL match
        }        
        */
        
        List<String> containedUrls = new ArrayList<String>();
        String urlAddress=null;
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            urlAddress=text.substring(urlMatcher.start(0),urlMatcher.end(0));
            urlAddress=urlAddress.replaceAll("<br", "");
            containedUrls.add(urlAddress);
        }

        return containedUrls;
    }
    
    /**
     * String tipinde parametre olarak verilen bir bilginin icinde yer alan tum 
     * eposta bilgilerini List<String> tipinde bir liste olarak geriye dondurur. 
     * @param text String tipinde icinden eposta bilgileri ayıklanacak parametre bilgisi
     * @return List<String> tipinde liste olarak veriler iceren geri donus bilgisi
     */
    public static List<String> extractEmails(String text)
    {
        /*
        String regex = ".*(\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b).*";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher("your text here");
        if (m.matches()) {
            String email = m.group(1);
            //do somethinfg with your email
        }
        */
        List<String> containedEmails = new ArrayList<String>();
        StringTokenizer stringTokenizer=null;
        String emailAddress=null;
        String urlRegex = ".*(\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b).*";
        //String urlRegex = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}\\b";        
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find())
        {
            stringTokenizer=new StringTokenizer(text.substring(urlMatcher.start(0),urlMatcher.end(0)),"<> ,;");
            while(stringTokenizer.hasMoreTokens()){
                emailAddress=new String(stringTokenizer.nextToken());
                emailAddress=emailAddress.replaceAll("\"", "");
                emailAddress=emailAddress.replaceAll("\n", "");
                emailAddress=emailAddress.replaceAll("'", "");
                emailAddress=emailAddress.replaceAll("mailto:", "");
                emailAddress=emailAddress.replaceAll("from:", "");
                emailAddress=emailAddress.replaceAll("to:", "");
                emailAddress=emailAddress.replaceAll("From:", "");
                emailAddress=emailAddress.replaceAll("To:", "");
                emailAddress=emailAddress.replaceAll("MIME-Version:", "");
                emailAddress=emailAddress.replaceAll("mime-version:", "");
                emailAddress=emailAddress.replaceAll("Mime-Version:", "");                
                emailAddress=emailAddress.trim();
                if (emailAddress.indexOf("@")!=-1 && emailAddress.indexOf("*")==-1 && emailAddress.indexOf("@")!=0 && emailAddress.indexOf("=")==-1){
                    stringTokenizer=new StringTokenizer(emailAddress,"@");
                    String tempStr=new String(stringTokenizer.nextToken());
                    System.out.println("tempStr: "+tempStr);
                    System.out.println("isHexNumber(tempStr): "+isHexNumber(tempStr));
                    System.out.println("tempStr.length(): "+tempStr.length());
                    if (!(isHexadecimal(tempStr) && tempStr.length()==32))
                        containedEmails.add(emailAddress);
                }
            }
        }

        return containedEmails;
    }

    /**
     * string bir ifade hex deger ise true aksi halde false doner
     * ancak duzgun calismadi
     * @param text kontrol edilecek String tipinde giris verisi
     * @return geri donus degeri boolean tipinde
     */
    //20160523, http://stackoverflow.com/questions/11424540/verify-if-string-is-hexadecimal
    public static boolean isHexNumber(String text) {
        try {
          Long.parseLong(text, 16);
          return true;
        }
        catch (NumberFormatException ex) {
          // Error handling code...
          return false;
        }
    }

    /**
     * string bir ifade hex deger ise true aksi halde false doner
     * @param text kontrol edilecek String tipinde giris verisi
     * @return geri donus degeri boolean tipinde
     */
    //20160523, http://stackoverflow.com/questions/11424540/verify-if-string-is-hexadecimal
    public static boolean isHexadecimal(String text) {
        //boolean isHex = mac_addr.matches("^[0-9a-fA-F]+$");
        //boolean isNumeric = str.matches("\\p{XDigit}+");

        text = text.trim();

        char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'D', 'E', 'F' };

        int hexDigitsCount = 0;

        for (char symbol : text.toCharArray()) {
            for (char hexDigit : hexDigits) {
                if (symbol == hexDigit) {
                    hexDigitsCount++;
                    break;
                }
            }
        }

        return true ? hexDigitsCount == text.length() : false;
    }

    /**
     * bir dizin yol bilgisi verilerek o dizin icindeki tum klasor ve dosya 
     * bilgilerini ArrayList<String> tipinde liste seklinde geriye dondurur.
     * @param path String tipinde icinde dizin ve dosyalar listelenecek dizin yol bilgisi
     * @param isDirsShown boolean tipinde eger sonuclara klasorler de dahil edilecek ise true verilmelidir.
     * @param isFilesShown boolean tipinde eger sonuclara dosyalar da dahil edilecek ise true verilmelidir.
     * @return 
     */
    public static ArrayList<String> getAllFiles(String path, boolean isDirsShown, boolean isFilesShown) {
        
        ArrayList<String> filesdirsList=new ArrayList<String>();
        int dirCount=0;
        int fileCount=0;
        
        //System.out.println("Path Parameter: "+path);
        
        File curDir = new File(path);
        File[] filesList = curDir.listFiles();
        for(File f : filesList){
            if(f.isDirectory()){
                if (isDirsShown)
                    filesdirsList.add(f.getName());
                dirCount++;
                //System.out.println("Dir-"+dirCount+": "+f.getName());
            }
            if(f.isFile()){
                if (isFilesShown)
                    filesdirsList.add(f.getName());
                fileCount++;
                //System.out.println("File-"+fileCount+": "+f.getName());
            }
        }
        return filesdirsList;

    }
    
}
