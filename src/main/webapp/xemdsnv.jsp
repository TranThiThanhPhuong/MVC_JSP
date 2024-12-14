<%@page import = "java.util.ArrayList, Model.Bean.nhanvienBEAN, Model.Bean.phongbanBEAN, Model.Bo.phongbanBO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WelCome</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<h1>DANH SACH HOC SINH</h1>
	<div>
	<%
		phongbanBO pbBO = new phongbanBO();
		ArrayList<phongbanBEAN> DSphongban = pbBO.xemdanhsachPB();
	%>
		<select name="idpb" required>
        	<%
          	  if (DSphongban != null) {
                for (phongbanBEAN dspb : DSphongban) {
        	%>
        		<option  value="<%= dspb.getIdpb() %>">
       		    	<%= dspb.getTenpb() %>
       			</option>
        	<%
                }
           	 }
        	%>
    		</select>
		<a href="form_themNV.jsp"><button>Thêm học sinh</button></a>
		<a href="form_timkiemNV.jsp"><button>Tìm kiếm học sinh</button></a>
	</div>
	<table>
		<tr>
			<th>MSSN</th>
			<th>Họ tên</th>
			<th>Khoa</th>
			<th>Giới tính</th>
			<th>Sửa học sinh</th>
			<th>Xóa học sinh</th>
		</tr>
		<%
		@SuppressWarnings("unchecked")
			ArrayList<nhanvienBEAN> DSnhanvien = 
			(ArrayList<nhanvienBEAN>) session.getAttribute("DSnhanvien");
			if (DSnhanvien != null) {
				for (nhanvienBEAN dsnv : DSnhanvien) {
		%>
		<tr>
			<td><%= dsnv.getId() %></td>
			<td><%= dsnv.getName() %></td>
			<td><%= dsnv.getIdpb() %></td>
			<td><%= dsnv.getAddress() %></td>
			<td><a href="<%= request.getContextPath() + "/nhanvienServlet?action=sua&idnv=" + dsnv.getId()%>">Sửa</a></td>
			<td><a href="<%= request.getContextPath() + "/nhanvienServlet?action=xoa&idnv=" + dsnv.getId()%>">Xóa</a></td>
		</tr>
		<%
			    }
			}
		%>
	</table>
	<a href="homepage.jsp"><button>Quay lại</button></a>
</body>
</html>
