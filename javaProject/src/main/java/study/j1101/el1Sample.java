package study.j1101;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/j1101/el1Sample")
public class el1Sample extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			super.service(request, response);
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf");
			response.getWriter().append("Served at: ").append(request.getContextPath());
			
			//변수 받을때, null예외처리
			//1. 기본 변수 
			String strA = "";
			strA = request.getParameter("A")==null? strA: request.getParameter("A");
			
			//2. 배열 
			String[] strArr = {};
			strArr = request.getParameterValues("arr")==null? strArr: request.getParameterValues("arr"); 
			//배열 사용 예시
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
	


		}

    public el1Sample() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
