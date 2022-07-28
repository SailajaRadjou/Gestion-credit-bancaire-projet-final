package com.radjou.sailaja.metier;

import java.sql.Date;

public class Credit {

	private String numCredit;
	private Date creditDate;
	private double capital;
	private int duree;
	private double taux;
	private double mensualite;
	private String etat;
	private Client client;
	
	public Credit() {
		super();
	}

	public Credit(String numCredit, Date creditDate, double capital, int duree, double taux, double mensualite,
			String etat, Client client) {
		super();
		this.numCredit = numCredit;
		this.creditDate = creditDate;
		this.capital = capital;
		this.duree = duree;
		this.taux = taux;
		this.mensualite = mensualite;
		this.etat = etat;
		this.client = client;
	}

	public String getNumCredit() {
		return numCredit;
	}

	public void setNumCredit(String numCredit) {
		this.numCredit = numCredit;
	}

	public Date getCreditDate() {
		return creditDate;
	}

	public void setCreditDate(Date creditDate) {
		this.creditDate = creditDate;
	}

	public double getCapital() {
		return capital;
	}

	public void setCapital(double capital) {
		this.capital = capital;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public double getMensualite() {
		return mensualite;
	}

	public void setMensualite(double mensualite) {
		this.mensualite = mensualite;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	@Override
	public String toString() {
		return "Credit [numCredit=" + numCredit + ", creditDate=" + creditDate + ", capital=" + capital + ", duree="
				+ duree + ", taux=" + taux + ", mensualite=" + mensualite + ", etat=" + etat + ", client=" + client
				+ "]";
	}
	
	
}
