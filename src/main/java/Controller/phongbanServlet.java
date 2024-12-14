package Controller;

import java.io.IOException;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Bean.nhanvienBEAN;
//import Model.Bean.nhanvienBEAN;
//import Model.Bo.nhanvienBO;
import Model.Bean.phongbanBEAN;
import Model.Bo.phongbanBO;

@WebServlet("/phongbanServlet")

public class phongbanServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idpb = request.getParameter("idpb");
		phongbanBO pbBO = new phongbanBO();
		try {
			if (idpb != null) {
				ArrayList<nhanvienBEAN> DSnhanvien = pbBO.xemdanhsachNVtrongPB(idpb);
		    	request.getSession().setAttribute("DSnhanvien", DSnhanvien);
		    	response.sendRedirect(request.getContextPath() + "/xemnvdspb.jsp");
			}
			else {
				ArrayList<phongbanBEAN> DSphongban = pbBO.xemdanhsachPB();
		    	request.getSession().setAttribute("DSphongban", DSphongban);
		    	response.sendRedirect(request.getContextPath() + "/xemdspb.jsp");
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
