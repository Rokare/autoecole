<nav class="navbar navbar-expand-lg bg-dark">
<a type ="button" class="btn btn-primary" href="index.php">Accueil</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">


      <ul class="nav navbar-nav navbar-right ml-auto">
       <li class="nav-item">
          <a type="button" class="btn btn-warning" href ="logout.php">Deconnexion</a>
      </li>
				</ul>
			</li>
  </div>
</nav>

<h1 class = "text-center">Rechercher les Candidats</h1>

<div class= "row">
<div class="col-md-6 col-md-offset-3">
 <form method="post" action="">
   <div class="col-md-6 col-md-offset-3">
    <div class="text-center">
      <label>Login</label>
      <input type="text" class="form-control" name="login" placeholder="Login">
    </div>
  </div>
  
     <div class="col-md-6 col-md-offset-3">
    <div class="text-center">
      <label>Nom</label>
      <input type="text" class="form-control" name="nom" placeholder="Nom">
    </div>
  </div>
  
     <div class="col-md-6 col-md-offset-3">
    <div class="text-center">
      <label>Prénom</label>
      <input type="text" class="form-control" name="prenom" placeholder="Prénom">
    </div>
  </div>
  
     <div class="col-md-6 col-md-offset-3">
    <div class="text-center">
      <label>Email</label>
      <input type="text" class="form-control" name="email" placeholder="Email">
    </div>
  </div>
  
  <button type="submit" name="submit" class="btn btn-primary" class="text-center" value = "rechercher">Recherche</button>
  <br>
  <br>

  </div>
</form>
</div>
