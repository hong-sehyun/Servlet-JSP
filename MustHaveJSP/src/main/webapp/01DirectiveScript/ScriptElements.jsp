<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%!
    public int add(int num1 , int num2) {
    	return num1 + num2;
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>
<%
String snum1 = request.getParameter("num1");
String snum2 = request.getParameter("num2");



int result = add(Integer.parseInt(snum1),Integer.parseInt(snum2));

%>

덧셈 결과 1 : <%=result %> <br />
덧셈 결과 2 : <%=add(30,40)  %> 
</body>
</html>