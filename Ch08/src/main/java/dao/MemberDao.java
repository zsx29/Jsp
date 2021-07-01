package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.MemberVO;

public class MemberDao {

	private static MemberDao instance = new MemberDao();

	public static MemberDao getInstance() {

		return instance;
	}
	
	private MemberDao() {}
	
	private final String HOST = "jdbc:mysql://54.180.109.191:3306/woguddldla";
	private final String USER = "woguddldla";
	private final String PASS = "qkrwogud1!";
	
	public void insertMember(MemberVO vo) {


		
		try {
			
			// (1)
			Class.forName("com.mysql.jdbc.Driver");
			// (2)
			Connection conn =  DriverManager.getConnection(HOST, USER, PASS);
			// (3)
			String sql = "INSERT INTO `MEMBER` VALUES (?, ?, ?, ?, ?, NOW())";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getHp());
			psmt.setString(4, vo.getPos());
			psmt.setInt(5, vo.getDep());
			// (4)
			psmt.executeUpdate();
			// (5)
			// (6)
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public MemberVO selectMember(String uid) {


		MemberVO vo = new MemberVO();

		try {
			// 1
			Class.forName("com.mysql.jdbc.Driver");
			// 2
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			// 3
			String sql = "SELECT * FROM `MEMBER` WHERE `uid`=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);

			// 4
			ResultSet rs = psmt.executeQuery();
			// 5
			if (rs.next()) {
				vo.setUid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setPos(rs.getString(4));
				vo.setDep(rs.getInt(5));
				vo.setRdate(rs.getString(6));
			}

			// 6
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return vo;
	}
	public List<MemberVO> selectMembers() {


		
		List<MemberVO> members = new ArrayList<MemberVO>();
		
		
		try {
			
			// (1)
			Class.forName("com.mysql.jdbc.Driver");
			// (2)
			Connection conn =  DriverManager.getConnection(HOST, USER, PASS);
			//3
			String sql = "SELECT * FROM `MEMBER`";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//4
			ResultSet rs = psmt.executeQuery();
			//5
			while(rs.next()) {
				MemberVO vo = new MemberVO();
				vo.setUid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setPos(rs.getString(4));
				vo.setDep(rs.getInt(5));
				vo.setRdate(rs.getString(6));
				
				members.add(vo);
			}
			//6
			conn.close();
			
			
		}catch(Exception e ) {
			e.printStackTrace();
		}
		return members;
		
	}
	public void updateMember(MemberVO vo) {
		
		try {

			// (1)
			Class.forName("com.mysql.jdbc.Driver");
			// (2)
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			// 3
			String sql  = "UPDATE `MEMBER` SET `name`=?, `hp`=?, `pos`=?, `dep`=? ";
		       	   sql += "WHERE `uid`=?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getName());
			psmt.setString(2, vo.getHp());
			psmt.setString(3, vo.getPos());
			psmt.setInt(4, vo.getDep());
			psmt.setString(5, vo.getUid());
			// 4
			psmt.executeUpdate();
			// 5

			// 6
			conn.close();

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	public void deleteMember(String uid) {
		
		try {

			// (1)
			Class.forName("com.mysql.jdbc.Driver");
			// (2)
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			// (3)
			String sql = "DELETE FROM `MEMBER` WHERE `uid` = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);

			// (4)
			psmt.executeUpdate();
			// (5)
			// (6)
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
