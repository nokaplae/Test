package com.java.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.java.ex.dto.Member;

public class MemberDao {
	
	
	
	public int joinDao(Member member) {
		
		int result = -1;
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

		String sql = "insert into test.member value(?,?,?,?,?,default)";
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUser_id());
			pstmt.setString(3, member.getUser_pwd());
			pstmt.setString(2, member.getUser_name());
			pstmt.setString(4, member.getUser_katakana());
			pstmt.setDate(5, member.getUser_birth());
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("쿼리 실행 오류");
		}

		try {
			if(pstmt!=null) {
				pstmt.close();
			}
			
			if(conn!=null) {
				conn.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
		
	}
}
