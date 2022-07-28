package com.radjou.sailaja.web;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.radjou.sailaja.dao.ClientDaoImple;
import com.radjou.sailaja.dao.CompteDaoImpl;
import com.radjou.sailaja.dao.CreditDaoImpl;
import com.radjou.sailaja.dao.EmployeeDaoImpl;
import com.radjou.sailaja.metier.Client;
import com.radjou.sailaja.metier.Compte;
import com.radjou.sailaja.metier.Credit;
import com.radjou.sailaja.metier.Employee;

//annotation de l'url(les requete accepté)
@WebServlet("/")
public class ClientServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	 EmployeeDaoImpl empDaoImpl = new EmployeeDaoImpl();
	 Employee employee;
	
     ClientDaoImple cDaoImple = new ClientDaoImple();
     ArrayList<Client> clients;
     Client c;
     
     CompteDaoImpl cmpdi = new CompteDaoImpl();
     Compte compte;
     ArrayList<Compte> comptes;
     
     CreditDaoImpl creditDaoImpl = new CreditDaoImpl();
     ArrayList<Credit> credits;
     Credit credit;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String path = request.getServletPath();
		//System.out.println(path);
		
		switch (path) {
		case "/list-client": 
			listClient(request, response);
			break;
			
		case "/consulte-compte":
			consulteCompte(request, response);
			break;
			
		case "/consulte-credit":
			consulteCredit(request, response);
			break;
			
		case "/list-compte":
			listCompte(request, response);
			break;
			
		case "/list-credit":
			listCredit(request, response);
			break;
			
		case "/new-compte": 
			String id = request.getParameter("id");
			request.setAttribute("clientId", id);
			request.getRequestDispatcher("new-compte.jsp").forward(request, response);
			break;
			
		case "/new-client": 
			request.getRequestDispatcher("new-client.jsp").forward(request, response);
			break;
			
		case "/new-credit": 
			String clientId = request.getParameter("id");
			request.setAttribute("clientId", clientId);
			request.getRequestDispatcher("new-credit.jsp").forward(request, response);
			break;
			
		case "/save-client":
			saveClient(request, response);
//			response.sendRedirect("list-client");
			break;
			
		case "/save-compte":
			saveCompte(request, response);
//			response.sendRedirect("list-client");
			break;
			
		case "/save-credit":
			saveCredit(request, response);
//			response.sendRedirect("list-client");
			break;		
			
		case "/search":
			findClient(request, response);
			break;
			
		case "/find-id-compte":
			findClientId(request, response);
			request.getRequestDispatcher("new-compte.jsp").forward(request, response);
			break;
			
		case "/find-id-credit":
			findClientId(request, response);
			request.getRequestDispatcher("new-credit.jsp").forward(request, response);
			break;
			
		case "/search-compte":
			findCompte(request, response);
			break;
			
		case "/search-credit":
			findCredit(request, response);
			break;
			
		case "/modify-client":
			modifyClient(request, response);
			break;
			
		case "/update-client":
			updateClient(request, response);
			break;
			
		case "/modify-compte":
			modifyCompte(request, response);
			break;
			
		case "/update-compte":
			updateCompte(request, response);
			break;
			
		case "/modify-credit":
			modifyCredit(request, response);
			break;
			
		case "/update-credit":
			updateCredit(request, response);
			break;
			
		case "/delete-client":
			deleteClient(request, response);
			response.sendRedirect("list-client");
			break;
			
		case "/delete-compte":
			deleteCompte(request, response);
			response.sendRedirect("list-compte");
			break;
		
		case "/delete-credit":
			deleteCredit(request, response);
			response.sendRedirect("list-credit");
			break;	
			
		case "/client-detail":
			detailClient(request, response);
			break;
			
		case "/login":
			loginEmployee(request, response);
			break;
		
		case "/home":
			countClient(request, response);
			break;
			
		default:
			loginEmployee(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/******************				Employee			**********************/
	private void registerEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		employee = empDaoImpl.find(username, password);
		
		if(employee == null) {
			String msg = "Enter correct username & password";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		
		}
		else {
			request.setAttribute("username", employee.getUserName());
			request.setAttribute("status", employee.getStatus());
			countClient(request, response);
		}
	}
	
	
	/******************				CLIENT				**********************/
	private void countClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int countClients = cDaoImple.count();
		int countComptes = cmpdi.count();
		int countCourants = cmpdi.countCourant();
		int countEpargne = cmpdi.countEpargne();
		request.setAttribute("no_of_clients", countClients);
		request.setAttribute("no_of_comptes", countComptes);
		request.setAttribute("comptes_courants", countCourants);
		request.setAttribute("comptes_epargne", countEpargne);
		request.getRequestDispatcher("Index.jsp").forward(request, response);
	}

	private void listClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		clients = cDaoImple.getAll();
		request.setAttribute("clients", clients);
		request.getRequestDispatcher("list-client.jsp").forward(request, response);
	}
	
	private void saveClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissance = request.getParameter("date");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String civilite = request.getParameter("civilite");
		c = new Client(nom, prenom, Date.valueOf(dateNaissance), adresse, tel, email, civilite);
		c = cDaoImple.save(c);
		request.setAttribute("client", c);
		request.getRequestDispatcher("confirmation.jsp").forward(request, response);
	}
	
	
	private void modifyClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idclient"));
		c  = cDaoImple.find(id);
		request.setAttribute("client", c);
		request.getRequestDispatcher("update-client.jsp").forward(request, response);
		
	}
	
	private void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String dateNaissance = request.getParameter("date");
		String adresse = request.getParameter("adresse");
		String tel = request.getParameter("tel");
		String email = request.getParameter("email");
		String civilite = request.getParameter("civilite");
		int id = Integer.parseInt(request.getParameter("id"));
		
		c = cDaoImple.find(id);
		
		c = new Client(nom, prenom, Date.valueOf(dateNaissance), adresse, tel, email, civilite);
		c.setId(id);
		c = cDaoImple.update(c);
		
		request.setAttribute("client", c);
		request.getRequestDispatcher("confirmation.jsp").forward(request, response);
	}
	
	private void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idclient"));
		c = new Client();
		c.setId(id);
		cDaoImple.delete(c);
	}
	
	private void detailClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idclient"));
		
		c = cDaoImple.find(id);
		request.setAttribute("client", c);
		request.getRequestDispatcher("client-detail.jsp").forward(request, response);
		
	}
	
	private void findClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		clients = cDaoImple.getAll(nom, prenom);
		
		if(clients.isEmpty()) {
			String msg = "Client Not Exist !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);
		
		}
		else {
			request.setAttribute("clients", clients);
			request.getRequestDispatcher("list-client.jsp").forward(request, response);
		}
		
	}
	private void findClientId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");		
		c = cDaoImple.find(nom, prenom);
		//System.out.println(c);
		request.setAttribute("client", c);	
	}
	
	/******************				COMPTE				**********************/
	
	private void findCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int id = cmpdi.searchCompte(nom, prenom);
		System.out.println(id);
		c = cDaoImple.find(id);
		System.out.println(c);
		comptes = cmpdi.getAll(id);
		if (comptes.isEmpty()) {
			String msg = "Le Compte n'existe pas pour ce client !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);		
		}
		else {
			request.setAttribute("client", c);
			request.setAttribute("comptes", comptes);
			request.getRequestDispatcher("consulte-compte.jsp").forward(request, response);		
		}
	}	
	
	private void listCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		comptes = cmpdi.getAll();
		if (comptes.isEmpty()) {
			String msg = "Aucun enregistrement trouvé !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);
			
		}
		else {
			request.setAttribute("comptes", comptes);
			request.getRequestDispatcher("list-comptes.jsp").forward(request, response);
		}
		
	}
	
	private void consulteCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		c = cDaoImple.find(id);
		comptes = cmpdi.getAll(id);
		
		if (comptes.isEmpty()) {
			String msg = "Pas de compte pour ce client !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);			
		}
		else {
			request.setAttribute("client", c);
			request.setAttribute("comptes", comptes);
			request.getRequestDispatcher("consulte-compte.jsp").forward(request, response);		
		}
	}
	
	private void saveCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		String dateCreation = request.getParameter("date_cree");
		double soldes = Double.parseDouble(request.getParameter("soldes"));
		String type = request.getParameter("type");
		double decouvert = Double.parseDouble(request.getParameter("decouvert"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int id = Integer.parseInt(request.getParameter("id"));
		c = cDaoImple.find(id);
		compte = new Compte(num, Date.valueOf(dateCreation), soldes, type, decouvert, taux, c);
		compte = cmpdi.save(compte);
				
		if (compte != null && c != null) {
			request.setAttribute("compte", compte);
			request.getRequestDispatcher("compte-confirmation.jsp").forward(request, response);
		}
		else if(compte == null && c == null ) {
			String msg = "Ce Client n'est pas reconnu !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);
		}
		else {
			String msg = "Numero de Compte Déja Exist !!! ";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);
		}
		
		
	}
	
	private void deleteCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numCompte = request.getParameter("num");
		compte = new Compte();
		compte.setNum(numCompte);
		cmpdi.delete(compte);
	}
	
		
	private void modifyCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numCompte = request.getParameter("num");
		compte = cmpdi.find(numCompte);
		request.setAttribute("compte", compte);
		request.getRequestDispatcher("update-compte.jsp").forward(request, response);
		
	}	
	
	private void updateCompte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num");
		System.out.println(num);
		String dateCreation = request.getParameter("date_cree");
		double soldes = Double.parseDouble(request.getParameter("soldes"));
		String type = request.getParameter("type");
		double decouvert = Double.parseDouble(request.getParameter("decouvert"));
		double taux = Double.parseDouble(request.getParameter("taux"));
		int id = Integer.parseInt(request.getParameter("id"));
		c = cDaoImple.find(id);
		
		compte = new Compte(num, Date.valueOf(dateCreation), soldes, type, decouvert, taux, c);
		compte = cmpdi.update(compte);
		System.out.println(compte);
		//request.setAttribute("client", c);
		request.setAttribute("compte", compte);
		request.getRequestDispatcher("compte-confirmation.jsp").forward(request, response);
	}
	
	
	/******************				CREDIT				**********************/
	
	private void consulteCredit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		c = cDaoImple.find(id);
		credits =creditDaoImpl.getAll(id);
		if (credits.isEmpty()) {
			String msg = "Pas de credits pour ce client !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);			
		}
		else {
		request.setAttribute("client", c);
		request.setAttribute("credits", credits);
		request.getRequestDispatcher("consulte-credit.jsp").forward(request, response);
		}
	}
	
	private void saveCredit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num_credit");
		String dateDemande = request.getParameter("date_demande");
		double montant = Double.parseDouble(request.getParameter("montant"));
		int duree = Integer.parseInt(request.getParameter("duree"));		
		double taux = Double.parseDouble(request.getParameter("taux"));
		String etat = request.getParameter("etat");
		double mensualite = Double.parseDouble(request.getParameter("mensualite"));
		int id = Integer.parseInt(request.getParameter("id"));
		c = cDaoImple.find(id);
		credit = new Credit(num, Date.valueOf(dateDemande), montant, duree, taux, mensualite, etat, c);
		credit = creditDaoImpl.insert(credit);
		
		if (credit != null && credit.getMensualite() != -1) {
			request.setAttribute("credit", credit);
			request.getRequestDispatcher("credit-confirmation.jsp").forward(request, response);
		}
		else if(credit != null && credit.getMensualite() == -1) {
			String msg = "Mensualité Incorrecte !!!";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);
		}
		else {
			String msg = "Numero de Credit Déja Exist !!! ";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);
		}
		
	}
	
	private void listCredit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		credits = creditDaoImpl.getAll();
		if (credits.isEmpty()) {
			String msg = "Aucun enregistrement trouvé !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);			
		}
		else {
			request.setAttribute("credits", credits);
			request.getRequestDispatcher("list-credits.jsp").forward(request, response);
		}
	}
	
	private void deleteCredit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numCredit = request.getParameter("num");
		credit = new Credit();
		credit.setNumCredit(numCredit);
		creditDaoImpl.delete(credit);
	}
	
	private void findCredit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		int id = creditDaoImpl.searchCredit(nom, prenom);
		
		c = cDaoImple.find(id);		
		credits = creditDaoImpl.getAll(id);
		if (credits.isEmpty()) {
			String msg = "Pas de credits pour ce client !";
			request.setAttribute("message", msg);
			request.getRequestDispatcher("warning-page.jsp").forward(request, response);			
		}
		else {		
			request.setAttribute("client", c);
			request.setAttribute("credits", credits);
			request.getRequestDispatcher("consulte-credit.jsp").forward(request, response);
		}
	}	
	
	private void modifyCredit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String numCredit = request.getParameter("num");
		credit = creditDaoImpl.find(numCredit);
		request.setAttribute("credit", credit);
		request.getRequestDispatcher("update-credit.jsp").forward(request, response);
		
	}	
	
	private void updateCredit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("num_credit");
		String dateDemande = request.getParameter("date_demande");
		double montant = Double.parseDouble(request.getParameter("montant"));
		int duree = Integer.parseInt(request.getParameter("duree"));		
		double taux = Double.parseDouble(request.getParameter("taux"));
		String etat = request.getParameter("etat");
		double mensualite = Double.parseDouble(request.getParameter("mensualite"));
		int id = Integer.parseInt(request.getParameter("id"));
		c = cDaoImple.find(id);
		
		credit = new Credit(num, Date.valueOf(dateDemande), montant, duree, taux, mensualite, etat, c);
		credit = creditDaoImpl.update(credit);
		
		request.setAttribute("credit", credit);
		request.getRequestDispatcher("credit-confirmation.jsp").forward(request, response);
	}
	
	
}
