<%@page import = "java.util.ArrayList, Model.Bean.phongbanBEAN, Model.Bean.nhanvienBEAN" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sach phong ban</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
<h1>DANH SACH PHONG BAN	</h1>
	<table>
		<tr>
			<th>ID phòng ban</th>
			<th>Tên phòng ban</th>
			<th>Mô tả</th>
			<th>DS nhân viên</th>
		</tr>
		<%
		@SuppressWarnings("unchecked")
			ArrayList<phongbanBEAN> DSphongban = 
			(ArrayList<phongbanBEAN>) session.getAttribute("DSphongban");
			if (DSphongban != null) {
				for (phongbanBEAN dspb : DSphongban) {
		%>
		<tr>
			<td><%= dspb.getIdpb() %></td>
			<td><%= dspb.getTenpb()%></td>
			<td><%= dspb.getMota() %></td>
			<td><a href="<%= request.getContextPath() + "/phongbanServlet?idpb=" + dspb.getIdpb()%>">Xem</a></td>
		</tr>
		<%
			    }
			}
		%>
	</table>
	<a href="homepage.jsp"><button>Quay lại</button></a>
</body>
</html>