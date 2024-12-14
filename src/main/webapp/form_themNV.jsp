<%@page import = "java.util.ArrayList, Model.Bean.phongbanBEAN, Model.Bo.phongbanBO, Model.Bean.nhanvienBEAN" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<script>
function checkIDNV() {
    const idNV = document.getElementsByName("idmoi")[0].value;
    console.log("Mã nhân viên gửi đi:", idNV); // Debug log
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "nhanvienServlet?action=checkIDNV", true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const response = xhr.responseText;
            console.log("Kết quả từ server:", response); // Debug log
            if (response.trim() === "true") {
                alert("Mã nhân viên đã tồn tại, vui lòng nhập mã khác!");
                document.getElementsByName("idmoi")[0].value = ""; // Xóa mã bị trùng
            }
        }
    };
    xhr.send("idNV=" + encodeURIComponent(idNV));
}

</script>
</head>
<body>
	<%
		phongbanBO pbBO = new phongbanBO();
		ArrayList<phongbanBEAN> DSphongban = pbBO.xemdanhsachPB();
	%>
 	<form action="nhanvienServlet" method="POST">
        <h4>Thêm<h4>
        <input type="hidden" name="action" value="formthemNV">
        <div>
            <label for="idnv">ID</label>
            <input type="text" name="idmoi" onBlur="checkIDNV()" required>
        </div>
        <div>
            <label for="tennv">Họ và Tên</label>
            <input type="text" name="hoten" required>
        </div>
        <div>
            <label for="diachi" >Địa Chỉ</label>
             <input type="text" name="diachi" required>
        </div>
        <div>
    		<label for="idpb">Tên Khoa</label>
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
		</div>
        <button type="submit" id="btnOK">OK</button>
        <button type="reset" id="btnReset">Reset</button>
    </form>
    <a href="xemdsnv.jsp"><button>Quay lại</button></a>
</body>
</html>