DROP DATABASE IF EXISTS PPE;

CREATE DATABASE IF NOT EXISTS PPE;
USE PPE;
# -----------------------------------------------------------------------------
#       TABLE : ILLUSTRATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ILLUSTRATION
 (
   ID_ILLUS INTEGER NOT NULL AUTO_INCREMENT ,
   CHEMIN VARCHAR(255) NOT NULL  
   , PRIMARY KEY (ID_ILLUS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : CANDIDAT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CANDIDAT
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   DATE_INSCRIPTION DATE NOT NULL  ,
   MODE_FACTURATION CHAR(6) NOT NULL  ,
   NOM CHAR(32) NOT NULL  ,
   PRENOM CHAR(32) NOT NULL  ,
   DATE_NAISSANCE DATE NOT NULL  ,
   TELEPHONE CHAR(10) NULL  
   , PRIMARY KEY (ID_TIERS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : DATEL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS DATEL
 (
   DHD DATETIME NOT NULL  
   , PRIMARY KEY (DHD) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : MOIS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MOIS
 (
   ID_MOIS INTEGER NOT NULL  ,
   ANNEE CHAR(32) NOT NULL  
   , PRIMARY KEY (ID_MOIS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : LIEU
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LIEU
 (
   ID_LIEU BIGINT(4) NOT NULL AUTO_INCREMENT ,
   ADRESSE CHAR(255) NOT NULL  ,
   CP CHAR(5) NOT NULL  ,
   VILLE CHAR(45) NOT NULL  
   , PRIMARY KEY (ID_LIEU) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : ETUDIANT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ETUDIANT
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   NIV_ETU CHAR(32) NOT NULL  ,
   REDUC REAL(5,2) NOT NULL  ,
   DATE_INSCRIPTION DATE NOT NULL  ,
   MODE_FACTURATION CHAR(6) NOT NULL  ,
   NOM CHAR(32) NOT NULL  ,
   PRENOM CHAR(32) NOT NULL  ,
   DATE_NAISSANCE DATE NOT NULL  ,
   TELEPHONE CHAR(10) NULL  
   , PRIMARY KEY (ID_TIERS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : MOTO
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MOTO
 (
   ID_VEHICULE INTEGER NOT NULL  ,
   CYLINDRE CHAR(32) NULL  ,
   PUISSANCE CHAR(32) NULL  ,
   NUM_IMMATRI CHAR(32) NOT NULL  ,
   NOM_MOD CHAR(32) NOT NULL  ,
   ANNEE_MOD DATE NOT NULL  ,
   DATE_ACHAT DATE NOT NULL  ,
   NB_KILO_INI BIGINT(6) NOT NULL  ,
   ETAT CHAR(32) NOT NULL  
   , PRIMARY KEY (ID_VEHICULE) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : EXAMEN
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EXAMEN
 (
   ID_TYPE INTEGER NOT NULL  ,
   ID_EXAM BIGINT(4) NOT NULL ,
   ID_LIEU BIGINT(4) NOT NULL  
   , PRIMARY KEY (ID_TYPE,ID_EXAM) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE EXAMEN
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_EXAMEN_LIEU
     ON EXAMEN (ID_LIEU ASC);

CREATE  INDEX I_FK_EXAMEN_TYPE_EXAMEN
     ON EXAMEN (ID_TYPE ASC);

# -----------------------------------------------------------------------------
#       TABLE : VOITURE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS VOITURE
 (
   ID_VEHICULE INTEGER NOT NULL  ,
   CONSO CHAR(32) NULL  ,
   NB_PLACES CHAR(32) NULL  ,
   NUM_IMMATRI CHAR(32) NOT NULL  ,
   NOM_MOD CHAR(32) NOT NULL  ,
   ANNEE_MOD DATE NOT NULL  ,
   DATE_ACHAT DATE NOT NULL  ,
   NB_KILO_INI BIGINT(6) NOT NULL  ,
   ETAT CHAR(32) NOT NULL  
   , PRIMARY KEY (ID_VEHICULE) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : TYPE_EXAMEN
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TYPE_EXAMEN
 (
   ID_TYPE INTEGER NOT NULL AUTO_INCREMENT ,
   LIBELLE CHAR(32) NULL  
   , PRIMARY KEY (ID_TYPE) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : TIERS
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TIERS
 (
   ID_TIERS BIGINT(4) NOT NULL AUTO_INCREMENT ,
   ID_LIEU BIGINT(4) NOT NULL  ,
   NOM CHAR(32) NOT NULL  ,
   PRENOM CHAR(32) NOT NULL  ,
   DATE_NAISSANCE DATE NOT NULL  ,
   TELEPHONE CHAR(10) NULL  
   , PRIMARY KEY (ID_TIERS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE TIERS
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_TIERS_LIEU
     ON TIERS (ID_LIEU ASC);

# -----------------------------------------------------------------------------
#       TABLE : VEHICULE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS VEHICULE
 (
   ID_VEHICULE INTEGER NOT NULL AUTO_INCREMENT ,
   NUM_IMMATRI CHAR(32) NOT NULL  ,
   NOM_MOD CHAR(32) NOT NULL  ,
   ANNEE_MOD DATE NOT NULL  ,
   DATE_ACHAT DATE NOT NULL  ,
   NB_KILO_INI BIGINT(6) NOT NULL  ,
   ETAT CHAR(32) NOT NULL  
   , PRIMARY KEY (ID_VEHICULE) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : PERSONNEL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PERSONNEL
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   DATE_EMBAUCHE DATE NOT NULL  ,
   DATE_FIN DATE NULL  ,
   NOM CHAR(32) NOT NULL  ,
   PRENOM CHAR(32) NOT NULL  ,
   DATE_NAISSANCE DATE NOT NULL  ,
   TELEPHONE CHAR(10) NULL  
   , PRIMARY KEY (ID_TIERS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : MONITEUR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MONITEUR
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   DATE_EMBAUCHE DATE NOT NULL  ,
   DATE_FIN CHAR(32) NULL  ,
   NOM CHAR(32) NOT NULL  ,
   PRENOM CHAR(32) NOT NULL  ,
   DATE_NAISSANCE DATE NOT NULL  ,
   TELEPHONE CHAR(10) NULL  
   , PRIMARY KEY (ID_TIERS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : SALARIE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SALARIE
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   NOM_ENTREPRISE CHAR(32) NOT NULL  ,
   DATE_INSCRIPTION DATE NOT NULL  ,
   MODE_FACTURATION CHAR(6) NOT NULL  ,
   NOM CHAR(32) NOT NULL  ,
   PRENOM CHAR(32) NOT NULL  ,
   DATE_NAISSANCE DATE NOT NULL  ,
   TELEPHONE CHAR(10) NULL  
   , PRIMARY KEY (ID_TIERS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : QUIZZ
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS QUIZZ
 (
   ID_QUIZZ BIGINT(4) NOT NULL AUTO_INCREMENT 
   , PRIMARY KEY (ID_QUIZZ) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : QUESTION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS QUESTION
 (
   ID_QUESTION INTEGER NOT NULL AUTO_INCREMENT ,
   ID_THEME INTEGER NOT NULL  ,
   CONTENU CHAR(255) NOT NULL  
   , PRIMARY KEY (ID_QUESTION) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE QUESTION
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_QUESTION_THEME
     ON QUESTION (ID_THEME ASC);

# -----------------------------------------------------------------------------
#       TABLE : REVISION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REVISION
 (
   ID_REVISION INTEGER NOT NULL AUTO_INCREMENT ,
   ID_VEHICULE INTEGER NOT NULL  ,
   LIBELLE CHAR(32) NOT NULL  ,
   MOTIF CHAR(32) NOT NULL  ,
   DATE_REVISION CHAR(32) NULL  
   , PRIMARY KEY (ID_REVISION) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE REVISION
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_REVISION_VEHICULE
     ON REVISION (ID_VEHICULE ASC);

# -----------------------------------------------------------------------------
#       TABLE : THEME
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS THEME
 (
   ID_THEME INTEGER NOT NULL AUTO_INCREMENT ,
   LIBELLE CHAR(32) NOT NULL  
   , PRIMARY KEY (ID_THEME) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : LECON
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LECON
 (
   ID_LECON INTEGER NOT NULL  ,
   INTITULE CHAR(32) NULL  ,
   DUREE CHAR(32) NULL  
   , PRIMARY KEY (ID_LECON) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : FORMULE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS FORMULE
 (
   ID_FORMULE INTEGER NOT NULL AUTO_INCREMENT ,
   LIBELLE CHAR(32) NOT NULL  ,
   TARIF CHAR(32) NOT NULL  ,
   DESCRIPTION CHAR(32) NOT NULL  ,
   DATE_DEBUT CHAR(32) NOT NULL  ,
   DATE_FIN CHAR(32) NULL  
   , PRIMARY KEY (ID_FORMULE) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       TABLE : ROULER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ROULER
 (
   ID_VEHICULE INTEGER NOT NULL  ,
   ID_MOIS INTEGER NOT NULL  ,
   NB_KILOMETRE CHAR(32) NOT NULL  
   , PRIMARY KEY (ID_VEHICULE,ID_MOIS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE ROULER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_ROULER_VEHICULE
     ON ROULER (ID_VEHICULE ASC);

CREATE  INDEX I_FK_ROULER_MOIS
     ON ROULER (ID_MOIS ASC);

# -----------------------------------------------------------------------------
#       TABLE : ENTRAINER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ENTRAINER
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   ID_QUIZZ BIGINT(4) NOT NULL  ,
   RESULTAT_QUIZZ INTEGER NULL  
   , PRIMARY KEY (ID_TIERS,ID_QUIZZ) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE ENTRAINER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_ENTRAINER_CANDIDAT
     ON ENTRAINER (ID_TIERS ASC);

CREATE  INDEX I_FK_ENTRAINER_QUIZZ
     ON ENTRAINER (ID_QUIZZ ASC);

# -----------------------------------------------------------------------------
#       TABLE : COMPOSER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS COMPOSER
 (
   ID_QUESTION INTEGER NOT NULL  ,
   ID_QUIZZ BIGINT(4) NOT NULL  ,
   REPONSE CHAR(32) NULL  
   , PRIMARY KEY (ID_QUESTION,ID_QUIZZ) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE COMPOSER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_COMPOSER_QUESTION
     ON COMPOSER (ID_QUESTION ASC);

CREATE  INDEX I_FK_COMPOSER_QUIZZ
     ON COMPOSER (ID_QUIZZ ASC);

# -----------------------------------------------------------------------------
#       TABLE : CHOISIR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CHOISIR
 (
   ID_FORMULE INTEGER NOT NULL  ,
   ID_TIERS BIGINT(4) NOT NULL  ,
   DATE_SOUSCRIPTION DATE NOT NULL  
   , PRIMARY KEY (ID_FORMULE,ID_TIERS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CHOISIR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CHOISIR_FORMULE
     ON CHOISIR (ID_FORMULE ASC);

CREATE  INDEX I_FK_CHOISIR_CANDIDAT
     ON CHOISIR (ID_TIERS ASC);

# -----------------------------------------------------------------------------
#       TABLE : EXAMEN_PRATIQUE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EXAMEN_PRATIQUE
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   ID_TYPE INTEGER NOT NULL  ,
   ID_EXAM BIGINT(4) NOT NULL  ,
   DATE_P DATETIME NOT NULL  ,
   RESULTAT_P CHAR(32) NOT NULL  
   , PRIMARY KEY (ID_TIERS,ID_TYPE,ID_EXAM) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE EXAMEN_PRATIQUE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_EXAMEN_PRATIQUE_CANDIDAT
     ON EXAMEN_PRATIQUE (ID_TIERS ASC);

CREATE  INDEX I_FK_EXAMEN_PRATIQUE_EXAMEN
     ON EXAMEN_PRATIQUE (ID_TYPE ASC,ID_EXAM ASC);

# -----------------------------------------------------------------------------
#       TABLE : EXAMEN_CODE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS EXAMEN_CODE
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   ID_TYPE INTEGER NOT NULL  ,
   ID_EXAM BIGINT(4) NOT NULL  ,
   DATE_C DATETIME NOT NULL  ,
   RESULTAT_C CHAR(15) NOT NULL  
   , PRIMARY KEY (ID_TIERS,ID_TYPE,ID_EXAM) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE EXAMEN_CODE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_EXAMEN_CODE_CANDIDAT
     ON EXAMEN_CODE (ID_TIERS ASC);

CREATE  INDEX I_FK_EXAMEN_CODE_EXAMEN
     ON EXAMEN_CODE (ID_TYPE ASC,ID_EXAM ASC);

# -----------------------------------------------------------------------------
#       TABLE : REPONDRE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS REPONDRE
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   ID_QUESTION INTEGER NOT NULL  ,
   REPONSE_C CHAR(32) NULL  
   , PRIMARY KEY (ID_TIERS,ID_QUESTION) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE REPONDRE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_REPONDRE_CANDIDAT
     ON REPONDRE (ID_TIERS ASC);

CREATE  INDEX I_FK_REPONDRE_QUESTION
     ON REPONDRE (ID_QUESTION ASC);

# -----------------------------------------------------------------------------
#       TABLE : PLANNING
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PLANNING
 (
   ID_LECON INTEGER NOT NULL  ,
   DHD DATETIME NOT NULL  ,
   ID_VEHICULE INTEGER NOT NULL  ,
   ID_TIERS BIGINT(4) NOT NULL  ,
   ID_TIERS_1 BIGINT(4) NOT NULL  ,
   DHF DATETIME NULL  
   , PRIMARY KEY (ID_LECON,DHD,ID_VEHICULE,ID_TIERS,ID_TIERS_1) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE PLANNING
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_PLANNING_LECON
     ON PLANNING (ID_LECON ASC);

CREATE  INDEX I_FK_PLANNING_DATEL
     ON PLANNING (DHD ASC);

CREATE  INDEX I_FK_PLANNING_VEHICULE
     ON PLANNING (ID_VEHICULE ASC);

CREATE  INDEX I_FK_PLANNING_MONITEUR
     ON PLANNING (ID_TIERS ASC);

CREATE  INDEX I_FK_PLANNING_CANDIDAT
     ON PLANNING (ID_TIERS_1 ASC);

# -----------------------------------------------------------------------------
#       TABLE : ILLUSTRER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ILLUSTRER
 (
   ID_QUESTION INTEGER NOT NULL  ,
   ID_ILLUS INTEGER NOT NULL  
   , PRIMARY KEY (ID_QUESTION,ID_ILLUS) 
 )engine = innoDB;

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE ILLUSTRER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_ILLUSTRER_QUESTION
     ON ILLUSTRER (ID_QUESTION ASC);

CREATE  INDEX I_FK_ILLUSTRER_ILLUSTRATION
     ON ILLUSTRER (ID_ILLUS ASC);

# -----------------------------------------------------------------------------
#       TABLE : H_EXAMEN_PRATIQUE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS H_EXAMEN_PRATIQUE
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   ID_TYPE INTEGER NOT NULL  ,
   ID_EXAM BIGINT(4) NOT NULL  ,
   DATE_HISTO DATE NOT NULL  ,
   DATE_P DATETIME NOT NULL  ,
   RESULTAT_P CHAR(32) NOT NULL  
   , PRIMARY KEY (ID_TIERS,ID_TYPE,ID_EXAM,DATE_HISTO) 
 )engine = innoDB;
 
# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE H_EXAMEN_PRATIQUE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_H_EXAMEN_PRATIQUE_EXAMEN_PRATIQUE
     ON H_EXAMEN_PRATIQUE (ID_TIERS ASC,ID_TYPE ASC,ID_EXAM ASC);

# -----------------------------------------------------------------------------
#       TABLE : H_EXAMEN_CODE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS H_EXAMEN_CODE
 (
   ID_TIERS BIGINT(4) NOT NULL  ,
   ID_TYPE INTEGER NOT NULL  ,
   ID_EXAM BIGINT(4) NOT NULL  ,
   DATE_HISTO DATE NOT NULL  ,
   DATE_C DATETIME NOT NULL  ,
   RESULTAT_C CHAR(15) NOT NULL  
   , PRIMARY KEY (ID_TIERS,ID_TYPE,ID_EXAM,DATE_HISTO) 
 )engine = innoDB;
 
# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE H_EXAMEN_CODE
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_H_EXAMEN_CODE_EXAMEN_CODE
     ON H_EXAMEN_CODE (ID_TIERS ASC,ID_TYPE ASC,ID_EXAM ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE CANDIDAT 
  ADD FOREIGN KEY FK_CANDIDAT_TIERS (ID_TIERS)
      REFERENCES TIERS (ID_TIERS) ;


ALTER TABLE ETUDIANT 
  ADD FOREIGN KEY FK_ETUDIANT_CANDIDAT (ID_TIERS)
      REFERENCES CANDIDAT (ID_TIERS) ;


ALTER TABLE MOTO 
  ADD FOREIGN KEY FK_MOTO_VEHICULE (ID_VEHICULE)
      REFERENCES VEHICULE (ID_VEHICULE) ;


ALTER TABLE EXAMEN 
  ADD FOREIGN KEY FK_EXAMEN_LIEU (ID_LIEU)
      REFERENCES LIEU (ID_LIEU) ;


ALTER TABLE EXAMEN 
  ADD FOREIGN KEY FK_EXAMEN_TYPE_EXAMEN (ID_TYPE)
      REFERENCES TYPE_EXAMEN (ID_TYPE) ;


ALTER TABLE VOITURE 
  ADD FOREIGN KEY FK_VOITURE_VEHICULE (ID_VEHICULE)
      REFERENCES VEHICULE (ID_VEHICULE) ;


ALTER TABLE TIERS 
  ADD FOREIGN KEY FK_TIERS_LIEU (ID_LIEU)
      REFERENCES LIEU (ID_LIEU) ;


ALTER TABLE PERSONNEL 
  ADD FOREIGN KEY FK_PERSONNEL_TIERS (ID_TIERS)
      REFERENCES TIERS (ID_TIERS) ;


ALTER TABLE MONITEUR 
  ADD FOREIGN KEY FK_MONITEUR_TIERS (ID_TIERS)
      REFERENCES TIERS (ID_TIERS) ;


ALTER TABLE SALARIE 
  ADD FOREIGN KEY FK_SALARIE_CANDIDAT (ID_TIERS)
      REFERENCES CANDIDAT (ID_TIERS) ;


ALTER TABLE QUESTION 
  ADD FOREIGN KEY FK_QUESTION_THEME (ID_THEME)
      REFERENCES THEME (ID_THEME) ;


ALTER TABLE REVISION 
  ADD FOREIGN KEY FK_REVISION_VEHICULE (ID_VEHICULE)
      REFERENCES VEHICULE (ID_VEHICULE) ;


ALTER TABLE ROULER 
  ADD FOREIGN KEY FK_ROULER_VEHICULE (ID_VEHICULE)
      REFERENCES VEHICULE (ID_VEHICULE) ;


ALTER TABLE ROULER 
  ADD FOREIGN KEY FK_ROULER_MOIS (ID_MOIS)
      REFERENCES MOIS (ID_MOIS) ;


ALTER TABLE ENTRAINER 
  ADD FOREIGN KEY FK_ENTRAINER_CANDIDAT (ID_TIERS)
      REFERENCES CANDIDAT (ID_TIERS) ;


ALTER TABLE ENTRAINER 
  ADD FOREIGN KEY FK_ENTRAINER_QUIZZ (ID_QUIZZ)
      REFERENCES QUIZZ (ID_QUIZZ) ;


ALTER TABLE COMPOSER 
  ADD FOREIGN KEY FK_COMPOSER_QUESTION (ID_QUESTION)
      REFERENCES QUESTION (ID_QUESTION) ;


ALTER TABLE COMPOSER 
  ADD FOREIGN KEY FK_COMPOSER_QUIZZ (ID_QUIZZ)
      REFERENCES QUIZZ (ID_QUIZZ) ;


ALTER TABLE CHOISIR 
  ADD FOREIGN KEY FK_CHOISIR_FORMULE (ID_FORMULE)
      REFERENCES FORMULE (ID_FORMULE) ;


ALTER TABLE CHOISIR 
  ADD FOREIGN KEY FK_CHOISIR_CANDIDAT (ID_TIERS)
      REFERENCES CANDIDAT (ID_TIERS) ;


ALTER TABLE EXAMEN_PRATIQUE 
  ADD FOREIGN KEY FK_EXAMEN_PRATIQUE_CANDIDAT (ID_TIERS)
      REFERENCES CANDIDAT (ID_TIERS) ;


ALTER TABLE EXAMEN_PRATIQUE 
  ADD FOREIGN KEY FK_EXAMEN_PRATIQUE_EXAMEN (ID_TYPE,ID_EXAM)
      REFERENCES EXAMEN (ID_TYPE,ID_EXAM) ;


ALTER TABLE EXAMEN_CODE 
  ADD FOREIGN KEY FK_EXAMEN_CODE_CANDIDAT (ID_TIERS)
      REFERENCES CANDIDAT (ID_TIERS) ;


ALTER TABLE EXAMEN_CODE 
  ADD FOREIGN KEY FK_EXAMEN_CODE_EXAMEN (ID_TYPE,ID_EXAM)
      REFERENCES EXAMEN (ID_TYPE,ID_EXAM) ;


ALTER TABLE REPONDRE 
  ADD FOREIGN KEY FK_REPONDRE_CANDIDAT (ID_TIERS)
      REFERENCES CANDIDAT (ID_TIERS) ;


ALTER TABLE REPONDRE 
  ADD FOREIGN KEY FK_REPONDRE_QUESTION (ID_QUESTION)
      REFERENCES QUESTION (ID_QUESTION) ;


ALTER TABLE PLANNING 
  ADD FOREIGN KEY FK_PLANNING_LECON (ID_LECON)
      REFERENCES LECON (ID_LECON) ;


ALTER TABLE PLANNING 
  ADD FOREIGN KEY FK_PLANNING_DATEL (DHD)
      REFERENCES DATEL (DHD) ;


ALTER TABLE PLANNING 
  ADD FOREIGN KEY FK_PLANNING_VEHICULE (ID_VEHICULE)
      REFERENCES VEHICULE (ID_VEHICULE) ;


ALTER TABLE PLANNING 
  ADD FOREIGN KEY FK_PLANNING_MONITEUR (ID_TIERS)
      REFERENCES MONITEUR (ID_TIERS) ;


ALTER TABLE PLANNING 
  ADD FOREIGN KEY FK_PLANNING_CANDIDAT (ID_TIERS_1)
      REFERENCES CANDIDAT (ID_TIERS) ;


ALTER TABLE ILLUSTRER 
  ADD FOREIGN KEY FK_ILLUSTRER_QUESTION (ID_QUESTION)
      REFERENCES QUESTION (ID_QUESTION) ;


ALTER TABLE ILLUSTRER 
  ADD FOREIGN KEY FK_ILLUSTRER_ILLUSTRATION (ID_ILLUS)
      REFERENCES ILLUSTRATION (ID_ILLUS) ;


ALTER TABLE H_EXAMEN_PRATIQUE 
  ADD FOREIGN KEY FK_H_EXAMEN_PRATIQUE_EXAMEN_PRATIQUE (ID_TIERS,ID_TYPE,ID_EXAM)
      REFERENCES EXAMEN_PRATIQUE (ID_TIERS,ID_TYPE,ID_EXAM) ;


ALTER TABLE H_EXAMEN_CODE 
  ADD FOREIGN KEY FK_H_EXAMEN_CODE_EXAMEN_CODE (ID_TIERS,ID_TYPE,ID_EXAM)
      REFERENCES EXAMEN_CODE (ID_TIERS,ID_TYPE,ID_EXAM) ;

