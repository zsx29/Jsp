package service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommonService;

public class DeleteService implements CommonService{

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {

		return "redirect:/Ch08/user/list.jsp";
	}

}
