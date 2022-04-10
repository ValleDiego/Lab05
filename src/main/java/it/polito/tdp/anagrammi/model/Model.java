package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.anagrammi.db.DAO;

public class Model {
	
	Map<String, RightWord> risultato = new HashMap<String, RightWord>();
	List<String> dizionario = new ArrayList<String>();//INIZIALIZZARE
	
	public Model() {//NON DIMENTICARTELO
		DAO dao = new DAO();
		this.dizionario = dao.getDizionario();
		System.out.println("Funziona: "+dizionario.size()+"\n");
	}
	
	public Map<String, RightWord> getAnagrammi(String parola){
		risultato.clear();
		anagramma_ricorsiva("", 0, parola);
		System.out.println("Risultato:"+risultato.size()+"\n");
		return risultato;
	}
	
	private void anagramma_ricorsiva(String parziale, int livello, String rimanenti){
		if(rimanenti.length()==0) {
			if(itExist(parziale)) {
				RightWord p = new RightWord(parziale, true);
				risultato.put(parziale, p);
			} else {
				RightWord p = new RightWord(parziale, false);
				risultato.put(parziale, p);
			}
		}else {
			for(int pos = 0; pos<rimanenti.length(); pos++) {
				anagramma_ricorsiva(parziale+rimanenti.charAt(pos), livello+1, rimanenti.substring(0, pos)+rimanenti.substring(pos+1));
			}
		}
		
		
	}

	private boolean itExist(String parziale) {
		// TODO Auto-generated method stub
		if(dizionario.contains(parziale))
		return true;
		return false;
	}
	

}
