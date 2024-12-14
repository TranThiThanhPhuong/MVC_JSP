package Model.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class CheckLoginDAO {

	public boolean isExistUser(String username, String password) throws ClassNotFoundException, SQLException {
	    boolean ktra = false;
		try {
	    	Class.forName("com.mysql.cj.jdbc.Driver");
	    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DULIEU", "root", "");
	    	Statement stm = conn.createStatement();
	    	String sql = "SELECT * FROM admin";
	    	ResultSet rs = stm.executeQuery(sql);
	    	while (rs.next()) {
	    		if ((username.equals(rs.getString(1)) &&
	    			password.equals(rs.getString(2)))) {
	    				ktra = true;
	    				break;
	    		}
	    	}
		}
	     catch (Exception e) {
	    	 System.out.print(e);
	     }
	    return ktra;
	}
	

}
