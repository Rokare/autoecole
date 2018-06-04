--TRIGGERS--
DROP TRIGGER IF EXISTS insertEtudiant;

DELIMITER //
/* TRIGGER QUI INSERE AUTOMATIQUEMENT DANS LA TABLE CANDIDAT AVANT L'INSERTION DANS LA TABLE ETUDIANT */
CREATE TRIGGER insertEtudiant
BEFORE INSERT ON etudiant
FOR EACH ROW
BEGIN
  declare nb int;
  declare nb2 int;

  SELECT count(*) into nb
	from etudiant
	where email = new.email
	or login = new.login
	or matricule = new.matricule;

	SELECT count(*) into nb2
	from candidat
	where email = new.email
	or login = new.login
	or matricule = new.matricule;

    IF nb > 0 OR nb2 > 0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table candidat ";

    ELSE
		    insert into candidat values(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, 4, new.telephone, new.id_ville, new.date_i, new.mode_fact);
    END IF;


    END //
DELIMITER ;



DROP TRIGGER IF EXISTS insertSalarie;
DELIMITER //
CREATE TRIGGER insertSalarie
BEFORE INSERT ON Salarie
FOR EACH ROW
/**/
BEGIN
    DECLARE nb int;
    DECLARE nb2 int;

    SELECT count(*) into nb
    FROM Salarie
    WHERE email = new.email
    OR login = new.login
    OR matricule = new.matricule;

    SELECT count(*) into nb2
  	from candidat
  	where email = new.email
  	or login = new.login
  	or matricule = new.matricule;

    IF nb > 0 OR nb2 > 0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = "Erreur d'insertion dans la table tiers";
    ELSE
        INSERT INTO candidat VALUES(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, 4, new.telephone, new.id_ville, new.date_i, new.mode_fact);
    END IF;
END //
DELIMITER ;



DROP TRIGGER IF EXISTS insertCandidat;

DELIMITER //
/* TRIGGER QUI INSERE AUTOMATIQUEMENT DANS LA TABLE CANDIDAT AVANT L'INSERTION DANS LA TABLE TIERS */
CREATE TRIGGER insertCandidat
BEFORE INSERT ON candidat
FOR EACH ROW
BEGIN
  DECLARE nb int;

  SELECT count(*) into nb
	from tiers
	where email = new.email
	or login = new.login
	or matricule = new.matricule;

    IF nb > 0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table tiers TRIGGER CANDIDAT";
	  ELSE
		    insert into tiers values(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, 4, new.telephone, new.id_ville);
    END IF;


END //
DELIMITER ;





DROP TRIGGER IF EXISTS insertMoniteur;

DELIMITER //

CREATE TRIGGER insertMoniteur
BEFORE INSERT ON moniteur
FOR EACH ROW
BEGIN
  declare nb int;
	declare nb2 int;

  SELECT count(*) into nb
	from moniteur
	where email = new.email
	or login = new.login
	or matricule = new.matricule;

	SELECT count(*) into nb2
	from tiers
	where email = new.email
	or login = new.login
	or matricule = new.matricule;

    IF nb > 0 or nb2 > 0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table moniteur ";
	ELSE
		insert into tiers values(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, 3, new.telephone, new.id_ville);
    END IF;


    END //
DELIMITER ;




DROP TRIGGER IF EXISTS insertPersonnel;

DELIMITER //

CREATE TRIGGER insertPersonnel
BEFORE INSERT ON personnel
FOR EACH ROW
    BEGIN
   	declare nb int;
	declare nb2 int;

    SELECT count(*) into nb
	from personnel
	where email = new.email
	or login = new.login
	or matricule = new.matricule;

	SELECT count(*) into nb2
	from tiers
	where email = new.email
	or login = new.login
	or matricule = new.matricule;

    IF nb > 0 or nb2 > 0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table personnel ";
	ELSE
		insert into tiers values(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, new.niveau, new.telephone, new.id_ville);
    END IF;


    END //
DELIMITER ;



DROP TRIGGER IF EXISTS deleteCandidat;

DELIMITER //

CREATE TRIGGER deleteCandidat
BEFORE DELETE ON candidat
FOR EACH ROW
    BEGIN
   	declare nb int ;
	declare nb2 int ;

    SELECT count(*) into nb
	from salarie
	where matricule = old.matricule;

	SELECT count(*) into nb2
	from etudiant
	where matricule = old.matricule;

    IF nb > 0 
    THEN
        DELETE FROM salarie where matricule = old.matricule;
	ELSEIF nb2 > 0
	THEN
		DELETE FROM etudiant where matricule = old.matricule;	
	
    END IF;


    END //
DELIMITER ;





DROP TRIGGER IF EXISTS deleteTiers;

DELIMITER //

CREATE TRIGGER deleteTiers
BEFORE DELETE ON tiers
FOR EACH ROW
    BEGIN
   	declare nb int ;
	declare nb2 int ;
	declare nb3 int;

    SELECT count(*) into nb
	from candidat
	where matricule = old.matricule;

	SELECT count(*) into nb2
	from moniteur
	where matricule = old.matricule;
	
	SELECT count(*) into nb3
	from personnel
	where matricule = old.matricule;

    IF nb > 0 
    THEN
        DELETE FROM candidat where matricule = old.matricule;
	ELSEIF nb2 > 0
	THEN
		DELETE FROM moniteur where matricule = old.matricule;
	ELSEIF nb3 > 0
	THEN
		DELETE FROM personnel where matricule = old.matricule;
    END IF;


    END //
DELIMITER ;





DROP TRIGGER IF EXISTS udpateMoniteur;

DELIMITER //

CREATE TRIGGER udpateMoniteur
BEFORE UPDATE ON moniteur
FOR EACH ROW
    BEGIN
   	
	
	update tiers
	set nom = new.nom, prenom = new.prenom, date_n= new.date_n, adresse = new.adresse, login = new.login, mdp = new.mdp, email= new.email, niveau = new.niveau, telephone = new.telephone, id_ville = new.id_ville
	where matricule = new.matricule;

    END //
DELIMITER ;


DROP TRIGGER IF EXISTS udpatePersonnel;

DELIMITER //

CREATE TRIGGER udpatePersonnel
BEFORE UPDATE ON personnel
FOR EACH ROW
    BEGIN
   	
	
	update tiers
	set nom = new.nom, prenom = new.prenom, date_n= new.date_n, adresse = new.adresse, login = new.login, mdp = new.mdp, email= new.email, niveau = new.niveau, telephone = new.telephone, id_ville = new.id_ville
	where matricule = new.matricule;

    END //
DELIMITER ;



DROP TRIGGER IF EXISTS udpateEtudiant;

DELIMITER //

CREATE TRIGGER udpateEtudiant
BEFORE UPDATE ON etudiant
FOR EACH ROW
    BEGIN
   	
	
	update candidat
	set nom = new.nom, prenom = new.prenom, date_n= new.date_n, adresse = new.adresse, login = new.login, mdp = new.mdp, email= new.email, niveau = new.niveau, telephone = new.telephone, id_ville = new.id_ville, date_i = new.date_i, mode_fact = new.mode_fact
	where matricule = new.matricule;

    END //
DELIMITER ;


DROP TRIGGER IF EXISTS udpateSalarie;

DELIMITER //

CREATE TRIGGER udpateSalarie
BEFORE UPDATE ON salarie
FOR EACH ROW
    BEGIN
   	
	
	update candidat
	set nom = new.nom, prenom = new.prenom, date_n= new.date_n, adresse = new.adresse, login = new.login, mdp = new.mdp, email= new.email, niveau = new.niveau, telephone = new.telephone, id_ville = new.id_ville, date_i = new.date_i, mode_fact = new.mode_fact
	where matricule = new.matricule;

    END //
DELIMITER ;


DROP TRIGGER IF EXISTS udpateCandidat;

DELIMITER //

CREATE TRIGGER udpateCandidat
BEFORE UPDATE ON candidat
FOR EACH ROW
    BEGIN
   	
	
	update tiers
	set nom = new.nom, prenom = new.prenom, date_n= new.date_n, adresse = new.adresse, login = new.login, mdp = new.mdp, email= new.email, niveau = new.niveau, telephone = new.telephone, id_ville = new.id_ville
	where matricule = new.matricule;

    END //
DELIMITER ;



DROP TRIGGER IF EXISTS DeleteCandidat;

DELIMITER //

CREATE TRIGGER DeleteCandidat
BEFORE Delete ON candidat
FOR EACH ROW
    BEGIN
   	
	
	delete from planning
	where mat_c = old.matricule;

    END //
DELIMITER ;


DROP TRIGGER IF EXISTS DeleteMoniteur;

DELIMITER //

CREATE TRIGGER DeleteMoniteur
BEFORE Delete ON moniteur
FOR EACH ROW
    BEGIN
   	
	
	delete from planning
	where mat_m = old.matricule;

    END //
DELIMITER ;

DROP TRIGGER IF EXISTS DeleteLecon;

DELIMITER //

CREATE TRIGGER DeleteLecon
BEFORE Delete ON lecon
FOR EACH ROW
    BEGIN
   	
	
	delete from planning
	where id_lecon = old.id_lecon;

    END //
DELIMITER ;



DROP TRIGGER IF EXISTS insertMoto;

DELIMITER //

CREATE TRIGGER insertMoto
BEFORE INSERT ON moto
FOR EACH ROW
    BEGIN
   	declare nb int;
	

    SELECT count(*) into nb
	from vehicule
	where id_vehicule = new.id_vehicule;


    IF nb > 0 
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table vehicule ";
	ELSE
		insert into vehicule values(new.id_vehicule, new.num_imma, new.nom_mod, new.annee, new.date_achat, new.nb_kilo_ini, new.etat);
    END IF;


    END //
DELIMITER ;



DROP TRIGGER IF EXISTS insertVoiture;

DELIMITER //

CREATE TRIGGER insertVoiture
BEFORE INSERT ON voiture
FOR EACH ROW
    BEGIN
   	declare nb int;
	

    SELECT count(*) into nb
	from vehicule
	where id_vehicule = new.id_vehicule;


    IF nb > 0 
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table vehicule ";
	ELSE
		insert into vehicule values(new.id_vehicule, new.num_imma, new.nom_mod, new.annee, new.date_achat, new.nb_kilo_ini, new.etat);
    END IF;


    END //
DELIMITER ;



DROP TRIGGER IF EXISTS deleteMoto;

DELIMITER //

CREATE TRIGGER deleteMoto
BEFORE DELETE ON moto
FOR EACH ROW
    BEGIN
   	declare nb int ;
	

    SELECT count(*) into nb
	from vehicule
	where id_vehicule = old.id_vehicule;


    IF nb > 0 
    THEN
        DELETE FROM vehicule where id_vehicule = old.id_vehicule;
	
    END IF;


    END //
DELIMITER ;



DROP TRIGGER IF EXISTS deleteVoiture;

DELIMITER //

CREATE TRIGGER deleteVoiture
BEFORE DELETE ON voiture
FOR EACH ROW
    BEGIN
   	declare nb int ;
	

    SELECT count(*) into nb
	from vehicule
	where id_vehicule = old.id_vehicule;


    IF nb > 0 
    THEN
        DELETE FROM vehicule where id_vehicule = old.id_vehicule;
	
    END IF;


    END //
DELIMITER ;




DROP TRIGGER IF EXISTS deleteVehicule;

DELIMITER //

CREATE TRIGGER deleteVehicule
BEFORE DELETE ON vehicule
FOR EACH ROW
    BEGIN
   	declare nb int ;
	declare nb2 int ;
	

    SELECT count(*) into nb
	from moto
	where id_vehicule = old.id_vehicule;

	SELECT count(*) into nb2
	from voiture
	where id_vehicule = old.id_vehicule;
	


    IF nb > 0 
    THEN
        DELETE FROM moto where id_vehicule = old.id_vehicule;
	ELSEIF nb2 > 0
	THEN
		DELETE FROM voiture where id_vehicule = old.id_vehicule;
    END IF;


    END //
DELIMITER ;




