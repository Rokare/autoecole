<?php


class Examen_Pratique
{
    protected $idType, $idExam, $idTiers, $date_p, $resultat_p ;

    public function __construct()
    {
        $this->exam = new Examen;
        $this->type = new Type;
        $this->candidat = new Candidat;
        $this->dateP = "";
        $this->resultatP = "";
    }

    public function getCodeTiers()
    {
        return $this->candidat->getCodeTiers();
    }

    public function getIdType()
    {
        return $this->type->getIdType();
    }

   
    public function getIdExam()
    {
        return $this->exam->getIdExam();
    }

    public function getDateP()
    {
        return $this->dateP;
    }

    public function getResultatP()
    {
        return $this->resultatP;
    }
    public function setIdExam($idExam)
    {
        $this->exam->setIdExam($idExam);
    }

    public function setCodeTiers($idTiers)
    {
        $this->candidat->setCodeTiers($idTiers);
    }
    public function setType($idType)
    {
        $this->type->setIdType($idType);
    }

    public function setDateP($date_p)
    {
        $this->dateP = $date_p;
    }

    public function setResultatP($resultat_p)
    {
        $this->resultatP = $resultat_p;
    }
  


}





?>