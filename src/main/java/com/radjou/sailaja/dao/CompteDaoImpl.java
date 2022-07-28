package com.radjou.sailaja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.radjou.sailaja.metier.Client;
import com.radjou.sailaja.metier.Compte;

public class CompteDaoImpl implements ICompteDao {
	Client client;
	Compte compte, cpt;
	
	PreparedStatement pStmt;
	Connection conn = SingletonConnection.getConnection();
	@Override
	public Compte save(Compte cmp) {
		try {
			cpt = find(cmp.getNum());
			if (cpt == null) {
				String sql = "insert into compte (num, date_creation, solde, type, decouvert, taux, id) values (?, ?, ?, ?, ?, ?, ?)";
				 
				pStmt = conn.prepareStatement(sql);
			
				pStmt.setString(1, cmp.getNum());
				pStmt.setDate(2, cmp.getDateCreation());
				pStmt.setDouble(3, cmp.getSolde());
				pStmt.setString(4, cmp.getType());
				pStmt.setDouble(5, cmp.getDecouvert());
				pStmt.setDouble(6, cmp.getTaux());
				pStmt.setInt(7, cmp.getClient().getId());
				
				pStmt.executeUpdate();
				System.out.println("Inserted a new record Successfully....");
				pStmt.close();
				
				return cmp;				
			}
			else {
				System.out.println("Compte Numero Déja Exist");
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public Compte update(Compte cmp) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("update compte set date_creation = ?, solde = ?, type = ?, decouvert = ?, taux = ? where num = ? and id = ?");
			
			pStmt.setString(6, cmp.getNum());
			pStmt.setDate(1, cmp.getDateCreation());
			pStmt.setDouble(2, cmp.getSolde());
			pStmt.setString(3, cmp.getType());
			pStmt.setDouble(4, cmp.getDecouvert());
			pStmt.setDouble(5, cmp.getTaux());
			pStmt.setInt(7, cmp.getClient().getId());
			
			pStmt.executeUpdate();
			System.out.println("Updated Successfully....");
			pStmt.close();
			return this.find(cmp.getNum());
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int delete(Compte cmp) {
		int res;
		try {
			PreparedStatement pStmt = conn.prepareStatement("delete from compte where num = ?");
			
			pStmt.setString(1, cmp.getNum());
			
			res = pStmt.executeUpdate();
			
			pStmt.close();
			return res;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}

	@Override
	public Compte find(String num) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from compte where num = ?");
			
			pStmt.setString(1, num);
			
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				ClientDaoImple cdi = new ClientDaoImple();
				client = cdi.find(rSet.getInt("id"));
				compte = new Compte();
				compte.setNum(rSet.getString("num"));
				compte.setDateCreation(rSet.getDate("date_creation"));
				compte.setSolde(rSet.getDouble("solde"));
				compte.setType(rSet.getString("type"));
				compte.setDecouvert(rSet.getDouble("decouvert"));
				compte.setTaux(rSet.getDouble("taux"));
				compte.setClient(client);
				
				
				pStmt.close();
				return compte;
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public ArrayList<Compte> getAll(int idClient) {
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from compte where id = ?");
			
			pStmt.setInt(1, idClient);
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				ClientDaoImple cdi = new ClientDaoImple();
				client = cdi.find(rSet.getInt("id"));
				compte = new Compte();
				compte.setNum(rSet.getString("num"));
				compte.setDateCreation(rSet.getDate("date_creation"));
				compte.setSolde(rSet.getDouble("solde"));
				compte.setType(rSet.getString("type"));
				compte.setDecouvert(rSet.getDouble("decouvert"));
				compte.setTaux(rSet.getDouble("taux"));
				compte.setClient(client);
				
				comptes.add(compte);
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return comptes;
	}

	@Override
	public ArrayList<Compte> getAll() {
		ArrayList<Compte> comptes = new ArrayList<Compte>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from compte");
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				ClientDaoImple cdi = new ClientDaoImple();
				client = cdi.find(rSet.getInt("id"));
				compte = new Compte();
				compte.setNum(rSet.getString("num"));
				compte.setDateCreation(rSet.getDate("date_creation"));
				compte.setSolde(rSet.getDouble("solde"));
				compte.setType(rSet.getString("type"));
				compte.setDecouvert(rSet.getDouble("decouvert"));
				compte.setTaux(rSet.getDouble("taux"));
				compte.setClient(client);
				
				comptes.add(compte);
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return comptes;
	}

	@Override
	public int count() {
		int count = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select count(*) as Num_Record from compte");
			
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
	public int countCourant() {
		int count = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select count(*) as Num_Record from compte where type = \"compte courant\";");
			
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
	public int countEpargne() {
		int count = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("select count(*) as Num_Record from compte where type = \"compte epargne\";");
			
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
	public int searchCompte(String nom, String prenom) {
		int id = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("SELECT DISTINCT id FROM compte NATURAL JOIN client WHERE nom = ? and prenom = ?");
			
			pStmt.setString(1, nom);
			pStmt.setString(2, prenom);
			ResultSet rSet = pStmt.executeQuery();
			if(rSet.next()) {
				id = rSet.getInt("id");
			}
			pStmt.close();
			return id;
		}	
		catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}

}
