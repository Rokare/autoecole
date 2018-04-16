<?php



class Revision
{
    protected $id_revision, $lesvehicules, $libelle, $motif, $date_revision;

    public function __construct()
    {
    $this->lesvehicules = array();
    $this->id_revision = 0;
    $this->libelle = "";
    $this->motif = "";
    $this->date_revision = "";
    }

    public function getLesVehicule(){
        return $this->lesvehicules;
    }

    public function getIdRevision()
    {
        return $this->id_revision;
    }

    public function getLibelle()
    {
        return $this->libelle;
    }
    public function getMotif()
    {
        return $this->motif;
    }

    public function getDate_Revision()
    {
        return $this->date_revision;
    }
    public function setVehicule($lesvehicules){
        $this->lesvehicules = $lesvehicules;
       //$this->vehicule->setIdVehicule($idVehicule);
    }

    public function setidRevision($id_revision)
    {
        $this->id_revision = $id_revision;
    }

    public function setLibelle($libelle)
    {
        $this->libelle = $libelle;
    }

    public function setMotif($motif)
    {
        $this->motif= $motif;
    }
    public function setDateRevision($date_revision)
    {
        $this->date_revision = $date_revision;
    }
}





?>
