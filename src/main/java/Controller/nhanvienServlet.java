package Controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import Model.Bean.nhanvienBEAN;
import Model.Bo.nhanvienBO;

@WebServlet("/nhanvienServlet")

public class nhanvienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		nhanvienBO nhanvienBO = new nhanvienBO();
		String idnv = request.getParameter("idnv");
		String action = request.getParameter("action");
		try {
			if ("checkIDNV".equals(action)) {
	            String idNV = request.getParameter("idNV");
	            boolean result = nhanvienBO.checkIdNV(idNV);
	            response.getWriter().write(String.valueOf(result));
	        }
			
			else if ("formthemNV".equals(action)) {
				String idmoi = request.getParameter("idmoi");
				String hoten = request.getParameter("hoten");
				String idpb = request.getParameter("idpb");
				String diachi = request.getParameter("diachi");
				
				boolean result = nhanvienBO.themNV(idmoi, hoten, idpb, diachi);
				if (result) {
					ArrayList<nhanvienBEAN> DSnhanvien = nhanvienBO.xemdanhsachNV();
		            request.getSession().setAttribute("DSnhanvien", DSnhanvien);
	                response.sendRedirect(request.getContextPath() + "/xemdsnv.jsp");
	            }
			}
			
			else if ("sua".equals(action)) {
				nhanvienBEAN nvBEAN = nhanvienBO.laythongtinNV(idnv);
				request.getSession().setAttribute("nhanvien", nvBEAN);
		    	response.sendRedirect(request.getContextPath() + "/form_suaNV.jsp");
			}
			
			else if ("formsuaNV".equals(action)) {
				String hoten = request.getParameter("hoten");
				String idpb = request.getParameter("idpb");
				String diachi = request.getParameter("diachi");
				
				boolean result = nhanvienBO.suathongtinNV(idnv, hoten, idpb, diachi);
				if (result) {
					ArrayList<nhanvienBEAN> DSnhanvien = nhanvienBO.xemdanhsachNV();
		            request.getSession().setAttribute("DSnhanvien", DSnhanvien);
	                response.sendRedirect(request.getContextPath() + "/xemdsnv.jsp");
	            }
			}
			
			else if ("xoa".equals(action)) {
				boolean result = nhanvienBO.xoathongtinNV(idnv);
				if (result) {
					ArrayList<nhanvienBEAN> DSnhanvien = nhanvienBO.xemdanhsachNV();
		            request.getSession().setAttribute("DSnhanvien", DSnhanvien);
	                response.sendRedirect(request.getContextPath() + "/xemdsnv.jsp");
	            } 
			}

			else if ("formtimkiemNV".equals(action)) {
				String info = request.getParameter("info");
				String input = request.getParameter("input");
				
				ArrayList<nhanvienBEAN> DSnhanvien = nhanvienBO.timkiemNV(info, input);
				request.getSession().setAttribute("DSnhanvien", DSnhanvien);
                response.sendRedirect(request.getContextPath() + "/ketquatimkiemNV.jsp");
			}
			
			else {
				ArrayList<nhanvienBEAN> DSnhanvien = nhanvienBO.xemdanhsachNV();
		    	request.getSession().setAttribute("DSnhanvien", DSnhanvien);
		    	response.sendRedirect(request.getContextPath() + "/xemdsnv.jsp");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
