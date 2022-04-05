package it.polito.tdp.anagrammi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import it.polito.tdp.anagrammi.db.DBConnect;


public class DAO {
	
	public List<String> getDizionario(){
		List<String> dizionario = null;
		final String sql = "SELECT nome FROM parola ";
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				dizionario.add(rs.getString("nome"));
			}
			st.close();
			conn.close();
		return dizionario;
		
	}catch (SQLException e) {
		// e.printStackTrace();
		throw new RuntimeException("Errore DB", e);
	}

}
}