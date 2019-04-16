package automobili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Metode {

	private Connection konektujSe(String baza) throws SQLException {
		
		final String url = "jdbc:mysql://localhost:3306/" + baza + "?useSSL=false";
		final String userName = "root";
		final String password = "root";
		
		return DriverManager.getConnection(url, userName, password);
		
	}
	
	public void ubaciMarku(String nazivMarke, String zemlja) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		
		try {
			konekcija = konektujSe("automobili");
			String query = "INSERT INTO marke VALUES (null,?,?)";
			pst = konekcija.prepareStatement(query);
				pst.setString(1, nazivMarke);
				pst.setString(2, zemlja);
			pst.execute();
			System.out.println("Uspesan unos");
			
		} catch (SQLException e) {
			System.out.println("Neuspesan unos");
			e.printStackTrace();
		} finally {
			
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	
	
	public Marke vratimarkuAutomobila(int id) {
		
		Connection konekcija = null;
		PreparedStatement pst = null;
		ResultSet res = null;
		Marke marke = new Marke();
		try {
			konekcija = konektujSe("automobili");
			String query = "SELECT * FROM marke WHERE id_marke = ?";
			pst = konekcija.prepareStatement(query);
			pst.setInt(1, id);
			res = pst.executeQuery();
			while(res.next()) {
				marke.setIdMarke(res.getInt("id_marke"));
				marke.setImeMarke(res.getString("naziv_marke"));
				marke.setZemlja(res.getString("zemlja"));
			}
			return marke;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}finally {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				konekcija.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	
	
	
}
