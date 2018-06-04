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
/* TRIGGER QUI INSERE AUTOMATIQUEMENT DANS LA TABLE TIERS AVANT L'INSERTION DANS LA TABLE CANDIDAT */
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


DROP TRIGGER IF EXISTS insertVoiture;

DELIMITER //

CREATE TRIGGER insertVoiture
BEFORE INSERT ON voiture
FOR EACH ROW
    BEGIN
   	declare nb int;
	declare nb2 int;

    

    IF nb > 0 or nb2 > 0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table personnel ";
	ELSE
		
    END IF;


    END //
DELIMITER ;


DROP TRIGGER IF EXISTS insertMoto;

DELIMITER //

CREATE TRIGGER insertMoto
BEFORE INSERT ON moto
FOR EACH ROW
    BEGIN
   	declare nb int;
	declare nb2 int;

    

    IF nb > 0 or nb2 > 0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table personnel ";
	ELSE
		
    END IF;


    END //
DELIMITER ;

DROP TRIGGER IF EXISTS insertPlanning;

DELIMITER //

CREATE TRIGGER insertPlanning
BEFORE INSERT ON planning
FOR EACH ROW
    BEGIN
   	

    

    IF nb > 0 or nb2 > 0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table personnel ";
	ELSE
		
    END IF;


    END //
DELIMITER ;


DROP TRIGGER IF EXISTS updateTiers

DELIMITER //

CREATE TRIGGER updateTiers
AFTER UPDATE ON tiers
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;

DROP TRIGGER IF EXISTS updateCandidat

DELIMITER //

CREATE TRIGGER updateCandidat
AFTER UPDATE ON candidat
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;

DROP TRIGGER IF EXISTS updateEtudiant

DELIMITER //

CREATE TRIGGER updateEtudiant
AFTER UPDATE ON etudiant
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;


DROP TRIGGER IF EXISTS updateSalarie

DELIMITER //

CREATE TRIGGER updateSalarie
AFTER UPDATE ON salarie
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;


DROP TRIGGER IF EXISTS updateVehicule

DELIMITER //

CREATE TRIGGER updateVehicule
AFTER UPDATE ON vehicule
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;

DROP TRIGGER IF EXISTS updateVoiture

DELIMITER //

CREATE TRIGGER updateVoiture
AFTER UPDATE ON voiture
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;

DROP TRIGGER IF EXISTS updateMoto

DELIMITER //

CREATE TRIGGER updateMoto
AFTER UPDATE ON moto
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;

DROP TRIGGER IF EXISTS updatePlanning

DELIMITER //

CREATE TRIGGER updatePlanning
AFTER UPDATE ON moto
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;

DROP TRIGGER IF EXISTS updatePlanning

DELIMITER //

CREATE TRIGGER updatePlanning
BEFORE UPDATE ON planning
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;


DROP TRIGGER IF EXISTS deleteLecon;

DELIMITER //

CREATE TRIGGER deleteLecon
BEFORE DELETE ON lecon
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;


DROP TRIGGER IF EXISTS deleteVehicule;

DELIMITER //

CREATE TRIGGER deleteVehicule
BEFORE DELETE ON vehicule
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;


DROP TRIGGER IF EXISTS deleteTiers;

DELIMITER //

CREATE TRIGGER deleteTiers
BEFORE DELETE ON tiers
FOR EACH ROW
    BEGIN
   	


    END //
DELIMITER ;

