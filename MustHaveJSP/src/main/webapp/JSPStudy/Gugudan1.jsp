<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%     
    String type = request.getParameter("type");
	String snum = request.getParameter("num");
	
	if(type == null) type ="list";
	else {
		if(type.equals("table")) type = "list";
	}
	
	int num = 2;
	if (snum != null) num = Integer.parseInt(snum);
	if (num == 0) num = 2;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudan Type1 (Jsp)</title>
</head>
<body>
	<h2>구구단 타입</h2>
	
	<% if(type.equals("table")) {%>
	<table border = "1" style="width:200px; text-align:center;">
	<tr><td><%= num %> 단 입니다.</td></tr>
	<% for (int i = 1; i <= 9; i++) { %>
	<tr><td><%= num %> * <%= i %> = <%= num*i %></td></tr>
	<%} %>
	
	</table>
	
	<%} else { %>
		<h3><%= num %> 단 입니다.</h3>
		<ul>
		<% for (int i = 1; i <= 9; i++) { %>
		<li><%= num %> * <%= i %> = <%= num*i %></li>
		<%} %>
		</ul>
<%} %>

</body>
</html>