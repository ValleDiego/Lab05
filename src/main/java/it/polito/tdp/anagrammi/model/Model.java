package it.polito.tdp.anagrammi.model;

import java.util.List;

import it.polito.tdp.anagrammi.db.DAO;

public class Model {
	
	
	List<String> dizionario = null;
	public Model() {//NON DIMENTICARTELO
		DAO dao = new DAO();
		this.dizionario = dao.getDizionario();
		System.out.println("Funziona: "+dizionario.size());
	}
	
	public List<String> getAnagrammi(String parola){
		
		List<String> risultato = null;
		
		
		return risultato;
		
	}
	

}
