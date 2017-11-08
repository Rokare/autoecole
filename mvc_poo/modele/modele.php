
<?php

    class Modele
    {
        
        private $pdo, $table;

        public function __construct ($server, $bdd, $user, $mdp)
        {
            $pdo = null;
            $this->table="";
            try{
                $this->pdo = new PDO ("mysql:host=".$server."; dbname=".$bdd,$user, $mdp);
            }
            catch(Exception $exp)
            {
              echo "Erreur de connexion a la bdd iris" ;
            }
            return $pdo;//pour l'utiliser à l'extérieur
        }
        public function setTable ($table)
        {
            $this->table  = $table;
        }
        public function selectAll()
        {

            if ($this->pdo ==null)
            {
                return null;
            }else{
                $requete = "select * from ".$this->table." ;";
                $select = $this->pdo->prepare($requete);
                $select->execute ();
                $resultats = $select->fetchAll();
                return $resultats;
            }
        }
        public function insert($uneDonnee)
        {
             if ($this->pdo !=null)
             {
               
                 $donnees = array();
                 $champs = array();
                 //construction des champs
                 foreach($uneDonnee as $cle=>$valeur)
                 {
                     $champs[] = ":".$cle;
                     $donnees[":".$cle] = $valeur;
                     
                 }
                 $listeChamps = implode(",", $champs); //rassemble les champs
                 $requete ="insert into ".$this->table." values (null, ".$listeChamps.");";
                 
                 $insert =$this->pdo->prepare ($requete);
                 $insert->execute($donnees);
             }
        }
        public function getPdo()
        {
            return $this->pdo;
        }
    }

?>

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
