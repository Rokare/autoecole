<?php
include("ville.class.php");
class Tiers
{
    protected $matricule, $nom, $prenom, $dateNaissance, $adresse, $login, $mdp, $email, $telephone, $niveau, $ville;

    public function __construct(){

        $this->matricule = "";
        $this->nom = "";
        $this->prenom = "";
        $this->dateNaissance = "";
        $this->adresse = "";
        $this->login = "";
        $this->mdp = "";
        $this->email = "";
        $this->telephone = "";
        $this->niveau = 0;
        $this->id_ville = 0;
        $this->ville = new Ville;

    }

    public function renseigner($tab){

        $this->nom = $tab['nom'];
        $this->prenom = $tab['prenom'];
        $this->dateNaissance = $tab['date_n'];
        $this->adresse = $tab['adresse'];
        $this->login = $tab['login'];
        $this->mdp = $tab['mdp'];
        $this->email = $tab['email'];
        $this->telephone = $tab['telephone'];
        $this->id_ville = $tab['id_ville'];


    }

    //Methode qui permet de serialiser l'objet -> tableau
    public function serialiser(){

        $tab = array();


        $tab['nom'] = $this->nom ;
        $tab['prenom'] = $this->prenom;
        $tab['date_n'] = $this->dateNaissance;
        $tab['adresse'] = $this->adresse;
        $tab['login'] = $this->login;
        $tab['mdp'] = $this->mdp;
        $tab['email'] =$this->email;
        $tab['telephone'] = $this->telephone;
        $tab['id_ville'] = $this->id_ville;
        return($tab);
    }

    /* GETTERS*/
    public function getMatricule(){

        return $this->matricule;

    }

    public function getNom(){

        return $this->nom;

    }

    public function getPrenom(){

        return $this->prenom;

    }

    public function getDateNaissance(){

        return $this->dateNaissance;

    }

    public function getAdresse(){

        return $this->adresse;

    }

    public function getLogin(){

        return $this->login;

    }

    public function getMdp(){

        return $this->mdp;

    }

    public function getEmail(){

        return $this->email;

    }

    public function getNiveau(){

        return $$this->niveau;

    }


    public function getTelephone(){

        return $this->telephone;

    }

    public function getVille(){

        return $this->ville;

    }


    /* SETTERS */
    public function setMatricule($matricule){
        $this->matricule = $matricule;
    }

    public function setNom($nom){

        $this->nom = $nom;

    }

    public function setPrenom($prenom){

        $this->prenom = $prenom;

    }

    public function setDateNaissance($dateNaissance){

        $this->dateNaissance = $dateNaissance;

    }

    public function setAdresse($adresse){

        $this->adresse = $adresse;

    }

    public function setLogin($login){

        $this->login = $login;

    }

    public function setMdp($mdp){

        $this->mdp = $mdp;

    }

    public function setEmail($email){

        $this->email = $email;

    }

    public function setNiveau($niveau){

        $this->niveau = $niveau;

    }

    public function setTelephone($telephone){

        $this->telephone = $telephone;

    }

    public function setVille($ville){

        $this->ville = $ville;

    }

}


?>
