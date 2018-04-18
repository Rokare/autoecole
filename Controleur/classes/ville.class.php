<?php

/**
 *
 */
class Ville
{
  protected $id_ville, $cp, $ville;
  function __construct()
  {
    $this->id_ville = 0;
    $this->cp = "";
    $this->ville = "";
  }


/**
 * @return mixed
 */
public function getCp()
{
  return $this->cp;
}

/**
 * @param mixed $cp
 *
 * @return static
 */
public function setCp($cp)
{
  $this->cp = $cp;
  return $this;
}

/**
 * @return mixed
 */
public function getId_ville()
{
  return $this->id_ville;
}

/**
 * @param mixed $id_ville
 *
 * @return static
 */
public function setId_ville($id_ville)
{
  $this->id_ville = $id_ville;
  return $this;
}

/**
 * @return mixed
 */
public function getVille()
{
  return $this->ville;
}

/**
 * @param mixed $ville
 *
 * @return static
 */
public function setVille($ville)
{
  $this->ville = $ville;
  return $this;
}


}











































 ?>
