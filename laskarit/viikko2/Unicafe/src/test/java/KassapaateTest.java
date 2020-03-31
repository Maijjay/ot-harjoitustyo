import com.mycompany.unicafe.Kassapaate;
import com.mycompany.unicafe.Maksukortti;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {
    Maksukortti kortti;
    Kassapaate kassa;

    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
        kassa = new Kassapaate();
    }
    
    @Test
    public void kassanRahamaaraJaMyydytLounaatTasmaavat() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, (kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty())); 
    }
    
    @Test
    public void oikeaMaaraMyytyjaEdullisiaLounaita(){
        kassa.syoEdullisesti(240);
        kassa.syoEdullisesti(240);
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }    
    
    @Test
    public void oikeaMaaraMyytyjaMaukkaitaLounaita(){
      kassa.syoMaukkaasti(400);
      kassa.syoMaukkaasti(400);
      assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void edullisestaOstostaOikeaMaaraVaihtorahaa(){
        assertEquals(260, kassa.syoEdullisesti(500));
        assertEquals(100240, kassa.kassassaRahaa());
    }
    
    @Test
    public void maukkaastaOstostaOikeaMaaraVaihtorahaa(){
        assertEquals(100, kassa.syoMaukkaasti(500));
        assertEquals(100400, kassa.kassassaRahaa());
    }
    
    @Test
    public void edullisenOstoEiOnnistoJosLiianVahanRahaa(){
        assertEquals(20, kassa.syoEdullisesti(20));
    }
    
    @Test
    public void maukkaanOstoEiOnnistoJosLiianVahanRahaa(){
         assertEquals(20, kassa.syoMaukkaasti(20));
    }
    
   @Test
    public void syoEdullisestiKortiltaToimii() {
        Kassapaate k = new Kassapaate();
        k.syoEdullisesti(kortti);
        assertEquals("saldo: 7.60", kortti.toString());
    }

    @Test
    public void syoMaukkaastiKortiltaToimii() {
        kassa.syoMaukkaasti(kortti);
        assertEquals("saldo: 6.0", kortti.toString());
    }
    
    @Test
    public void rahanLatausKortilleOnnistuu(){
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(101000, kassa.kassassaRahaa());
        assertEquals(2000, kortti.saldo());
    }
    
    @Test
    public void rahanLatausKortilleEiOnnistu() {
        kassa.lataaRahaaKortille(kortti, -100);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(1000, kortti.saldo());
    }

}
