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
<title>Liste Clients</title>
</head>
<body>
<%@ include file = "layout/navbar.jsp" %>

<div class="container mt-15 table_width">
<h3 style="margin-top: 5rem; margin-bottom: 3rem;">Liste Client</h3>
<form method="post" action="search" style="margin-top: 15px;">
	<div class="row g-3">
	  <div class="col">
	    <input type="text" class="form-control" placeholder="Nom" name="nom">
	  </div>
	  <div class="col">
	    <input type="text" class="form-control" placeholder="Prenom" name="prenom">
	  </div>
	  <button type="submit" class="btn btn-secondary col-sm-2 mb-2">Chercher</button>
	</div>
</form>

<hr style =	"margin-top: 2rem; margin-bottom: 2rem; height: 2px; border: 0; background-image: -webkit-linear-gradient(left, #f0f0f0, #8c8b8b, #f0f0f0);">

<table class="table" style="margin-top: 15px;">
  <thead>
    <tr>
      <th scope="col">#Id</th>
      <th scope="col">Nom</th>
      <th scope="col">Prenom</th>
      <th scope="col">Adresse</th>
      <th scope="col">Date Naissance</th>
      <th scope="col">Telephone</th>
      <th scope="col">@Mail</th>
      <th scope="col">Civilité</th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var = 'c' items="${clients}">
    <tr>
      <th scope="row">${c.getId()}</th>
      <td>${c.getNom()}</td>
      <td>${c.getPrenom()}</td>
      <td>${c.getAdresse()}</td>
      <td>${c.getDateNaissance()}</td>
      <td>${c.getTel()}</td>
      <td>${c.getMail()}</td>
      <td>${c.getCivilite()}</td>
      <td><a href="modify-client?idclient=${c.getId()}" class="btn btn-warning" data-toggle="tooltip" data-placement="bottom" title="Modifier"><i class="fas fa-edit icon_disp"></i></a></td>
      <td>
      <c:if test="${status==1}">
      	<a href="delete-client?idclient=${c.getId()}" class="btn btn-danger"  data-toggle="tooltip" data-placement="bottom" title="Supprimer">
      		<i class="fa-solid fa-trash-can icon_disp"></i>
      	</a>
      </c:if>	
      </td>
      <td><a href="client-detail?idclient=${c.getId()}" class="btn btn-info"  data-toggle="tooltip" data-placement="bottom" title="Plus d'infos"><i class="fa-solid fa-circle-info icon_disp"></i></a></td>
    </tr>
  </c:forEach>  
  </tbody>
</table>
<!--<div class="col-12">
	<a href="new-client" class="btn btn-primary">Add Client</a>
</div> -->
</div>
<%@ include file = "layout/footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>