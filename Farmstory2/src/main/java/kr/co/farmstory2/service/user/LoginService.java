package kr.co.farmstory2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.farmstory2.dao.MemberDao;
import kr.co.farmstory2.service.CommonService;
import kr.co.farmstory2.vo.MemberVo;



public class LoginService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if (req.getMethod().equals("GET")) {
						
			return "/user/login.jsp";
			
		}else {
			
			String uid  = req.getParameter("uid");
			String pass = req.getParameter("pass");
			
			MemberVo mv = MemberDao.getInstance().selectMember(uid, pass);
			
			if(mv != null) {
				
				HttpSession sess = req.getSession();
				sess.setAttribute("sessMember", mv);
				
				return "redirect:/Farmstory2/";
				
			}else {
				
				return "redirect:/Farmstory2/user/login.do?success=100";
			}
			
			
		}
		
	}
	
}
