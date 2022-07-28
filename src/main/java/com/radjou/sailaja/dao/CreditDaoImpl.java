package com.radjou.sailaja.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.radjou.sailaja.metier.Client;
import com.radjou.sailaja.metier.Credit;

public class CreditDaoImpl implements ICreditDao {
	Client client;
	Credit credit, crt;
	
	PreparedStatement pStmt;
	Connection conn = SingletonConnection.getConnection();

	@Override
	public Credit insert(Credit credit) {
		try {
			
			crt = find(credit.getNumCredit());

			if (crt == null) {
				
				String sql = "insert into credit (num_credit, date_credit, capital, duree, taux, mensualite, etat, id) values (?, ?, ?, ?, ?, ?, ?, ?)";

				pStmt = conn.prepareStatement(sql);

				pStmt.setString(1, credit.getNumCredit());
				pStmt.setDate(2, credit.getCreditDate());
				pStmt.setDouble(3, credit.getCapital());
				pStmt.setInt(4, credit.getDuree());
				pStmt.setDouble(5, credit.getTaux());
				pStmt.setDouble(6, credit.getMensualite());
				pStmt.setString(7, credit.getEtat());
				pStmt.setInt(8, credit.getClient().getId());
				
				double mensual = calculeMensual(credit.getCapital(), credit.getDuree(), credit.getTaux());
				System.out.println(mensual);
				
				if (mensual == credit.getMensualite()) {
					pStmt.executeUpdate();
					System.out.println("Inserted a new record Successfully....");
					pStmt.close();
					return credit;
					
				}		 
				else {
				System.out.println("Mishandling Error");
				credit.setMensualite(-1);
				return credit;
				}
			}

		}
		
		catch (Exception e) {
			System.err.println(e);
		}
		
		return null;
	}

	
	@Override
	public Credit update(Credit credit) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("update credit set date_credit = ?, capital = ?, duree = ?, taux = ?, mensualite = ?, etat = ? where num_credit = ? and id = ?");
			
			pStmt.setString(7, credit.getNumCredit());
			pStmt.setDate(1, credit.getCreditDate());
			pStmt.setDouble(2, credit.getCapital());
			pStmt.setInt(3, credit.getDuree());
			pStmt.setDouble(4, credit.getTaux());
			pStmt.setDouble(5, credit.getMensualite());
			pStmt.setString(6, credit.getEtat());
			pStmt.setInt(8, credit.getClient().getId());

			pStmt.executeUpdate();
			System.out.println("Updated Successfully....");
			pStmt.close();

			return credit;
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public int delete(Credit credit) {
		int res;
		try {
			PreparedStatement pStmt = conn.prepareStatement("delete from credit where num_credit = ?");
			
			pStmt.setString(1, credit.getNumCredit());
			
			res = pStmt.executeUpdate();
			System.out.println("Deleted Successfully....");
			
			pStmt.close();
			return res;
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return 0;
	}

	@Override
	public Credit find(String creditNum) {
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from credit where num_credit = ?");
			
			pStmt.setString(1, creditNum);
			
			ResultSet rSet = pStmt.executeQuery();
			
			if(rSet.next()) {
				ClientDaoImple cdi = new ClientDaoImple();
				client = cdi.find(rSet.getInt("id"));
				credit = new Credit();
				credit.setNumCredit(rSet.getString("num_credit"));
				credit.setCreditDate(rSet.getDate("date_credit"));
				credit.setCapital(rSet.getDouble("capital"));
				credit.setDuree(rSet.getInt("duree"));
				credit.setTaux(rSet.getDouble("taux"));
				credit.setMensualite(rSet.getDouble("mensualite"));
				credit.setEtat(rSet.getString("etat"));
				credit.setClient(client);
				
				
				pStmt.close();
				return credit;
			}
			
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		return null;
	}

	@Override
	public ArrayList<Credit> getAll(int idClient) {
		ArrayList<Credit> credits = new ArrayList<Credit>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from credit where id = ?");
			
			pStmt.setInt(1, idClient);
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				ClientDaoImple cdi = new ClientDaoImple();
				client = cdi.find(rSet.getInt("id"));
				credit = new Credit();
				credit.setNumCredit(rSet.getString("num_credit"));
				credit.setCreditDate(rSet.getDate("date_credit"));
				credit.setCapital(rSet.getDouble("capital"));
				credit.setDuree(rSet.getInt("duree"));
				credit.setTaux(rSet.getDouble("taux"));
				credit.setMensualite(rSet.getDouble("mensualite"));
				credit.setEtat(rSet.getString("etat"));
				credit.setClient(client);
				
				credits.add(credit);
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return credits;
	}

	@Override
	public ArrayList<Credit> getAll() {
		ArrayList<Credit> credits = new ArrayList<Credit>();
		
		try {
			PreparedStatement pStmt = conn.prepareStatement("select * from credit");
			
			
			ResultSet rSet = pStmt.executeQuery();
			
			while (rSet.next()) {
				ClientDaoImple cdi = new ClientDaoImple();
				client = cdi.find(rSet.getInt("id"));
				credit = new Credit();
				credit.setNumCredit(rSet.getString("num_credit"));
				credit.setCreditDate(rSet.getDate("date_credit"));
				credit.setCapital(rSet.getDouble("capital"));
				credit.setDuree(rSet.getInt("duree"));
				credit.setTaux(rSet.getDouble("taux"));
				credit.setMensualite(rSet.getDouble("mensualite"));
				credit.setEtat(rSet.getString("etat"));
				credit.setClient(client);
				
				credits.add(credit);
			}
			
			
		} catch (Exception e) {
			System.err.println(e);
		}
		
		return credits;
		
	}


	@Override
	public int searchCredit(String nom, String prenom) {
		int id = 0;
		try {
			PreparedStatement pStmt = conn.prepareStatement("SELECT DISTINCT id FROM credit NATURAL JOIN client WHERE nom = ? and prenom = ?");
			
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
	
	public static double calculeMensual(double capital, int duree, double taux) {		       
		      		       
		      taux /= 100.0;		       
		         
		      double tauxMensual = taux / 12.0;
		       
		      int dureeMois = duree * 12;
		     		       
		      double mensualite = (capital*tauxMensual) / (1-Math.pow(1+tauxMensual, -dureeMois));
		      
		      mensualite = (double) (Math.round(mensualite*100.0)/100.0);
		      return mensualite;
	}
	

}
