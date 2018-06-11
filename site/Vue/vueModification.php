
<?php
if(isset($resultats))
{

 ?>
<br>
 <br>
 <br>
 <br>
 <div class="container">
 <form method="post" action="">
   <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Login</label>
      <input type="text" class="form-control" id="inputNom4" name="login" value="<?php if(isset($resultats['login']))
      {
 echo $resultats['login'];} ?>" pattern="[a-zA-Z0-9].{6,32}" required>
    </div>

  </div>
   <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Nom</label>
      <input type="text" class="form-control" id="inputNom4" name="nom"  value="<?php echo $resultats['nom'];?>" pattern="[a-zA-Z].{2,30}" required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Prenom</label>
      <input type="text" class="form-control" id="inputPrenom4" name="prenom" value="<?php echo $resultats['prenom']; ?>" pattern="[a-zA-Z].{2,30}" required>
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Date de naissance</label>
      <input type="date" class="form-control" id="inputEmail4" name="date_n" value="<?php echo $resultats['date_n'];?>" required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" id="inputEmail4" name="email" value="<?php echo $resultats['email'];?>" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">
    </div>
  </div>
  <div class="form-row">

   <div class="form-group col-md-6">
     <label for="inputEmail4">Adresse</label>
     <textarea type="text" class="form-control" id="inputNom4" name="adresse" pattern="[a-zA-Z0-9].{8,256}" required><?php echo $resultats['adresse'];?></textarea>
   </div>

  </div>
  <div class="form-row">
  <div class="form-group col-md-6">
    <label for="inputAddress">Code Postale</label>
    <input type="text" class="form-control" id="inputAdresse" name="id_ville" value="<?php echo $resultats['id_ville'];?>" pattern="[0-9]{5}" required>
  </div>
  <div class="form-group col-md-6">
    <label for="inputAddress">Telephone</label>
    <input type="text" class="form-control" id="inputAdresse" name="telephone" value="<?php echo $resultats['telephone'];?>" pattern="[0-9]{10}" required>
  </div>

  </div>

  <button type="submit" name="update" class="btn btn-primary">S'inscrire</button>

  </div>
</form>


</div>
<?php

}
 ?>
