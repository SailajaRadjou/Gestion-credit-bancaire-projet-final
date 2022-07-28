<script type="text/javascript">
	var calc = document.getElementById('calc_button');

	calc.addEventListener('click', function() {
		let capital = document.getElementById("inputMontant").value;
		let duree = document.getElementById("inputDuree").value;
		let taux = document.getElementById("inputTaux").value;
		let inputMensual = document.getElementById("inputMensualite");
		taux /= 100.0;
		const tauxMensual = taux / 12.0;
		const dureeMois = duree * 12;
		const mensualite = (capital * tauxMensual)
				/ (1 - Math.pow(1 + tauxMensual, -dureeMois));

		inputMensual.value = mensualite.toFixed(2);

		if (inputMensual.value != null && inputMensual.value != ""
				&& inputMensual.value != "NaN") {
			document.getElementById("save_button").disabled = false;
		}

	});
</script>