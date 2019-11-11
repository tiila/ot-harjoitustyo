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
public class MaksukorttiTest { //Testiluokan nimen on aina pääsyttävä "Test"
    
    //Huom. Pidä testit toisistaan riippumattomina!
    //Huom. 2, Huomioi erilaiset alkutilanteet
    //Huom. 3, Huomioi rivikattavuus
    //Huom. 4, Mieti, onko hyvä käyttää assertThat
    //Huom. 5, assertEquals(odotettu, metodinAntamaTulos)

    //Testien kohteena oleva olio talletetaan täällä, jotta testimetodit voivat nähdä setUp:n luoman maksukortin!
    Maksukortti kortti;

    public MaksukorttiTest() {
    }

    @BeforeClass //Suoritetaan ennen kuin testaus aloitetaan (ei tarvita tässä)
    public static void setUpClass() { 
    }

    @AfterClass //Suoritetaan kun testaus on päättynyt  (ei tarvita tässä)
    public static void tearDownClass() {
    }

    @Before //Tämä suoritetaan ennen jokaista testitapausta!
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @After //Suoritetaan jokaisen testin jälkeen  (ei tarvita tässä)
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void hello() {
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());

    }

    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {
        kortti.syoMaukkaasti();
        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        // nyt kortin saldo on 2
        kortti.syoEdullisesti();
        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }

    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }

    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }
    
    //Tehtava, oma testi
    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi() {
        kortti.syoEdullisesti(); //-2.5
        kortti.syoEdullisesti(); //-2.5
        kortti.syoEdullisesti(); //-2.5
        // nyt kortin saldo on 2.5
        kortti.syoMaukkaasti(); //Ei pitäisi vähentää mitään, sillä menisi miinukselle
        assertEquals("Kortilla on rahaa 2.5 euroa", kortti.toString());
    }
    
    //Tehtava, oma testi 2
    @Test
    public void negatiivinenLatausEiMuutaKortinSaldoa() {
        kortti.lataaRahaa(-5); //Ei pitäisi muuttaa kortin saldoa (10)
        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }
    
    //Tehtava, oma testi 3
    @Test
    public void voiOstaaEdullisenLounaanJosLoppusaldoNolla() {
        kortti.syoEdullisesti(); //-2.5
        kortti.syoEdullisesti(); //-2.5
        kortti.syoEdullisesti(); //-2.5
        kortti.syoEdullisesti(); //-2.5
        // nyt kortin saldo on 0
        assertEquals("Kortilla on rahaa 0.0 euroa", kortti.toString());
    }
    
    //Tehtava, oma testi 4
    @Test
    public void voiOstaaMaukkaanLounaanJosLoppusaldoNolla() {
        kortti.lataaRahaa(2); //Nyt kortin saldo on 12
        kortti.syoMaukkaasti(); //-4
        kortti.syoMaukkaasti(); //-4
        kortti.syoMaukkaasti(); //-4
        // nyt kortin saldo on 0
        assertEquals("Kortilla on rahaa 0.0 euroa", kortti.toString());
    }
    
}
