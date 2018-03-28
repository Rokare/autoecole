<?php


class Examen_Code
{
    protected $idType, $idExam, $idTiers, $date_c, $resultat_c ;

    public function __construct()
    {
        $this->exam = new Examen;
        $this->type = new Type;
        $this->candidat = new Candidat;
        $this->dateC = "";
        $this->resultatC = "";
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

    public function getDateC()
    {
        return $this->dateC;
    }

    public function getResultatC()
    {
        return $this->resultatC;
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

    public function setDateP($date_c)
    {
        $this->dateC = $date_c;
    }

    public function setResultatP($resultat_c)
    {
        $this->resultatC = $resultat_c;
    }
  


}





?>