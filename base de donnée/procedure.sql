


DROP PROCEDURE IF EXISTS statut ;
DELIMITER //
CREATE PROCEDURE statut
(log text, mdp text, OUT val text)
BEGIN
DECLARE cand int;
DECLARE perso int;
DECLARE moni int;

select count(matricule) into cand
from candidat
where login = log
and mdp = mdp;

select count(matricule) into perso
from personnel
where login = log
and mdp = mdp;

select count(matricule) into moni
from moniteur
where login = log
and mdp = mdp;



	IF cand > 0 and perso = 0 and moni = 0 THEN
	set val ='candidat';
	END IF;
	IF cand = 0 and perso > 0 and moni = 0 THEN
	set val ='personnel';
	END IF;
	IF cand = 0 and perso = 0 and moni > 0 THEN
	set val ='moniteur';
	END IF; 
	
END //
DELIMITER ;


call verifstatut('admin', '123', @out_value);