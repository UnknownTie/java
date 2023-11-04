<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- t3_ApplicationCheck.jsp -->
<jsp:include page="/include/bs4.jsp" />
<p><br/></p>
<div class="container">
<%
  request.setCharacterEncoding("utf-8");
  //response.setContentType("text/html; charset=utf-8");
  
	String id = request.getParameter("aMidAA")== null ? "null" : request.getParameter("aMidAA");
	
  String amid = (String) application.getAttribute("aMidA");
  String anickName = (String) application.getAttribute("aNickNameA");
  String aname = (String) application.getAttribute("aNameA");
  
  String smid = (String) session.getAttribute("sMidA");
  String snickName = (String) session.getAttribute("sNickNameA");
  String sname = (String) session.getAttribute("sNameA");
  
  Cookie[] cookies = request.getCookies();

  String cmid = "";
  String cnickName = "";
  String cname = "";
  for(int i=0; i<cookies.length; i++) {
  	if(cookies[i].getName().equals("cMidA")){
  		cmid = cookies[i].getValue();
  	}else if(cookies[i].getName().equals("cNameA")){
  		cname = cookies[i].getValue();
  	}else if(cookies[i].getName().equals("cNickNameA")){
  		cnickName = cookies[i].getValue();
  	}
  }


  
%>
  <h2>어플리케이션값 출력?</h2>
  <p>아이디 : <%=amid %></p>
  <p>닉네임 : <%=anickName %></p>
  <p>성명 : <%=aname %></p>
  
  <h2>세션값 출력?</h2>
  <p>아이디 : <%=smid %></p>
  <p>닉네임 : <%=snickName %></p>
  <p>성명 : <%=sname %></p>
  <hr/>  
  
  <h2>쿠키 출력?</h2>
  <p>아이디 : <%=cmid %></p>
  <p>닉네임 : <%=cnickName %></p>
  <p>성명 : <%=cname %></p>
  <hr/>
    
  <h2>값출력</h2>
    <p>아이디 : ${aMidA}</p>
    <p>아이디 : <%=id %></p>
  
  
  
  <p><a href="t3_ApplicationMain.jsp" class="btn btn-success">돌아가기</a></p>
</div>