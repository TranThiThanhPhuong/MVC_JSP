<%@ page import="java.util.ArrayList, Model.Bean.nhanvienBEAN" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kết quả tìm kiếm</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<h4>Kết quả tìm kiếm</h4>
        <table>
            <tr>
			<th>ID nhân viên</th>
			<th>Họ tên</th>
			<th>ID phòng ban</th>
			<th>Địa chỉ</th>
		</tr>
    <%
    	@SuppressWarnings("unchecked")
    	ArrayList<nhanvienBEAN> DSnhanvien = 
		(ArrayList<nhanvienBEAN>) session.getAttribute("DSnhanvien");
		if (DSnhanvien != null && !DSnhanvien.isEmpty()) {
			for (nhanvienBEAN dsnv : DSnhanvien) {
    %>
        <tr>
            <td><%= dsnv.getId() %></td>
			<td><%= dsnv.getName() %></td>
			<td><%= dsnv.getIdpb() %></td>
			<td><%= dsnv.getAddress() %></td>
        </tr>
		<%
			    }
			}
		%>
    </table>
    <a href="xemdsnv.jsp"><button>Quay lại</button></a>
</body>
</html>