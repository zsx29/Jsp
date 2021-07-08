package kr.co.farmstory2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.farmstory2.db.DBConfig;
import kr.co.farmstory2.db.Sql;
import kr.co.farmstory2.vo.MemberVo;
import kr.co.farmstory2.vo.TermsVo;

public class MemberDao {

	private static MemberDao instance = new MemberDao();

	private MemberDao() {};

	public static MemberDao getInstance() {
		return instance;
	}

	public void insertMember(MemberVo mv) {

		try{
			//1,2�ܰ�
			Connection conn = DBConfig.getInstance().getConnection();
			
			// 3�ܰ�
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_MEMBER);
			psmt.setString(1, mv.getUid());
			psmt.setString(2, mv.getPass());
			psmt.setString(3, mv.getName());
			psmt.setString(4, mv.getNick());
			psmt.setString(5, mv.getEmail());
			psmt.setString(6, mv.getHp());
			psmt.setString(7, mv.getZip());
			psmt.setString(8, mv.getAddr1());
			psmt.setString(9, mv.getAddr2());
			psmt.setString(10, mv.getRegip());
			
			// 4�ܰ�
	        psmt.executeUpdate();
	        
			// 5�ܰ�
	        
			// 6�ܰ�
			conn.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}

	public TermsVo selectTerms() {

		TermsVo tv = new TermsVo();

		try {
			Connection conn = DBConfig.getInstance().getConnection();
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(Sql.SELECT_TERMS);
			if (rs.next()) {
				tv.setTerms(rs.getString(1));
				tv.setPrivacy(rs.getString(2));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tv;
	}

	public MemberVo selectMember(String uid, String pass) {

		MemberVo mv = null;

		try {
			// 1,2�ܰ�
			Connection conn = DBConfig.getInstance().getConnection();

			// 3�ܰ�
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_MEMBER);
			psmt.setString(1, uid);
			psmt.setString(2, pass);
			// 4�ܰ�
			ResultSet rs = psmt.executeQuery();
			// 5�ܰ�
			if (rs.next()) {
				// ȸ���� ���
				mv = new MemberVo();
				mv.setUid(rs.getString(1));
				mv.setPass(rs.getString(2));
				mv.setName(rs.getString(3));
				mv.setNick(rs.getString(4));
				mv.setEmail(rs.getString(5));
				mv.setHp(rs.getString(6));
				mv.setGrade(rs.getInt(7));
				mv.setZip(rs.getString(8));
				mv.setAddr1(rs.getString(9));
				mv.setAddr2(rs.getString(10));
				mv.setRegip(rs.getString(11));
				mv.setRdate(rs.getString(12));
			}

			// 6�ܰ�
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return mv;
		
	}

	public int selectMemberCount(String uid) {
		
		int count = -1;
		
		try{
			//1,2�ܰ�
			Connection conn = DBConfig.getInstance().getConnection();
			// 3�ܰ�
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_UID);
			psmt.setString(1, uid);
			// 4�ܰ�
			ResultSet rs = psmt.executeQuery();
			// 5�ܰ�
			if(rs.next()){
				count = rs.getInt(1);
			}
			
			// 6�ܰ�
			conn.close();
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return count;
	}
	
	public void seelctMembers() {
	}

	public void updateMember() {
	}

	public void deleteMember() {
	}
}
