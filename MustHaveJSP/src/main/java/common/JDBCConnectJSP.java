package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.jsp.JspWriter;

public class JDBCConnectJSP {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/musthave";
	private String id = "musthave";
	private String pwd = "tiger";
	
	public Connection getConnection() throws Exception {
			Class.forName(driver);
			return DriverManager.getConnection(url, id, pwd);
	}
	
	public void printMember(Connection con) throws Exception {
			Statement st = con.createStatement();	
			ResultSet rs = st.executeQuery("select * from member");
			
			while (rs.next()) { 
			System.out.println(String.format("%s, %s, %s, %s", rs.getString("id"), rs.getInt("pass"), 
					rs.getString("name"), rs.getString("regidate")));
			}
			rs.close();
			st.close();
			System.out.println("-".repeat(80));
	}
	
	public void printBoard(Connection con) throws Exception { 
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from board");
		while (rs.next()) { 
			System.out.println(String.format("%d, %s, %s, %s, %s, %d", rs.getInt("num"), rs.getString("title"),
					rs.getString("content"), rs.getString("id"), rs.getString("postdate"), rs.getInt("visitcount")));
			}
		rs.close();
		st.close();
	}
	
	public void writeMemberTable(Connection con, JspWriter out) {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			out.write("<table border=\"1\">");
			out.write("<tr>");
			out.write("<td>id</td> <td>pass</td> <td>name</td> <td>regidate</td>");	
			out.write("</tr>");
			
			st = con.createStatement();
			rs = st.executeQuery("select * from member");
			
			while (rs.next()) { 
				out.write("<tr>");
				out.write("<td>"); out.write(rs.getString("id")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("pass")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("name")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("regidate")); out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
			} catch (Exception e) { }
		}
	} 
	
	public void writeBoardTable(Connection con, JspWriter out) {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			out.write("<table border=\"1\">");
			out.write("<tr>");
			out.write("<td>num</td> <td>title</td> <td>content</td> <td>id</td>"
					+ "<td>postdate</td> <td>visitcount</td>");	
			out.write("</tr>");
			
			st = con.createStatement();
			rs = st.executeQuery("select * from board");
			
			while (rs.next()) { 
				out.write("<tr>");
				out.write("<td>"); out.write(rs.getInt("num")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("title")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("content")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("id")); out.write("</td>");
				out.write("<td>"); out.write(rs.getString("postdate")); out.write("</td>");
				out.write("<td>"); out.write(rs.getInt("visitcount")); out.write("</td>");
				out.write("</tr>");
			}
			out.write("</table>");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
			} catch (Exception e) { }
		}
	} 

	public static void main(String[] args) throws Exception {
		JDBCConnectJSP jdbcj = new JDBCConnectJSP();
		Connection con = jdbcj.getConnection();

		
		jdbcj.printMember(con);
		jdbcj.printBoard(con);

		con.close();
	}
}
