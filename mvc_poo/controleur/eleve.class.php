<?php

    class Eleve
    {
        
        private $nom, $prenom, $classe, $age;
        
        public function __construct()
        {
            $this->nom = "";
            $this->prenom = "";
            $this->classe = "";
            $this->age = 0;
            
        }
        
        public function renseigner ($tab)
        {
            $this->nom = $tab["nom"];
            $this->prenom = $tab["prenom"];
            $this->classe = $tab["classe"];
            $this->age = $tab["age"];
        }
       // une méthode qui permet de serialiser l objet -> tableau
        
        
        public function serialiser ()
        {
            
            $tab = array();
            $tab["nom"] = $this->nom;
            $tab["prenom"] = $this->prenom;
            $tab["classe"] = $this->classe;
            $tab["age"] = $this->age;
            return $tab;
        }
        
        public function getNom()
        {
            return $this->nom;
        }
        
        public function setNom($nom)
        {
            $this->nom = $nom;
        }
        
        public function getPrenom()
        {
            return $this->prenom;
        }
        
        public function setPrenom($prenom)
        {
            $this->prenom = $prenom;
        
        }

        public function getClasse()
        {
            return $this->classe;
        }
        
        public function setClasse($classe)
        {
            $this->Classe = $classe;

        }

        public function getAge()
        {
            return $this->age;
        }
        
        public function setAge($age)
        {
            $this->age = $age;


        }



    }






?>