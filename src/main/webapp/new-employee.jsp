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
<title>New Employee</title>
</head>
<body>
<%@ include file = "layout/navbar.jsp" %>
<div class="container-lg mt-20">
	<h2 style="margin-top: 5rem; margin-bottom: 3rem;">New Employee</h2>
	<form class="row g-3" method = "post" action = "save-employee" style="margin-top: 15px;">
		  <div class="col-md-12">
		    <label for="inputUserName" class="form-label">Username</label>
		    <input type="text" class="form-control" id="inputUserName" name="user-name">
		  </div>		  
		  
		  <div class="col-md-12">
		    <label for="inputEmail4" class="form-label">Email</label>
		    <input type="email" class="form-control" id="inputEmail4" name="email">
		  </div>
		  
		  <div class="col-md-12">
		    <label for="inputPassword" class="form-label">Password</label>
		    <input type="password" class="form-control" id="inputPassword" name="password">
		  </div>		  
		  
		  <div class="col-md-6">
				<label for="inputStatus" class="form-label">Status</label>
				<select	id="inputStatus" class="form-select" name="status">
					<option value="0" selected>0</option>					
					<option value="1" disabled>1</option>
				</select>
			</div>
		  
		  <div class="col-12" style="margin-top: 20px;">
		    <button type="submit" class="btn btn-primary  mt-5">Enregistrer</button>
		  </div>
	</form>
</div>	
<%@ include file = "layout/footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>