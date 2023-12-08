package user;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommandForm;

public class CommandLoginCk implements CommandForm {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String rtn ="";
		String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		String pwd = request.getParameter("pswd")==null ? "" : request.getParameter("pswd");
		
		System.out.println("mid: "+mid);
		System.out.println("pwd: "+pwd);
		UsersDAO dao = new UsersDAO();
		
		UsersVO vo = dao.getUserCheck(mid);
		
		System.out.println("vo.getId() : " + vo.getId());
		//if(!vo.getMid().equals(mid)) {
		if(vo.getId() == null || !vo.getId().equals(mid)) {
			request.setAttribute("msg", "아이디를 확인하세요");
			request.setAttribute("url", "/Login.us");
			return "";
		}
		else if(!vo.getPswd().equals(pwd)) {
			request.setAttribute("msg", "비밀번호를 확인하세요");
			request.setAttribute("url", "/Login.us");
			return "";
		}
	
		//ip 확인
		InetAddress local;
		try {
			// 마지막 접속 IP
			local = InetAddress.getLocalHost();	
			vo.setUsersLastIp(local.getHostAddress());
			
      // 마지막 접속 시간       
			LocalDateTime now = LocalDateTime.now();            
			String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));              
			System.out.println(formatedNow);  

			vo.setUsersLastTime(formatedNow);
			
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		
		// 1.세션처리
		HttpSession session = request.getSession();
		session.setAttribute("sId", mid);
		session.setAttribute("sUserIdx", vo.getIdx());
		//session.setAttribute("sBuy", vo.getUsers_buyersIdx());
		request.setAttribute("msg", "NO");
		request.setAttribute("url", "/ProductList.p");
		
		return rtn;
	}


}
