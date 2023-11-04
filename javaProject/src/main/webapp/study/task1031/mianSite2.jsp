<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- t2_SessionCheck.jsp -->
<jsp:include page="/include/bs4.jsp" />
<p><br/></p>
<div class="container">

<%
request.setCharacterEncoding("utf-8");
  Cookie[] cookies = request.getCookies();
	String cookieId =(String) session.getAttribute("sMid");
	String cookiePswd="";

  for(int i=0; i<cookies.length; i++) {
  	if(cookies[i].getName().equals("cId")  ){
  		cookieId = cookies[i].getValue();
  	} else if( cookies[i].getName().equals("cPswd") ){
  		cookiePswd = cookies[i].getValue();
  	}
  }
  String id = (String) session.getAttribute("mid");
  String pswd = (String) session.getAttribute("pswd");

%>

  <h2>회원정보(B)</h2>
  <p>아이디 : <%=cookieId %></p>
  <p>비밀번호 : <%=cookiePswd %></p>
  
  <p><a href="mianSite.jsp" class="btn btn-success">A 이동</a></p>
  <hr/>
  <p><a href="./login.jsp" onclick="session.invalidate();" class="btn btn-success">로그아웃</a></p>
  



</div>
