<?php



class Revision
{
    private $idRevision, $vehicule, $libelle, $motif, $dateRevision;

    public function __construct()
    {
    $this->vehicule = new Vehicule;
    $this->idRevision = 0;
    $this->libelle = "";
    $this->motif = "";
    $this->dateRevision = "";
    }

    public function getVehicule(){
        return $this->vehicule;
    }

    public function getIdRevision()
    {
        return $this->idRevision;
    }

    public function getLibelle()
    {
        return $this->libelle;
    }
    public function getMotif()
    {
        return $this->motif;
    }

    public function getDateRevision()
    {
        return $this->dateRevision;
    }
    public function setVehicule($vehicule){
        $this->vehicule = $vehicule;

    }

    public function setidRevision($idRevision)
    {
        $this->idRevision = $idRevision;
    }

    public function setLibelle($libelle)
    {
        $this->libelle = $libelle;
    }

    public function setMotif($motif)
    {
        $this->motif= $motif;
    }
    public function setDateRevision($dateRevision)
    {
        $this->dateRevision = $dateRevision;
    }
}





?>
