<?php


class Formule
{
    protected $idFormule, $libelle, $tarif, $description, $date_debut, $date_fin ;

    public function __construct()
    {
        $this->idFormule = 0;
        $this->libelle = "";
        $this->tarif = "";
        $this->description = "";
        $this->dateDebut = "";
        $this->dateFin = "";
        $this->tarif = "";
    }


    public function getIdFormule()
    {
        return $this->idFormule;
    }
    public function getLibelle()
    {
        return $this->libelle;
    }
    public function getTarif()
    {
        return $this->tarif;
    }
   

    public function getDescription()
    {
        return $this->description;
    }

    public function getDateDebut()
    {
        return $this->dateDebut;
    }

    public function getDateFin()
    {
        return $this->dateFin;
    }

    public function setIdFormule($idFormule)
    {
        $this->idFormule = $idFormule;
    }

    public function setLibelle($libelle)
    {
        $this->libelle = $libelle;
    }

    public function setTarif($tarif)
    {
        $this->tarif =  $tarif;
    }

    public function setDescitpion($description)
    {
        $this->description = $description;
    }
    
    public function setDateDebut($date_debut)
    {
        $this->dateDebut = $date_debut;
    }

    public function setDateFin($date_fin)
    {
        $this->dateFin = $date_fin;
    }


}





?>