# StudyTracker

StudyTracker-sovelluksen avulla käyttäjä voi pitää kirjaa kursseistaan ja opiskelustaan. Käyttäjät voivat lisätä itselleen kursseja kurssitietokannasta sekä kirjata opiskeluun käyttämänsä ajan kurssikohtaisesti. Sovellus on Ohjelmistotekniikan kurssin projekti syksyllä 2019.


## Dokumentaatio

[Vaatimusmäärittely](https://github.com/tiila/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) 

[Työaikakirjanpito](https://github.com/tiila/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)

[Arkkitehtuuri](https://github.com/tiila/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)


## Releaset

[Viikko 5]()


## Komentorivitoimnnot


### Testaus

Testit suoritetaan komennolla

`mvn test`

Testikattavuusraportit luodaan komennolla

`mvn jacoco:report`

Testikattavuusraporttia voi tarkastella avaamalla selaimella tiedosto target/site/jacoco/index.html


### Suoritettavan jarin generointi

Komento

`mvn package`

generoi hakemistoon target suoritettavan jar-tiedoston StudyTracker-1.0-SNAPSHOT.jar


### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/tiila/ot-harjoitustyo/blob/master/StudyTracker/checkstyle.xml) määritellyt tarkistukset suoritetaan komennolla

`mvn jxr:jxr checkstyle:checkstyle`
 
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html











