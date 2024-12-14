<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
 	<form action="nhanvienServlet" method="POST">
        <h4>Tìm kiếm thông tin nhân viên theo ID, tên, địa chỉ</h4>
        <input type="hidden" name="action" value="formtimkiemNV">
        <div>
            <label for="idnv">ID</label>
            <input type="radio" name="info" value="id">
        </div>
        <div>
            <label for="hoten">Họ, Tên</label>
            <input type="radio" name="info" value="hoten">
        </div>
        <div>
            <label for="diachi">Địa chỉ</label>
            <input type="radio" name="info" value="diachi">
        </div>
        <div>
            <label for="input">Nhập</label>
            <input type="text" name="input">
        </div>
        <button type="submit" id="btnOK">Tìm kiếm</button>
        <button type="reset" id="btnReset">Reset</button>
    </form>
    <a href="xemdsnv.jsp"><button>Quay lại</button></a>
</body>
</html>