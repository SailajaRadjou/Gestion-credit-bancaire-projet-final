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
<title>Liste Employees</title>
</head>
<body>
<%@ include file = "layout/navbar.jsp" %>

<div class="container mt-15">
<h3 style="margin-top: 5rem; margin-bottom: 3rem;">Liste Employee</h3>


<table class="table" style="margin-top: 15px;">
  <thead>
    <tr>
      <th scope="col">#Employee Id</th>
      <th scope="col">Username</th>
      <th scope="col">Email Adresse</th>      
      <th>Actions</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var = 'c' items="${employees}">
    <tr>
      <th scope="row">${c.getEmpId()}</th>
      <td>${c.getUserName()}</td>
      <td>${c.getEmail()}</td>
      
      <td><a href="modify-client?idclient=${c.getEmpId()}" class="btn btn-warning" data-toggle="tooltip" data-placement="bottom" title="Modifier"><i class="fas fa-edit icon_disp"></i></a></td>
      <td>
      
      	<a href="delete-client?idclient=${c.getEmpId()}" class="btn btn-danger"  data-toggle="tooltip" data-placement="bottom" title="Supprimer">
      		<i class="fa-solid fa-trash-can icon_disp"></i>
      	</a>
      
      </td>
      
    </tr>
  </c:forEach>  
  </tbody>
</table>

</div>
<%@ include file = "layout/footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>