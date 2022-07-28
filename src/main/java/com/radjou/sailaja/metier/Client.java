package com.radjou.sailaja.metier;

import java.sql.Date;

public class Client {

	private int id;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private String tel;
	private String mail;
	private String civilite;
	
	//private ArrayList<Compte> comptes = new ArrayList<Compte>();

	// Constructor to initialize
	public Client() {
				
	}

	// Constructor with parameter
	public Client(String nom, String prenom, Date dob, String address, String phonenum, String email,
			String civilite) {
		
		this.nom = nom;
		this.prenom = prenom;
		dateNaissance = dob;
		adresse = address;
		tel = phonenum;
		mail = email;
		this.civilite = civilite;
	}

	
	// Getter Setters for all variables
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	/*
	 * public void addCompte(Compte compte) { comptes.add(compte); }
	 * 
	 * public void afficherCompte(){ for(Compte compte:comptes) {
	 * System.out.println(compte); } }
	 */

	// Displaying Data
	public void displayData() {
		System.out.println("\nDepuis Client Class\n");
		System.out.println("\nClient Id : " + this.id);
		System.out.println("Client Nom : " + this.nom);
		System.out.println("Client Prenom : " + this.prenom);
		System.out.println("Client Date de Naissance : " + this.dateNaissance);
		System.out.println("Client Adresse : " + this.adresse);
		System.out.println("Client Tel-No : " + this.tel);
		System.out.println("Client Email : " + this.mail);
		System.out.println("Client Civilité : " + this.civilite);
		//afficherCompte();
		
	}

	public String toString() {
		return "Client [idClient=" + id + ", nomClient=" + nom + ", prenomClient=" + prenom
				+ ", dateNaissanceClient=" + dateNaissance + ", adresseClient=" + adresse + ", telClient="
				+ tel + ", mailClient=" + mail + ", civilite=" + civilite + "]";
	}

	public boolean equals(Client client) {
		return this.id == client.id && this.nom == client.nom && this.prenom == client.prenom
				&& this.dateNaissance == client.dateNaissance && this.adresse == client.adresse && 
				this.tel == client.tel && this.mail == client.mail && this.civilite == client.civilite;
	}

}