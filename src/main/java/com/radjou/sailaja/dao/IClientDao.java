package com.radjou.sailaja.dao;

import java.util.ArrayList;

import com.radjou.sailaja.metier.Client;

public interface IClientDao {

	Client save(Client c);
	Client update(Client c);
	int delete(Client c);
	
	ArrayList<Client> getAll();
	ArrayList<Client> getAll(String nom);
	ArrayList<Client> getAll(String nom, String prenom);
	
	Client find(int id);
	Client find(String nom);
	Client find(String nom, String prenom);
	
	int count();
}
