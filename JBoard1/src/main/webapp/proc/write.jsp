<%@page import="kr.co.jboard1.db.Sql"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="kr.co.jboard1.bean.MemberBean"%>
<%@page import="kr.co.jboard1.db.DBConfig"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	// Multipart 전송 데이터 수신
	String path = request.getServletContext().getRealPath("/file");
	int maxSize = 1024 * 1024 * 10;  // 최대 파일 허용 용량 : 10mb --> 반드시 제한 해야함 --> 오류잡기

	// 업로드
	MultipartRequest mRequest = new MultipartRequest(request,
													 path,
													 maxSize,
													 "UTF-8",
													 new DefaultFileRenamePolicy());
	/*
		try{
			MultipartRequest mRequest = new MultipartRequest(request,
															 path,
															 maxSize,
															 "UTF-8",
															 new DefaultFileRenamePolicy());
			
		}catch(excetion e){
			e.printStackTrace();
			response.sendRedirect("/JBoard1/write.jsp?success=105");
			return;
		}
	
		write.jsp 가서 success값 에러발생 코드 작성
	*/

	String title = mRequest.getParameter("title");
	String content = mRequest.getParameter("content");
	String fname = mRequest.getFilesystemName("fname");  // 첨부 된 fileName
	String regip = request.getRemoteAddr();
	
	// 세션 사용자 정보 가져오기
	MemberBean mb = (MemberBean)session.getAttribute("sessMember");
	String uid = mb.getUid();
	
	int seq = 0;
	
	try{
		// 1,2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		Statement stmt = conn.createStatement();
		PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_ARTICLE);
		psmt.setString(1, title);
		psmt.setString(2, content);
		psmt.setInt(3, fname == null ? 0 : 1);
		psmt.setString(4, uid);
		psmt.setString(5, regip);
		
		// 4단계
		psmt.executeUpdate();
		ResultSet rs = stmt.executeQuery(Sql.SELECT_MAX_SEQ); // 방금 INSERT한 글에 가장큰 seq번호
		
		// 5단계
		// int seq = 0;
		if(rs.next()){
			seq = rs.getInt(1);
		}
		
		
		// 6단계
		conn.close();
		
		
	}catch(Exception e){
		
		e.printStackTrace();
		
	}
	
	if(fname != null){ //파일을 첨부하지 않았을 경우 조건
		
		// 고유한 파일 이름 생성하기 (fileName --> fileRename)
		int i = fname.lastIndexOf(".");  
		String ext = fname.substring(i);  // 확장자 구하기
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss_");
		String now = sdf.format(new Date());
		String newName = now + uid + ext; // ex) 20210610104200_admin.jpg
		
		// 파일명 수정 스트림 작업
		File oriFile = new File(path + "/" + fname);
		File newFile = new File(path + "/" + newName);
		
		oriFile.renameTo(newFile);  // 파일 이름 변경
		
		// 파일 테이블 INSERT 작업
		// 1단계, 2단계
		Connection conn = DBConfig.getInstance().getConnection();
		
		// 3단계
		PreparedStatement psmt = conn.prepareStatement(Sql.INSERT_FILE);
		psmt.setInt(1, seq);
		psmt.setString(2, fname);
		psmt.setString(3, newName);

		// 4단계
		psmt.executeUpdate();		
		// 5단계
		// 6단계
		conn.close();
	}
	
	// 리다이렉트
	response.sendRedirect("/JBoard1/list.jsp");
	
	
	
	
	
	
	
	
	
%>