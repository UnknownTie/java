package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommandForm;

@SuppressWarnings("serial")
@WebServlet("*.u")
public class UsersCtrl extends HttpServlet{

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			CommandForm command = null;
			String viewPage = "/WEB-INF/user/";
			
			String com = request.getRequestURI();
			
			String work = com.substring(com.lastIndexOf("/")+1,com.lastIndexOf("."));
			
			HttpSession session = request.getSession();
	
			System.out.println("com : "+com);
			System.out.println("work : "+work);
		
		switch (work) {
			case "Login": {
				//회원 로그인
				viewPage += "Login.jsp";
				session.removeAttribute("sId");
				session.removeAttribute("sIdx");
				break;
			}
			case "LoginCk": {
				//회원 로그인
				command = new CommandLoginCk();
				command.execute(request, response);
				viewPage = "/include/message.jsp";
				break;
			}
			case "Logout": {
				//회원 로그아웃
				System.out.println("Logout");
				//권한 초기화
				session.removeAttribute("sId");
				session.removeAttribute("sStatus");
				viewPage += "Login.jsp";
				break;
			}
			case "Join": {
				//회원 가입 요청
				viewPage += "Join.jsp";
				break;
			}
			case "JoinCk": {
				//회원 가입 요청
				System.out.println("JoinCk");
				command = new CommandJoinCk();
				command.execute(request, response);
				
				return;
			}
			case "joinOk": {
				//회원 승인	
				break;
			}
			default:
		}
		
		System.out.println(work + " :" + viewPage);
		
		request.getRequestDispatcher(viewPage).forward(request, response);
	}

}
