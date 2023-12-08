package buyproduct;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommandForm;

@SuppressWarnings("serial")
@WebServlet("*.bp")
public class BuyProductsCtrl extends HttpServlet{

		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			CommandForm command = null;
			String viewPage = "/WEB-INF/buyproduct/";
			
			String com = request.getRequestURI();
			
			String work = com.substring(com.lastIndexOf("/")+1,com.lastIndexOf("."));
			
			HttpSession session = request.getSession();

			System.out.println("com : "+com);
			System.out.println("work : "+work);

		switch (work) {
			case "BuyProductList": {
				//상품 목록
				String idx = request.getParameter("idx")==null ? "" : request.getParameter("idx");
				System.out.println("idx :" + idx);
				
				command = new CommandDeviceCk();
				command.execute(request, response);
				viewPage += "BuyProductList.jsp";
				break;
			}
			case "BuyProductView": {
				//제품의 값 
				command = new CommandDeviceView();
				command.execute(request, response);
			
			}
			case "Schedule": {		
				command = new CommandSchedule();
				command.execute(request, response);
				viewPage += "/BuyProductView.jsp";
				break;
			}
			case "ScheduleOk": {		
				command = new CommandScheduleOk();
				command.execute(request, response);
				command = new CommandSchedule();
				command.execute(request, response);
				return;
			}
			case "ScheduleCk": {		
				command = new CommandSchedule();
				command.execute(request, response);
				return;
			}
			case "BuyProductChange": {		
				command = new CommandDeviceChange();
				command.execute(request, response);
				viewPage += "/BuyProductChange.jsp";
				return;
			}
			
			
			
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
