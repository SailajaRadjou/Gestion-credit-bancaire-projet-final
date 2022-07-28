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
<title>Modifier un Compte</title>
</head>
<body>
<%@ include file = "layout/navbar.jsp" %>
<div class="container-lg mt-20">
	<h2 style="margin-top: 5rem; margin-bottom: 3rem;">Modifier un Compte</h2>
	<form class="row g-3" method = "post" action = "update-compte" style="margin-top: 35px;">
		  <div class="col-md-6">
		    <label for="inputNum" class="form-label">Numero de Compte</label>
		    <input type="text" class="form-control" id="inputNum" name="num" readonly value = ${compte.getNum()}>
		  </div>
		  <div class="col-md-6">
		    <label for="inputId" class="form-label">Numero de Client</label>
		    <input type="number" class="form-control" id="inputId" name="id" readonly value = ${compte.getClient().getId()}>
		  </div>
		  <div class="col-md-6">
		    <label for="inputDateCree" class="form-label">Date de Création</label>
		    <input type="date" class="form-control" id="inputDateCree" name="date_cree" value = ${compte.getDateCreation()}>
		  </div>
		  <div class="col-6">
		    <label for="inputSoldes" class="form-label">Soldes</label>
		    <input type="number" class="form-control" id="inputSoldes" name="soldes" value = ${compte.getSolde()}>
		  </div>
		  <div class="col-md-4">
		    <label for="inputType" class="form-label">Type</label>
		    <select id="inputType" class="form-select" name="type" >
		      <option selected>${compte.getType()}</option>
		      <option value="Compte Courant">Compte Courant</option>
		      <option value="Compte Epargne">Compte Epargne</option>		      
		    </select>
		  </div>
		  <div class="col-md-4">
		    <label for="inputDecouvert" class="form-label">Decouvert</label>
		    <input type="number" class="form-control" id="inputDecouvert" name="decouvert" value = ${compte.getDecouvert()}>
		  </div>
		  <div class="col-md-4">
		    <label for="inputTaux" class="form-label">Taux</label>
		    <input type="number" class="form-control" id="inputTaux" name="taux" value = ${compte.getTaux()}>
		  </div>		  
		  
		  <div class="col-12" style="margin-top: 5rem;">
		    <button type="submit" class="btn btn-primary mt-5">Enregistrer</button>
		  </div>
	</form>
</div>
<%@ include file = "layout/footer.jsp" %>	
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>