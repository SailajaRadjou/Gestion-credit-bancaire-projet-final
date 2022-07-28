package com.radjou.sailaja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.radjou.sailaja.metier.Client;

public class ClientDaoImple implements IClientDao{
	Client client;
	Connection conn = SingletonConnection.getConnection();
	@Override
	public Client save(Client c) {
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("insert into client (nom, prenom, date_naissance, tel, adresse, mail, civilite) values (?, ?, ?, ?, ?, ?, ?)");
			
			pStmt.setString(1, c.getNom());
			pStmt.setString(2, c.getPrenom());
			pStmt.setDate(3, c.getDateNaissance());
			pStmt.setString(4, c.getTel());
			pStmt.setString(5, c.getAdresse());
			pStmt.setString(6, c.getMail());
			pStmt.setString(7, c.getCivilite());
			
			pStmt.executeUpdate();
			System.out.println("Inserted a new record Successfully....");
			pStmt.close();
			
			pStmt = conn.prepareStatement("select max(id) as Last_Record from client");
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				c.setId(rSet.getInt("Last_Record"));
				pStmt.close();
				return c;
			}			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Client update(Client c) {
	
		try {
			PreparedStatement pStmt = conn.prepareStatement("update client set nom = ?, prenom = ?, date_naissance = ?, adresse = ?, tel = ?, mail = ?, civilite = ? where id = ?");
			
			pStmt.setInt(8, c.getId());
			pStmt.setString(1, c.getNom());
			pStmt.setString(2, c.getPrenom());
			pStmt.setDate(3, c.getDateNaissance());
			pStmt.setString(5, c.getTel());
			pStmt.setString(4, c.getAdresse());
			pStmt.setString(6, c.getMail());
			pStmt.setString(7, c.getCivilite());
			
			pStmt.executeUpdate();
			System.out.println("Updated Successfully....");
			pStmt.close();
			return this.find(c.getId());
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int delete(Client c) {
		int res;
		try {
			PreparedStatement pStmt = conn.prepareStatement("delete from client where id = ?");
			
			pStmt.setInt(1, c.getId());
			
			res = pStmt.executeUpdate();
			
			pStmt.close();
			return res;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}

	@Override
	public ArrayList<Client> getAll() {
		
		ArrayList<Client> clients = new ArrayList<Client>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client");
			
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				client = new Client();
				client.setId(rSet.getInt("id"));
				client.setNom(rSet.getString("nom"));
				client.setPrenom(rSet.getString("prenom"));
				client.setDateNaissance(rSet.getDate("date_naissance"));
				client.setAdresse(rSet.getString("adresse"));
				client.setTel(rSet.getString("tel"));
				client.setMail(rSet.getString("mail"));
				client.setCivilite(rSet.getString("civilite"));
				
				clients.add(client);
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return clients;
	}

	@Override
	public ArrayList<Client> getAll(String nom) {
		ArrayList<Client> clients = new ArrayList<Client>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client where nom = ?");
			//"select * from client where nom like ?"
			//pStmt.setString(1,'%'+nom+'%');
			
			pStmt.setString(1, nom);
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				client = new Client();
				client.setId(rSet.getInt("id"));
				client.setNom(rSet.getString("nom"));
				client.setPrenom(rSet.getString("prenom"));
				client.setDateNaissance(rSet.getDate("date_naissance"));
				client.setAdresse(rSet.getString("adresse"));
				client.setTel(rSet.getString("tel"));
				client.setMail(rSet.getString("mail"));
				client.setCivilite(rSet.getString("civilite"));
				
				clients.add(client);
			}
			
			pStmt.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return clients;
	}

	@Override
	public Client find(int id) {
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client where id = ?");
			
			pStmt.setInt(1, id);
			
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				client = new Client();
				client.setId(rSet.getInt("id"));
				client.setNom(rSet.getString("nom"));
				client.setPrenom(rSet.getString("prenom"));
				client.setDateNaissance(rSet.getDate("date_naissance"));
				client.setAdresse(rSet.getString("adresse"));
				client.setTel(rSet.getString("tel"));
				client.setMail(rSet.getString("mail"));
				client.setCivilite(rSet.getString("civilite"));
				pStmt.close();
				return client;
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Client find(String nom) {
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client where nom = ?");
			
			pStmt.setString(1, nom);
			
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				client = new Client();
				client.setId(rSet.getInt("id"));
				client.setNom(rSet.getString("nom"));
				client.setPrenom(rSet.getString("prenom"));
				client.setDateNaissance(rSet.getDate("date_naissance"));
				client.setAdresse(rSet.getString("adresse"));
				client.setTel(rSet.getString("tel"));
				client.setMail(rSet.getString("mail"));
				client.setCivilite(rSet.getString("civilite"));
				
				return client;
			}
			
			pStmt.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Client find(String nom, String prenom) {
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client where nom = ? and prenom = ?");
			
			pStmt.setString(1, nom);
			pStmt.setString(2, prenom);
			
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				client = new Client();
				client.setId(rSet.getInt("id"));
				client.setNom(rSet.getString("nom"));
				client.setPrenom(rSet.getString("prenom"));
				client.setDateNaissance(rSet.getDate("date_naissance"));
				client.setAdresse(rSet.getString("adresse"));
				client.setTel(rSet.getString("tel"));
				client.setMail(rSet.getString("mail"));
				client.setCivilite(rSet.getString("civilite"));
				
				return client;
			}
			
			pStmt.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int count() {
		
		int count = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select count(*) as Num_Record from client");
			
			ResultSet rSet = pStmt.executeQuery();
			if(rSet.next()) {
				count = rSet.getInt("Num_Record");
			}
			pStmt.close();
			return count;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}

	@Override
	public ArrayList<Client> getAll(String nom, String prenom) {
		ArrayList<Client> clients = new ArrayList<Client>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from client where nom like ? and prenom like ?");
			
			pStmt.setString(1,'%'+nom+'%');
			
			pStmt.setString(2,'%'+prenom+'%');
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				client = new Client();
				client.setId(rSet.getInt("id"));
				client.setNom(rSet.getString("nom"));
				client.setPrenom(rSet.getString("prenom"));
				client.setDateNaissance(rSet.getDate("date_naissance"));
				client.setAdresse(rSet.getString("adresse"));
				client.setTel(rSet.getString("tel"));
				client.setMail(rSet.getString("mail"));
				client.setCivilite(rSet.getString("civilite"));
				
				clients.add(client);
			}
			
			pStmt.close();
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return clients;
	}

}
