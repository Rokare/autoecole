DROP DATABASE IF EXISTS adlauto;

CREATE DATABASE IF NOT EXISTS adlauto;
USE adlauto;

CREATE TABLE ville(
	id_ville int(8) not null auto_increment,
	cp varchar(5) not null,
	ville varchar(128) not null,
	PRIMARY KEY(id_ville)
);

CREATE TABLE datel(
	dhd datetime not null,
	PRIMARY KEY(dhd)
);

CREATE TABLE type_examen(
	id_type int(4) not null auto_increment,
	libelle varchar(70) not null,
	PRIMARY KEY(id_type)
);

CREATE TABLE examen(
	id_exam int(6) not null auto_increment,
	id_type int(4) not null,
	id_ville int(8) not null,
	FOREIGN KEY(id_ville) REFERENCES ville(id_ville),
	FOREIGN KEY(id_type) REFERENCES type_examen(id_type),
	PRIMARY KEY(id_exam)
);

CREATE TABLE formule(
	id_formule int(4) not null auto_increment,
	libelle varchar(32) not null,
	tarif float not null,
	description varchar(255) not null,
	date_d date not null,
	date_f date,
	PRIMARY KEY(id_formule)
);

CREATE TABLE tiers(
	matricule varchar(9) not null,
	nom varchar(32) not null,
	prenom varchar(32) not null,
	date_n date not null,
	adresse varchar(255) not null,
	login varchar(32) not null,
	mdp varchar(64) not null,
	email varchar(128) not null,
	niveau int not null,
	telephone varchar(10) not null,
	id_ville int(8) not null,
	FOREIGN KEY(id_ville) REFERENCES ville(id_ville),
	PRIMARY KEY(matricule)
);

CREATE TABLE moniteur(
	matricule varchar(9) not null,
	nom varchar(32) not null,
	prenom varchar(32) not null,
	date_n date not null,
	adresse varchar(255) not null,
	login varchar(32) not null,
	mdp varchar(64) not null,
	email varchar(128) not null,
	niveau int not null,
	telephone varchar(10) not null,
	id_ville int(8) not null,
	date_e date not null,
	date_fe date,
	FOREIGN KEY(id_ville) REFERENCES ville(id_ville),
	FOREIGN KEY(matricule) REFERENCES tiers(matricule),
	PRIMARY KEY(matricule)
);

CREATE TABLE personnel(
	matricule varchar(9) not null,
	nom varchar(32) not null,
	prenom varchar(32) not null,
	date_n date not null,
	adresse varchar(255) not null,
	login varchar(32) not null,
	mdp varchar(64) not null,
	email varchar(128) not null,
	niveau int not null,
	telephone varchar(10) not null,
	id_ville int(8) not null,
	date_e date not null,
	date_fe date,
	FOREIGN KEY(id_ville) REFERENCES ville(id_ville),
	FOREIGN KEY(matricule) REFERENCES tiers(matricule),
	PRIMARY KEY(matricule)
);

CREATE TABLE candidat(
	matricule varchar(9) not null,
	nom varchar(32) not null,
	prenom varchar(32) not null,
	date_n date not null,
	adresse varchar(255) not null,
	login varchar(32) not null,
	mdp varchar(64) not null,
	email varchar(128) not null,
	niveau int not null,
	telephone varchar(10) not null,
	id_ville int(8) not null,
	date_i date not null,
	mode_fact varchar(32) not null,
	FOREIGN KEY(id_ville) REFERENCES ville(id_ville),
	FOREIGN KEY(matricule) REFERENCES tiers(matricule),
	PRIMARY KEY(matricule)
);

CREATE TABLE etudiant(
	matricule varchar(9) not null,
	nom varchar(32) not null,
	prenom varchar(32) not null,
	date_n date not null,
	adresse varchar(255) not null,
	login varchar(32) not null,
	mdp varchar(64) not null,
	email varchar(128) not null,
	niveau int not null,
	telephone varchar(10) not null,
	id_ville int(8) not null,
	date_i date not null,
	mode_fact varchar(32) not null,
	niv_etu int not null,
	reduc int not null,
	FOREIGN KEY(id_ville) REFERENCES ville(id_ville),
	FOREIGN KEY(matricule) REFERENCES candidat(matricule),
	PRIMARY KEY(matricule)
);

CREATE TABLE salarie(
	matricule varchar(9) not null,
	nom varchar(32) not null,
	prenom varchar(32) not null,
	date_n date not null,
	adresse varchar(255) not null,
	login varchar(32) not null,
	mdp varchar(64) not null,
	email varchar(128) not null,
	niveau int not null,
	telephone varchar(10) not null,
	id_ville int(8) not null,
	date_i date not null,
	mode_fact varchar(32) not null,
	nom_entrep varchar(128),
	FOREIGN KEY(id_ville) REFERENCES ville(id_ville),
	FOREIGN KEY(matricule) REFERENCES candidat(matricule),
	PRIMARY KEY(matricule)
);


CREATE TABLE mois(
	id_mois int not null auto_increment,
	annee year not null,
	PRIMARY KEY(id_mois)
);

CREATE TABLE vehicule(
	id_vehicule int(4) not null auto_increment,
	num_imma varchar(10) not null,
	nom_mod varchar(32) not null,
	annee year not null,
	date_achat date not null,
	nb_kilo_ini float,
	etat varchar(8) not null,
	PRIMARY KEY(id_vehicule)
);

CREATE TABLE voiture(
	id_vehicule int(4) not null auto_increment,
	num_imma varchar(10) not null,
	nom_mod varchar(32) not null,
	annee char(4) not null,
	date_achat date not null,
	nb_kilo_ini float,
	etat varchar(8) not null,
	conso varchar(8),
	nb_places int(2),
	FOREIGN KEY(id_vehicule) REFERENCES vehicule(id_vehicule),
	PRIMARY KEY(id_vehicule)
);

CREATE TABLE moto(
	id_vehicule int(4) not null auto_increment,
	num_imma varchar(10) not null,
	nom_mod varchar(32) not null,
	annee year not null,
	date_achat date not null,
	nb_kilo_ini float,
	etat varchar(8) not null,
	cylindres int(3),
	puissance int(8),
	FOREIGN KEY(id_vehicule) REFERENCES vehicule(id_vehicule),
	PRIMARY KEY(id_vehicule)
);

CREATE TABLE revision(
	id_revision int not null auto_increment,
	libelle varchar(32) not null,
	motif varchar(255) not null,
	date_revision date,
	id_vehicule int(4) not null,
	FOREIGN KEY(id_vehicule) REFERENCES vehicule(id_vehicule),
	PRIMARY KEY(id_revision)
);

CREATE TABLE rouler(
	nb_km int not null,
	id_vehicule int not null,
	id_mois int not null,
	FOREIGN KEY(id_vehicule) REFERENCES vehicule(id_vehicule),
	FOREIGN KEY(id_mois) REFERENCES mois(id_mois),
	PRIMARY KEY(id_vehicule, id_mois)
);

CREATE TABLE lecon(
	id_lecon int not null auto_increment,
	intitule varchar(32) not null,
	duree float,
	date_hd date not null,
	PRIMARY KEY(id_lecon)
);

CREATE TABLE planning(
	date_hf date,
	id_lecon int not null,
	id_vehicule int(4) not null,
	dhd datetime not null,
	mat_m varchar(7) not null,
	mat_c varchar(7) not null,
	FOREIGN KEY(id_lecon) REFERENCES lecon(id_lecon),
	FOREIGN KEY(id_vehicule) REFERENCES vehicule(id_vehicule),
	FOREIGN KEY(mat_m) REFERENCES moniteur(matricule),
	FOREIGN KEY(mat_c) REFERENCES candidat(matricule),
	FOREIGN KEY(dhd) REFERENCES datel(dhd),
	PRIMARY KEY(id_lecon, id_vehicule, mat_m, mat_c, dhd)
);

CREATE TABLE choisir(
	date_souscription date not null,
	id_formule int(4) not null,
	mat_c varchar(7) not null,
	FOREIGN KEY(id_formule) REFERENCES formule(id_formule),
	FOREIGN KEY(mat_c) REFERENCES candidat(matricule),
	PRIMARY KEY(id_formule, mat_c)
);

CREATE TABLE examen_code(
	date_c date not null,
	resultat_c varchar(10),
	matricule varchar(7) not null,
	id_exam int(6) not null,
	FOREIGN KEY(matricule) REFERENCES candidat(matricule),
	FOREIGN KEY(id_exam) REFERENCES examen(id_exam),
	PRIMARY KEY(matricule, id_exam)
);

CREATE TABLE examen_pratique(
	date_p date not null,
	resultat_p varchar(10),
	matricule varchar(7) not null,
	id_exam int(6) not null,
	FOREIGN KEY(matricule) REFERENCES candidat(matricule),
	FOREIGN KEY(id_exam) REFERENCES examen(id_exam),
	PRIMARY KEY(matricule, id_exam)
);

CREATE TABLE h_examen_code AS
SELECT *
FROM examen_code
WHERE 1 = 2;

CREATE TABLE h_examen_pratique AS
SELECT *
FROM examen_pratique
WHERE 1 = 2;


source C:\Users\user\Downloads\villes_france.sql

INSERT INTO ville(id_ville, cp, ville)
SELECT ville_id, ville_code_postal,ville_nom
FROM villes_france_free;

DROP TABLE villes_france_free;

INSERT INTO PERSONNEL (matricule, nom, prenom, date_n, adresse, login, mdp, email, niveau, telephone, id_ville, date_e, date_fe) VALUES
('M12345678', 'admin', 'admin', curdate(), 'admin', 'admin',  sha1('123') , 'admin@adlauto.fr', 1, '0181570057', 1, curdate(), null);
