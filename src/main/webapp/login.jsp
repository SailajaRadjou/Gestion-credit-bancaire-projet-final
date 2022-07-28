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
<title>Gestion Bancaire</title>
</head>
<body>
	<div class="container mt-5 main_container">
		<div class="row justify-content-md-center">
			<div class="col-md-6">
			
				<div class="login_image">
	                <img src="https://pics.clipartpng.com/midle/Hand_Tree_PNG_Clipart-2979.png" width="260" height="265" class="d-inline-block align-top" alt="">  
	                <div class="logo_title"><a class="text-decoration-none fs-1 fw-bold" href="home">Seasons</a></div>
	                <div class="logo_slog"><p class="fs-4">Credit Union - Find Your Monetary Finesse  <i class="fa-solid fa-hand-holding-heart"></i></p></div>
	                
            	</div>
				 <form method="post" action="login" style="margin-top: 15px;">
					  <div class="mb-3">
					    <label for="exampleInputUsername" class="form-label">Username</label>
					    <input type="text" class="form-control" id="exampleUsername" aria-describedby="usernameHelp" name="username">
					    
					  </div>
					  <div class="mb-3">
					    <label for="exampleInputPassword1" class="form-label">Password</label>
					    <input type="password" class="form-control" id="exampleInputPassword1" name= "password">
					  </div>
					  
					  <button type="submit" class="btn btn-primary" data-toggle="tooltip" data-placement="bottom" title="Login">Submit</button>
				</form>
				<hr>
		  		<p class="mb-0" style="font-size: 1.5rem; color: red; font-weight: 600;">${message}</p>
		  	</div>
		  </div>		
	</div>
	<%@ include file = "layout/footer.jsp" %>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</html>