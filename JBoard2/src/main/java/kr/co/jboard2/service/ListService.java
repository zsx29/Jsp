package kr.co.jboard2.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.ArticleDao;
import kr.co.jboard2vo.ArticleVo;

public class ListService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {

		// 전송데이터 수신
		
		List<ArticleVo> av = ArticleDao.getInstance().selectArticles(av);
		
		req.setAttribute("av", av);
		
		return "/list.jsp";
	}

}
