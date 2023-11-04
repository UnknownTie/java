<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- t2_SessionMidDelete.jsp -->
<%
	application.removeAttribute("aMidA");
	application.removeAttribute("aNickNameA");
	application.removeAttribute("aNameA");
		
	session.removeAttribute("sMidA");
	session.removeAttribute("sNickNameA");
	session.removeAttribute("sNameA");
	
  Cookie[] cookies = request.getCookies();
	for(int i=0; i<cookies.length; i++) {
		// 재사용이 불가능하도록 다른 값읖 덮어쓰고 날려버린다.
		cookies[i].setPath("/");
    cookies[i].setValue("");
		cookies[i].setMaxAge(0);
		response.addCookie(cookies[i]);
	}
%>
<script>
  alert(" 삭제되었습니다.");
  location.href = "t2_SessionMain.jsp";
</script>