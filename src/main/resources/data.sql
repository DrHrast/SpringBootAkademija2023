CREATE TABLE test (
    id INT primary key AUTO_INCREMENT,
    name VARCHAR(100),
    description VARCHAR(255)
);

INSERT INTO test (name, description)
    VALUES ('Stipe', 'Mesica na raznju'),
           ('Ante', 'Gotov na na');


CREATE TABLE pretrage_letova (

    id INT PRIMARY KEY AUTO_INCREMENT,
    sifra_polazista CHAR(3),
    sifra_odredista CHAR(3),
    datum_odlazka DATE,
    datum_povratka DATE,
    broj_odraslih INT,

    datum_kreiranja DATE,
    korisnik_kreiranja VARCHAR(50),
    datum_azuriranja DATE,
    korisnik_azuriranja VARCHAR(50)

);

CREATE TABLE rezultati_pretrage (

    id INT PRIMARY KEY AUTO_INCREMENT,
    polazak_aerodrom_plazni_let CHAR(3),
    polazak_sifra_aerodroma_odrediste CHAR(3),
    polazak_datum_polaska VARCHAR(25),
    polazak_datum_dolaska VARCHAR(25),

    povratak_sifra_aerodroma_polazak CHAR(3),
    povratak_sifra_aerodroma_odrediste CHAR(3),
    povratak_datum_polaska VARCHAR(25),
    povratak_datum_dolaska VARCHAR(25),

    prijevoznik VARCHAR(50),
    cijena VARCHAR(10),

    id_pretrage INT,

    datum_kreiranja DATE,
    korisnik_kreiranja VARCHAR(50),
    datum_azuriranja DATE,
    korisnik_azuriranja VARCHAR(50)

);

ALTER TABLE rezultati_pretrage ADD FOREIGN KEY (id_pretrage) REFERENCES pretrage_letova (id);