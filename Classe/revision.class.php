<?php



class Revision
{
    protected $idRevision,$idVehicule, $Libelle, $Motif, $DateRevision;
    public function __construct()
    {
    $this->vehicule = new Vehicule;
    $this->idRevision = 0;
    $this->Libelle = "";
    $this->Motif = "";
    $this->DateRevision = "";
    
    }




    public function getIdVehicule(){
        return $this->vehicule->getIdVehicule;
    }

    public function getidRevision()
    {
        return $this->idRevision;
    }

    public function getLibelle()
    {
        return $this->Libelle;
    }
    public function getMotif()
    {
        return $this->Motif;
    }

    public function getDateRevision()
    {
        return $this->DateRevision;
    }
    public function setVehicule($idVehicule){
        $this->vehicule->setIdVehicule = $idVehicule->getIdVehicule;
       
    }

    public function setidRevision($idRevision)
    {
        $this->idRevision = $idRevision;
    }
    
    public function setLibelle($Libelle)
    {
        $this->Libelle = $Libelle;
    }
    
    public function setMotif($Motif)
    {
        $this->Motif= $Motif;
    }
    public function setDateRevision($DateRevision)
    {
        $this->idDateRevision = $DateRevision;
    }
}





?>