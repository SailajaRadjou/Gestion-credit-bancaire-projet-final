package com.radjou.sailaja.metier;

import java.sql.Date;

public class Compte {

	private String num;
	private Date dateCreation;
	private double solde;
	private String type;
	private double decouvert;
	private double taux;
	private Client client;
	
	public Compte() {
		super();
	}

	public Compte(String num, Date dateCreation, double solde, String type, double decouvert, double taux,
			Client client) {
		super();
		
		this.num = num;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.type = type;
		this.decouvert = decouvert;
		this.taux = taux;
		this.client = client;
	}	

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(double decouvert) {
		this.decouvert = decouvert;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Compte [num=" + num + ", dateCreation=" + dateCreation + ", solde=" + solde + ", type="
				+ type + ", decouvert=" + decouvert + ", taux=" + taux + ", client=" + client + "]";
	}


	
}
