--TRIGGERS--
DROP TRIGGER IF EXISTS insertCandidat;

DELIMITER //
/* TRIGGER QUI INSERE AUTOMATIQUEMENT DANS LA TABLE CANDIDAT AVANT L'INSERTION DANS LA TABLE ETUDIANT */
CREATE TRIGGER insertCandidat
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
	from tiers
	where email = new.email
	or login = new.login
	or matricule = new.matricule;

    IF nb > 0 OR nb2 >0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table candidat ";

    ELSE
		    insert into candidat values(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, 4, new.telephone, new.id_ville, curdate(), new.mode_fact);
    END IF;


    END //
DELIMITER ;



DROP TRIGGER IF EXISTS insertSalarie;
DELIMITER //

/* TRIGGER QUI INSERE AUTOMATIQUEMENT DANS LA TABLE CANDIDAT AVANT L'INSERTION DANS LA TABLE SALARIE */
CREATE TRIGGER insertSalarie
BEFORE INSERT ON salarie
FOR EACH ROW
BEGIN
    DECLARE nb int;
    DECLARE nb2 int;

    SELECT count(*) int nb
    FROM salarie
    WHERE email = new.email
    OR login = new.login
    OR matricule = new.matricule;

    SELECT count(*) into nb2
  	from tiers
  	where email = new.email
  	or login = new.login
  	or matricule = new.matricule;

    IF nb > 0 OR nb2 > 0
    THEN
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = "Erreur d'insertion dans la table tiers";
    ELSE
        INSERT INTO candidat VALUES(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.email, 4, new.telephone, new.id_ville, curdate(), new.mode_fact);
    END IF;
END //
DELIMITER ;



DROP TRIGGER IF EXISTS insertTiers;

DELIMITER //
/* TRIGGER QUI INSERE AUTOMATIQUEMENT DANS LA TABLE CANDIDAT AVANT L'INSERTION DANS LA TABLE TIERS */
CREATE TRIGGER insertTiers
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
        SET MESSAGE_TEXT = " erreur d'insertion dans la table tiers ";
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
