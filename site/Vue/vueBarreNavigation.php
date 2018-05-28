

<nav class="navbar navbar-expand-lg bg-dark">
<a type ="button" class="btn btn-primary" href="index.php">Accueil</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">


      <ul class="nav navbar-nav navbar-right ml-auto">
      <li class="nav-item">
      <a class="nav-link text-center btn btn-outline-secondary my-2 my-sm-0" href="index.php?page=1">Inscription</a>

      </li>
			<li class="nav-item">
				<a data-toggle="dropdown" class="nav-link dropdown-toggle btn btn-outline-success  my-2 my-sm-0" href="#">Connexion</a>
				<ul class="dropdown-menu login-form">
					<li>
						<form  method="post">
							<div class="form-group">
								<label>Identifiant</label>
								<input type="text" name ="login" class="form-control" required="required">
							</div>
							<div class="form-group">
								<div class="clearfix">
									<label>Mot de Passe</label>
									<a href="#"  class="pull-right text-muted"><small>Oublié?</small></a>
								</div>

								<input type="password" name ="mdp" class="form-control" required="required">
							</div>
							<input type="submit" name ="submit" class="btn btn-danger btn-block" value="Connexion">
						</form>
					</li>
				</ul>
			</li>

  </div>
</nav>
