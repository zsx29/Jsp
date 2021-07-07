package kr.co.farmstory2.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.farmstory2.db.DBConfig;
import kr.co.farmstory2.db.Sql;
import kr.co.farmstory2vo.ArticleVo;
import kr.co.farmstory2vo.FileVo;

// DAO(Database Access Object) ?��?��?��
public class ArticleDao {
	
	// ?���??��
	private static ArticleDao instance = new ArticleDao();
	private ArticleDao() {}
	
	public static ArticleDao getInstance() {

		return instance;
	}
	
//-------------------------------------------------------------------------//
	
	// ?��?���? 그룹
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
	
	// ?��???�� ?���?
	public int getPageStartNum(int total, int start) {
		return total - start;
		
	}
	
	// ?��???�� ?��?���?
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
		
	}
	
	// ?��?���? ?��?��
	public int getCurrentPage(String pg) {
		
		int currentPage = 1;
		
		if(pg != null) {
			
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
		
	}
	
	// 마�?�? ?��?���? 계산
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0){
			lastPageNum = total / 10;
			
		}else{
			lastPageNum = total / 10 + 1;
			
		}
		
		return lastPageNum;
		
	}
	
	// ?��?���? 번호 계산
	public int selectCountArticle() {
		
		int total = 0;
		
		try{
			// 1, 2?���?
			Connection conn = DBConfig.getInstance().getConnection();
			// 3?���?
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_ARTICLE);
			// 4?���?
			ResultSet rs = psmt.executeQuery();
			// 5?���?
			if(rs.next()) {
				total = rs.getInt(1);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	// ?���?
	public void insertComment(ArticleVo comment) {



		try{
			
		// 1, 2 ?���?
        Connection conn = DBConfig.getInstance().getConnection();
		// 3?���?
        PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
        psmt.setInt(1, comment.getParent());
        psmt.setString(2, comment.getContent());
        psmt.setString(3, comment.getUid());
        psmt.setString(4, comment.getRegip());
		// 4?���?
        psmt.executeUpdate();
		// 5?���?
		// 6?���?
        conn.close();
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	// ?���? �??��?���?
	public List<ArticleVo> selectComments(String parent) {
	
		List<ArticleVo> articles = new ArrayList<>();
			
			try{
				
				// 1?���?, 2?���?
				Connection conn = DBConfig.getInstance().getConnection();
				
				// 3?���?
				PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COMMENTS);
				psmt.setString(1, parent);
				
				// 4?���?
				ResultSet rs = psmt.executeQuery();
				
				// 5?���?
				while(rs.next()){
					//ARTICLE BEAN ?��?��
					ArticleVo  article = new ArticleVo();
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
				// 6?���?
				conn.close();
				
				}catch(Exception e){
					e.printStackTrace();
					
				}
				
				return articles;
				
		}
	
	// 게시?�� �??��?���?
	public List<ArticleVo> selectArticles(int start) {
		
		List<ArticleVo> articles = new ArrayList<>();
		
		try{
			// 1,2´Ü°è
			Connection conn = DBConfig.getInstance().getConnection();
			// 3´Ü°è
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setInt(1, start);
			// 4´Ü°è
			ResultSet rs = psmt.executeQuery();
			// 5´Ü°è
			while(rs.next()){
				ArticleVo article = new ArticleVo();
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
			// 6´Ü°è
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return articles;		
	}// selectArticles end
	
	// 게시�? �??��?���?
	public ArticleVo selectArticle(String seq) {


		
		// ArticleBean ?��?��
		ArticleVo article = new ArticleVo();
		
		// FileBean ?��?��
		FileVo fb = new FileVo();
		
		try{
			// 1, 2?���?
			Connection conn = DBConfig.getInstance().getConnection();
			// 3 ?���?
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, seq);
			// 4 ?���?
			ResultSet rs =  psmt.executeQuery();
			// 5 ?���?
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
				
				// 추�??��?�� (JBOARD_FILE)
				fb.setSeq(rs.getInt(12));
				fb.setParent(rs.getInt(13));
				fb.setOriName(rs.getString(14));
				fb.setNewName(rs.getString(15));
				fb.setDownload(rs.getInt(16));
				fb.setRdate(rs.getString(17));
				
				article.setFb(fb);

			}
			// 6 ?���?
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return article;
		
	}
	
	// ?��?��로드 ?��?�� ?��?��
	public FileVo selectFile(String seq) {

		FileVo fb = new FileVo();
		
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

	// ?��?��로드?�� 증�?
	public void updateFileDownload(String seq) {


		try{
			// 1,2?���?
			Connection conn = DBConfig.getInstance().getConnection();
			
			// 3?���?
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setString(1, seq);
			
			// 4?���?
			psmt.executeUpdate();
			
			// 5?���?			
			// 6?���?
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	// 조회?�� 증�?
 	public void updateArticleHit(String seq) {



		
		try{
			// 1, 2?���?
			Connection conn = DBConfig.getInstance().getConnection();
			// 3 ?���?
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
			psmt.setString(1, seq);
			// 4 ?���?
			psmt.executeUpdate();
			// 5 ?���? - update문이?�� ?��?��
			
			// 6 ?���?
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
 	
    // ?���? 카운?��
  	public void updateCommentCount(String seq, int type) {


  		PreparedStatement psmt = null;
 		
 		try{
 			// 1, 2?���?
 			Connection conn = DBConfig.getInstance().getConnection();
 			// 3 ?���?
 			if(type ==1) {
 				psmt = conn.prepareStatement(Sql.UPDATE_COMMENT_COUNT_PLUS); 				
 			}else {
 				psmt = conn.prepareStatement(Sql.UPDATE_COMMENT_COUNT_MINUS); 				
 			}
 			psmt.setString(1, seq);
 			// 4 ?���?
 			psmt.executeUpdate();
 			// 5 ?���? - update문이?�� ?��?��
 			
 			// 6 ?���?
 			conn.close();
 			
 		}catch(Exception e){
 			e.printStackTrace();
 			
 		}
 	}
  	
  	// ?���? ?��?��
  	public void deleteComment(String seq) {


		try {
			
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.DELETE_COMMENT);
			
			psmt.setString(1, seq);
			psmt.executeUpdate();
		
			conn.close();
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
 	
  	// ?���? ?��?��
  	public int updateComment(String content, String seq) {
		
		int result = 0;
		
		try {
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_COMMENT);
			psmt.setString(1, content);
			psmt.setString(2, seq);
			
			result = psmt.executeUpdate();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
  	
  	// �? ?��?��
  	public void updateAritcle(String title, String content, String seq){

  		
  		try {
  			
  			Connection conn = DBConfig.getInstance().getConnection();
  			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE);
  			
  			psmt.setString(1, title);
  			psmt.setString(2, content);
 			psmt.setString(3, seq);
  			psmt.executeUpdate();
  			
  			conn.close();
  		
  			
  		}catch(Exception e) {
  			
  			e.printStackTrace();
  		}
  	}
  	
  	// �? ?��?��
  	public void deleteArticle(String seq, String parent) {

  		
  		try {
			
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.DELETE_ARTICLE);
			
			psmt.setString(1, seq);
			psmt.setString(2, parent);
			psmt.executeUpdate();
			
		
			conn.close();
		}catch (Exception e) {
			
			e.printStackTrace();
			
		}
  		
  	}
  	
}















