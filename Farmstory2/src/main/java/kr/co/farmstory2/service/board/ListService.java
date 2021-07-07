package kr.co.farmstory2.service.board;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.farmstory2.service.CommonService;


public class ListService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		// ��Ŭ��� ���̽� �ؾ���
		String group = req.getParameter("group");
		String cate  = req.getParameter("cate");
		
		req.setAttribute("group", group);
		req.setAttribute("cate", cate);
		
		return "/board/list.jsp";
	}
	
}