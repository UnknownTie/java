package newEductaion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class communication
 */
@WebServlet({"/communication" , "/comGet" , "/comPost" , "/comService" , "/한글가능"})
public class communication extends HttpServlet {
	private static final long serialVersionUID = 1L;
		PrintWriter out ;

    public communication() {
        super();
    		System.out.println("communication 생성자");
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
  		
  		String name = request.getParameter("name");
  		String age = request.getParameter("age");
  		String path = request.getParameter("path");
  				
  		System.out.println("name : " + name );
  		System.out.println("age : " + age );
  		System.out.println("path : " + path );
  		
  		out.println("name : " + name +"<br/>");
  		out.println("age : " + age +"<br/>");
  		out.println("path : " + path +"<br/><br/>");
  		
  		out.println("<p>현 getRequestURL : "+request.getRequestURL()+"</p>" );
  		out.println("<p>현 getRequestURI : "+request.getRequestURI()+"</p>");
  		
  		out.println("<p><a href='"+path+"'>돌아가기</a></p>");

  		
  	}
  	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet ()");
		out.println("doGet ()");

		//1. 기본 변수
		String strA = "";
		strA = request.getParameter("A")==null? strA: request.getParameter("A");
		
		//2. 배열 
		String[] strArr = {};
		strArr = request.getParameterValues("arr")==null? strArr: request.getParameterValues("arr"); 
		//배열 사용
		String ckStrings = ""; 
		
		if(strArr.length > 0 ) {
			for(String ckString : strArr) {
				ckStrings += ckString + "/";
			}
			//자료 저장
			ckStrings = ckStrings.substring(0,ckStrings.length()-1);
		}
		else {
			// 로그 남기기 ( 값 X ) 
			System.out.println("arr null"); 
		}
		
		//----------------------------------------------------

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		out.println("doPost ()");
		response.getWriter().append("doPost : ").append(request.getContextPath());
		doGet(request, response);
	}
	
	

}
