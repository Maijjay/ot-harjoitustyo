# Laivanupotus
<img src = "https://github.com/Maijjay/ot-harjoitustyo/blob/master/dokumentointi/kuvat/untitled.png">
Laivanupotus on kahden pelaajan strateginen arvauspeli, missä on tarkoitus upottaa vastustajan laivat. Ohjelma arpoo pelin käynnistäessä kumpi pelaaja aloittaa. Pelaajat asettavat laivansa omille ruudukoilleen ja sen jälkeen arvaavat vuorotellen toisen pelaajan laudalta koordinaatteja, tarkoituksena osua vastustajan laivoihin. Pelin voittaa se pelaaja, joka on ensimmäisenä upottanut vastustajan kaikki laivat. 
 
### Dokumentaatio
  * [Vaatimusmäärittely](https://github.com/Maijjay/ot-harjoitustyo/blob/master/dokumentointi/m%C3%A4%C3%A4rittelydokumentti.md)
  * [Arkkitehtuurikuvaus](https://github.com/Maijjay/ot-harjoitustyo/blob/master/dokumentointi/Arkkitehtuurikuvaus.md) 
  * [Työaikakirjanpito](https://github.com/Maijjay/ot-harjoitustyo/blob/master/dokumentointi/tyoaikakirjanpito.md)
  * [Käyttöohjeet](https://github.com/Maijjay/ot-harjoitustyo/blob/master/dokumentointi/K%C3%A4ytt%C3%B6ohje.md)


### Releaset
 * [Viikko 5](https://github.com/Maijjay/ot-harjoitustyo/releases/tag/viikko5)
 * [Viikko 6](https://github.com/Maijjay/ot-harjoitustyo/releases/tag/viikko6)
 
### Komentorivillä suorittettavat komennot
  
  #### Jar tiedoston generointi
   * Ohjelmasta voidaan tehdä .jar tiedosto komennolla: ```mvn package```
   
  #### Ohjelman suorittaminen
   * Ohjelma voidaan suorittaa komennolla: ```java -jar Battleship.jar```
 
  #### Testien suorittaminen
   * Testien suoritus komennolla: ```mvn test```
   * Testikattavuusraportti luodaan komennolla:```mvn jacoco:report``` 
   (raporttia voi tarkastella selaimella ja se löytyy: target/site/jacoco/index.html)
  
  #### Checkstyle
   * Checkstyleraportti luodaan komennolla: ```mvn jxr:jxr checkstyle:checkstyle ```
     (raporttia voi tarkastella selaimella ja se löytyy: target/site/checkstyle.html)

  #### JavaDoc
  * JavaDoc voidaan generoida komennolla: ```mvn javadoc:javadoc```
    (raporttia voi tarkastella selaimella ja se löytyy: target/site/apidocs/index.html)

  
  
