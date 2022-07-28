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
<title>Credit Confirmation</title>
</head>
<body>
<%@ include file = "layout/navbar.jsp" %>
<div class="container-lg">
<div class="card" style="width: 45rem; margin: 10rem auto;">
  <div class="card-header bg-light text-center">
    <h1>Credit Confirmation</h1>
  </div>
  <ul class="list-group list-group-flush">
    <li class="list-group-item h4">Client Id&emsp;:&emsp;${credit.getClient().getId()}</li>
    <li class="list-group-item h4">Nom &emsp;:&emsp;${credit.getClient().getNom()}</li>
    <li class="list-group-item h4">Prenom&emsp;:&emsp;${credit.getClient().getPrenom()}</li>
    <li class="list-group-item h4">N° de Crédit&emsp;:&emsp;${credit.getNumCredit()}</li>
    <li class="list-group-item h4">Date de Demande&emsp;:&emsp;${credit.getCreditDate()}</li>
    <li class="list-group-item h4">Montant du Crédit&emsp;:&emsp;${credit.getCapital()}</li>
    <li class="list-group-item h4">Durée du Crédit (en années)&emsp;:&emsp;${credit.getDuree()}</li>
    <li class="list-group-item h4">Taux d'intérêt %&emsp;:&emsp;${credit.getTaux()}</li>
    <li class="list-group-item h4">Mensualité&emsp;:&emsp;${credit.getMensualite()}</li>
    <li class="list-group-item h4">État de Crédit&emsp;:&emsp;${credit.getEtat()}</li>
  </ul>
</div>
</div>
<%@ include file = "layout/footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>