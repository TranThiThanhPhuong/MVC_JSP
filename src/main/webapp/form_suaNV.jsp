<%@page import = "java.util.ArrayList, Model.Bean.phongbanBEAN, Model.Bo.phongbanBO, Model.Bean.nhanvienBEAN" %>
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
	<%
		phongbanBO pbBO = new phongbanBO();
		ArrayList<phongbanBEAN> DSphongban = pbBO.xemdanhsachPB();
		nhanvienBEAN nv = (nhanvienBEAN) session.getAttribute("nhanvien");
	%>
 	<form action="nhanvienServlet" method="POST">
        <h4>Sửa thông tin nhân viên</h4>
        <input type="hidden" name="action" value="formsuaNV">
        <div>
            <label for="idnv">ID Nhân Viên</label>
            <input type="text" name="idnv" value="<%= nv.getId() %>" >
        </div>
        <div>
            <label for="tennv">Họ và Tên</label>
            <input type="text" name="hoten" required value="<%= nv.getName() %>">
        </div>
        <div>
            <label for="diachi" >Địa Chỉ</label>
             <input type="text" name="diachi" value="<%= nv.getAddress() %>">
        </div>
        <div>
    		<label for="idpb">Tên Phòng Ban</label>
    		<select name="idpb" required>
        	<%
          	  if (DSphongban != null) {
                for (phongbanBEAN dspb : DSphongban) {
        	%>
        		<option value="<%= dspb.getIdpb() %>" 
            		<%= dspb.getIdpb().equals(nv.getIdpb()) ? "selected" : "" %>>
       		    	<%= dspb.getTenpb() %>
       			</option>
        	<%
                }
           	 }
        	%>
    		</select>
		</div>
        <button type="submit" id="btnOK">OK</button>
        <button type="reset" id="btnReset">Reset</button>
    </form>
    <a href="xemdsnv.jsp"><button>Quay lại</button></a>
</body>
</html>