
<?php
    
    include("modele/modele.php");
    class Controleur
    {
        
        private $unModele;
        
        public function __construct($server, $bdd, $user, $mdp, $table)
        {
           $this->unModele = new Modele ($server, $bdd, $user, $mdp);
            $this->unModele->setTable($table);  
        }
        
        public function selectAll ()
        {

            if($this->unModele->getPdo() != null)
            {
               return $this->unModele->selectAll();

            }
            else{
                return null;
            }
        }
        
        public function insert($unEleve)
        {
            //traitement des infos
            $tab = $unEleve->serialiser();
            $this->unModele->insert($tab);
        }
    }






      
    
    
?>
