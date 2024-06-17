<%@ page contentType="text/html; charset=utf-8"%>
<%
session.invalidate();
%>
<html>
<head>
<title>Logout</title>
</head>
<body>
	 <%response.sendRedirect("index.jsp"); %>
</body>
</html>