<style>
*, ::before,::after{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
  scroll-behavior: smooth;
}

html, body{
  position: relative;
  width: 100%;
  overflow-x:hidden; 
  
  height: 100vh;
}
img{
  object-fit: cover;
}

body{
	/*background: linear-gradient(0deg, rgba(155,157,157,1) 0%, rgba(218,217,214,1) 45%);*/
	background: radial-gradient(circle, rgba(229,240,241,1) 26%, rgba(240,241,233,1) 82%);
	color: #191970;
	font-size: 1rem;
	font-weight: bold;
	
}

.login_image{

	display: grid;
    justify-items: center;
}

.logo_title{
    
    font-family: 'Dancing Script', cursive;
    display: inline-grid;
    justify-items: stretch;
    
}

.logo_title a{
    letter-spacing: 2px;
    font-size: 2rem;
    font-weight: bolder;
    color: #082f8a;
}
.logo_slog{
    font-style: italic;
    font-size: 1.1rem;
    font-weight: bolder;
}

.nav_link_display{
    padding-left:30px !important;
    font-size: 1.3rem;
}

.user_display{
	padding-right:10px !important;
    font-size: 1.1rem;
    text-transform: uppercase;
}

/*.container, .container-lg{	
	height: 100vh;
}*/
	
.main_container{	
	height: 60vh;
	
	border: 5px hidden rgba(28,110,164,0.42);
	border-radius: 0px 0px 15px 15px;
	/*box-shadow: 5px 5px 15px 5px rgba(0,0,0,0.38);*/
}
.container_display{

	display: flex;
	justify-content: space-evenly;
    align-items: center;
    
}
.card-body{
	box-shadow: 5px 5px 15px 5px rgba(0,0,0,0.38);
	/*background: radial-gradient(circle, rgba(240,241,233,1) 51%, rgba(201,225,227,1) 98%);*/
	background: radial-gradient(circle, rgba(240,241,233,1) 51%, rgba(247,250,250,1) 98%);
}
.card_display{
	width: 30rem !important;
	padding: 25px;
	
}

.count_card{
	max-width: 18rem;
	box-shadow: 5px 5px 15px 5px rgba(0,0,0,0.38);
}
.button_display, .btn-primary{
	background: radial-gradient(circle, rgba(108,196,212,1) 0%, rgba(50,103,198,1) 100%);
}

/*.btn-primary{
	
	background: radial-gradient(circle, rgba(63,94,251,1) 0%, rgba(70,223,252,1) 100%);
}*/

.button_display, .btn-primary{
	color: white;
	font-size:1.2rem;
	font-weight: 600;
	letter-spacing: 2px;
	
}

.btn-secondary{
	width: 150px;
	border: 3px outset rgba(28,110,164,0.24);
	border-radius: 15px 15px 15px 15px;
	color: white;
	font-size:1.2rem;
	letter-spacing: 1px;
	font-weight: 600;
	background: radial-gradient(circle, rgba(17,163,206,1) 39%, rgba(1,91,153,1) 99%);
}

.bg-light{
	color: white;
	font-size:1.3rem;
	font-weight: 600;
	letter-spacing: 1px;
	background: radial-gradient(circle, rgba(118,226,224,1) 0%, rgba(148,162,235,1) 95%);
}

.card-title, .card-text, .h4{
	color:#191970;
}

/****************************	Responsive	Mobile****************************/

@media (min-width: 768px){
	/*.row{
		margin: 0 !important;
	}
	form{
		max-width: 58rem;
    	margin: 5rem auto;
    }*/
	.container{
		max-width: 100%;
	}
	.nav_disp_resp{
		flex-direction: row !important;
		justify-content: space-around !important;
	}
	.span_signout{
		display: flex;
	    align-items: baseline;
    }
    .main_container{
    	margin: 10rem auto !important;
    }
    .display_total{
    	justify-content: space-evenly !important;
    }
  /* .card{
   		 width: 50rem !important;
    
    }*/
}

</style>