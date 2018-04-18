<?php

class Vehicule
{
    protected $idVehicule, $numImmatri, $nomMod, $anneeMod, $dateAchat, $nbKiloIni, $etat;

    public function __construct()
    {
        $this->idVehicule = 0;
        $this->numImmatri = "";
        $this->nomMod = "";
        $this->anneeMod = "";
        $this->dateAchat = "";
        $this->nbKiloIni = 0;
        $this->etat = "";
    }




    /* GETTERS*/
    public function getIdVehicule(){
        return $this->idVehicule;
    }

    public function getNumImmatri(){

        return $this->numImmatri;

    }

    public function getNomMod(){

        return $this->nomMod;

    }

    public function getAnneeMod(){

        return $this->anneeMod;

    }

    public function getDateAchat(){

        return $this->dateAchat;

    }

    public function getNbKiloIni(){

        return $this->nbKiloIni;

    }

    public function getEtat(){
        return $this->etat;
    }



    /* SETTERS */
    public function setIdVehicule($idVehicule){
        $this->idVehicule = $idVehicule;
    }

    public function setNumImmatri($numImmatri){

        $this->numImmatri = $numImmatri;

    }

    public function setNomMod($nomMod){

        $this->nomMod = $nomMod;

    }

    public function setAnneeMod($anneeMod){

        $this->anneeMod = $anneeMod;

    }

    public function setDateAchat($dateAchat){

        $this->dateAchat = $dateAchat;

    }

    public function setNbKiloIni($nbKiloIni){

        $this->nbKiloIni = $nbKiloIni;

    }

    public function setEtat($etat)
    {
        $this->etat = $etat;
    }

}


?>
