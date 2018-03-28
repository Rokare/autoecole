<?php


class Formule
{
    protected $idFormule, $idTiers, $date_souscription ;

    public function __construct()
    {
        $this->formule = new Formule;
        $this->candidat = new Candidat;
        $this->dateSouscription = "";
 
    }


    public function getIdFormule()
    {
        return $this->formule->getIdFormule;
    }
    public function getCodeTiers()
    {
        return $this->candidat->getCodeTiers();
    }
    public function getDateSouscription()
    {
        return $this->dateSouscription;
    }
   


    public function setIdFormule($idFormule)
    {
        $this->formule->setIdFormule($idFormule);
    }

    public function setCodeTiers($idTiers)
    {
        $this->candidat->setCodeTiers($idTiers);
    }

    public function setDateSouscription($tarif)
    {
        $this->dateSouscription =  $date_souscription;
    }

   

}





?>