DROP SCHEMA IF EXISTS oblig1_jpa CASCADE;

CREATE SCHEMA oblig1_jpa;
SET search_path TO oblig1_jpa;
    
CREATE TABLE ansatt
(
	ansattid		SERIAL,
    brukernavn      VARCHAR(4) NOT NULL UNIQUE,
    fornavn         VARCHAR(20),
    etternavn       VARCHAR(20),
    ansettelsesdato DATE,
    stilling        VARCHAR(20),
    maanedslonn     DECIMAL(10,2),
    PRIMARY KEY (ansattid)
);

    
CREATE TABLE avdeling (
	avdelingsid 	serial NOT NULL,
	avdelingsnavn 	varchar(20) NOT NULL,
	avdelingssjef 	integer NOT NULL,
	PRIMARY KEY (avdelingsid),
	FOREIGN KEY (avdelingssjef) REFERENCES ansatt(ansattid) 
	
);
 
INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn)
VALUES
    ('HA', 'Hassan', 	'Ali', 		'2003-03-20', 'Doggy', 		5),
    ('NJ', 'Niklas', 	'Johansson','2000-05-05', 'Standing',	51),
    ('KN', 'Katarina',	'Nedrelid', '2018-06-20', 'SittingDown',52),
    ('DB', 'Darren', 	'Bernardo', '2018-06-20', 'BehindYou', 	53),
    ('DW', 'Didrik', 	'Whatever', '2018-06-20', 'On1Leg', 	54);
   

INSERT INTO
  avdeling(avdelingsnavn, avdelingssjef)
VALUES
    ('avdeling1', 2),
    ('avdeling2', 3);
      
