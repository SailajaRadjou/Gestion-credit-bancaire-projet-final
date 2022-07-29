<script type="text/javascript">
      
			
			const choixCompte = document.querySelector('#inputType');
			const decouvert = document.querySelector('#inputDecouvert');
			const taux = document.querySelector('#inputTaux');
			
			//for activating textbox corresponding to the type of the account
			choixCompte.addEventListener('change', function(){
			
					if(choixCompte.value == "Compte Courant"){
						taux.readOnly = true;
						decouvert.readOnly = false;
					}
						
					else if(choixCompte.value == "Compte Epargne"){
						decouvert.readOnly = true;
						taux.readOnly = false;
					}
						
					else{
						taux.readOnly = true;
						decouvert.readOnly = true;
					}
						
			});
</script>