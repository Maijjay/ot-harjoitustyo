package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    Kassapaate kassa;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
        kassa = new Kassapaate();
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void KortinSaldoAlussaOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void saldonKasvatusToimii() {
        kortti.lataaRahaa(1000);
        assertEquals("saldo: 10.10", kortti.toString());
    }

//     @Test
//    public void saldonKasvatusNegatiivisellasummallaEiToimi() {
//        kortti.lataaRahaa(-1000);
//        assertEquals("saldo: 10.0", kortti.toString());
//    }
    @Test
    public void syoEdullisestiToimii() {
        kortti.lataaRahaa(990);
        Kassapaate k = new Kassapaate();
        k.syoEdullisesti(kortti);
        assertEquals("saldo: 7.60", kortti.toString());
    }

    @Test
    public void syoMaukkaastiToimii() {
        kortti.lataaRahaa(990);
        kassa.syoMaukkaasti(kortti);
        assertEquals("saldo: 6.0", kortti.toString());
    }

    @Test
    public void saldoEiMuutuJosRahaEiRiita() {
        kassa.syoEdullisesti(kortti);
        kassa.syoMaukkaasti(kortti);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void otaRahaaPalauttaaOikeinFalse() {
        assertFalse(kortti.otaRahaa(110));
    }

    @Test
    public void otaRahaaPalauttaaOikeinTrue() {
        kortti.lataaRahaa(1000);
        assertTrue(kortti.otaRahaa(500));
    }

}
