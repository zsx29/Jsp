package service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import service.CommonService;
import vo.MemberVO;
import vo.UserVo;

public class RegisterService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if (req.getMethod().equals("GET")) {
			// GET -> list페이지에서 register 페이지로 이동할 때 GET 방식으로 받아오기 때문에
			return "/user/register.jsp";
 
		}else {
			// POST
			
			// 전송 파라미터 수신
			String uid = req.getParameter("uid");
			String name = req.getParameter("name");
			String hp = req.getParameter("hp");
			String age = req.getParameter("age");
			
			UserVo vo = new UserVo();
			vo.setUid(uid);
			vo.setName(name);
			vo.setHp(hp);
			vo.setAge(age);

			UserDao.getInstance().insertUser(vo);
			
			return "redirect:/Ch08/user/list.do";
		}
		
		
	}
}
