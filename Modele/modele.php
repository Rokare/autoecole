<?php

class Modele
{
    private $pdo, $table;

    public function __construct($serveur, $bdd, $user, $mdp)
    {
        $this->pdo = null;
        $this->table = null;

        try{

          $this->pdo = new PDO("mysql:host=".$serveur.";dbname=".$bdd,$user,$mdp);


        }
        catch(Exception $exp){

          echo "Erreur de connexion a la BDD:".$bdd;

        }
    }

    public function selectAll()
    {
        if($this->pdo == null){

            return null;

        }else{

            $requete = "select * from ".$this->table." ;";
            $select = $this->pdo->prepare($requete);
            $select->execute();
            $resultats = $select->fetchAll();

            return $resultats;

        }
    }


    public function insert($donnee){

        if($this->pdo != null){
            $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            $donnees = array();
            $champs = array();

            //Construction des champs
            foreach($donnee as $cle => $valeur){

                $champs[] = ":".$cle;
                $donnees[":".$cle] = $valeur;
            }

            //explode : sépare une chaine de caractère en tableau
            //implode : concatène un tableau
            $matricule = matricule();
            $listeChamps = implode(",", $champs);
            $requete = "insert into ".$this->table." values ('$matricule',".$listeChamps.");";

            $insert = $this->pdo->prepare($requete);
            $insert->execute($donnees);

        }

    }

    public function delete ()
     {
         $requete = "delete from ".$this->table." where ".$this->delid." = ".$this->delid2 ;

         $select = $this->pdo->prepare($requete);
         if($this->pdo != null) //si la connexion n'est pas nullle
         {
             $select->execute();
         }
         else{
             return null;
         }
     }


    public function verifmatricule($matricule)
    {
        if($this->pdo == null){

            return null;

        }else{

            $requete = "select matricule from tiers where matricule = ".$matricule."  ;";
            $select = $this->pdo->prepare($requete);
            $select->execute();
            $resultats = $select->fetchAll();
            if(empty($resultats))
            {
              return true;
            }
            else {
              return false;
            }
        }

    }

    public function getPdo(){

        return $this->pdo;

    }

    public function setTable($table)
    {
        $this->table = $table;
    }


}

?>
