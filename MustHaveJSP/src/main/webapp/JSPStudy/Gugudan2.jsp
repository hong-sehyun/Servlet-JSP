<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String scol = request.getParameter("col");

int col = 3;
if (scol != null)
	col = Integer.parseInt(scol);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>구구단 타입2</h2>

	<%
			for (int i = 1; i <= 9; i += col) {

			for (int j = 0; j < col; j++) {
				if(9<i+j) break; 
	%>
	<%= col +"*"+ (i+j) + "=" + col*(i+j) %>

	<%	} %>
	<br>

	<%	}%>
	
	
	<%
// for (int i = 2; i <= 9; i += col) {
// 	for (int k = 1; k < 9; k++) {

// 	for (int j = 0; j < col; j++) {
// 		if(9<i+j) break;
// 	out.print(String.format("%d*%d=%d " ,	i+j, k, k*(i+j)) );
		
// 	} 
// 	out.print("<br>");

// 	}
// 	out.print("<br>");

// }

%>


</body>
</html>