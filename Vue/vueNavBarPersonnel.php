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
			<li class="nav-item">
				<a data-toggle="dropdown" class="nav-link dropdown-toggle btn btn-outline-success  my-2 my-sm-0" href="#">Recherche</a>
				<ul class="dropdown-menu login-form">
					<li>
						<form  method="post">
							<div class="form-group">
								<label>Nom</label>
								<input type="text" name ="nom" class="form-control" >
								<div class="form-group">
								<div class="clearfix">
									<label>Prénom</label>
								</div>
								<input type="text" name ="prenom" class="form-control" >
							</div>

								<div class="form-group">
								<label>Login</label>
								<input type="text" name ="login" class="form-control">
							</div>
                                <div class="form-group">
								<label>E-mail</label>
								<input type="text" name ="email" class="form-control" >
							</div>
							</div>
							<input type="submit" name ="submit" class="btn btn-danger btn-block" value="Rechercher">
						</form>
					</li>
				</ul>
			</li>

  </div>
</nav>
