package kr.co.jboard1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.jboard1.bean.ArticleBean;
import kr.co.jboard1.bean.FileBean;
import kr.co.jboard1.db.DBConfig;
import kr.co.jboard1.db.Sql;

// DAO(Database Access Object) 클래스
public class ArticleDao {
	
	// 싱글톤
	private static ArticleDao instance = new ArticleDao();
	private ArticleDao() {}
	
	public static ArticleDao getInstance() {
		return instance;
	}
	
//-------------------------------------------------------------------------//
	
	// 페이지 그룹
	public int[] getPageGroup(int currentPage, int lastPageNum) {
		
		int groupCurrent = (int) Math.ceil(currentPage / 10.0);
		int groupStart = (groupCurrent - 1) * 10 + 1;
		int groupEnd = groupCurrent * 10;
		
		if(groupEnd > lastPageNum) {
			groupEnd = lastPageNum;
		}
		
		int[] groups = {groupStart, groupEnd};
		
		return groups;
	}
	
	// 스타트 넘버
	public int getPageStartNum(int total, int start) {
		return total - start;
		
	}
	
	// 스타트 페이지
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
		
	}
	
	// 페이지 이동
	public int getCurrentPage(String pg) {
		
		int currentPage = 1;
		
		if(pg != null) {
			
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
		
	}
	
	// 마지막 페이지 계산
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0){
			lastPageNum = total / 10;
			
		}else{
			lastPageNum = total / 10 + 1;
			
		}
		
		return lastPageNum;
		
	}
	
	// 페이지 번호 계산
	public int selectCountArticle() {
		
		int total = 0;
		
		try{
			// 1, 2단계
			Connection conn = DBConfig.getInstance().getConnection();
			// 3단계
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_ARTICLE);
			// 4단계
			ResultSet rs = psmt.executeQuery();
			// 5단계
			if(rs.next()) {
				total = rs.getInt(1);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	// 게시판 가져오기
	public List<ArticleBean> selectArticles(int start) {
		
		List<ArticleBean> articles = new ArrayList<>();
		
		try{
			
			// 1단계, 2단계
			Connection conn = DBConfig.getInstance().getConnection();
			
			// 3단계
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setInt(1, start);
			
			// 4단계
			ResultSet rs = psmt.executeQuery();
			
			// 5단계
			while(rs.next()){
				//ARTICLE BEAN 생성
				ArticleBean  article = new ArticleBean();
				article.setSeq(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setUid(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11));
				article.setNick(rs.getString(12));
				
				articles.add(article);
			}
			// 6단계
			conn.close();
			
			}catch(Exception e){
				e.printStackTrace();
				
			}
			
			return articles;
			
	}
	
	// 게시물 가져오기
	public ArticleBean selectArticle(String seq) {
		
		// ArticleBean 생성
		ArticleBean article = new ArticleBean();
		
		// FileBean 생성
		FileBean fb = new FileBean();
		
		try{
			// 1, 2단계
			Connection conn = DBConfig.getInstance().getConnection();
			// 3 단계
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, seq);
			// 4 단계
			ResultSet rs =  psmt.executeQuery();
			// 5 단계
			if(rs.next()) {
				article.setSeq(rs.getInt(1));
				article.setParent(rs.getInt(2));
				article.setComment(rs.getInt(3));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setContent(rs.getString(6));
				article.setFile(rs.getInt(7));
				article.setHit(rs.getInt(8));
				article.setUid(rs.getString(9));
				article.setRegip(rs.getString(10));
				article.setRdate(rs.getString(11));
				
				// 추가필드 (JBOARD_FILE)
				fb.setSeq(rs.getInt(12));
				fb.setParent(rs.getInt(13));
				fb.setOriName(rs.getString(14));
				fb.setNewName(rs.getString(15));
				fb.setDownload(rs.getInt(16));
				fb.setRdate(rs.getString(17));
				
				article.setFb(fb);

			}
			// 6 단계
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return article;
		
	}
	
	// 다운로드 파일 선택
	public FileBean selectFile(String seq) {

		FileBean fb = new FileBean();
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_FILE);
			psmt.setString(1, seq);
			
			ResultSet rs = psmt.executeQuery();
			
			if(rs.next()) {
				fb.setSeq(rs.getInt(1));
				fb.setParent(rs.getInt(2));
				fb.setOriName(rs.getString(3));
				fb.setNewName(rs.getString(4));
				fb.setDownload(rs.getInt(5));
				fb.setRdate(rs.getString(6));
			}
			
			conn.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return fb;
	}

	// 다운로드수 증가
	public void updateFileDownload(String seq) {


		try{
			// 1,2단계
			Connection conn = DBConfig.getInstance().getConnection();
			
			// 3단계
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setString(1, seq);
			
			// 4단계
			psmt.executeUpdate();
			
			// 5단계			
			// 6단계
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	// 조회수 증가
 	public void updateArticleHit(String seq) {
		
		try{
			// 1, 2단계
			Connection conn = DBConfig.getInstance().getConnection();
			// 3 단계
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
			psmt.setString(1, seq);
			// 4 단계
			psmt.executeUpdate();
			// 5 단계 - update문이라 없음
			
			// 6 단계
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
}















