-- Adresse ---------------------------------------------------------------------------------------------------------------------
select * from adresse;

-- Benutzer --------------------------------------------------------------------------------------------------------------------
select * from benutzer;

select * from benutzer
where benutzername = 'DonColon';

select * from benutzer
where email = 'drrafshi@hotmail.de';

-- Yogurt ----------------------------------------------------------------------------------------------------------------------
select * from yogurt;

select * from yogurt
where veroeffentlicht = 'true';

select * from yogurt
where name = 'Banana Awesome';

select y.name, y.preis
from yogurt y, benutzer b
where y.besitzer = b.id
  and b.benutzername = 'DonColon';
  
select y.name, y.preis
from yogurt y, benutzer b
where y.besitzer = b.id
  and b.id = 1;
  
select avg(be.wertung) as Wertung
from Yogurt y, Bewertung be
where y.id = be.yogurt
  and y.name = 'Banana Awesome';
  
select distinct y.name, y.preis
from yogurt y, zutatenliste zl, zutat z, zutatenkategorie zk
where y.id = zl.yogurt and zl.zutat = z.id
  and z.kategorie = zk.id
  and veroeffentlicht = 'true'
  and zk.name = 'Früchte';

-- TODO Alle Zutaten nach vegan prüfen
select y.name, y.preis
from yogurt y, zutatenliste zl, zutat z
where y.id = zl.yogurt and zl.zutat = z.id
  and z.name in (
    select name from zutat
    where vegan = 'true'
  )
  and veroeffentlicht = 'true';
  
select y.name, avg(be.wertung) as Wertung
from Yogurt y, Bewertung be
where y.id = be.yogurt
  and veroeffentlicht = 'true'
group by y.name
order by avg(be.wertung) desc;
  
select * from yogurt
where veroeffentlicht = 'true'
order by preis desc;

select * from yogurt
where veroeffentlicht = 'true'
order by preis asc;

select * from yogurt
where veroeffentlicht = 'true'
order by name asc;

select * from yogurt
where veroeffentlicht = 'true'
order by name desc;

-- Bewertung -------------------------------------------------------------------------------------------------------------------
select u.vorname, b.wertung, b.nachricht, b.bewertungsdatum
from yogurt y, bewertung b, benutzer u
where y.id = b.yogurt and b.bewerter = u.id
  and y.name = 'Banana Awesome';
  
select u.vorname, b.wertung, b.nachricht, b.bewertungsdatum
from yogurt y, bewertung b, benutzer u
where y.id = b.yogurt and b.bewerter = u.id
  and y.id = 1;

-- Zutat -----------------------------------------------------------------------------------------------------------------------
select z.name
from zutat z, zutatenkategorie zk
where z.kategorie = zk.id
  and zk.name = 'Früchte';

select z.name
from zutat z, zutatenkategorie zk
where z.kategorie = zk.id
  and zk.id = 1;
  
-- Bestellung ------------------------------------------------------------------------------------------------------------------
select best.bestelldatum, best.gesamtpreis, best.zahlungsart, y.name, pos.menge
from bestellung best, bestellposition pos, yogurt y
where pos.bestellung = best.id and pos.yogurt = y.id
order by best.bestelldatum desc;
