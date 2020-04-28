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
Kun peli käynnistetään 

## Käyttöliittymä

Käyttöliittymänä toimii tekstikäyttöliittymä ja siitä on mahdollista asettaa ruudukkoon laivat sekä suorittaa osumia.

