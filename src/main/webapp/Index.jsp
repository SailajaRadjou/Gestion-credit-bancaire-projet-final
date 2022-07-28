<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<%@ include file = "css/style.jsp"%>
<%@ include file = "css/footer-style.jsp"%>
<title>Gestion Bancaire</title>
</head>
<body>
	<%-- <div class="container d-flex justify-content-between align-items-center">
		<h1 class="text-center">Gestion Credit Bancaire</h1>
		<span class="ms-5 fs-2 fw-bold">${username}<a class="nav-link" href="login">Signout</a></span>
		
	</div> --%>

<%@ include file = "layout/navbar.jsp" %>
<div class="container mt-5 main_container">
	
	<div class="row container_display">
	  <div class="col-sm-6 card_display">
	    <div class="card">
	      <div class="card-body text-center">
	        <h5 class="card-title">Liste des Clients</h5>
	        <p class="card-text">Pour voir les infos Personnel des clients</p>
	        <a href="list-client" class="btn button_display ">Cliquer Ici</a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6 card_display">
	    <div class="card">
	      <div class="card-body text-center">
	        <h5 class="card-title">Ajouter un Nouveau Client</h5>
	        <p class="card-text">Pour ajoute un nouveau client</p>
	        <a href="new-client" class="btn button_display">Cliquer Ici</a>
	      </div>
	    </div>
	  </div>
	</div>
	<div class="row container_display">
	  <div class="col-sm-6 card_display">
	    <div class="card">
	      <div class="card-body text-center">
	        <h5 class="card-title">Liste des Comptes</h5>
	        <p class="card-text">Pour voir les infos sur les comptes</p>
	        <a href="list-compte" class="btn button_display">Cliquer Ici</a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6 card_display">
	    <div class="card">
	      <div class="card-body text-center">
	        <h5 class="card-title">Ajouter un Nouveau Compte</h5>
	        <p class="card-text">Pour ajoute un nouveau compte</p>
	        <a href="new-compte" class="btn button_display">Cliquer Ici</a>
	      </div>
	    </div>
	  </div>
	</div>
	<div class="row container_display">
	  <div class="col-sm-6 card_display">
	    <div class="card">
	      <div class="card-body text-center">
	        <h5 class="card-title">Liste des Credits</h5>
	        <p class="card-text">Pour voir les infos sur les credits</p>
	        <a href="list-credit" class="btn button_display">Cliquer Ici</a>
	      </div>
	    </div>
	  </div>
	  <div class="col-sm-6 card_display">
	    <div class="card">
	      <div class="card-body text-center">
	        <h5 class="card-title">Demande de Credit</h5>
	        <p class="card-text">Pour une Nouvelle Demande de Credit</p>
	        <a href="new-credit" class="btn button_display">Cliquer Ici</a>
	      </div>
	    </div>
	  </div>
	</div>
	<div class="d-flex justify-content-around mt-5">
		<div class="card text-dark bg-light mb-3 count_card">
		  <div class="card-header text-center">Clients</div>
		  <div class="card-body">
		    <h5 class="card-title">Nombre total de Clients</h5>
		    <p class="card-text h4">${no_of_clients}</p>
		  </div>
		</div>
		<div class="card text-dark bg-light mb-3 count_card">
		  <div class="card-header text-center">Comptes</div>
		  <div class="card-body">
		    <h5 class="card-title">Nombre total de Comptes</h5>
		    <p class="card-text h4">${no_of_comptes}</p>		    
		    
		  </div>
		</div>  
		<div class="card text-dark bg-light mb-3 count_card">
		  <div class="card-header text-center">Comptes Activités</div>
		  <div class="card-body">
		    <ul class="list-group">
			  <li class="list-group-item h6 card-text">Compte Courant Totale : ${comptes_courants}</li>
			  <li class="list-group-item h6 card-text">Compte Epargne Totale : ${comptes_epargne}</li>			  
			</ul>
		  </div>
		</div>
	</div>
</div>
<%@ include file = "layout/footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>