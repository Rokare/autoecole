DROP FUNCTION IF EXISTS statut;
DELIMITER //
CREATE FUNCTION statut(log text, mdp text)
returns varchar(20)
		DETERMINISTIC

	BEGIN
	
	DECLARE statut varchar(20);
	DECLARE cand int;
	DECLARE perso int;
	DECLARE moni int;
	
	select count(*) as cand
	from  candidat
	where login = log
	and mdp = mdp;
	
	select count(*) as moni
	from  moniteur
	where login = log
	and mdp = mdp;
	
	select count(*) as perso
	from  personnel
	where login = log
	and mdp = mdp;
	
	IF cand > 0 and perso = 0 and moni = 0 
	THEN
		SET statut ='candidat';
	ELSE IF cand = 0 and perso > 0 and moni = 0
	THEN
		SET statut ="personnel";
	ELSE IF cand = 0 and perso = 0 and moni > 0
	THEN
		SET statut ="moniteur";
	ELSE
		SET statut = "ERREUR";
		
	END IF;
	
	return(statut);
	
	
	END //
DELIMITER ;
