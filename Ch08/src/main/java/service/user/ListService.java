package service.user;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import service.CommonService;
import vo.UserVo;

public class ListService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		List<UserVo> users = UserDao.getInstance().selectUsers();
		
		req.setAttribute("users", users);
		
		return "/user/list.jsp";
	}

}
