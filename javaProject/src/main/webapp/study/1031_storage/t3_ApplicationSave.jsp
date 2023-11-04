<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- t3_ApplicationSave.jsp -->
<%
  request.setCharacterEncoding("utf-8");

	String mid = request.getParameter("aMidA")==null ? "guest" : request.getParameter("aMidA");
	String nickName = request.getParameter("nickName")==null ? "손님" : request.getParameter("nickName");
	String name = request.getParameter("name")==null ? "방문자" : request.getParameter("name");
	


	//session
	session.setAttribute("sMidA", mid+ " (session)");
	session.setAttribute("sNickNameA", nickName+ " (session)");
	session.setAttribute("sNameA", name+ " (session)");
  
	//application
	application.setAttribute("aMidA", mid+ " (application)");
	application.setAttribute("aNickNameA", nickName+ " (application)");
	application.setAttribute("aNameA", name+ " (application)");
	
	//Cookie
	String cookType = mid + "_C"; // 쿠키 특수문자, 공백 사용  X 
  Cookie cookieMid = new Cookie("aMidA", cookType);
  cookieMid.setMaxAge(60*60*24);	// 쿠키의 만료시간(초) : 60*60*24  - 1일
  cookType = nickName + "_C";
  Cookie cookieNickName = new Cookie("cNickNameA", cookType);
  cookieNickName.setMaxAge(60*60*24);
  cookType = name + "_C";
  Cookie cookieName = new Cookie("cNameA", cookType);
  cookieName.setMaxAge(60);
	
  response.addCookie(cookieMid);
  response.addCookie(cookieNickName);
  response.addCookie(cookieName);
	

%>
<script>
  alert("어플리케이션에 저장되었습니다.");
  location.href = "t3_ApplicationMain.jsp";
</script>