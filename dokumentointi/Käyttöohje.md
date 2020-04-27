# Käyttöohje

### Ohjelman käynnistäminen

* Ohjelma käynnistetään komennolla: java -jar.battleship.

## Yleistä

* Ohjelmassa on tekstikäyttöliittymä. Kun pelin käynnistää se kertoo aluksi ohjeet pelin pelaamiseen.
Pelissä on kaksi pelaajaa ja pelin alussa ohjelma arpoo kumpi pelaaja aloittaa. 
Pelilauta eli ruudukko on kokoa 10x10, on kuitenkin huomattava, että ruuduko alkaa nollasta ja loppuu yhdeksään. Laivat ovat kokoa 1x1, 2x1, 3x1, 4x1 ja 5x1. 

## Laivan asettaminen ruudukkoon.

* Molemmat pelaajat asettavat vuorollaan omat laivansa ruudukkoon. Ensin laitetaan laiva joka on kooltaan 1x1, sitten 2x1 ja niin edelleen kunnes kaikki 5 laivaa on laitettu ruudukkoon.
Laiva asetetaan ruudukkoon antamalla syötteenä koordinaatit x ja y sekä true tai false. Koordinaatit kuvastavat laivan päädyn paikkaa ruudukossa. Jos pelaaja laittaa syötteeseen true, laiva 
asetetaan vaakasuoraan ja falsella taas pystysuoraan. Tämän jälkeen tulostuu pelilauta, jossa juuri asetettu laita on kuvattu "1" -merkeillä.

* Esimerkki: Pelaaja 2 laittaa laivan kohtaan [0, 0].

```
Insert ship. Input: x y horizontal. Example: 1 2 true. Ships length is 1.
0 0 true
Ship added
 1  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 ```
 ## Pelaajan vuoro
 
 * Kun on pelaajan vuoro, hän syöttää ensin koordinaatin x ja sitten y. Jos molemmat ovat lukuja 0-9, syöte hyväksytään ja peli kertoo osuiko pelaaja laivaan vai ohi.
 Jos pelaaja osui laivaan, osuma merkitään pelaajan pelilaudalle "X" -merkillä, osuessa ohi "O" -merkillä. 
 Peli kertoo erikseen jos laiva on uponnut. Pelaaja saa uuden vuoron jos osui laivaan.
 
 * Esimerkki: Pelaaja 1 ampuu kohtaan [0, 0]

```
 Player 1's turn
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
 _  _  _  _  _  _  _  _  _  _ 
Give coordinates:
Insert x: 0
Insert y: 0
You hit!
Ship has sunk
```
* Pelaaja 1 saa uuden vuoron ja kohtaan [0, 0] tulee "X".

## Pelin voittaminen

* Pelin voittaa kun toinen pelaaja upottaa kaikki toisen pelaajan laivat. 


 
 
 
 
