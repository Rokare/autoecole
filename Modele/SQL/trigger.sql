DROP TRIGGER IF EXISTS insertCandidat;

DELIMITER //

CREATE TRIGGER insertCandidat
AFTER INSERT ON etudiant
FOR EACH ROW
    BEGIN
   	declare nb int;
	
    SELECT count(*) into nb 
	from candidat 
	where email = new.email 
	or login = new.login 
	or matricule = new.matricule;
	
    IF nb > 0 
    THEN  
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table candidat ";
	ELSE
		insert into candidat values(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, new.telephone, new.id_ville, new.date_i, new.mode_fact);
    END IF;
	

    END //
DELIMITER ;


DROP TRIGGER IF EXISTS insertEtudiant;

DELIMITER //

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
	from tiers 
	where email = new.email 
	or login = new.login 
	or matricule = new.matricule;
	
    IF nb > 0 or nb2 > 0
    THEN  
        SIGNAL SQLSTATE '42000'
        SET MESSAGE_TEXT = " erreur d'insertion dans la table etudiant ";

    END IF;
	

    END //
DELIMITER ;



DROP TRIGGER IF EXISTS insertTiers;

DELIMITER //

CREATE TRIGGER insertTiers
AFTER INSERT ON candidat
FOR EACH ROW
    BEGIN
   	declare nb int;
	
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
		insert into tiers values(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, new.telephone, new.id_ville);
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
		insert into tiers values(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, new.telephone, new.id_ville);
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
		insert into tiers values(new.matricule, new.nom, new.prenom, new.date_n, new.adresse, new.login, new.mdp, new.email, new.telephone, new.id_ville);
    END IF;
	

    END //
DELIMITER ;










SELECT count(*) 
	from tiers
	where email = "grxeg" 
	or login = "gxrg" 
	or matricule = "grxegr";





insert into moniteur values("grxegr", "grxegeg", "grerx", "0000-05-03", "gxegrg", "gxrg", "gxrre", "grxeg","4544",44444, "0000-02-02","0000-02-02");