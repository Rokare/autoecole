<?php

class Modele
{
    private $pdo, $table;

    public function __construct($serveur, $bdd, $user, $mdp)
    {
        $this->pdo = null;
        $this->table = null;

        try{

          $this->pdo = new PDO("mysql:host=".$serveur.";dbname=".$bdd,$user,$mdp);


        }
        catch(Exception $exp){

          echo "Erreur de connexion a la BDD:".$bdd;

        }
    }
    public function verifmatricule($matricule)
    {
        if($this->pdo == null){

            return null;

        }else{

            $requete = "select matricule from tiers where matricule = ".$matricule."  ;";
            $select = $this->pdo->prepare($requete);
            $select->execute();
            $resultats = $select->fetchAll();
            if(empty($resultats))
            {
              return true;
            }
            else {
              return false;
            }
        }

    }
    public function pagination($login, $nom, $prenom, $email, $perPage)
    {

      if($this->pdo != null && !empty($nom) || !empty($login) || !empty($prenom) || !empty($email)){
          $requete = 'select count(matricule) as nbMatricule from '.$this->table.' where nom like "'.$nom.'%"
                      and prenom like "'.$prenom.'%" and email like "'.$email.'%"
                      and login like "'.$login.'%"';
          $req = $this->pdo->prepare($requete);
          $req->execute();
          $reponse = $req->fetch();
          $nbMatricule = $reponse['nbMatricule'];
          $nbPage = ceil($nbMatricule/$perPage);
          return $nbPage;



      }
    }

    public function connexion($login, $mdp)
    {


					$requete = "select * from  tiers where login = '$login' AND mdp = '$mdp'";
          $select = $this->pdo->prepare($requete);
          $select->execute();
						if($reponse = $select->fetch())
						{
                session_start();
								$_SESSION['login'] = $reponse['login'];
								$_SESSION['matricule'] = $reponse['matricule'];

                return true;
						}
						else
						{
              return false;
						}
    }

    public function selectAll()
    {
        if($this->pdo == null){

            return null;

        }else{

            $requete = "select * from ".$this->table." ;";
            $select = $this->pdo->prepare($requete);
            $select->execute();
            $resultats = $select->fetchAll();

            return $resultats;

        }
    }


    public function verifstatut($login, $mdp)
    {
        if($this->pdo == null){

            return null;

        }else{

            $requete = "call statut('$login', '$mdp', @statut)";
            $req = $this->pdo->exec($requete);
            $req = $this->pdo->prepare("select @statut");
            $req->execute();
            if($reponse = $req->fetch())
            {
              $rep = $reponse[0];
            }
            return $rep;

        }
    }

    public function rechercher($login, $nom, $prenom, $email,$cPage, $perPage) {
    
             if($this->pdo != null && !empty($nom) || !empty($login) || !empty($prenom) || !empty($email)){
                 $requete = 'select * from '.$this->table.' where nom like "'.$nom.'%"
                             and prenom like "'.$prenom.'%" and email like "'.$email.'%"
                             and login like "'.$login.'%" limit '.(($cPage-1)*$perPage).",$perPage";
             $req = $this->pdo->prepare($requete);
             $req->execute();
             $reponse = $req->fetchAll();

             if(empty($reponse))
             {
               return false;
             }
             else{

               return $reponse;
             }

             }
    }



    public function insert($donnee, $matricule){

     if($this->pdo != null){
         $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
         $donnees = array();
         $champs = array();

         //Construction des champs
         foreach($donnee as $cle => $valeur){
             $champs[] = ":".$cle;
             $donnees[":".$cle] = $valeur;
         }

         //explode : sépare une chaine de caractère en tableau
         //implode : concatène un tableau

         $listeChamps = implode(",", $champs);
         $requete = "insert into ".$this->table." values ('$matricule',".$listeChamps.");";

         $insert = $this->pdo->prepare($requete);
         $insert->execute($donnees);

     }

 }

    public function delete ()
     {
       if($this->pdo != null) //si la connexion n'est pas nullle
       {
         $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
         $requete = "delete from ".$this->table." where ".$this->delchamp." = '".$this->delvaleur."'" ;
         $delete = $this->pdo->prepare($requete);
          $delete->execute();
          return true;
         }
         else{
             return false;
         }
     }

     public function udpateCandidat($tab, $matricule)
      {
        if($this->pdo != null) //si la connexion n'est pas nullle
        {
          extract($tab);
          $this->pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
          $requete = "update ".$this->table." set nom ='".$nom."',prenom ='".$prenom."',
                        adresse ='".$adresse."',login = '".$login."',email = '".$email."',
                        telephone='".$telephone."' where matricule = '".$matricule."'" ;
          $udpate = $this->pdo->prepare($requete);
          $udpate->execute();
         }
      }

     public function setDelchamp($champ)
     {
       $this->delchamp = $champ;
     }

     public function setDelvaleur($valeur)
     {
       $this->delvaleur = $valeur;
     }

    public function getPdo(){

        return $this->pdo;

    }

    public function setTable($table)
    {
        $this->table = $table;
    }


}

?>
