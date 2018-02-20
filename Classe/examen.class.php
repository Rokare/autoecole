<?php


class Examen
{
    protected $idType, $idExam, $idLieu ;

    public function __construct()
    {
        $this->idExam = 0;
        $this->lieu = new Lieu;
        $this->type = new Type;
    }

    public function getIdLieu()
    {
        return $this->lieu->getIdLieu();
    }

   
    public function getType()
    {
        return $this->type->getIdType();
    }

    public function getIdExam()
    {
        return $this->idExam;
    }

    public function setIdExam($idExam)
    {
        $this->idExam = $idExam;
    }

    public function setIdLieu($idLieu)
    {
        $this->lieu->setIdLieu($idLieu);
    }
    public function setType($idType)
    {
        $this->type->setIdType($idType);
    }
    public function setVille($ville)
    {
        $this->ville = $ville;
    }


}





?>