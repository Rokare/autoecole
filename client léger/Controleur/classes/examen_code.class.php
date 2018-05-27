<?php


class Examen_Code
{
    protected $type, $exam, $candidat, $dateC, $resultatC ;

    public function __construct()
    {
        $this->exam = new Examen;
        $this->type = new Type;
        $this->candidat = new Candidat;
        $this->dateC = "";
        $this->resultatC = "";
    }

    public function getCandidat()
    {
        return $this->candidat;
    }

    public function getType()
    {
        return $this->type;
    }


    public function getExam()
    {
        return $this->exam;
    }

    public function getDateC()
    {
        return $this->dateC;
    }

    public function getResultatC()
    {
        return $this->resultatC;
    }
    public function setExam($exam)
    {
        $this->exam = $exam;
    }

    public function setCandidat($candidat)
    {
        $this->candidat = $candidat);
    }
    public function setType($type)
    {
        $this->type = $type;
    }

    public function setDateC($dateC)
    {
        $this->dateC = $dateC;
    }

    public function setResultatC($resultatC)
    {
        $this->resultatC = $resultatC;
    }



}





?>
