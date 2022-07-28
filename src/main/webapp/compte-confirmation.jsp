<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&display=swap" rel="stylesheet">
<%@ include file = "css/style.jsp"%>
<%@ include file = "css/footer-style.jsp"%>
<title>Compte Confirmation</title>
</head>
<body>
<%@ include file = "layout/navbar.jsp" %>
<div class="container mt-5">
	<div class="card" style="width: 45rem; margin: 10rem auto;">
	  <div class="card-header bg-light text-center">
	    <h1>Compte Confirmation</h1>
	  </div>	
		<ul class="list-group list-group-flush">
		  <li class="list-group-item h4">#Client Id&emsp;:&emsp;${compte.getClient().getId()}</li>
		  <li class="list-group-item h4">Nom&emsp;:&emsp;${compte.getClient().getNom()}</li>
		  <li class="list-group-item h4">Prenom&emsp;:&emsp;${compte.getClient().getPrenom()}</li>
		  <li class="list-group-item h4">N° de Compte&emsp;:&emsp;${compte.getNum()}</li>
		  <li class="list-group-item h4">Date Creation&emsp;:&emsp;${compte.getDateCreation()}</li>
		  <li class="list-group-item h4">Soldes&emsp;:&emsp;${compte.getSolde()}</li>
		  <li class="list-group-item h4">Type&emsp;:&emsp;${compte.getType()}</li>
		  <li class="list-group-item h4">Decouvert&emsp;:&emsp;${compte.getDecouvert()}</li>
		  <li class="list-group-item h4">Taux&emsp;:&emsp;${compte.getTaux()}</li>
		</ul>
	
	</div>
</div>
<%@ include file = "layout/footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>