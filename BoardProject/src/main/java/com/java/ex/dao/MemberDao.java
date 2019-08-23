package com.java.ex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.java.ex.dto.Member;

import static com.java.ex.dao.JdbcConnection.*;


public class MemberDao {
	
	
	/**
	 * 会員登録処理を行う
	 * @param member ユーザーの情報
	 * @return DB上で更新されたレコードの数。1だったら成功
	*/
	public int joinDao(Member member)  {
		
		final JdbcConnection conn = new JdbcConnection();
		final String sql = "insert into test.member value(?,?,?,?,?,default)";
		
		int result = -1;
		
		if(conn.connect()==true) {
	
				final PreparedStatement pstmt = conn.prepare(sql);
				
				try {
					pstmt.setString(1, member.getUser_id());
					pstmt.setString(2, member.getUser_pwd());
					pstmt.setString(3, member.getUser_name());
					pstmt.setString(4, member.getUser_katakana());
					pstmt.setDate(5, member.getUser_birth());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				result = conn.executeUpdate(pstmt);
			}		
		conn.close();

		return result;
	}
		
	/**
	 * 同じアイディーをシェック
	 * @param 登録画面のアイディー
	 * @return DB上で同じアイディー　TRUE、同じアイディーがない　FALSE
	*/
	public boolean confirmID(String userid)  {
		
		final JdbcConnection conn = new JdbcConnection();
		final String sql = "select id from test.member where id = ?";
		boolean result = false;
		
		if(conn.connect()==true) {
			

				final PreparedStatement pstmt = conn.prepare(sql);
		
				try {
					pstmt.setString(1, userid);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				result = conn.executeQueryDup(pstmt);
			
			
		} 
		conn.close();
		
		return result;
		
	}	
}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*		boolean result = false;
			
		String sql = "select id from test.member where id = ?";
			
		Connection conn = null;		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
	
			rs = pstmt.executeQuery();
			
			result = rs.next();
					
		
		}catch(SQLException e) {
			e.printStackTrace();
		
		} finally {
			close(conn, pstmt, rs);
		}
		return result;*/
		
	
