<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME PAGE</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
		<p><a href="${pageContext.request.contextPath}/phongbanServlet">Quản lý phòng ban</a></p>
		<p><a href="${pageContext.request.contextPath}/nhanvienServlet">Quản lý học sinh</a></p>
		<p><a href="Login.jsp"><button>Đăng xuất</button></a></p>
</body>
</html>