package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnect2 {

	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public boolean  connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/musthave", "musthave", "tiger");
			System.out.println("DB연결 성공");
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
		} return false;
	}
	
	private void closeDB() {
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (psmt != null) psmt.close();
			if (con != null) con.close();
			
			System.out.println("JDBC 자원 해제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void printBoard() {
		try {
			stmt = con.createStatement();	
			String sql = "select * from board";
			rs = stmt.executeQuery(sql);		
			
			while (rs.next()) { 
			System.out.println(String.format("%d, %s, %s, %s, %s, %d", rs.getInt("num"), rs.getString("title"),
					rs.getString("content"), rs.getString("id"), rs.getString("postdate"), rs.getInt("visitcount")));
			}
		} 
		    catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void printMember() {
		try {
			stmt = con.createStatement();	
			String sql = "select * from member";
			rs = stmt.executeQuery(sql);		
			
			while (rs.next()) { 
			System.out.println(String.format("%s, %d, %s, %s", rs.getString("id"), rs.getInt("pass"), 
					rs.getString("name"), rs.getString("regidate")));
			}
		} 
		    catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JDBCConnect2 j2 = new JDBCConnect2();
		if(j2.connectDB() == true) {
			j2.printBoard();
			j2.printMember();
			}
			j2.closeDB();
	}
}
