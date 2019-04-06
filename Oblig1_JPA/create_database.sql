
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
    CONSTRAINT Ansatt_pk PRIMARY KEY (ansattid)
);

INSERT INTO
  ansatt(brukernavn, fornavn, etternavn, ansettelsesdato, stilling, maanedslonn)
VALUES
    ('asdf', 'Hassan', 'Ali', '2003-03-20', 'Doggy', 5);

