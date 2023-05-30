package common;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContext;

public class JDBCConnect3 {
	private String driver;
	private String url;
	private String id;
	private String pwd;
	
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
}
