<?php

class vehicule

    {
    protected $id_vehicule, $num_immatri, $nom_mod, $annee_mod, $date_achat, $nb_kilo_ini, $etat;
    public function __construct()
    {
        $this->idvehicule = 0;
        $this->num_immatri = "";
        $this->nom_mod = "";
        $this->annee_mod = "";
        $this->date_achat = "";
        $this->nb_kilo_ini = 0;
        $this->etat = "";
    }




    public function renseigner($tab){

        $this->num_immatri = $tab['num_immatri'];
        $this->nom_mod = $tab['nom_mod'];
        $this->annee_mod = $tab['annne_mod'];
        $this->date_achat = $tab['date_achat'];
        $this->nb_kilo_ini = $tab['nb_kilo_ini'];
        $this->etat = $tab['etat'];

    }

    //Methode qui permet de serialiser l'objet -> tableau
    public function serialiser(){

        $tab = array();
        $tab['num_immatri'] = $this->num_immatri;
        $tab['nom_mod'] = $this->nom_mod ;
        $tab['annne_mod'] =  $this->annee_mod ;
        $tab['date_achat'] = $this->date_achat;
        $tab['nb_kilo_ini'] = $this->nb_kilo_ini;
        $tab['etat'] = $this->etat;
        return($tab);
    }

    
    /* GETTERS*/
    public function getId_Vehicule(){
        return $this->id_vehicule;
    }

    public function getNum_Immatri(){

        return $this->num_immatri;

    }

    public function getNom_Mod(){

        return $this->nom_mod;

    }

    public function getAnnee_Mod(){

        return $this->annee_mod;

    }

    public function getDateAchat(){

        return $this->date_achat;

    }

    public function getNb_Kilo_Ini(){

        return $this->nb_kilo_ini;

    }

    public function getEtat(){
        return $this->etat;
    }



    /* SETTERS */
    public function setId_Vehicule($id_vehicule){
        $this->id_vehicule = $id_vehicule;
    }

    public function setNum_Immatri($num_immatri){

        $this->num_immatri = $num_immatri;

    }

    public function setNom_Mod($nom_mod){

        $this->nom_mod = $nom_mod;

    }

    public function setAnnee_Mod($annne_mod){

        $this->annne_mod = $annne_mod;

    }

    public function setDate_Achat($date_achat){

        $this->date_achat = $date_achat;

    }

    public function setNb_Kilo_Ini($nb_kilo_ini){

        $this->nb_kilo_ini = $nb_kilo_ini;

    }

    public function setEtat($etat)
    {
        $this->etat = $etat;
    }

}


?>
