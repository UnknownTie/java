<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- t1_CookiesDelete.jsp -->
<%
  request.setCharacterEncoding("utf-8");
  //response.setContentType("text/html; charset=utf-8");

  String id = request.getParameter("mid")==null ? "" : request.getParameter("mid");
  String pswd = request.getParameter("pswd")==null ? "" : request.getParameter("pswd");
  String loginCk = request.getParameter("idCheck")==null ? "" : request.getParameter("idCheck");


  if(loginCk.equals("true")){
    Cookie cookieId = new Cookie("cId", id);
    
    cookieId.setMaxAge(60*60*24);	// 쿠키의 만료시간(초) : 60*60*24  - 1일

    Cookie cookiePwd = new Cookie("cPswd", pswd);
    cookiePwd.setMaxAge(60*60*24);
    
    response.addCookie(cookieId);
    response.addCookie(cookiePwd);
  }
  else{
    Cookie[] cookies = request.getCookies();
    
  	for(int i=0; i<cookies.length; i++) {
  		cookies[i].setMaxAge(0);
  		response.addCookie(cookies[i]);
  	}
  }
  
	session.setAttribute("sMid", id);
  
%>


<script>
  location.href = "mianSite.jsp";
</script>