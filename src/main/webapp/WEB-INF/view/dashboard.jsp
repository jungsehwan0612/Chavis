<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	if (session.getAttribute("bodyshop") == null) {
		response.sendRedirect("logout.jsp");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1><%=session.getAttribute("bodyshop") %></h1>
</body>
</html>