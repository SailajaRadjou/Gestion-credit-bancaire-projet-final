<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&display=swap" rel="stylesheet">
<%@ include file = "css/style.jsp"%>
<%@ include file = "css/footer-style.jsp"%>
<title>Update Client</title>
</head>
<body>
<%@ include file = "layout/navbar.jsp" %>
<div class="container-lg mt-20">
	<h2 style="margin-top: 5rem; margin-bottom: 3rem;">Update Client</h2>
	<form class="row g-3" method = "post" action = "update-client" style="margin-top: 15px;">
		  <div class="col-md-4">
		    <label for="inputId" class="form-label">ID</label>
		    <input type="text" class="form-control" id="inputId" name="id" readonly value = ${client.getId()} />
		  </div>
		  <div class="col-md-4">
		    <label for="inputNom" class="form-label">Nom</label>
		    <input type="text" class="form-control" id="inputNom" name="nom" value = ${client.getNom()}>
		  </div>
		  <div class="col-md-4">
		    <label for="inputPrenom" class="form-label">Prenom</label>
		    <input type="text" class="form-control" id="inputPrenom" name="prenom" value = ${client.getPrenom()}>
		  </div>
		  <div class="col-12">
		    <label for="inputAddress" class="form-label">Address</label>
		    <input type="text" class="form-control" id="inputAddress" name="adresse" value = ${client.getAdresse()}>
		  </div>
		  <div class="col-md-4">
		    <label for="inputDate" class="form-label">Date de Naissance</label>
		    <input type="date" class="form-control" id="inputDate" name="date" value = ${client.getDateNaissance()}>
		  </div>
		  <div class="col-md-8">
		    <label for="inputTel" class="form-label">Telephone</label>
		    <input type="text" class="form-control" id="inputTel" name="tel" value = ${client.getTel()}>
		  </div>
		  <div class="col-md-8">
		    <label for="inputEmail4" class="form-label">Email</label>
		    <input type="email" class="form-control" id="inputEmail4" name="email" value = ${client.getMail()}>
		  </div>
		  
		  <div class="col-md-4">
		    <label for="inputGenre" class="form-label">Civilité</label>
		    <select id="inputGenre" class="form-select" name="civilite">
		      <option value=${client.getCivilite()} selected>${client.getCivilite()}</option>
		      <option value="Mlle.">Mlle.</option>
		      <option value="Mme.">Mme.</option>
		      <option value="Mr.">Mr.</option>
		    </select>
		  </div>
		  
		  <div class="col-12" style="margin-top: 20px;">
		    <button type="submit" class="btn btn-primary mt-5">Enregistrer</button>
		  </div>
	</form>
</div>
<%@ include file = "layout/footer.jsp" %>	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>