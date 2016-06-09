/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app_with_pooka;

import net.suberic.pooka.*;
import net.suberic.pooka.AddressBookManager.*;
import net.suberic.pooka.AlternativeAttachment;
import net.suberic.pooka.Attachment;
import net.suberic.pooka.BackendMessageFilter;
import net.suberic.pooka.DateFormatter;
import net.suberic.pooka.ExternalLauncher;
import net.suberic.pooka.FileSignatureGenerator;
import net.suberic.pooka.FolderInfo;
import net.suberic.pooka.FullMailcapCommandMap;
import net.suberic.pooka.MBPAttachment;
import net.suberic.pooka.MailQueue;
import net.suberic.pooka.MailUtilities;
import net.suberic.pooka.MessageCryptoInfo;
import net.suberic.pooka.MessageFilter;
import net.suberic.pooka.MessageInfo;
import net.suberic.pooka.MultiMessageInfo;
import net.suberic.pooka.NetworkConnection;
import net.suberic.pooka.NetworkConnectionManager;
import net.suberic.pooka.NewMessageInfo;
import net.suberic.pooka.NoTrashFolderException;
import net.suberic.pooka.OperationCancelledException;
import net.suberic.pooka.OutgoingFolderInfo;
import net.suberic.pooka.OutgoingMailServer;
import net.suberic.pooka.OutgoingMailServerManager;
import net.suberic.pooka.Pooka;
import net.suberic.pooka.PookaEncryptionManager;
import net.suberic.pooka.PookaLogManager;
import net.suberic.pooka.PookaManager;
import net.suberic.pooka.PopInboxFolderInfo;
import net.suberic.pooka.RowCounter;
import net.suberic.pooka.SearchTermManager;
import net.suberic.pooka.SignatureGeneratorImpl;
import net.suberic.pooka.StartupManager;
import net.suberic.pooka.StoreInfo;
import net.suberic.pooka.StoreManager;
import net.suberic.pooka.StringSignatureGenerator;
import net.suberic.pooka.UIDFolderInfo;
import net.suberic.pooka.UIDMimeMessage;
import net.suberic.pooka.UpdatableMBP;
import net.suberic.pooka.UserProfile;
import net.suberic.pooka.UserProfileManager;
import net.suberic.pooka.VirtualFolderInfo;
import net.suberic.pooka.messaging.*;
import net.suberic.pooka.resource.*;
import net.suberic.pooka.htmlparser.PookaStringBean;
import net.suberic.pooka.gui.*;
import net.suberic.pooka.filter.*;
import net.suberic.pooka.event.*;
import net.suberic.pooka.crypto.*;
import net.suberic.pooka.cache.*;
import net.suberic.pooka.thread.*;
import net.suberic.pooka.ssl.*;
import net.suberic.pooka.vcard.*;
import net.suberic.pooka.ldap.*;
import net.suberic.pooka.jdbcaddr.*;
import net.suberic.util.*;
import net.suberic.util.DynamicAbstractAction;
import net.suberic.util.FileVariableBundle;
import net.suberic.util.ItemListChangeEvent;
import net.suberic.util.ItemManager;
import net.suberic.util.JDBCVariableBundle;
import net.suberic.util.PreferencesVariableBundle;
import net.suberic.util.ValueChangeAdapter;
import net.suberic.util.VariableBundle;
import net.suberic.util.*;
import net.suberic.util.DynamicAbstractAction;
import net.suberic.util.FileVariableBundle;
import net.suberic.util.ItemListChangeEvent;
import net.suberic.util.ItemManager;
import net.suberic.util.JDBCVariableBundle;
import net.suberic.util.PreferencesVariableBundle;
import net.suberic.util.ValueChangeAdapter;
import net.suberic.util.VariableBundle;
import net.suberic.util.cache.*;
import net.suberic.util.event.*;
import net.suberic.util.gui.*;
import net.suberic.util.prefs.*;
import net.suberic.util.swing.*;
import net.suberic.util.thread.*;
import java.util.*;
import javax.swing.*;

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

/**
 *
 * @author Kenan Savas
 */
public class App_with_pooka {

    /**
     * Ana fonksiyon olup, burada once yeni bir Pooka nesnesi create edilmekte
     * ve onun main foksiyonu cagrilarak da Pooka e-posta istemci uygulamasi
     * calistirilmaktadir. ayrica Pooka arabirimi calistiginda dosyalarinin iceren 
     * dizin yol bilgisi de Pooka metotlari ile alinarak MainForm ana program
     * cagrilmasinda bu yol bilgisi ana programa paramtere olarak aktarilarak
     * tum eposta dosya islemlerinde kullanilmaktadir.
     * 
     * dikkat Pooka ile calisirken mutlaka bilinmelidir ki eklenilen eposta hesabi
     * icin ayarlardan cache mode ayari full disconnect support secilmelidir ki
     * tum eposta bilgileri bu programda offline olarak ve ilgili diizn yol bilgisi 
     * altındaki eposta bilgileri iceren eml tipindeki dosyalari kullanir. dosya isimleri
     * sadece baslik bilgisi ve diger alanlari iceren zaman, from, to bilgi bilgileri
     * iceren dosyalar icin isim _hdr ile biterken, tum email bilgisini diger
     * alanlar ve content dahil icerirse bu dosyalarin ismi _msg son eki ile bitmektedir.
     * 
     * onemli husus sudur ki projede pek cok jar library dosyasinin projeye dahil
     * edildigi gorulebilir. cunku bazi libraryler icin ucanaccess 
     * (ms access veritabanina baglanti icin), bazi libraryler de natty 
     * (her turlu istenilen formatta verilen bir tarih zaman bilgisini parse etmek icin ki, 
     * ms access veritabanina epostalarin tarih bilgisi ozellikle bu durumla 
     * ilgili rutinler icin cok ugras ile istenilen sekilde problemsiz 
     * kaydedilebilmektedir.) kutuphanesi icindir.
     * 
     * en son olarak bu metot ile MainForm nesnesi uzerinden ana arayüz program 
     * penceresi iceren nesne create edilerek ekrana getirilmektedir.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Pooka pookaObject=new Pooka();
    
        pookaObject.main(args);
        
        //VariableBundle variableBundle=pookaObject.getResources();
        
        //net.suberic.pooka.filter.FilterAction filter=net.suberic.pooka.
        
        //NetworkConnectionManager networkConManager= pookaObject.getConnectionManager();
        
        //Vector vectorList=new Vector();
        //vectorList=networkConManager.getConnectionList();
        //System.out.println(networkConManager);
        
        PookaManager pookaManager=pookaObject.getPookaManager();
        
        //System.out.println("Pooka belgelerim dizin yolu: "+pookaManager.getLocalrc());
        //System.out.println("Pooka yerel dizin yolu: "+pookaManager.getPookaRoot().toString()+"\n");

        //PookaMessageListener pookaMessageListener=pookaManager.getMessageListener();
        //MainPanel mainPanel=pookaObject.getMainPanel();
        //FolderPanel folderPanel=mainPanel.getFolderPanel();
        //UserProfileManager userProfileManager=pookaManager.getUserProfileManager();
        //List mailPropertiesList=userProfileManager.getMailPropertiesList();
        //System.out.println(mailPropertiesList);
        
        MainForm mainJFrame=new MainForm(pookaManager.getPookaRoot().toString()+"\\.pooka");
        mainJFrame.setVisible(true);
    
    }
    
}
