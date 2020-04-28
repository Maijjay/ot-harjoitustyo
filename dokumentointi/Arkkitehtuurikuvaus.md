# Arkkitehtuurikuvaus

## Rakenne

Koodin luokka/pakkauskaavio on seuraava: 

<img src = "https://github.com/Maijjay/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Battleship%20package%20diagram.png">

## Sovelluslogiikka

Sovelluslogiika muodostavat luokat State, Player, Grid ja Ship. 
State on vastuussa toiminnallisten kokonaisuuksien suorittamisesta:
  * Aloittavan pelaajan arpominen metodilla determineFirstTurn()
  * Laivojen asettaminen ruudukkoihin pelin alussa metodilla FirstTurn()
  * Vuorojen suorittaminen metodilla turn()

### Päätoiminnallisuudet

#### Pelin aloitus

<img>

Kun peli käynnistetään, luokka State suorittaa metodin determineFirstTurn() ja tämän jälkeen metodin firstTurn(). Oletetaan, että pelaaja1 aloittaa pelin. Tällöin firstTurn() metodi kutsuu ensin pelaajan1 metodia initializeShip(), tämä metodi kysyy pelaajalta syötteet(int x, int y, boolean horizontal) ja kutsuu pelaaja luokan omaa metodia setNewShip(x, y, horizontal) jos pelaajan antamat syötteet olivat oikeanlaiset. Pelaajalla on Grid -olio johon laiva laitetaan. Metodi setNewShip(...) siis kutsuu siis grid.addShip() joka palauttaa true jos laivan asettaminen ruudukkoon onnistui. Jos laivan lisääminen onnistui kasvatetaan pelaaja luokan shipSize -muuttujaa yhdellä. Tämä sykli toistuu niin kauan kun shipSize on 5, eli laivoja on asetettu ruudukkoon onnistuneesti 5 kappaletta. Kun pelaaja1 on asettanut laivansa State luokan metodi firstTurn() suorittaa saman pelaajalle 2.

## Käyttöliittymä

Käyttöliittymänä toimii tekstikäyttöliittymä ja siitä on mahdollista asettaa ruudukkoon laivat sekä suorittaa osumia.









