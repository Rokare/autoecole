<?php
include("tiers.class.php");
class Candidat extends Tiers{

    private $dateInscription, $modeFacturation;

    public function __construct(){

        parent::__construct();
        $this->dateInscription = "";
        $this->modeFacturation = "";

    }


    public function renseigner($tab){

        $this->nom = $tab['nom'];
        $this->prenom = $tab['prenom'];
        $this->dateNaissance = $tab['date_n'];
        $this->adresse = $tab['adresse'];
        $this->login = $tab['login'];
        $this->mdp = sha1($tab['mdp']);
        $this->email = $tab['email'];
        $this->niveau = 4;
        $this->telephone = $tab['telephone'];
        $this->id_ville = $tab['id_ville'];
        $this->dateInscription = date("Y-m-d");
        $this->modeFacturation = $tab['mode_fact'];

    }

    //Methode qui permet de serialiser l'objet -> tableau
    public function serialiser(){

        $tab = array();


        $tab['nom'] = $this->nom ;
        $tab['prenom'] = $this->prenom;
        $tab['date_n'] = $this->dateNaissance;
        $tab['adresse'] = $this->adresse;
        $tab['login'] = $this->login;
        $tab['mdp'] = $this->mdp;
        $tab['email'] =$this->email;
        $tab['niveau']=$this->niveau;
        $tab['telephone'] = $this->telephone;
        $tab['id_ville'] = $this->id_ville;
        $tab['date_i'] = $this->dateInscription;
        $tab['mode_fact']= $this->modeFacturation;
        return($tab);
    }


    /* GETTERS */
    public function getDateInscription(){
        return $this->dateInscription;
    }

    public function getModeFacturation(){
        return $this->modeFacturation;
    }


    /*SETTERS*/
    public function setDateInscription($dateInscription){
        $this->dateInscription = $dateInscription;
    }

    public function setModeFacturation($modeFacturation){
        $this->modeFacturation = $modeFacturation;
    }

}


?>
