<script type="text/javascript">
      
			const etats = document.querySelectorAll('.etat');
			const demandeCredit = document.querySelector('#demandeCredit');
			//giving autorisation for demande de credit
			//if etat == "en attente" then we can't add new credit for the client 
			for (const etat of etats) {
						  
			  if(etat.textContent == "En attente")
				  demandeCredit.disabled = true;				
			  else
				  demandeCredit.disabled = false;
			}			
			
</script>