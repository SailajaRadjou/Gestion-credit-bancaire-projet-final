
<div class="m-4">
    <nav class="navbar navbar-expand-lg navbar-light" style="background: radial-gradient(circle, rgba(32,178,170,1) 10%, rgba(187,224,237,1) 98%);">
        <div class="container-fluid">
            <div>
                <img src="https://pics.clipartpng.com/midle/Hand_Tree_PNG_Clipart-2979.png" width="70" height="75" class="d-inline-block align-top" alt="">  
                <span class="logo_title"><a class="navbar-brand flex-grow-1" href="home">Seasons</a><span class="logo_slog">Credit Union</span></span>
            </div>
          
          
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse justify-content-end" id="navbarNavAltMarkup">
            <div class="navbar-nav">
              <a class="nav-link nav_link_display active" aria-current="page" href="home">Home</a>
              <c:if test="${status==1}">
	              <li class="nav-item dropdown">
	                <a class="nav-link dropdown-toggle nav_link_display" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
	                  Employees
	                </a>
	                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	                  <li><a class="dropdown-item" href="new-employee">Add Employee</a></li>   
	                  <li><a class="dropdown-item" href="list-employee">Employee List</a></li>               
	                </ul>
	              </li>
	          </c:if>    
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle nav_link_display" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Clients
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="new-client">Add Client</a></li>   
                  <li><a class="dropdown-item" href="list-client">Client List</a></li>               
                </ul>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle nav_link_display" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Comptes
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="new-compte">Add Compte</a></li>   
                  <li><a class="dropdown-item" href="list-compte">Comptes List</a></li>               
                </ul>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle nav_link_display" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                  Credits
                </a>
                <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <li><a class="dropdown-item" href="new-credit">Add Credit</a></li>   
                  <li><a class="dropdown-item" href="list-credit">Credits List</a></li>               
                </ul>
              </li>
              <span class="ms-5 fw-bold">${username}<a class="nav-link" href="login"  data-toggle="tooltip" data-placement="bottom" title="Signout"><i class="fa-solid fa-right-from-bracket fs-3 fw-bold"></i></a></span>                           
            </div>
          </div>
        </div>
      </nav>
</div>

<%-- <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <a class="navbar-brand flex-grow-1" href="index" style="font-size:2rem;">Gestion Bancaire</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="home" style="font-size:1.5rem;padding-left:30px;">Home</a>
        <a class="nav-link" href="list-client" style="font-size:1.5rem;padding-left:30px;">Clients</a>
        <a class="nav-link" href="new-client" style="font-size:1.5rem;padding-left:30px;">Add Client</a>
        <a class="nav-link" href="list-compte" style="font-size:1.5rem;padding-left:30px;">Comptes</a>         
        <a class="nav-link" href="list-credit" style="font-size:1.5rem;padding-left:30px;">Credits</a>
        <span class="ms-5 fs-2 fw-bold">${username}<a class="nav-link" href="login">Signout</a></span>
      </div>
    </div>
  </div>
</nav> --%>