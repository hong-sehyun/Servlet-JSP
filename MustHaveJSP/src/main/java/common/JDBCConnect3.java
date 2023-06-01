package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;

public class JDBCConnect3 {
	private String driver;
	private String url;
	private String id;
	private String pwd;
	
	public Connection con;
	public Statement stmt;
	public PreparedStatement psmt;
	public ResultSet rs;
	
	public JDBCConnect3() {
		driver = "com.mysql.cj.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/musthave";
		id = "musthave";
		pwd = "tiger";
	}

	public JDBCConnect3(String driver, String url, String id, String pwd) {
		this.driver = driver;
		this.url = url;
		this.id = id;
		this.pwd = pwd;
	}
	
	public JDBCConnect3(ServletContext app) {
		driver = app.getInitParameter("MySQLDriver");
		url = app.getInitParameter("MySQLUrl");
		id = app.getInitParameter("MySQLId");
		pwd = app.getInitParameter("MySQLPwd");
	}
	
	public Connection getConnection() {
		try {
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,id,pwd);
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void close() {
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
}
