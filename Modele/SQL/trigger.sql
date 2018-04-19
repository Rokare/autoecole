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
	
    SELECT count(*) into nb 
	from etudiant 
	where email = new.email 
	or login = new.login 
	or matricule = new.matricule;
	
    IF nb > 0 
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



insert into etudiant values("grxegr", "grxegeg", "grerx", "0000-05-03", "gxegrg","grxer", "gxrg", "gxrre", "grxeg", 4444, "0000-02-02","gexgg",25, 25);