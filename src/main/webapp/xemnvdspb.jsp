<%@page import = "java.util.ArrayList, Model.Bean.nhanvienBEAN" %>
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
	<h1>DANH SACH NHAN VIEN	</h1>
	<table>
		<tr>
			<th>ID nhân viên</th>
			<th>Họ tên</th>
			<th>Địa chỉ</th>
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
			<td><%= dsnv.getAddress() %></td>
		</tr>
		<%
			    }
			}
		%>
	</table>
	<a href="xemdspb.jsp"><button>Quay lại</button></a>
</body>
</html>
