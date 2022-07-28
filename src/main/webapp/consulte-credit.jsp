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
<title>Liste Credits d'un Client</title>
</head>
<body>
<%@ include file = "layout/navbar.jsp" %>

<div class="container mt-15">
<h2 style="margin-top: 5rem; margin-bottom: 3rem;">Credits Consultations</h2>

<form method="post" action="new-credit" style="margin-top: 15px;">
	<div class="row g-3">
	  <div class="col">
	    <input type="text" class="form-control" placeholder="Nom" name="nom" readonly value = ${client.getNom()} >
	  </div>
	  <div class="col">
	    <input type="text" class="form-control" placeholder="Prenom" name="prenom" readonly value = ${client.getPrenom()}>
	  </div>
	  <div class="col">
	    <input type="text" class="form-control" placeholder="Client Id" name="id" readonly value = ${client.getId()}>
	  </div>
	  <button type="submit" class="btn btn-warning col-sm-2 mb-2" id="demandeCredit">Demande Crédit</button>
	 
	</div>
</form>
<hr style =	"margin-top: 2rem; margin-bottom: 2rem; height: 2px; border: 0; background-image: -webkit-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);">				  
<table class="table" style="margin-top: 3rem;">
  <thead>
    <tr>
      
      <th scope="col">N° de Crédit</th>
      <th scope="col">Date de Demande</th>
      <th scope="col">Montant du Crédit</th>
      <th scope="col">Durée du Crédit (en années) </th>
      <th scope="col">Taux d'intérêt %</th>
      <th scope="col">Mensualité</th>
      <th scope="col">État de Crédit</th>      
      <th></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var = 'c' items="${credits}">
    <tr>
      <td>${c.getNumCredit()}</td>
      <td>${c.getCreditDate()}</td>
      <td>${c.getCapital()}</td>
      <td>${c.getDuree()}</td>
      <td>${c.getTaux()}</td>
      <td>${c.getMensualite()}</td>
      <td class="etat">${c.getEtat()}</td>
      <td><a href="modify-credit?numCredit=${c.getNumCredit()}" class="btn btn-info" data-toggle="tooltip" data-placement="bottom" title="Modifier"><i class="fas fa-edit icon_disp"></i></a></td>
      <td><a href="delete-credit?numCredit=${c.getNumCredit()}" class="btn btn-danger" data-toggle="tooltip" data-placement="bottom" title="Supprimer"><i class="fa-solid fa-trash-can icon_disp"></i></a></td>      
    </tr>
  </c:forEach>
  <%@ include file = "scripts/affiche-etat.jsp" %>  
  </tbody>
</table>
 <%@ include file = "scripts/autoriser-demande.jsp" %> 
</div>
<%@ include file = "layout/footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>