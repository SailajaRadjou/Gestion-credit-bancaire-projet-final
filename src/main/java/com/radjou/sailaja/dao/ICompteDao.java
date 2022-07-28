package com.radjou.sailaja.dao;

import java.util.ArrayList;

import com.radjou.sailaja.metier.Compte;

public interface ICompteDao {
	
	Compte save(Compte cmp);
	Compte update(Compte cmp);
	int delete(Compte cmp);
	
	Compte find(String num);
	ArrayList<Compte> getAll(int idClient);
	ArrayList<Compte> getAll();
	
	int count();
	int countCourant();
	int countEpargne();
	
	int searchCompte(String nom, String prenom);
}
