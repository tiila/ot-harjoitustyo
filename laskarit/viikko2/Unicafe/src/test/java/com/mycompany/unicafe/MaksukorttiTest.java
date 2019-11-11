package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    //lisää vielä sopivat tarvittavat testit jacocon mukaan
    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test //Oma testi 1
    public void kortinAlkusaldoOnOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test //Oma testi 2
    public void lataaminenKasvattaaSaldoaOikein() {
        kortti.lataaRahaa(15);
        //kortin saldo nyt 25.0
        assertEquals(25, kortti.saldo());
    }

    @Test //Oma testi 3 (otaRahaa())
    public void saldoVaheneeOikeinKunRahaaRiittavasti() {
        kortti.otaRahaa(9);
        assertEquals(1, kortti.saldo());
    }

    @Test //Oma testi 4 (otaRahaa())
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        kortti.otaRahaa(11);
        assertEquals(10, kortti.saldo());
    }

    @Test //Oma testi 5 (otaRahaa(), palauttaa true, jos rahat riittivät ja muuten false)
    public void palauttaaOikeanArvon() {
        assertEquals(true, kortti.otaRahaa(5));
        assertEquals(false, kortti.otaRahaa(11));
    }

}
