package product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommandForm;
import user.CommandJoinCk;

@SuppressWarnings("serial")
@WebServlet("*.p")
public class ProductsCtrl extends HttpServlet{

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			CommandForm command = null;
			String viewPage = "/WEB-INF/product/";
			
			String com = request.getRequestURI();
			
			String work = com.substring(com.lastIndexOf("/")+1,com.lastIndexOf("."));
			
			HttpSession session = request.getSession();
			int status = session.getAttribute("sLevel")==null ? 999 : (int) session.getAttribute("sLevel");
			System.out.println("com : "+com);
			System.out.println("work : "+work);

		switch (work) {
			case "ProductList": {
				//상품 목록
				viewPage += "ProductList.jsp";
				command = new CommandProductList();
				command.execute(request, response);
				
				break;
			}
//			case "LoginCk": {
//				//회원 로그인
//				command = new CommandLoginCk();
//				command.execute(request, response);
//				viewPage = "/include/message.jsp";
//				break;
//			}
//			case "Logout": {
//				//회원 로그아웃
//				System.out.println("Logout");
//				//권한 초기화
//				session.removeAttribute("sId");
//				session.removeAttribute("sStatus");
//				viewPage += "Login.jsp";
//				break;
//			}
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
