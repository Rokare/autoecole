<?php


class Examen
{
    private $idExam, $type, $ville ;

    public function __construct()
    {
        $this->idExam = 0;
        $this->ville = new Ville;
        $this->type = new TypeExamen;
    }

    public function getVille()
    {
        return $this->ville;
    }


    public function getType()
    {
        return $this->type;
    }

    public function getIdExam()
    {
        return $this->idExam;
    }

    public function setIdExam($idExam)
    {
        $this->idExam = $idExam;
    }

    public function setUneVille($uneVille)
    {
        $this->uneVille = $uneVille;
    }
    public function setUnType($unType)
    {
        $this->unType = $unType;
    }



}





?>
