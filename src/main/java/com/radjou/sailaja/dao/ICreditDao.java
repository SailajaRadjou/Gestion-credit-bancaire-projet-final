package com.radjou.sailaja.dao;

import java.util.ArrayList;

import com.radjou.sailaja.metier.Credit;



public interface ICreditDao {

	Credit insert(Credit credit);
	Credit update(Credit credit);
	int delete(Credit credit);
	
	Credit find(String creditNum);
	ArrayList<Credit> getAll(int idClient);
	ArrayList<Credit> getAll();
	
	int searchCredit(String nom, String prenom);
}
