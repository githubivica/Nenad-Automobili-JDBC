package automobili;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	
	
	
	
	
	
	
}
