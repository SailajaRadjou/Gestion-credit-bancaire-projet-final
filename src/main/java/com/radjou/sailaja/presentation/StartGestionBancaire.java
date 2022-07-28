package com.radjou.sailaja.presentation;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.radjou.sailaja.dao.ClientDaoImple;
import com.radjou.sailaja.dao.CompteDaoImpl;
import com.radjou.sailaja.dao.CreditDaoImpl;
import com.radjou.sailaja.dao.EmployeeDaoImpl;
import com.radjou.sailaja.metier.Client;
import com.radjou.sailaja.metier.Compte;
import com.radjou.sailaja.metier.Credit;
import com.radjou.sailaja.metier.Employee;

public class StartGestionBancaire {

	public static void main(String[] args) {
		EmployeeDaoImpl empDao = new EmployeeDaoImpl();
		
		//Employee emp = new Employee("Pasupathi","pasup@banqmail.com","pathi17");
		Employee emp1;
		//emp1 = empDao.save(emp);//add new record	
		
//		if (emp1 != null ) {
//			System.out.println(emp1);
//		}
		
		emp1 = empDao.find("pasupathi","pathi17");//Get by nom & prenom
		if (emp1 != null ) {
			System.out.println(emp1);
		}
		else {
			System.out.println("Null");
		}
		
//		Credit credit = new Credit(); 
//		ClientDaoImple cImple = new ClientDaoImple();
//		Client clientObj2 = cImple.find(25);
//		CreditDaoImpl creditDaoImpl = new CreditDaoImpl();
		// Scanner scanner = new Scanner(System.in);
		 
//		credit = creditDaoImpl.find("CR112"); 
//		 System.out.println(credit);
//		 //creditDaoImpl.delete(credit);
//		 if (credit != null) {
//			 credit.setCapital(6850);
//			 credit.setDuree(5);
//			 credit=creditDaoImpl.update(credit);
//			}
//			else {
//				System.out.println("Record Not Found - Cannot Update!!");
//			}

//		int id = creditDaoImpl.searchCredit("rettina", "melina");
//		 System.out.println("\n"+id);
	      // Prompt user for details of loan
	       
	      
//	      int loanAmount = 15000;
//	       
//	      
//	      int termInYears = 8;
//	       
//	      
//	      double interestRate = 15;
	      
//	      Credit credit = new Credit(); 
//	     double mensualite = credit.calcMensualite(loanAmount, termInYears, interestRate);
//		
//		 credit =new Credit("CR212", Date.valueOf("2022-03-11"), loanAmount, termInYears, interestRate, mensualite, "Réfusée", clientObj2);
//		
//		
//		credit = creditDaoImpl.insert(credit);
//		System.out.println(credit);
//		
//		ArrayList<Credit> credits = new ArrayList<Credit>();
//		credits=creditDaoImpl.getAll();
//		for (Credit credit1 : credits) {
//			System.out.println(credit1);
//		}
		
		//ClientDaoImple cImple = new ClientDaoImple();
		//Client clientObj2 = cImple.find(17);
		
		//Compte compte = new Compte("B101", Date.valueOf("2022-05-10"), 6450, "Compte Courant", 0, 0, clientObj2);
		
		//CompteDaoImpl cdi = new CompteDaoImpl();
		
		//Compte c;		
		
//		c=cdi.save(compte);
//		System.out.println(c);
		
		
//		ArrayList<Compte> comptes = new ArrayList<>();
//		comptes=cdi.getAll();
//		for (Compte compte : comptes) {
//			System.out.println(compte);
//		}
		
//		
//		clientObj2 = cImple.find(9);//Get by Id
//		if (clientObj2 != null) {
//			compte.setNum("B099");
//			compte.setDateCreation(Date.valueOf("2021-10-06"));
//			compte.setSolde(6587);
//			compte.setType("Compte Courant");
//			compte.setClient(clientObj2);
//			cdi.update(compte);
//		}
//		else {
//			System.out.println("Record Not Found - Cannot Update!!");
//		}
		
		/*Client client = new Client("Pasupathi", "Sailaja", Date.valueOf("1980-11-26"), "1 Avenue François Mitterand", "06.54.45.60.16", "p.sailaja@gmail.com", "Mme.");
		
		
		}*/
				
//		Client client = new Client();
//		System.out.println("Donner les informations de Client : ");
//		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Nom : ");
//		client.setNom(sc.next());
//		System.out.println("Prenom : ");
//		client.setPrenom(sc.next());
//		System.out.println("Date de Naissance : ");
//		client.setDateNaissance(Date.valueOf(sc.next()));
//		sc.nextLine();
//		System.out.println("Adresse : ");
//		client.setAdresse(sc.nextLine());
//		System.out.println("Telephone : ");
//		client.setTel(sc.next());
//		System.out.println("Mail : ");
//		client.setMail(sc.next());
//		System.out.println("Civilité : ");
//		client.setCivilite(sc.next());
//		
//		ClientDaoImple cdi = new ClientDaoImple();
//		
//		client = cdi.save(client);//add new record	
		
//		if (client != null ) {
//			System.out.println(client);
//		}
//		
		//cdi.getAll();//Get all records
		
//		client = cdi.find("Nisha");//Get by name
//		if (client != null ) {
//			System.out.println(client);
//		}
//		
//		client = cdi.find("Nisha","Rao");//Get by nom & prenom
//		if (client != null ) {
//			System.out.println(client);
//		}
//		
//		int num_records = cdi.count();
//		System.out.println("Number Of Records in the Client Table : "+num_records);
		
//		client = cdi.find(12);//Get by Id
//		if (client != null) {
//			client.setNom("Melina");
//			client.setPrenom("Raj");
//			cdi.update(client);
//		}
//		else {
//			System.out.println("Record Not Found - Cannot Update!!");
//		}
//		if (client != null ) {
//			System.out.println(client);
//		}
//		cdi.getAll("Radjou");//Get all records by name
//		
//		//cdi.delete(13);
//		client.setId(14);
//		int del_rec = cdi.delete(client);
//		
//		if (del_rec == 1) {
//			System.out.println("Deleted Successfully....");
//		} else {
//			System.out.println("Deletion Failure - Record Not found....");
//		}
	}

}
