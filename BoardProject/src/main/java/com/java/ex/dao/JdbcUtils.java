package com.java.ex.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JdbcUtils {
	
	
	
	static {		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			
		}	
	}
	
	
	
	public static Connection getConnection() {
		
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
		String user ="track_java";
		String password = "1234";
		
		try {
			
			conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(Connection conn) {
		
		try {
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		
		try{
			if(pstmt!= null) pstmt.close();
			if(conn !=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		
		try{
			if(rs!= null) rs.close();
			if(pstmt!= null) pstmt.close();
			if(conn !=null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try{
			
			conn.commit();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
