package Model.Bo;

import java.sql.SQLException;
import Model.Dao.CheckLoginDAO;

public class CheckLoginBO {
	CheckLoginDAO checkLoginDAO = new CheckLoginDAO();
	public boolean isValidUser(String username, String password) throws ClassNotFoundException, SQLException {
		return checkLoginDAO.isExistUser(username, password);
	}
}
