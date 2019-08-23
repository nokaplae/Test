package com.java.ex.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.ex.dto.Member;


public class JdbcConnection {
	
	
	private Connection conn = null;
	
	private String url;
	private String user;
	private String password;
	
	
	public JdbcConnection() {
		this.url = "jdbc:mysql://127.0.0.1:3306/test?serverTimezone=UTC";
		this.user = "track_java";
		this.password = "1234";
	}
	
	
	public boolean connect() {		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			return false;
		}	

		try {			
			this.conn = DriverManager.getConnection(url, user, password);
		} catch(SQLException e) {
			e.printStackTrace();
			return false;
		}		
		return true;
	}
	
	
	public PreparedStatement prepare(String sql)  {
		
		if(this.conn == null) return null;
			
		try {
			return this.conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
	
	
	
	public int executeUpdate(PreparedStatement pstmt) {
		
		
		if(pstmt == null) return -1;
		int result = -1;
		
		try {
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		
		try{
			if(pstmt!= null) pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return result;
		
	}
	
	public boolean executeQueryDup(PreparedStatement pstmt) {
		
		boolean result = false;
		ResultSet rs = null;
		
		if(pstmt == null) return false;
	
		try {	
			rs = pstmt.executeQuery();
			result = rs.next();
				
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		}
		
		try{
			if(rs!=null) rs.close();
			if(pstmt!= null) pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return result;
		}
		return result;
		
	}
	
	
	
	public Member executeQueryMember(PreparedStatement pstmt) {
		
		Member member =null;
		ResultSet rs = null;
	
		if(pstmt == null) return null;
		
		try {
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				member = new Member();
				member.setUser_id(rs.getString("id"));
				member.setUser_pwd(rs.getString("pwd"));
				member.setUser_name(rs.getString("name"));
				member.setUser_katakana(rs.getString("katakana"));
				member.setUser_birth(rs.getDate("birth"));
				member.setUser_indate(rs.getTimestamp("indate"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		try{
			if(rs!=null) rs.close();
			if(pstmt!= null) pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return member;
		
	}
	
	public List<Member> executeQueryList(PreparedStatement pstmt) {
		
		List<Member> list = new ArrayList<Member>();
		ResultSet rs = null;
		
		if(pstmt == null) return null;		
		try {
			
			rs = pstmt.executeQuery();
			while(rs.next()) {	
				Member member = new Member();
				member.setUser_id(rs.getString("id"));
				member.setUser_pwd(rs.getString("pwd"));
				member.setUser_name(rs.getString("name"));
				member.setUser_katakana(rs.getString("katakana"));
				member.setUser_birth(rs.getDate("birth"));
				member.setUser_indate(rs.getTimestamp("indate"));	
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		try{
			if(rs!=null) rs.close();
			if(pstmt!= null) pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return list;
		
	}






	public void close() {		
		try {	
			if (this.conn != null) this.conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	


}
