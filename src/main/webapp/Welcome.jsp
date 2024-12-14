<%@page import = "java.util.List, Model.Bean.Wife" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WelCome</title>
</head>
<body>
	<table>
		<%
		 Object obj = session.getAttribute("wifeArray");
	    if (obj instanceof List<?>) {
	        List<?> list = (List<?>) obj;
	        for (Object element : list) {
	            if (element instanceof Wife) {
	                Wife wife = (Wife) element;
	                %>
					<tr>
						<td><%= wife.getName() %></td>
						<td><%= wife.getAddress() %></td>
						<td><%= wife.isAlive() ? "Yes" : "No" %></td>
					</tr>
	    <%
					}
				}
			}
		%>
	</table>
	
</body>
</html>
