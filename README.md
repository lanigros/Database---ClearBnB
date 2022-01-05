# Database - ClearBnB

Företaget ClearBnB är en blivande konkurrent till AirBnB. De vill bygga en webbapplikation i vilken deras användare kan hyra ut sina bostäder och hyra bostäder.

Ni har fått i uppdrag att bygga en Java-Express backend för denna webbapplikation.

I applikationen ska användarna bl a kunna:

Se information om vilka bostäder som är tillgängliga efter att ha filtrerat på ett valfritt antal parametrar som tidsperiod, storlek, plats m.m.
Se om det går att hyra en bostad mellan vissa datum och vad det skulle kosta
Genomföra bokningar
Lägga upp sina bostäder för uthyrning, med information om när de är tillgängliga, vilket pris de vill ta, en textbeskrivning, en beskrivning av vilka bekvämligheter (badkar, kök, dusch etc. etc.) som finns tillgängliga, samt bilder.
Efter att en uthyrning har skett ska båda parter kunna lämna omdöme om varann, 1-5 “stjärnor” samt textkommentar.
Man ska kunna ta bort sin/a omdömen.
Vid bokning ska pengar dras från hyresgästens bankkonto (i er databas), betalningen ska kunna misslyckas.
Skapa konto, Logga in/ut samt förbli inloggad vid omstart
Se sin egna och andras profiler
Man ska kunna redigera sin bostadsbeskrivning (inkl pris osv). Vid redigerandet av detta ska det sparas versionshistorik.
Vid åskådandet av en bostadsbeskrivning ska man kunna bläddra bland de tidigare versionerna.
Man ska kunna chatta med kundsupport (utan en 3rd party integration som ex: intercom)
Caching (mer info längre ned)
Individuellt grupparbete
Om man endast är 1 person som utför uppgiften så behöver man inte ha med funktionaliteterna:

Redigering av bostad (inkl pris etc) samt versionshistorik av detta
Live-chat
Caching
Valfritt antal/kombination av sökfilter. D.v.s sök-funktionaliteten ska finnas men det räcker med att man endast kan söka på 1 filter åt gången.
Övriga detaljer
ClearBnb ska tjäna 15% ovanpå det pris som de som hyr ut kräver, d.v.s om uthyraren begär ha 2000:- ska listpriset vara 2300:-.

Företaget ClearBnB har internt ett frontend-team men saknar kunskaper för backendutveckling.
Därför behöver ni inte lägga mycket tid på att skapa en snygg frontend (läs: så gott som 0 rader CSS).

Ni ska förutom backend-koden skriva lite kod för hur frontenden bör agera i samverkan med er backend för att förenkla deras framtida integration.
I er frontend ska man som användare kunna utföra alla de app-specifika features listade ovan men såklart även:

Vill ni dela upp er frontend i många filer, använda frameworks osv så är det upp till er och hur ni vill göra, ni kan snabba på frontend-utvecklingen genom att använda tekniker ni är bekväma i, alternativt ta chansen att fördjupa er i något nytt ifall ni har tid och lust.

Cache-uppgiften
(Gäller endast för grupper på 2+ personer)
Er primära databas ska vara SQL-baserad, utöver denna ska ni skapa ett cache-lager via MongoDB.
En del tyngre queries kommer (under vanligt frontend-användande) kallas på och returnera samma resultat flera gånger, dessa ska sparas som dokument i cache:n och användas istället för att det ska utföras många dyra JOINs osv om och om igen.
PS. Att ha en cache innebär en stor teknisk utmaning som heter “Cache invalidation”.

Följande gäller alla
Er backend & databasstruktur ska vara ordentligt genomtänkt och strukturerad.
Domändriven design ska tillämpas till den grad som den studerande finner lämpligt, detta bör vara fokusområdet i Sprint 2.

Kom igång
Vid behov, gör domän-research på t.ex. AirBnB för att få en klar bild på vad ni ska skapa.
Skriv en feature list (förenklade user stories) som godkänns av produktägaren.
Modellera er SQL-databas med (simpel) UML, använd gratis onlineverktyg som t.ex app.diagrams.net.
Specificera backendroutes, ska ni använda REST? Kanske blanda med funktioner?
Innan ni börjar koda eller skapa DBs ska ni ha utfört ovanstående planering
SCRUM-artiklar:
Att skapa user stories
Wireframes + UML = sant
Planning Poker
SCRUM-board i Trello

Dummy data
Skapa ett antal användare och lägg in dummy data. Minst 20 användare, varav minst 10 ska hyra ut bostäder, varav minst 3 ska hyra ut flera bostäder. Det ska gå att via gränssnittet lägga till nya användare, bostäder etc…

Betygskriterier
FÖR GODKÄNT:
Ni ska ha arbetat agilt i grupp.
Ni ska ha levererat en fungerande webbapplikation enligt de User Stories ni skrivit och fått godkända av läraren i rollen som produktägare.
Ni ska ha fått ER-diagram godkänt av läraren i rollen som produktägare.
Ni ska ha använt er av tekniker ni lärt er under delkursen.
Koden ska så långt som möjligt vara semantisk och fungerande.
Ni ska kontinuerligt ha checkat in er kod på git.
Utöver bedömningen för gruppen som helhet, behöver det för varje gruppmedlem framgå att denne uppfyllt kraven för Godkänt. Detta innebär att varje gruppmedlem bör ha checkat in relevant arbete under sitt namn, i git.
FÖR VÄL GODKÄNT:
Utöver ovanstående krav för Godkänt:

Funktionalitet och användargränssnitt ska vara tydligt och lätt att förstå.
Ni ska ha en hög grad av konsekvens och semantik i er kod.
Ni ska ha levererat en välfungerande applikation.
Utöver applikationen tillkommer det en skriftlig inlämningsuppgift där ni ska redogöra er kompetens och hur den speglats i ert projekt.
