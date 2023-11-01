package newEductaion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaCollect.mySqlConnect.MemberDAO;
import javaCollect.mySqlConnect.MemberVO;


@WebServlet("/connDB")
public class connDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter out ;
	MemberDAO dao = new MemberDAO();
		public connDB() {
        super();
		}

  	@Override
  	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		System.out.println("service ()");
  		
  		request.setCharacterEncoding("utf-8"); //이클립스 console 
  		response.setCharacterEncoding("utf-8");
  		response.setContentType("text/html; charset=UTF-8;");
  		// response getWriter로 가져오기전에 char 세팅을 해줘야된다.
  		out = response.getWriter();
  		out.println("service ()<br/><br/>");
  		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\""+request.getContextPath()+"/css/test.css\" >\r\n");
  		

  		String strid = request.getParameter("id");
  		String strPswd = request.getParameter("pswd");
  		out.println("strid : " + strid);
  		out.println("strPswd : " + strPswd);

			MemberVO member = dao.logIn(strid, strPswd);

			System.out.println("1");
			//member.vo.ge

			
			if(member == null) {
				out.println("<p>로그인 실패</p>");
			}
			else {
				out.println("<p>로그인</p>");
			}
  		
  		out.println("<p><a href='"+request.getParameter("path")+"'>돌아가기</a></p>");

  	}

}
