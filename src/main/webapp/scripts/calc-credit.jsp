<script type="text/javascript">
	var calc = document.getElementById('calc_button');
	calc.addEventListener('click', function() {
		let capital = document.getElementById("inputMontant").value;
		let duree = document.getElementById("inputDuree").value;
		let taux = document.getElementById("inputTaux").value;
		let inputMensual = document.getElementById("inputMensualite");		
		// Convert interest rate into a decimal
	    // eg. 6.5% = 0.065
		taux /= 100.0;		
		// Monthly interest rate 
	    // is the yearly rate divided by 12
		const tauxMensual = taux / 12.0;
		
		// The length of the term in months 
	    // is the number of years times 12
		const dureeMois = duree * 12;
		
		// Calculate the monthly payment
		const mensualite = (capital * tauxMensual)
				/ (1 - Math.pow(1 + tauxMensual, -dureeMois));

		//The toFixed() method converts a number to a string.
		//toFixed() method rounds the string to a specified number of decimals.
		inputMensual.value = mensualite.toFixed(2);

		//if mensual textbox is null save button is disabled
		if (inputMensual.value != null && inputMensual.value != ""
				&& inputMensual.value != "NaN") {
			document.getElementById("save_button").disabled = false;
		}
	});
</script>