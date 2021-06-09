package kr.co.jboard1.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConfig {

	private static DBConfig instance = new DBConfig();
	private DBConfig() {}
	
	public static DBConfig getInstance() {
		return instance;
	}
	
	//DB 정보
	private final String HOST = "jdbc:mysql://54.180.109.191:3306/woguddldla";
	private final String USER = "woguddldla";
	private final String PASS = "qkrwogud1!";
	
	public Connection getConnection() throws Exception{
		// 1단계
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계
		Connection conn = DriverManager.getConnection(HOST, USER, PASS);
		
		return conn;
	}
	
}
