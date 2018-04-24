<br>
 <br>
 <br>
 <br>
 <div class="container">
 <form method="post" action="">
   <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Login</label>
      <input type="text" class="form-control" id="inputNom4" name="login" placeholder="Login" pattern="[a-zA-Z0-9].{6,32}" required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Mot de Passe</label>
      <input type="password" class="form-control" id="inputPrenom4" name="mdp" placeholder="********" pattern="[a-zA-Z0-9].{6,32}" required>
    </div>
  </div>
   <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Nom</label>
      <input type="text" class="form-control" id="inputNom4" name="nom" placeholder="Nom" pattern="[a-zA-Z].{2,30}" required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Prenom</label>
      <input type="text" class="form-control" id="inputPrenom4" name="prenom" placeholder="Prenom" pattern="[a-zA-Z].{2,30}" required>
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Date de naissance</label>
      <input type="date" class="form-control" id="inputEmail4" name="date_n" placeholder="Date format AAAA-MM-JJ" required>
    </div>
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" id="inputEmail4" name="email" placeholder="jean@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Ville</label>
      <input type="text" class="form-control" id="inputNom4" name="ville" placeholder="Paris" pattern="[a-zA-Z.-].{3,128}" required>
    </div>
   <div class="form-group col-md-6">
     <label for="inputEmail4">Adresse</label>
     <textarea type="text" class="form-control" id="inputNom4" name="adresse" placeholder="45 rue Levent" pattern="[a-zA-Z0-9].{8,256}" required></textarea>
   </div>

  </div>
  <div class="form-row">
  <div class="form-group col-md-6">
    <label for="inputAddress">Code Postale</label>
    <input type="text" class="form-control" id="inputAdresse" name="id_ville" placeholder="Ex: 75000" pattern="[0-9]{5}" required>
  </div>
  <div class="form-group col-md-6">
    <label for="inputAddress">Telephone</label>
    <input type="text" class="form-control" id="inputAdresse" name="telephone" placeholder="Ex: 0155060833" pattern="[0-9]{10}" required>
  </div>

  </div>

  <button type="submit" name="inscription" class="btn btn-primary">S'inscrire</button>

  </div>
</form>


</div>
