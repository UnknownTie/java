package buyproduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.CommandForm;

public class CommandScheduleOk implements CommandForm {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
		
		HttpSession session = request.getSession();
		String mid =(String)session.getAttribute("sId")==null ? "" : (String) session.getAttribute("sId");
		String Date = request.getParameter("date")==null ? "" : request.getParameter("date");
		String memo = request.getParameter("memo")==null ? "" : request.getParameter("memo");
		int memoIdx = request.getParameter("memoIdx")==null ? 0 : Integer.parseInt(request.getParameter("memoIdx"));
		int serial = request.getParameter("productSerial")==null ? 0 : Integer.parseInt(request.getParameter("productSerial")) ;
		
		ScheduleVO vo = new ScheduleVO();
		
		vo.setIdx( memoIdx);
		vo.setUserId(mid);
		vo.setDiviceId(serial);
		vo.setMemo(memo);
		vo.setTime(Date);
		
		System.out.println(vo);
		ScheduleDAO dao = new ScheduleDAO();
		int res;
		if(memoIdx == 0) 
			res = dao.setScheduleInputOk(vo);
		else 
			res = dao.setScheduleUpdateOk(vo);
		

		
		System.out.println("res"+res);
		response.getWriter().write(res+"");
		
		return null;
	}

}
