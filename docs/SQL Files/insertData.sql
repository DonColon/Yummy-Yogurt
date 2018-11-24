insert into Adresse
    values(AddressSequence.nextval, 'Bei der Schule', '12', '88515', 'Langenenslingen');
  
insert into Adresse 
    values(AddressSequence.nextval, 'Goethestrasse', '21a', '88996', 'Monopoly');
  
insert into Adresse 
    values(AddressSequence.nextval, 'Schillerstrasse', '9b', '88996', 'Monopoly');
  
insert into Adresse
    values(AddressSequence.nextval, 'Johannesstrasse', '5', '72458', 'Albstadt');

insert into Adresse
    values(AddressSequence.nextval, 'Am Schloss', '1', '72488', 'Sigmaringen');
    
insert into Adresse
    values(AddressSequence.nextval, 'Am Rathaus', '3', '72458', 'Albstadt');
    
    
insert into Benutzer 
    values(UserSequence.nextval, 'Dardan', 'Rrafshi', 'DonColon', 'drrafshi@hotmail.de', '1234', to_date('30.01.97'), to_date(SYSDATE), 1);
    
insert into Benutzer 
    values(UserSequence.nextval, 'Hasan', 'Karadeniz', 'Krdnz57', 'Krdnz57@gmail.com', '234567', to_date('14.07.98'), to_date(SYSDATE), 2);
    
insert into Benutzer
    values(UserSequence.nextval, 'Martin', 'Hafner', 'Martin', 'hafnerma@gmx.de', 'IT_SEC_GOD', to_date('30.07.96'), to_date(SYSDATE), 3);
    
insert into Benutzer
    values(UserSequence.nextval, 'Richard', 'Ries', 'RichardDieRakete', 'richie@gmail.com', 'Reich', to_date('14.03.97'), to_date(SYSDATE), 4);
    

insert into Zutatenkategorie
    values(CategorySequence.nextval, 'Joghurtbasis', 150);
    
insert into Zutatenkategorie
    values(CategorySequence.nextval, 'Früchte', 20);
    
insert into Zutatenkategorie
    values(CategorySequence.nextval, 'Nüsse und Kerne', 20);
    
insert into Zutatenkategorie
    values(CategorySequence.nextval, 'Schoko', 25);
    
insert into Zutatenkategorie
    values(CategorySequence.nextval, 'Süßigkeiten', 30);
    
insert into Zutatenkategorie
    values(CategorySequence.nextval, 'Soßen', 40);
    
    
insert into Zutat
    values(IngredientSequence.nextval, 'Bananen-Joghurt', 'false', 'false', 1);
  
insert into Zutat
    values(IngredientSequence.nextval, 'Ananas-Joghurt', 'false', 'false', 1);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Pfirsich-Joghurt', 'false', 'false', 1);
  
insert into Zutat
    values(IngredientSequence.nextval, 'Aprikose-Joghurt', 'false', 'false', 1);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Mango-Joghurt', 'false', 'false', 1);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Maracuja-Joghurt', 'false', 'false', 1);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Erdbeer-Joghurt', 'false', 'false', 1);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Kirsch-Joghurt', 'false', 'false', 1);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Himbeer-Joghurt', 'false', 'false', 1);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Apfel-Joghurt', 'false', 'false', 1);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Birnen-Joghurt', 'false', 'false', 1);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Nuccio-Joghurt', 'false', 'false', 1); 
    
insert into Zutat
    values(IngredientSequence.nextval, 'Schoko-Joghurt', 'false', 'false', 1);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Vanille-Joghurt', 'false', 'false', 1);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Light-Joghurt', 'true', 'false', 1);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Banane', 'true', 'false', 2);  
    
insert into Zutat
    values(IngredientSequence.nextval, 'Ananas', 'true', 'false', 2); 
    
insert into Zutat
    values(IngredientSequence.nextval, 'Birne', 'true', 'false', 2);     
    
insert into Zutat
    values(IngredientSequence.nextval, 'Apfel', 'true', 'false', 2);     
    
insert into Zutat
    values(IngredientSequence.nextval, 'Pfirsich', 'true', 'false', 2);     
    
insert into Zutat
    values(IngredientSequence.nextval, 'Aprikose', 'true', 'false', 2);        
    
insert into Zutat
    values(IngredientSequence.nextval, 'Mango', 'true', 'false', 2);        
    
insert into Zutat
    values(IngredientSequence.nextval, 'Marcuja', 'true', 'false', 2);        
    
insert into Zutat
    values(IngredientSequence.nextval, 'Pflaume', 'true', 'false', 2);        
    
insert into Zutat
    values(IngredientSequence.nextval, 'Himbeere', 'true', 'false', 2);        
    
insert into Zutat
    values(IngredientSequence.nextval, 'Erdbeere', 'true', 'false', 2);        
    
insert into Zutat
    values(IngredientSequence.nextval, 'Johannesbeere', 'true', 'false', 2);        
    
insert into Zutat
    values(IngredientSequence.nextval, 'Blaubeere', 'true', 'false', 2);        
  
insert into Zutat
    values(IngredientSequence.nextval, 'Brombeere', 'true', 'false', 2);      

insert into Zutat
    values(IngredientSequence.nextval, 'Kirsche', 'true', 'false', 2);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Granatapfel', 'true', 'false', 2); 

insert into Zutat
    values(IngredientSequence.nextval, 'Rosinen', 'true', 'false', 2); 
    
insert into Zutat
    values(IngredientSequence.nextval, 'Haselnüsse', 'true', 'false', 3); 
  
insert into Zutat
    values(IngredientSequence.nextval, 'Walnüsse', 'true', 'false', 3);   
  
insert into Zutat
    values(IngredientSequence.nextval, 'Macadamia', 'true', 'false', 3);   
  
insert into Zutat
    values(IngredientSequence.nextval, 'Mandeln', 'true', 'false', 3);   
  
insert into Zutat
    values(IngredientSequence.nextval, 'Pistazie', 'true', 'false', 3);   
  
insert into Zutat
    values(IngredientSequence.nextval, 'Cashewkerne', 'true', 'false', 3);   
  
insert into Zutat
    values(IngredientSequence.nextval, 'Paranüsse', 'true', 'false', 3);   
  
insert into Zutat
    values(IngredientSequence.nextval, 'Pekannüsse', 'true', 'false', 3);   
  
insert into Zutat
    values(IngredientSequence.nextval, 'Tigernüsse', 'true', 'false', 3);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Hanfnüsse', 'true', 'false', 3);  
  
insert into Zutat
    values(IngredientSequence.nextval, 'Sonnenblumenkerne', 'true', 'false', 3);  

insert into Zutat
    values(IngredientSequence.nextval, 'Kürbiskerne', 'true', 'false', 3);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Kokoschips', 'true', 'false', 3);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Kokosraspeln', 'true', 'false', 3);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Schokostreusel', 'true', 'false', 4);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Schokobomben', 'true', 'false', 4);    
    
insert into Zutat
    values(IngredientSequence.nextval, 'Schokoplättchen', 'false', 'false', 4);    
    
insert into Zutat
    values(IngredientSequence.nextval, 'Weiße-Schokoplättchen', 'false', 'false', 4);    
    
insert into Zutat
    values(IngredientSequence.nextval, 'Chocolate Boons', 'true', 'false', 4);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Kakaosplitter', 'true', 'false', 4); 
    
insert into Zutat
    values(IngredientSequence.nextval, 'Schoko-Cornflakes', 'false', 'false', 4);     
    
insert into Zutat
    values(IngredientSequence.nextval, 'Schokoherzen', 'false', 'false', 4);     
    
insert into Zutat
    values(IngredientSequence.nextval, 'Schokoholic-Crunchy', 'false', 'false', 4);     
    
insert into Zutat
    values(IngredientSequence.nextval, 'Froot-Loops', 'true', 'false', 5);     
    
insert into Zutat
    values(IngredientSequence.nextval, 'Haribo', 'false', 'true', 5);      
    
insert into Zutat
    values(IngredientSequence.nextval, 'Saure-Schlangen', 'false', 'true', 5);      
    
insert into Zutat
    values(IngredientSequence.nextval, 'MM', 'false', 'false', 5);      
    
insert into Zutat
    values(IngredientSequence.nextval, 'Marshmallows', 'false', 'false', 5); 
    
insert into Zutat
    values(IngredientSequence.nextval, 'Oreo', 'false', 'false', 5);   
  
insert into Zutat
    values(IngredientSequence.nextval, 'Smarties', 'false', 'false', 5);     

insert into Zutat
    values(IngredientSequence.nextval, 'Toffifee', 'false', 'false', 5);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Raffaello', 'false', 'false', 5);
  
insert into Zutat
    values(IngredientSequence.nextval, 'Ferero-Küsschen', 'false', 'false', 5);   
  
insert into Zutat
    values(IngredientSequence.nextval, 'Mon Cherie', 'false', 'true', 5);     
  
insert into Zutat
    values(IngredientSequence.nextval, 'Ferero-Rocher', 'false', 'false', 5);
    
insert into Zutat
    values(IngredientSequence.nextval, 'Schokosoße', 'false', 'false', 6);   

insert into Zutat
    values(IngredientSequence.nextval, 'Nougatsoße', 'true', 'false', 6);
  
insert into Zutat
    values(IngredientSequence.nextval, 'Karamell', 'true', 'false', 6);  

insert into Zutat
    values(IngredientSequence.nextval, 'Zitronensoße', 'true', 'false', 6); 

insert into Zutat
    values(IngredientSequence.nextval, 'Erdbeersoße', 'true', 'false', 6); 

insert into Zutat
    values(IngredientSequence.nextval, 'Himbeersoße', 'true', 'false', 6); 

insert into Zutat
    values(IngredientSequence.nextval, 'Kirschsoße', 'true', 'false', 6); 
    
    
insert into Yogurt
    values(YogurtSequence.nextval, 'Banana Awesome', 220, 'true', 1);
    
insert into Yogurt
    values(YogurtSequence.nextval, 'Nuts Royal', 230, 'true', 1);
    
insert into Yogurt
    values(YogurtSequence.nextval, 'Super Yogurt X', 235, 'true', 2);
  
insert into Yogurt
    values(YogurtSequence.nextval, 'Fruity Loop', 230, 'true', 2);  

insert into Yogurt
    values(YogurtSequence.nextval, 'Blutbadbecher', 230, 'false', 3);
    
insert into Yogurt
    values(YogurtSequence.nextval, 'MC Fitty', 210, 'true', 3);
    
insert into Yogurt
    values(YogurtSequence.nextval, 'Sugar Bombs', 255, 'true', 4);

insert into Yogurt
    values(YogurtSequence.nextval, 'Goldbecher', 230, 'false', 4);
    

insert into Zutatenliste
    values(1, 1);
    
insert into Zutatenliste
    values(1, 16);
    
insert into Zutatenliste
    values(1, 47);
  
insert into Zutatenliste
    values(1, 48);  
  
insert into Zutatenliste
    values(2, 12);  
  
insert into Zutatenliste
    values(2, 33);  
  
insert into Zutatenliste
    values(2, 34);  
  
insert into Zutatenliste
    values(2, 69);  
    
insert into Zutatenliste
    values(3, 7);
  
insert into Zutatenliste
    values(3, 33);  
  
insert into Zutatenliste
    values(3, 47);

insert into Zutatenliste
    values(3, 68);
    
insert into Zutatenliste
    values(4, 10);
    
insert into Zutatenliste
    values(4, 16);
    
insert into Zutatenliste
    values(4, 26);
    
insert into Zutatenliste
    values(4, 18);

insert into Zutatenliste
    values(4, 17);
    
insert into Zutatenliste
    values(5, 7);    
    
insert into Zutatenliste
    values(5, 30);      
    
insert into Zutatenliste
    values(5, 46);      
    
insert into Zutatenliste
    values(5, 68);      
    
insert into Zutatenliste
    values(6, 15);      
    
insert into Zutatenliste
    values(6, 19);     
    
insert into Zutatenliste
    values(6, 26);     
    
insert into Zutatenliste
    values(6, 16);     
    
insert into Zutatenliste
    values(7, 13);    
    
insert into Zutatenliste
    values(7, 47);     
    
insert into Zutatenliste
    values(7, 70); 
    
insert into Zutatenliste
    values(7, 69); 
    
insert into Zutatenliste
    values(8, 14);     
    
insert into Zutatenliste
    values(8, 19);     
    
insert into Zutatenliste
    values(8, 37);     
    
insert into Zutatenliste
    values(8, 70);
    
    
insert into Bewertung
    values(RatingSequence.nextval, 1, 1, 5, 'This Froyo is awesome', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 2, 1, 4, 'Der Yogurt ist echt klasse!', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 3, 1, 5, 'd', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 4, 1, 3, 'f', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 1, 2, 5, 'g', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 2, 2, 4, 't', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 3, 2, 5, 'r', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 4, 2, 3, 's', to_timestamp(LOCALTIMESTAMP));   
    
insert into Bewertung
    values(RatingSequence.nextval, 1, 3, 3, 'l', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 2, 3, 4, 'o', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 3, 3, 2, 'pp', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 4, 3, 5, 'ase', to_timestamp(LOCALTIMESTAMP));    
    
insert into Bewertung
    values(RatingSequence.nextval, 1, 4, 5, 'hjuz', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 2, 4, 3, 'sbdhhg', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 3, 4, 5, 'ergergweg', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 4, 4, 3, 'ergegggr', to_timestamp(LOCALTIMESTAMP));    
    
insert into Bewertung
    values(RatingSequence.nextval, 1, 5, 1, 'ergerg', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 2, 5, 4, 'ggreg', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 3, 5, 5, 'gegrgre', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 4, 5, 3, 'gegeg', to_timestamp(LOCALTIMESTAMP));    
    
insert into Bewertung
    values(RatingSequence.nextval, 1, 6, 5, 'fwewfwe', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 2, 6, 4, 'tukliuil', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 3, 6, 5, 'zukllzkz', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 4, 6, 5, 'fsgsgg', to_timestamp(LOCALTIMESTAMP));    
    
insert into Bewertung
    values(RatingSequence.nextval, 1, 7, 4, 'geeege', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 2, 7, 2, 'xcbjj', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 3, 7, 5, 'wewgerh', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 4, 7, 3, 'rghergc', to_timestamp(LOCALTIMESTAMP));    
    
insert into Bewertung
    values(RatingSequence.nextval, 1, 8, 1, 'fwewfw4', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 2, 8, 2, '4r5geh', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 3, 8, 4, 'rgeh66u', to_timestamp(LOCALTIMESTAMP));
    
insert into Bewertung
    values(RatingSequence.nextval, 4, 8, 5, 'esdfvdh', to_timestamp(LOCALTIMESTAMP));
    

insert into Bestellung
    values(OrderSequence.nextval, 1, 220, 'PayPal', to_timestamp(LOCALTIMESTAMP));

insert into Bestellung
    values(OrderSequence.nextval, 1, 230, 'PayPal', to_timestamp(LOCALTIMESTAMP));
    

insert into Bestellposition
    values(OrderItemSequence.nextval, 1, 1, 1);
    
insert into Bestellposition
    values(OrderItemSequence.nextval, 2, 2, 1);
    
commit;
