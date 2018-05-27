<?php


class H_Examen_Code extends Examen_Code
{
    private $dateHisto;


    public function __construct()
    {
      parent::__construct();
      $this->dateHisto = "";
    }

    public function getDateHisto()
    {
      return $this->dateHisto;
    }

    public function setDateHisto($dateHisto)
    {
      $this->dateHisto = $dateHisto;
    }
}





?>
