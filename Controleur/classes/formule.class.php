<?php


class Formule
{
    private $idFormule, $libelle, $tarif, $description, $dateDebut, $dateFin ;

    public function __construct()
    {
        $this->idFormule = 0;
        $this->libelle = "";
        $this->tarif = 0.0;
        $this->description = "";
        $this->dateDebut = "";
        $this->dateFin = "";
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

    public function setDescription($description)
    {
        $this->description = $description;
    }

    public function setDateDebut($dateDebut)
    {
        $this->dateDebut = $dateDebut;
    }

    public function setDateFin($dateFin)
    {
        $this->dateFin = $dateFin;
    }


}





?>
