/*
 * Lisans bilgisi icin lutfen proje ana dizinindeki zemberek2-lisans.txt dosyasini okuyunuz.
 */

/*
 * Created on 13.Eyl.2005
 *
 */
//package net.zemberek.kullanim;
package app_with_pooka;

import java.util.List;
import java.util.*;

import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Alfabe;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.Kok;
import net.zemberek.yapi.ek.Ek;

public class TestCozumle {

    //private static Zemberek zemberek;
    private static char I = Alfabe.CHAR_ii;
    private static char S = Alfabe.CHAR_ss;

    public static ArrayList<String> cozumle(String str) {
        ArrayList<String> liste=new ArrayList<String>();
        Zemberek zemberek;
        zemberek = new Zemberek(new TurkiyeTurkcesi());
        if (zemberek.kelimeDenetle(str) == true) {
            Kelime[] sonuc = zemberek.kelimeCozumle(str);
            liste.add("Oluşan çözümleme sayısı: " + sonuc.length);
            for (Kelime kelime: sonuc) {
                Kok kok = kelime.kok();
                liste.add("Kok :" + kok.icerik() + " Tipi : " + kok.tip().toString());
                List<Ek> ekler = kelime.ekler();
                if (ekler != null) {
                    liste.add("Ekler:");
                    for (int j = 0; j < ekler.size(); j++) {
                        Ek ek = ekler.get(j);
                        liste.add("Ek-" + j + " : " + ek.ad());
                    }
                }
            }
            liste.add("\n");
        } else {
            liste.add(str + " Türkçe değil");
        }
        return liste;
    }

    public static void main(String[] args) {
        //zemberek = new Zemberek(new TurkiyeTurkcesi());
        System.out.println(cozumle("kedi"));
        System.out.println(cozumle("kediciklerin"));
        System.out.println(cozumle("getirttirebilirsiniz"));
        System.out.println(cozumle("Çekoslovakyal"+I+"la"+S+"t"+I+"rabileceklerimizdenseniz"));
        System.out.println(cozumle("Mrhaba"));
    }
}
