<%-- <%@ page import="common.JDBCConnectH2" %> --%>
<%@ page import="common.JDBCConnectJSP" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection" %>
<%@ page import="javax.servlet.jsp.JspWriter" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC 연동</title>
</head>
<body>

<%-- <%

JDBCConnectJSP jdbcj = new JDBCConnectJSP();
Connection con = jdbcj.getConnection();
jdbcj.writeMemberTable(con, out);
jdbcj.writeBoardTable(con, out);
%> --%>

<%

// String driver = application.getInitParameter("MySQLDriver");
// String url = application.getInitParameter("MySQLUrl");
// String id = application.getInitParameter("MySQLId");
// String pwd = application.getInitParameter("MySQLPwd");
// JDBCConnectJSP jdbcj1 = new JDBCConnectJSP(driver, url, id, pwd);
// Connection con1 = jdbcj1.getConnection();
// jdbcj1.writeMemberTable(con1, out);
// jdbcj1.writeBoardTable(con1, out);


String driver = application.getInitParameter("H2Driver");
String url = application.getInitParameter("H2Url");
String id = application.getInitParameter("H2Id");
String pwd = application.getInitParameter("H2Pwd");
JDBCConnectJSP jdbch = new JDBCConnectJSP(driver, url, id, pwd);
Connection con1 = jdbch.getConnection();
jdbch.writeMemberTable(con1, out);
jdbch.writeBoardTable(con1, out);
%>
</body>
</html>