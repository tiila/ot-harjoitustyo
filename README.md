# StudyTracker

StudyTracker-sovelluksen avulla käyttäjä voi pitää kirjaa kursseistaan ja opiskelustaan. Käyttäjät voivat lisätä itselleen kursseja kurssitietokannasta sekä kirjata opiskeluun käyttämänsä ajan kurssikohtaisesti. Sovellus on Ohjelmistotekniikan kurssin projekti syksyllä 2019.


## Dokumentaatio

[Käyttöohje]() Ei ole vielä

[Vaatimusmäärittely](https://github.com/tiila/ot-harjoitustyo/blob/master/dokumentaatio/vaatimusmaarittely.md) 

[Arkkitehtuurikuvaus](https://github.com/tiila/ot-harjoitustyo/blob/master/dokumentaatio/arkkitehtuuri.md)

[Testausdokumentti]() Ei ole vielä

[Työaikakirjanpito](https://github.com/tiila/ot-harjoitustyo/blob/master/dokumentaatio/tyoaikakirjanpito.md)




## Releaset

[Viikko 5](https://github.com/tiila/ot-harjoitustyo/releases/tag/Viikko5)


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

### JavaDoc

JavaDoc generoidaan komennolla

 `mvn javadoc:javadoc`
 
 JavaDocia voi tarkastella avaamalla selaimella tiedosto *target/site/apidocs/index.html*


### Checkstyle

Tiedostoon [checkstyle.xml](https://github.com/tiila/ot-harjoitustyo/blob/master/StudyTracker/checkstyle.xml) määritellyt tarkistukset suoritetaan komennolla

`mvn jxr:jxr checkstyle:checkstyle`
 
Mahdolliset virheilmoitukset selviävät avaamalla selaimella tiedosto target/site/checkstyle.html











