/*
 * Lisans bilgisi icin lutfen proje ana dizinindeki zemberek2-lisans.txt dosyasini okuyunuz.
 */

/*
 * Created on 11.Eyl.2005
 *
 */
//package net.zemberek.kullanim;
package app_with_pooka;

import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;

public class TestHecele {

    public static void heceYaz(String[] heceler) {
        for (int i = 0; i < heceler.length; i++) {
            System.out.print(heceler[i]);
            if (i < heceler.length - 1) {
                System.out.print(" - ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Zemberek zemberek = new Zemberek(new TurkiyeTurkcesi());
        heceYaz(zemberek.hecele("Merhaba"));
        heceYaz(zemberek.hecele("javacılardanmış"));
        heceYaz(zemberek.hecele("Türklerin"));
    }
}
