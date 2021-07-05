package kr.co.jboard2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.jboard2.dao.MemberDao;
import kr.co.jboard2.service.CommonService;
import kr.co.jboard2vo.MemberVo;

public class LoginService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {

		if (req.getMethod().equals("GET")) {
			
			// GET
			return "/user/login.jsp";
			
		}else {
			
			//POST
			
			// 전송데이터 수신
			String uid  = req.getParameter("uid");
			String pass = req.getParameter("pass");
			
			MemberVo mv = MemberDao.getInstance().selectMember(uid, pass);
			
			if(mv != null) {
				//
				HttpSession sess = req.getSession();
				sess.setAttribute("sessMember", mv);
				
				return "redirect:/JBoard2/list.do";
				
			}else {
				
				return "redirect:/JBoard2/user/login.do?success=100";
			}
			
			
			
		}
		
		
	}

	
}
