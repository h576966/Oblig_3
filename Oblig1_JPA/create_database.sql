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
    PRIMARY KEY (ansattid)
);

    
CREATE TABLE avdeling (
	avdelingsid 		SERIAL NOT NULL,
	avdelingsnavn 		varchar(20) NOT NULL,
	avdelingssjef 		integer NOT NULL,
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
	prosjektid		integer NOT NULL,
	ansattid		integer NOT NULL,
	prosjektrolle 	varchar(20) NOT NULL,
	arbeidstimer	DECIMAL(4,1),
	PRIMARY KEY (prosjektid, ansattid),
	FOREIGN KEY (prosjektid) REFERENCES prosjekt(prosjektid), 
	FOREIGN KEY (ansattid) REFERENCES ansatt(ansattid) 
);
	

 
INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn)
VALUES
    ('HA', 'Hassan', 	'Ali', 		'2003-03-20', 'Doggy', 		14000),
    ('NJ', 'Niklas', 	'Johansson','2000-05-05', 'Standing',	14000),
    ('KN', 'Katarina',	'Nedrelid', '2018-06-20', 'SittingDown', 37000),
    ('DB', 'Darren', 	'Bernardo', '2018-06-20', 'BehindYou', 	41000),
    ('DW', 'Didrik', 	'Whatever', '2018-06-20', 'On1Leg', 	7500);
   

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




      
