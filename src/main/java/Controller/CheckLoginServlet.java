package Controller;

import java.io.IOException;
import java.sql.SQLException;

//import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Bo.CheckLoginBO;

@WebServlet("/CheckLoginServlet")

public class CheckLoginServlet extends HttpServlet  {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
			//String destination = null;
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			CheckLoginBO checkLoginBO = new CheckLoginBO();
			try {
			    if (checkLoginBO.isValidUser(username, password)) {
			    	response.sendRedirect(request.getContextPath() + "/homepage.jsp");
			    }
			    else {
			    	response.sendRedirect(request.getContextPath() + "/Login.jsp");
			    }
			} catch (ClassNotFoundException | SQLException e) {
			    e.printStackTrace();
			  }
	}
}
