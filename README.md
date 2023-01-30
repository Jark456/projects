# Avaruustietokeskus - projekti

## Yleinen tiivistelmä

Ohjelma on suunniteltu harrastus- ja oppimistarkoitukseen. Ohjelman on tarkoitus toimia eräänlaisena ”tietokeskuksena” , josta käyttäjä voi hakea tietoa eri taivaankappaleista avaruudessa.

Nykyinen versio sisältää laskurin, jolla voi leikkimielisesti laskea kuinka kauan tietyllä nopeudella kestäisi matkata millekin taivaankappaleelle. Myöhemmin toteutusvaiheessa on tietokanta-näkymä, joka sisältää käyttäjälle näkyvän listan eri taivaankappaleista. Tästä listasta käyttäjä voi selata tai etsiä tarkempia kuvauksia tietystä kohteesta.

**Ohjelman tarkoituksena** on, että se helpottaa käyttäjiä löytämään tietoa eri taivaankappaleista yksinkertaisesta tietokannasta.

**Tekninen toteutus:** Java ja sen graafinen käyttöliittymäkirjasto Swing. Tietokannan toteutuksessa tullaan käyttämään SQL:llää

**Projektin tila:** keskeneräinen, johtuen sen puuttuvista ominaisuuksista ja yleisistä parannuksista.

## Käyttöskenaariot

Tarkastellaan hieman yleisiä käyttöskenaarioita, mitä käyttäjän oletetaan tekevän:

**Käyttäjä laskee matkan tietylle taivaankappaleelle:** 

Valitsee kohteen mihin haluaa matkustaa → Kirjoittaa tekstikenttään nopeutensa taivaankappaletta kohden km/h → Painaa ”Laske” -näppäintä, jolloin ilmestyy ponnahdusikkuna, jossa ilmoitetaan matkan kesto. 


**Käyttäjä haluaa tarkastella tietokannasta kohteita:** 

Klikkaa ”planeetta-tietokanta”- painiketta →  avautuu uusi näkymä → Käyttäjä näkee taulukon kohteista ja voi tarkastella niitä selaamalla listaa → Käyttäjä valitsee kursorilla tietyn kohteen listasta → listan sivuun ilmestyy tarkempi kuvaus kohteesta.




## Ominaisuudet: 

**Laskuri**

- Laskee matkan keston maapallolta valittuun kohteeseen.
- Ilmoittaa ajan ponnahdusikkunalla vuosissa, kuukausissa ja päivissä.

**Tietokantanäkymä:**

Ei vielä toteutusta

### Ehdotuksia uusista ominaisuuksista ja parannuksista, joita voisi tehdä seuraaville versioille: 

**Laskuri:**

- Kun laskuria käyttää, näytölle voisi tulla informaatiota siitä, mitä matka vaatii matkustajalta, jotta hän voi turvallisesti matkata taivaankappaleelle, sekä millaiset asuinolosuhteet siellä vallitsevat.

- Hauska kaksiulotteinen animaatio siitä kun ”hahmo” lähtee matkalle maapallolta, ja saapuu kohteeseen.

**Tietokantanäkymä (ei toteutettu):**

- Käyttäjä pystyy etsimään laajasta tietokannasta hakusanalla haluamansa taivaankappaleen.
- Käyttäjä voi järjestää taivaankappaleet taulusta esimerkiksi planeetan tyypin (esim. kiviplaneetta) perusteella.
- Käyttäjä valitsee tietyn kohteen listasta ja viereen päivittyy infoteksti kohteen ominaisuuksista.
- Käyttäjä voi lisätä kohteen myös havaitut – listaan.


**Parannukset koodin suhteen:** 

Kun tietokantanäkymä toteutetaan, kohteet tehdään oliopohjaisiksi, jolloin tiedot haetaan tietokannasta.






