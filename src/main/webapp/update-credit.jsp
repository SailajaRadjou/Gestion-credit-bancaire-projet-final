<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">	
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&display=swap" rel="stylesheet">
<%@ include file = "css/style.jsp"%>
<%@ include file = "css/footer-style.jsp"%>
<title>New Credit</title>
</head>
<body>
	
	<%@ include file="layout/navbar.jsp"%>
	<div class="container-lg mt-20">
		<h2 style="margin-top: 5rem; margin-bottom: 3rem;">Credit Modification</h2>
		<form class="row g-3" method="post" action="update-credit" name="creditForm"
			style="margin-top: 15px;">
			<div class="col-md-4">
			    <label for="inputId" class="form-label">Numero de Client</label>
			    <input type="number" class="form-control" id="inputId" name="id" readonly value = ${credit.getClient().getId()}>
			</div>
			<div class="col-md-4">
				<label for="inputNum" class="form-label">Numero de Credit : </label>			
				<input	type="text" class="form-control" id="inputNum" name="num_credit" readonly value = ${credit.getNumCredit()}>
			</div>
			<div class="col-md-4">
				<label for="inputDateDemande" class="form-label">Date de Demande : </label>
				<input type="date" class="form-control" id="inputDateDemande"
					name="date_demande" readonly value = ${credit.getCreditDate()}>
			</div>
			
				<div class="col-4">
					<label for="inputMontant" class="form-label">Montant du Crédit : </label> <input
						type="number" class="form-control" id="inputMontant" name="montant" readonly value = ${credit.getCapital()}>
				</div>
				<div class="col-md-4">
					<label for="inputDuree" class="form-label">Durée du Crédit (en années) : </label> <input
						type="number" class="form-control" id="inputDuree"
						name="duree" readonly value = ${credit.getDuree()}>
				</div>
				<div class="col-md-4">
					<label for="inputTaux" class="form-label">Taux d'intérêt % : </label> <input
						type="number" class="form-control" id="inputTaux"
						name="taux" readonly value = ${credit.getTaux()}>
				</div>
				<div class="col-md-6">
					<label for="inputMensualite" class="form-label">Mensualité à Payer : </label>
					
					 <input	type="text" class="form-control" id="inputMensualite" name="mensualite" readonly value = ${credit.getMensualite()}>
					 
				</div>
				
			<div class="col-md-6">
				<label for="inputEtat" class="form-label">État de Crédit</label>
				 <select
					id="inputEtat" class="form-select" name="etat">
					<option selected>${credit.getEtat()}</option>
					<option value="En attente">En attente...</option>
					<option value="Refusée">Refusée</option>
					<option value="Acceptée">Acceptée</option>
				</select>
			</div>		
			
			<div class="col-12" style="margin-top: 5rem;">
			
				<button type="submit" class="btn btn-primary mt-5">Modifier</button>
			</div>
			
		</form>
	</div>
	<%@ include file="layout/footer.jsp"%>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>