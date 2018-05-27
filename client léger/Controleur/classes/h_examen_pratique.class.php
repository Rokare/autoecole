<?php


class H_Examen_Pratique extends Examen_Pratique
{
    private $dateHisto ;

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
