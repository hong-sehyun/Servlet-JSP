
<% 
String sel =  request.getParameter("sel");
String val =  request.getParameter("val");


// if(sel.equals("gugudanType1")) {
// 	response.sendRedirect("Gugudan1.jsp?num="+val);
// } else {
// 	response.sendRedirect("Gugudan2.jsp?col="+val);

// }
if(sel.equals("gugudanType1")) {
	request.getRequestDispatcher("Gugudan1.jsp?num="+val).forward(request, response);
} else {
	request.getRequestDispatcher("Gugudan2.jsp?col="+val).forward(request, response);

}


%>


