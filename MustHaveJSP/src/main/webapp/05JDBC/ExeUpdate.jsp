<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="common.JDBCConnect3" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>회원 추가 테스트(executeUpdate() 사용)</h2>
	<%
	//DB연결
	JDBCConnect3 jdbc = new JDBCConnect3();
	Connection con = jdbc.getConnection();
	
	if (con == null) {
		out.print("Fail to connect DB");
		return;
	}
	
	
	String id = "test1";
	String pwd = "1111";
	String name = "테스트1회원";
	
	String sql = "INSERT INTO member(id, pass, name) values (?, ?, ?)";
	

	PreparedStatement psmt = con.prepareStatement(sql);
	psmt.setString(1, id);
	psmt.setString(2, pwd);
	psmt.setString(3, name);
	int inResult = psmt.executeUpdate();
	out.println(inResult + "행이 입력되었습니다");
	
	psmt.close();
	
	jdbc.closeConnection(con);
	%>
	

</body>
</html>