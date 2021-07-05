package kr.co.jboard2.service.user;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import kr.co.jboard2.dao.MemberDao;
import kr.co.jboard2.service.CommonService;
import kr.co.jboard2vo.MemberVo;

public class RegisterService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if (req.getMethod().equals("GET")) {
			
			return "/user/register.jsp";
		}else {
			
			//POST
			// ���� ������ ����
			
			String uid   = req.getParameter("uid");
			String pass1 = req.getParameter("pass1");
			String name  = req.getParameter("name");
			String nick  = req.getParameter("nick");
			String email = req.getParameter("email");
			String hp    = req.getParameter("hp");
			String zip 	 = req.getParameter("zip");
			String addr1 = req.getParameter("addr1");
			String addr2 = req.getParameter("addr2");
			String regip = req.getRemoteAddr();
			
			MemberVo mv = new MemberVo();
			mv.setUid(uid);
			mv.setPass(pass1);
			mv.setName(name);
			mv.setNick(nick);
			mv.setEmail(email);
			mv.setHp(hp);
			mv.setZip(zip);
			mv.setAddr1(addr1);
			mv.setAddr2(addr2);
			mv.setRegip(regip);
			
			
			
			MemberDao.getInstance().insertMember(mv);
			
			// �����̷�Ʈ
			return "redirect:/JBoard2/user/login.do";
		}
	}


}
