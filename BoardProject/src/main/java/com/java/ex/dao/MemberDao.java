package com.java.ex.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.ex.dto.Member;

public class MemberDao {
	
	
	
	public int joinDao(Member member)  {
		
		int result = -1;
		
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
		String user ="track_java";
		String password = "1234";
		
		String sql = "insert into test.member value(?,?,?,?,?,default)";
		
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getUser_id());
			pstmt.setString(3, member.getUser_pwd());
			pstmt.setString(2, member.getUser_name());
			pstmt.setString(4, member.getUser_katakana());
			pstmt.setDate(5, member.getUser_birth());
			
			result = pstmt.executeUpdate();
			
		}catch(ClassNotFoundException e) {
		
			e.printStackTrace();
			System.out.println("ドライバーローディング失敗");
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		
		
		} finally {
			
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
		}

		return result;
		
	}
	
	
	
	
	
	public int confirmID(String userid)  {
	
		int result = -1;
		
		
		String sql = "select id from test.member where id = ?";
		
		
		Connection conn = null;
		String url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
		String user ="track_java";
		String password = "1234";
			
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, user, password);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);

			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
			
		}catch(ClassNotFoundException e) {
		
			e.printStackTrace();
		
		
		
		}catch(SQLException e) {
			e.printStackTrace();
		
		
		} finally {
			
			try {
				if(rs!=null) {
					rs.close();
				}
				
				if(pstmt!=null) {
					pstmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
		
			}
		}

		return result;
	}
}
