package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
	public void selectMember() {}
	public void selectMembers() {}
	public void updateMember() {}
	public void deleteMember() {}
	
}
