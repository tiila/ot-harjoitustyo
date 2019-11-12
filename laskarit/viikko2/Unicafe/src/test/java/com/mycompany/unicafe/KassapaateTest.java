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
    /*
    
Tee testit jotka testaavat ainakin seuraavia asioita:

* luodun kassapäätteen rahamäärä ja myytyjen lounaiden määrä on oikea (rahaa 1000, lounaita myyty 0)
* käteisosto toimii sekä edullisten että maukkaiden lounaiden osalta
-jos maksu riittävä: kassassa oleva rahamäärä kasvaa lounaan hinnalla ja vaihtorahan suuruus on oikea
-jos maksu on riittävä: myytyjen lounaiden määrä kasvaa
-jos maksu ei ole riittävä: kassassa oleva rahamäärä ei muutu, kaikki rahat palautetaan vaihtorahana ja myytyjen lounaiden määrässä ei muutosta
* seuraavissa testeissä tarvitaan myös Maksukorttia jonka oletetaan toimivan oikein
* korttiosto toimii sekä edullisten että maukkaiden lounaiden osalta
- jos kortilla on tarpeeksi rahaa, veloitetaan summa kortilta ja palautetaan true
- jos kortilla on tarpeeksi rahaa, myytyjen lounaiden määrä kasvaa
- jos kortilla ei ole tarpeeksi rahaa, kortin rahamäärä ei muutu, myytyjen lounaiden määrä muuttumaton ja palautetaan false
* kassassa oleva rahamäärä ei muutu kortilla ostettaessa
* kortille rahaa ladattaessa kortin saldo muuttuu ja kassassa oleva rahamäärä kasvaa ladatulla summalla
 
- Varmista jacocon avulla, että kassapäätteen testeillä on 100% lause- ja haaraumakattavuus! 
    
- Talleta kohdassa testikattavuus olevan kuvan tyylinen screenshot projektisi kattavuusraportista palautusrepositoriosi hakemistoon laskarit/viikko2.

- Muista tallentaa tekemäsi muutokset gitiin ja työntää ne Githubiin (git push).

- Muista tehdä myös lopus Maksukortti-testit
    
    */
    
    
    
    
    public KassapaateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
