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

<img src = "https://github.com/Maijjay/ot-harjoitustyo/blob/master/dokumentointi/kuvat/LaivojenAsettaminen.png">
(Sekvenssikaavio kuvastaa metodin firstTurn toimintaa.)


Kun peli käynnistetään, luokka State suorittaa metodin determineFirstTurn() ja tämän jälkeen metodin firstTurn(). Oletetaan, että pelaaja1 aloittaa pelin. Tällöin firstTurn() metodi kutsuu ensin pelaajan1 metodia initializeShip(), tämä metodi kysyy pelaajalta syötteet(int x, int y, boolean horizontal) ja kutsuu pelaaja luokan omaa metodia setNewShip(x, y, horizontal) jos pelaajan antamat syötteet olivat oikeanlaiset. Pelaajalla on Grid -olio johon laiva laitetaan. Metodi setNewShip(...) siis kutsuu siis grid.addShip() joka palauttaa true jos laivan asettaminen ruudukkoon onnistui. Jos laivan lisääminen onnistui kasvatetaan pelaaja luokan shipSize -muuttujaa yhdellä. Tämä sykli toistuu niin kauan kun shipSize on 5, eli laivoja on asetettu ruudukkoon onnistuneesti 5 kappaletta. Kun pelaaja1 on asettanut laivansa State luokan metodi firstTurn() suorittaa saman pelaajalle 2.

#### Pelaajan vuoro
<img src = "https://github.com/Maijjay/ot-harjoitustyo/blob/master/dokumentointi/kuvat/Vuoro.png">
(Sekvenssikaavio kuvastaa metodin turn toimintaa.)

Kun pelaajat ovat laittaneet vuoroillaan laivat ruudukkoihin on aika aloittaa itse peli. Luokka State suorittaa metodin turn(). Metodi sisältää molempien pelaajien vuoron suorittamiseen omat if -lauseet. Oletetaan, että pelaaja 1 aloittaa pelin. Mennään siis metodissa turn() ensimmäisen if -lauseen sisään. Se tulostaa, että on pelaajan 1 vuoro ja sen jälkeen ruudukon, missä näkyy pelaajan 1 mahdolliset aikaisemmat arvaukset. If lauseen sisällä on while looppi, jonka sisällä pysytään kunnes pelaaja osuu huti tai voittaa pelin.
  
  Seuraaksi metodi kutsuu luokan Player metodia askCoordinatesForTheHit(), tämä metodi kysyy pelaajalta koordinaatit ja kutsuu Player luokan metodia hit(int x, int y), jos annetut koordinaatit olivat kelvolliset (kysytään uudelleen kunnes ne ovat). Player luokan metodi hit(x, y) tarkastaa onko kyseiseen ruutuun jo lyöty kutsumalla Grid luokan metodia isSquareHit(x, y), jos ruutuun on jo lyöty palataan kysymään uusia koordinaatteja. 
   
   Jos ruutuun ei ole vielä lyöty niin metodi kutsuu Grid luokan metodia hit(x, y). Grid luokan metodi hit(x, y) käy ruudukon läpi ja katsoo onko kyseisessä kohdassa laivaa. Jos laiva löytyy, peli ilmoittaa osumasta tulosteella "You hit!" ja merkitsemällä ruutuun "X". Tämän jälkeen tarkastetaan luokalta Ship onko laiva elossa kutsumalla metodia getIsAlive(), koko laivan upotessa vähennetään muuttujasta shipsLeft yksi. Jos mihinkään laivaan ei taas lyöty niin peli tulostaa "You missed!" ja laittaa ruutun "O". 
   
   Luokan Grid metodi hit(x, y) palauttaa nyt sitä kutsuneelle metodille true jos pelaaja osui laivaan. Näin palataan siis takaisin State luokkaan asti metodiin turn(). Tässä metodissa ollaan vieläkin while loopin sisällä ja koska osuma on onnistunut pelaaja saa uuden vuoron. Ennenkuin uudet koordinaatit kysytään, niin loopin sisällä tarkastatetaan Player luokan getShipsLeft() metodilta onko kaikki laivat upotettu, missä tapauksessa pelaaja tietenkin voittaa ja peli loppuu.
   
   Oletetaan nyt, että pelaaja 1 arvaa koordinaatit missä ei ole vastustajan laivaa. Tällöin metodille turn() palautetaan false ja se kutsuu State luokan metodia changeTurn(), mikä muuttaa muuttujan currentPlayer nyt numeroksi kaksi ja kutsuu jälleen metodia turn(). Näin siirrytää pelaajan 1 vuorosta pelaajan 2 vuoroon. Tätä vuorojen vaihtoa jatkuu kunnes toinen pelaajista voittaa pelin.

## Käyttöliittymä

Käyttöliittymänä toimii tekstikäyttöliittymä. Tekstikäyttöliittymä ottaa pelaajalta vastaan inputteja kuten koordinaatit laivojen asettamiseen ja laivojen lyömiseen. TKL mm. tulostaa ohjeet pelin pelaamiseen, pelaajien ruudukoita, kysyy pelaajien inputteja ja kertoo kun peli on voitettu. Käyttöliittymää olisi sinänsä syytä parantaa tai eriyttää omaan luokkaansa, koska sen toiminnallisuudet on sisälletty pelin logiikasta vastaaviin luokkiin.




