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

import net.zemberek.erisim.Zemberek;
import net.zemberek.islemler.KokBulucu;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.Kok;
import net.zemberek.yapi.ek.Ek;

public class TestOner {

    private static Zemberek zemberek;

    public static void cozumle(String str) {
        if (zemberek.kelimeDenetle(str) == true) {
            Kelime[] sonuc = zemberek.kelimeCozumle(str);
            System.out.println("Oluşan çözümleme sayisi: " + sonuc.length);
            for (Kelime kelime : sonuc) {
                Kok kok = kelime.kok();
                System.out.println("Kök :" + kok.icerik() + "\nTipi : " + kok.tip().toString());
                List<Ek> ekler = kelime.ekler();
                if (ekler != null) {
                    System.out.println("Ekler:");
                    for (int j = 0; j < ekler.size(); j++) {
                        Ek ek = ekler.get(j);
                        System.out.println("Ek-" + j + " : " + ek.ad());
                    }
                }
            }
            System.out.println();
        } else {
            String[] oneriler = zemberek.oner(str);
            if (oneriler.length!=0) {
                System.out.println(str + " Türkçe değil, öneri üretiliyor:");
                for (int i = 0; i < oneriler.length; i++) {
                    System.out.println("Öneri-" + " : " + oneriler[i]);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        zemberek = new Zemberek(new TurkiyeTurkcesi());
        cozumle("ve");
        cozumle("kırtasiyecilik");
        cozumle("kitaplik");
        cozumle("deneme");
        cozumle("Mrhaba");
        cozumle("teknolokiler");
        cozumle("seil");
    }
}
