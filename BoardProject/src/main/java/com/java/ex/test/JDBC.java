package com.java.ex.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {

public static void main(String[] args) {

		

		

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}

		

		

		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
		String user ="track_java";
		String password = "1234";


		try{
			conn = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("연동실패");
		}


		try {
			if(conn!=null) {
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
