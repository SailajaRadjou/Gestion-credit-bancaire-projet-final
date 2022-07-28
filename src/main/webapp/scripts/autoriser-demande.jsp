<script type="text/javascript">
      
			const etats = document.querySelectorAll('.etat');
			const demandeCredit = document.querySelector('#demandeCredit');
			
			for (const etat of etats) {
						  
			  if(etat.textContent == "En attente")
				  demandeCredit.disabled = true;				
			  else
				  demandeCredit.disabled = false;
			}			
			
</script>