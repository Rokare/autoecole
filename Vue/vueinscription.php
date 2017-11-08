<br>
 <br>
 <br>
 <br>
 <div class="container">
 <form method="post" action="">
   <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Nom</label>
      <input type="text" class="form-control" id="inputNom4" name="nom" placeholder="Nom" pattern="[a-zA-Z].{4,}">
    </div>
    <div class="form-group col-md-6">
      <label for="inputPassword4">Prenom</label>
      <input type="text" class="form-control" id="inputPrenom4" name="prenom" placeholder="Prenom" pattern="[a-zA-Z].{4,}">
    </div>
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputEmail4">Date de naissance</label>
      <input type="date" class="form-control" id="inputEmail4" name="date_naissance" placeholder="Date format AAAA-MM-JJ">
    </div>
    <div class="form-group col-md-6">
      <label for="inputEmail4">Email</label>
      <input type="email" class="form-control" id="inputEmail4" name="email" placeholder="jean@gmail.com" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">
    </div>
  </div>
  <div class="form-row">
  <div class="form-group col-md-6">
    <label for="inputAddress">Telephone</label>
    <input type="text" class="form-control" id="inputAdresse" name="telephone" placeholder="Ex: 0155060833" pattern="[0-9]{10}">
  </div>
  <div class="form-group col-md-6">
    <label for="inputAddress">Code Lieu</label>
    <input type="text" class="form-control" id="inputAdresse" name="id_lieu" placeholder="Ex: 1215" pattern="[0-9]{5}">
  </div>
  </div>
 
  <button type="submit" name="inscription" class="btn btn-primary">S'inscrire</button>
  
  </div>
</form>


</div>