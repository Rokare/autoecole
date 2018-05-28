<?php


class Examen_Pratique
{
  protected $type, $exam, $candidat, $dateP, $resultatP ;

  public function __construct()
  {
      $this->exam = new Examen;
      $this->type = new Type;
      $this->candidat = new Candidat;
      $this->dateP = "";
      $this->resultatP = "";
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

  public function getDateP()
  {
      return $this->dateP;
  }

  public function getResultatP()
  {
      return $this->resultatP;
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

  public function setDateP($dateP)
  {
      $this->dateP = $dateP;
  }

  public function setResultatP($resultatP)
  {
      $this->resultatP = $resultatP;
  }





}





?>
