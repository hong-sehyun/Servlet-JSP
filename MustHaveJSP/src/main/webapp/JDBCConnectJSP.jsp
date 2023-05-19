<%@ page import="common.JDBCConnectJSP" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import=" java.sql.Connection" %>
<%@ page import="javax.servlet.jsp.JspWriter" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

JDBCConnectJSP jdbcj = new JDBCConnectJSP();
Connection con = jdbcj.getConnection();
jdbcj.writeMemberTable(con, out);
jdbcj.writeBoardTable(con, out);
%>
</body>
</html>