package user;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.CommandForm;

public class CommandJoinCk implements CommandForm {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("id")==null ? "" : request.getParameter("id");
		String pswd = request.getParameter("pswd")==null ? "" : request.getParameter("pswd");

		UsersDAO dao = new UsersDAO();
		UsersVO vo = dao.getUserCheck(id);
		
		String res = "0";
		
		//아이디 존재 확인 : 없으면
		if(vo.getId() == null ) {
			vo.setId(id);
			vo.setPswd(pswd);
			if(dao.getUserJoin(vo) == 1)
				res = "1";
		}

		response.getWriter().write(res);
		
		return null;
	}

}
