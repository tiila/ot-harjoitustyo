package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    //lisää vielä sopivat tarvittavat testit jacocon mukaan
    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test //Oma testi 1
    public void kortinAlkusaldoOnOikein() {
        assertEquals(1000, kortti.saldo());
    }

    @Test //Oma testi 2
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(1500);
        //kortin saldo nyt 2500.0
        assertEquals(2500, kortti.saldo());
    }

    @Test //Oma testi 3 (otaRahaa())
    public void saldoVaheneeOikeinKunRahaaRiittavasti() {
        kortti.otaRahaa(900);
        assertEquals(100, kortti.saldo());
    }

    @Test //Oma testi 4 (otaRahaa())
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(1100);
        assertEquals(1000, kortti.saldo());
    }

    @Test //Oma testi 5 (otaRahaa(), palauttaa true, jos rahat riittivät ja muuten false)
    public void otaRahaaPalauttaaOikeanArvon() {
        assertEquals(true, kortti.otaRahaa(500));
        assertEquals(false, kortti.otaRahaa(1100));
    }

    @Test // Oma testi 6 (toString(), palauttaa oikean arvon)
    public void toStringPalautusToimii() {
        assertEquals("saldo: 10.0", kortti.toString());

    }

}
