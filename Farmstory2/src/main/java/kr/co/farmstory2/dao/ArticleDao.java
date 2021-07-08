package kr.co.farmstory2.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.co.farmstory2.db.DBConfig;
import kr.co.farmstory2.db.Sql;
import kr.co.farmstory2.vo.ArticleVo;
import kr.co.farmstory2.vo.FileVo;

// DAO(Database Access Object) ?겢?옒?뒪
public class ArticleDao {
	
	// ?떛湲??넠
	private static ArticleDao instance = new ArticleDao();
	private ArticleDao() {}
	
	public static ArticleDao getInstance() {

		return instance;
	}
	
//-------------------------------------------------------------------------//
	
	// ?럹?씠吏? 洹몃９
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
	
	// ?뒪???듃 ?꽆踰?
	public int getPageStartNum(int total, int start) {
		return total - start;
		
	}
	
	// ?뒪???듃 ?럹?씠吏?
	public int getLimitStart(int currentPage) {
		return (currentPage - 1) * 10;
		
	}
	
	// ?럹?씠吏? ?씠?룞
	public int getCurrentPage(String pg) {
		
		int currentPage = 1;
		
		if(pg != null) {
			
			currentPage = Integer.parseInt(pg);
		}
		
		return currentPage;
		
	}
	
	// 留덉?留? ?럹?씠吏? 怨꾩궛
	public int getLastPageNum(int total) {
		
		int lastPageNum = 0;
		
		if(total % 10 == 0){
			lastPageNum = total / 10;
			
		}else{
			lastPageNum = total / 10 + 1;
			
		}
		
		return lastPageNum;
		
	}
	
	// ?럹?씠吏? 踰덊샇 怨꾩궛
	public int selectCountArticle(String cate) {

		
		int total = 0;
		
		try{
			// 1, 2?떒怨?
			Connection conn = DBConfig.getInstance().getConnection();
			// 3?떒怨?
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COUNT_ARTICLE);
			psmt.setString(1, cate);
			// 4?떒怨?
			ResultSet rs = psmt.executeQuery();
			// 5?떒怨?
			if(rs.next()) {
				total = rs.getInt(1);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return total;
		
	}
	
	// ?뙎湲?
	public void insertComment(ArticleVo comment) {



		try{
			
		// 1, 2 ?떒怨?
        Connection conn = DBConfig.getInstance().getConnection();
		// 3?떒怨?
        PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_COMMENT);
        psmt.setInt(1, comment.getParent());
        psmt.setString(2, comment.getContent());
        psmt.setString(3, comment.getUid());
        psmt.setString(4, comment.getRegip());
		// 4?떒怨?
        psmt.executeUpdate();
		// 5?떒怨?
		// 6?떒怨?
        conn.close();
		}catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	// ?뙎湲? 媛??졇?삤湲?
	public List<ArticleVo> selectComments(String parent) {
	
		List<ArticleVo> articles = new ArrayList<>();
			
			try{
				
				// 1?떒怨?, 2?떒怨?
				Connection conn = DBConfig.getInstance().getConnection();
				
				// 3?떒怨?
				PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_COMMENTS);
				psmt.setString(1, parent);
				
				// 4?떒怨?
				ResultSet rs = psmt.executeQuery();
				
				// 5?떒怨?
				while(rs.next()){
					//ARTICLE BEAN ?깮?꽦
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
				// 6?떒怨?
				conn.close();
				
				}catch(Exception e){
					e.printStackTrace();
					
				}
				
				return articles;
				
		}
	
	// 寃뚯떆?뙋 媛??졇?삤湲?
	public List<ArticleVo> selectArticles(String cate, int start) {

		
		List<ArticleVo> articles = new ArrayList<>();
		
		try{
			// 1,2쨈횥째챔
			Connection conn = DBConfig.getInstance().getConnection();
			// 3쨈횥째챔
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLES);
			psmt.setString(1, cate);
			psmt.setInt(2, start);
			// 4쨈횥째챔
			ResultSet rs = psmt.executeQuery();
			// 5쨈횥째챔
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
			// 6쨈횥째챔
			conn.close();
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		return articles;		
	}// selectArticles end
	
	// 寃뚯떆臾? 媛??졇?삤湲?
	public ArticleVo selectArticle(String seq) {


		
		// ArticleBean ?깮?꽦
		ArticleVo article = new ArticleVo();
		
		// FileBean ?깮?꽦
		FileVo fb = new FileVo();
		
		try{
			// 1, 2?떒怨?
			Connection conn = DBConfig.getInstance().getConnection();
			// 3 ?떒怨?
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_ARTICLE);
			psmt.setString(1, seq);
			// 4 ?떒怨?
			ResultSet rs =  psmt.executeQuery();
			// 5 ?떒怨?
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
				
				// 異붽??븘?뱶 (JBOARD_FILE)
				fb.setSeq(rs.getInt(12));
				fb.setParent(rs.getInt(13));
				fb.setOriName(rs.getString(14));
				fb.setNewName(rs.getString(15));
				fb.setDownload(rs.getInt(16));
				fb.setRdate(rs.getString(17));
				
				article.setFb(fb);

			}
			// 6 ?떒怨?
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return article;
		
	}
	
	// ?떎?슫濡쒕뱶 ?뙆?씪 ?꽑?깮
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

	// ?떎?슫濡쒕뱶?닔 利앷?
	public void updateFileDownload(String seq) {


		try{
			// 1,2?떒怨?
			Connection conn = DBConfig.getInstance().getConnection();
			
			// 3?떒怨?
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_FILE_DOWNLOAD);
			psmt.setString(1, seq);
			
			// 4?떒怨?
			psmt.executeUpdate();
			
			// 5?떒怨?			
			// 6?떒怨?
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
	}
	
	// 議고쉶?닔 利앷?
 	public void updateArticleHit(String seq) {



		
		try{
			// 1, 2?떒怨?
			Connection conn = DBConfig.getInstance().getConnection();
			// 3 ?떒怨?
			PreparedStatement psmt = conn.prepareStatement(Sql.UPDATE_ARTICLE_HIT);
			psmt.setString(1, seq);
			// 4 ?떒怨?
			psmt.executeUpdate();
			// 5 ?떒怨? - update臾몄씠?씪 ?뾾?쓬
			
			// 6 ?떒怨?
			conn.close();
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
 	
    // ?뙎湲? 移댁슫?듃
  	public void updateCommentCount(String seq, int type) {


  		PreparedStatement psmt = null;
 		
 		try{
 			// 1, 2?떒怨?
 			Connection conn = DBConfig.getInstance().getConnection();
 			// 3 ?떒怨?
 			if(type ==1) {
 				psmt = conn.prepareStatement(Sql.UPDATE_COMMENT_COUNT_PLUS); 				
 			}else {
 				psmt = conn.prepareStatement(Sql.UPDATE_COMMENT_COUNT_MINUS); 				
 			}
 			psmt.setString(1, seq);
 			// 4 ?떒怨?
 			psmt.executeUpdate();
 			// 5 ?떒怨? - update臾몄씠?씪 ?뾾?쓬
 			
 			// 6 ?떒怨?
 			conn.close();
 			
 		}catch(Exception e){
 			e.printStackTrace();
 			
 		}
 	}
  	
  	// ?뙎湲? ?궘?젣
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
 	
  	// ?뙎湲? ?닔?젙
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
  	
  	// 湲? ?닔?젙
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
  	
  	// 湲? ?궘?젣
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
  	
	public int insertArticle(ArticleVo vo) {
			
			try{
				Connection conn = DBConfig.getInstance().getConnection();
				PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
				psmt.setString(1, vo.getCate());
				psmt.setString(2, vo.getTitle());
				psmt.setString(3, vo.getContent());
				psmt.setInt(4, vo.getFile());
				psmt.setString(5, vo.getUid());
				psmt.setString(6, vo.getRegip());
				
				psmt.executeUpdate();
				
				conn.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return selectMaxSeq();
		}
	
	public int selectMaxSeq() {
			
			int seq = 0;
			
			try {
				Connection conn = DBConfig.getInstance().getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(Sql.SELECT_MAX_SEQ);
				
				if(rs.next()) {
					seq = rs.getInt(1);
				}
				
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			return seq;
		}
  	
	public void insertFile(int seq, String fname, String newName) {
		try {
			// 1, 2´Ü°è
			Connection conn = DBConfig.getInstance().getConnection();
			// 3´Ü°è
			PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_FILE);
			psmt.setInt(1, seq);
			psmt.setString(2, fname);
			psmt.setString(3, newName);
			
			// 4´Ü°è
			psmt.executeUpdate();
			// 5´Ü°è
			// 6´Ü°è
			conn.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ArticleVo> selectLatests() {

		
		List<ArticleVo> latests = new ArrayList<>();
		
		try {
			
			Connection conn = DBConfig.getInstance().getConnection();
			PreparedStatement psmt = conn.prepareStatement(Sql.SELECT_LATESTS);
			ResultSet rs = psmt.executeQuery();
			
			while(rs.next()) {
				
				ArticleVo article = new ArticleVo();
			
				article.setSeq(rs.getInt(1));
				article.setCate(rs.getString(4));
				article.setTitle(rs.getString(5));
				article.setRdate(rs.getString(11).substring(2, 10));
				
				latests.add(article);
				
			}
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return latests;
	}

}















