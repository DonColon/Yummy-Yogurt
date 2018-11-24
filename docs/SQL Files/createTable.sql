create table Adresse(
    ID           int          primary key,
    Strasse      varchar2(64) not null,
    Hausnummer   varchar2(64) not null,
    Postleitzahl varchar2(64) not null,
    Wohnort      varchar2(64) not null
);


create table Benutzer(
    ID              int            primary key,
    Vorname         varchar2(64)   not null,
    Nachname        varchar2(64)   not null,
    Benutzername    varchar2(64)   unique not null,
    Email           varchar2(64)   unique not null,
    Passwort        varchar2(1024) not null,
    Geburtsdatum    date           not null,
    Beitrittsdatum  date           not null,
    Adresse         int            not null,
    constraint checkDatum check(Geburtsdatum < Beitrittsdatum)
);


create table Zutatenkategorie(
    ID    int          primary key,
    Name  varchar2(64) unique not null,
    Preis int          not null,
    constraint checkKategoriePreis check(Preis > 0)
);


create table Zutat(
    ID    int            primary key,
    Name  varchar2(64)   unique not null,
    Vegan varchar2(8)    not null,
    Haram varchar2(8)    not null,
    Kategorie  int       not null,
    constraint checkVegan check(Vegan in ('true', 'false')),
    constraint checkHaram check(Haram in ('true', 'false'))
);


create table Yogurt(
    ID              int              primary key,
    Name            varchar2(64)     not null,
    Preis           int              not null,
    Veroeffentlicht varchar2(8)      not null,
    Besitzer        int              not null,
    constraint checkYogurtPreis check(Preis > 0),
    constraint checkVeroeffentlicht check(Veroeffentlicht in ('true', 'false'))
);


create table Zutatenliste(
    Yogurt  int,
    Zutat   int,
    primary key(Yogurt, Zutat)
);


create table Bewertung(
    ID          int primary key,
    Bewerter    int not null,
    Yogurt      int not null,
    Wertung     int not null,
    Nachricht        varchar2(255) not null,
    Bewertungsdatum  timestamp     not null,
    constraint checkWertung check(Wertung >= 1 and Wertung <= 5)
);


create table Bestellung(
    ID           int            primary key,
    Besteller    int            not null,
    Gesamtpreis  int            not null,
    Zahlungsart  varchar2(32)   not null,
    Bestelldatum timestamp      not null,
    
    constraint checkGesamtpreis check(Gesamtpreis > 0),
    constraint checkZahlungsart check(Zahlungsart in(
        'PayPal', 'Amazon-Pay', 'Apple-Pay', 'Stripe', 
        'American-Express', 'JCB', 'Visa', 'Mastercard'
    ))
);


create table Bestellposition(
    ID            int primary key,
    Bestellung    int not null,
    Yogurt        int not null,
    Menge         int not null,
    constraint checkMenge check(Menge > 0 and Menge <= 2000)
);
