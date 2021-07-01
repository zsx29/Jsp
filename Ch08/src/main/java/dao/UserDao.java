package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.UserVo;

public class UserDao {

	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		
		return instance;
	}
	
	private UserDao() {}
	
	private final String HOST = "jdbc:mysql://54.180.109.191:3306/woguddldla";
	private final String USER = "woguddldla";
	private final String PASS = "qkrwogud1!";
	
	public List<UserVo> selectUsers() {
		
		List<UserVo> users = new ArrayList<UserVo>();
		
		
		try {
			
			//1
			Class.forName("com.mysql.jdbc.Driver");
			//2
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			//3
			String sql = "SELECT * FROM `USER1`";
			PreparedStatement psmt = conn.prepareStatement(sql);
			//4
			ResultSet rs = psmt.executeQuery();
			//5
			while(rs.next()) {
				UserVo vo = new UserVo();
				vo.setUid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setAge(rs.getInt(4));
				users.add(vo);
			}
			//6
			conn.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
		
		
		
	}

	public void insertUser(UserVo vo) {

		
		try {
			
			//1
			Class.forName("com.mysql.jdbc.Driver");
			
			//2
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			
			//3
			String sql = "INSERT INTO `USER1` VALUES (?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getUid());
			psmt.setString(2, vo.getName());
			psmt.setString(3, vo.getHp());
			psmt.setInt(4, vo.getAge());
			//4
			psmt.executeUpdate();
			//6
			conn.close();
			
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}

	public void updateUser() {}
	
	public void selectUser(String uid) {
		
		UserVo vo = new UserVo();
		
		try {

			// 1
			Class.forName("com.mysql.jdbc.Driver");
			// 2
			Connection conn = DriverManager.getConnection(HOST, USER, PASS);
			
			// 3
			String sql = "SELECT * FROM `USER1` WHERE `uid` = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, uid);
			// 4
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setUid(rs.getString(1));
				vo.setName(rs.getString(2));
				vo.setHp(rs.getString(3));
				vo.setAge(rs.getInt(4));
			}
			
			//6
			conn.close();
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
	
}



















