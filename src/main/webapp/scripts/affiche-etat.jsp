<script type="text/javascript">
      
			const elmts = document.querySelectorAll('.etat');			
			
			for (const elmt of elmts) {
						  
			  if(elmt.textContent == "En attente")
				  elmt.classList.add("table-warning");
			  else if(elmt.textContent == "Acceptée")
				  elmt.classList.add("table-success");
			  else
				  elmt.classList.add("table-danger");
						  
			  console.log(elmt.textContent);
			  
			}		
			
</script>

