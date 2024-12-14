<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
	<form action="CheckLoginServlet" method="post">
		<h2>Đăng nhập hệ thống</h2>
		Tên đăng nhập <input type="text" name="username" required><br>
		Mật khẩu <input type="password" name="password" required>
		<br>
		<br>
		<input type="submit" value="Đăng nhập">
		<input type="button" value="Hủy">
	</form>
</body>
</html>