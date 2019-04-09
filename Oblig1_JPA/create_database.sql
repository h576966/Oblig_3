DROP SCHEMA IF EXISTS oblig1_jpa CASCADE;

CREATE SCHEMA oblig1_jpa;
SET search_path TO oblig1_jpa;
    
CREATE TABLE ansatt
(
    ansattid			SERIAL,
    brukernavn			VARCHAR(4) NOT NULL UNIQUE,
    fornavn        		VARCHAR(20),
    etternavn       	VARCHAR(20),
    ansettelsesdato 	DATE,
    stilling       		VARCHAR(20),
    maanedslonn     	DECIMAL(10,2),
    ansattavdeling		INTEGER,
    ansattprosjekt		INTEGER,
    PRIMARY KEY (ansattid)
);

    
CREATE TABLE avdeling (
	avdelingsid 		SERIAL NOT NULL,
	avdelingsnavn 		VARCHAR(20) NOT NULL,
	avdelingssjef 		INTEGER NOT NULL,
	PRIMARY KEY (avdelingsid),
	FOREIGN KEY (avdelingssjef) REFERENCES ansatt(ansattid) 
	
);

CREATE TABLE prosjekt (
	prosjektid 			SERIAL NOT NULL,
	prosjektnavn 		VARCHAR(20) NOT NULL,
	beskrivelse 		VARCHAR(50),
	PRIMARY KEY (prosjektid)

);

CREATE TABLE prosjektdeltagelse (
	prosjektid		INTEGER NOT NULL,
	ansattid		INTEGER NOT NULL,
	prosjektrolle 	VARCHAR(20) NOT NULL,
	arbeidstimer	DECIMAL(4,1),
	PRIMARY KEY (prosjektid, ansattid),
	FOREIGN KEY (prosjektid) REFERENCES prosjekt(prosjektid), 
	FOREIGN KEY (ansattid) REFERENCES ansatt(ansattid) 
);
	

 
INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn, ansattavd)
VALUES
    ('HA', 'Hassan', 	'Ali', 		'2003-03-20', 'Doggy', 		14000, 	1, 1),
    ('NJ', 'Niklas', 	'Johansson','2000-05-05', 'Standing',	14000, 	1, 1),
    ('KN', 'Katarina',	'Nedrelid', '2018-06-20', 'SittingDown', 37000, 2, 1),
    ('DB', 'Darren', 	'Bernardo', '2018-06-20', 'BehindYou', 	41000, 	2, 1),
    ('DW', 'Didrik', 	'Whatever', '2018-06-20', 'On1Leg', 	7500, 	2, 1);
   

INSERT INTO
  avdeling(avdelingsnavn, avdelingssjef)
VALUES
    ('avdeling1', 2),
    ('avdeling2', 3);

INSERT INTO
 prosjekt(prosjektnavn, beskrivelse)
VALUES
    ('prosjektnavn1', 'something really important'),
    ('prosjektnavn2', 'something important'),
    ('prosjektnavn3', 'something less important');

INSERT INTO
 prosjektdeltagelse(prosjektid, ansattid, prosjektrolle, arbeidstimer)
VALUES
    (1, 1, 'slav', 37),
    (2, 2,'prosjektleder', 37.5),
    (3, 3,'ingen vet', 40),
    (3, 4,'prosjektmedarbeidare', 80),
    (3, 5,'ingen vet', 40.5);

ALTER TABLE ansatt 
ADD FOREIGN KEY (ansattavd) REFERENCES avdeling(avdelingsid);


      
