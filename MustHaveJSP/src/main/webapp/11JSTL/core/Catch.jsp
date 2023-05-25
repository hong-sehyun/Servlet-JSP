<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>      
    <%
    String snum = request.getParameter("snum");
    int num = 0;
    if (snum != null) 
    	num = Integer.parseInt(snum);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>자바 코드에서의 예외</h4>
	<%
	int num1 = 100;
	%>
	
	<c:catch var="eMessage">
		<%
		int result = num1/0;
		%>
	</c:catch>
	
	<c:if test="${not empty eMessage }">
	
	예외 내용 : ${ eMessage }
	</c:if>
	
	<h4>EL 에서의 예외</h4>
	<c:set var="num2" value="200" />
	<c:catch var="eMessage">
	${"일" + num2}
	</c:catch>
	예외 내용 : ${ eMessage }
</body>
</html>