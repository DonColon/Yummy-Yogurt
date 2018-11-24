alter table Benutzer
  add constraint Benutzer_Adresse foreign key(Adresse) references Adresse(ID);

alter table Zutat 
  add constraint Zutat_Zutatenkategorie foreign key(Kategorie) references Zutatenkategorie(ID);
  
alter table Yogurt
  add constraint Yogurt_Benutzer foreign key(Besitzer) references Benutzer(ID);


alter table Zutatenliste
  add constraint Zutatenliste_Yogurt foreign key(Yogurt) references Yogurt(ID)
  add constraint Zutatenliste_Zutaten foreign key(Zutat) references Zutat(ID);

alter table Bewertung
  add constraint Bewertung_Benutzer foreign key(Bewerter) references Benutzer(ID)
  add constraint Bewertung_Yogurt foreign key(Yogurt) references Yogurt(ID);
  
alter table Bestellung
  add constraint Bestellung_Benutzer foreign key(Besteller) references Benutzer(ID);

alter table Bestellposition
  add constraint Bestellposition_Bestellung foreign key(Bestellung) references Bestellung(ID)
  add constraint Bestellposition_Yogurt foreign key(Yogurt) references Yogurt(ID);