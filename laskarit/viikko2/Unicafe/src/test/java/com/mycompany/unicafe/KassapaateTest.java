package com.mycompany.unicafe;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dell
 */
public class KassapaateTest {

    Kassapaate paate;
    Maksukortti korttiEiTarpeeksiSaldoa;
    Maksukortti korttiSaldoaRiittaa;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        korttiEiTarpeeksiSaldoa = new Maksukortti(100);
        korttiSaldoaRiittaa = new Maksukortti(10000);
    }

    @Test
    public void uudessaKassassaOnOikeaSumma() {
        assertEquals(100000, paate.kassassaRahaa());
    }

    @Test
    public void uudenKassanTilastotOvatOikein() {
        int edullisia = paate.edullisiaLounaitaMyyty();
        int maukkaita = paate.maukkaitaLounaitaMyyty();
        int lounaitamyyty = edullisia + maukkaita;
        assertEquals(0, lounaitamyyty);

    }

    @Test
    public void syoEdullisestiToimiiKunKateismaksuOnRiittava() {
        paate.syoEdullisesti(250);
        assertEquals(100240, paate.kassassaRahaa()); //Lisaa oikean summan kassaan
        int palautus = 250 - 240;
        assertEquals(10, palautus); //Palauttaa oikean summan
        assertEquals(1, paate.edullisiaLounaitaMyyty()); //Lisää myydyn lounaan tilastoon

    }

    @Test
    public void syoEdullisestiToimiiKunKateismaksuEiRiittava() {
        paate.syoEdullisesti(230);
        assertEquals(100000, paate.kassassaRahaa()); //Ei lisää kassaan rahaa
        assertEquals(0, paate.edullisiaLounaitaMyyty()); //Ei lisää mitään tilastoihin
        assertEquals(230, paate.syoEdullisesti(230)); //Palauttaa koko maksun

    }

    @Test
    public void syoMaukkaastiToimiiKunKateismaksuOnRiittava() {
        paate.syoMaukkaasti(420);
        assertEquals(100400, paate.kassassaRahaa());
        int palautus = 420 - 400;
        assertEquals(20, palautus); //Palauttaa oikean summan
        assertEquals(1, paate.maukkaitaLounaitaMyyty()); //Lisää myydyn lounaan tilastoon

    }

    @Test
    public void syoMaukkaastiToimiiKunKateismaksuEiRiittava() {
        paate.syoMaukkaasti(390);
        assertEquals(100000, paate.kassassaRahaa()); //Ei lisää kassaan rahaa
        assertEquals(0, paate.maukkaitaLounaitaMyyty()); //Ei lisää mitään tilastoihin
        assertEquals(390, paate.syoMaukkaasti(390)); //Palauttaa koko maksun

    }

    /*
    
    public boolean syoEdullisesti(Maksukortti kortti) {
        if (kortti.saldo() >= 240) {
            kortti.otaRahaa(240);
            this.edulliset++;
            return true;
        } else {
            return false;
        }
    }

     */
    @Test
    public void syoEdullisestiToimiiKunKortillaOnKatetta() {
        paate.syoEdullisesti(korttiSaldoaRiittaa);
        int kortinsaldo = korttiSaldoaRiittaa.saldo();
        assertEquals(9760, kortinsaldo); //Ottaa rahaa kortilta
        assertEquals(100000, paate.kassassaRahaa()); //Kassan rahamaara ei muutu
        assertEquals(1, paate.edullisiaLounaitaMyyty()); //Lisää myydyn lounaan tilastoon
        assertEquals(true, paate.syoEdullisesti(korttiSaldoaRiittaa));
    }

    @Test
    public void syoEdullisestiToimiiKunKortillaEiKatetta() {
        paate.syoEdullisesti(korttiEiTarpeeksiSaldoa);
        assertEquals(100000, paate.kassassaRahaa()); //Kassan rahamaara ei muutu
        assertEquals(100, korttiEiTarpeeksiSaldoa.saldo()); //Kortin rahamaara ei muutu
        assertEquals(0, paate.edullisiaLounaitaMyyty()); //Ei lisää mitään tilastoihin
        assertEquals(false, paate.syoEdullisesti(korttiEiTarpeeksiSaldoa));
    }

    @Test
    public void syoMaukkaastiToimiiKunKorttillaOnKatetta() {
        paate.syoMaukkaasti(korttiSaldoaRiittaa);
        int kortinsaldo = korttiSaldoaRiittaa.saldo();
        assertEquals(9600, kortinsaldo); //Ottaa rahaa kortilta
        assertEquals(100000, paate.kassassaRahaa()); //Kassan rahamaara ei muutu
        assertEquals(1, paate.maukkaitaLounaitaMyyty()); //Lisää myydyn lounaan tilastoon
        assertEquals(true, paate.syoMaukkaasti(korttiSaldoaRiittaa));

    }

    @Test
    public void syoMaukkaastiToimiiKunKortillaEiKatetta() {
        paate.syoMaukkaasti(korttiEiTarpeeksiSaldoa);
        assertEquals(100000, paate.kassassaRahaa()); //Kassan rahamaara ei muutu
        assertEquals(100, korttiEiTarpeeksiSaldoa.saldo()); //Kortin rahamaara ei muutu
        assertEquals(0, paate.edullisiaLounaitaMyyty()); //Ei lisää mitään tilastoihin
        assertEquals(false, paate.syoMaukkaasti(korttiEiTarpeeksiSaldoa));
    }

    @Test
    public void kortinLatausToimiiPositiivisellaSummalla() {
        paate.lataaRahaaKortille(korttiSaldoaRiittaa, 1000);
        assertEquals(101000, paate.kassassaRahaa()); //Kassan summa kasvaa
        assertEquals(11000, korttiSaldoaRiittaa.saldo()); //Kortin saldo muuttuu

    }

    @Test
    public void kortinLatausToimiiNegatiivisellaSummalla() {
        paate.lataaRahaaKortille(korttiSaldoaRiittaa, -1000);
        assertEquals(100000, paate.kassassaRahaa()); //Kassan summa ei muutu
        assertEquals(10000, korttiSaldoaRiittaa.saldo()); //Kortin saldo ei muutu

    }
}

/*
package com.mycompany.unicafe;

public class Kassapaate {

    private int kassassaRahaa;
    private int edulliset;
    private int maukkaat;

    public Kassapaate() {
        this.kassassaRahaa = 100000;
    }

    public void lataaRahaaKortille(Maksukortti kortti, int summa) {
        if (summa >= 0) {
            kortti.lataaRahaa(summa);
            this.kassassaRahaa += summa;
        } else {
            return;
        }
    }

    public int kassassaRahaa() {
        return kassassaRahaa;
    }

}
 */

 /*

    
Tee testit jotka testaavat ainakin seuraavia asioita:
- Varmista jacocon avulla, että kassapäätteen testeillä on 100% lause- ja haaraumakattavuus! 

- Talleta kohdassa testikattavuus olevan kuvan tyylinen screenshot projektisi kattavuusraportista palautusrepositoriosi hakemistoon laskarit/viikko2.

- Muista tallentaa tekemäsi muutokset gitiin ja työntää ne Githubiin (git push).

 */
