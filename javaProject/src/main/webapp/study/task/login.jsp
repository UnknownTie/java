<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  Cookie[] cookies = request.getCookies();
	String cookieId ="";
	String cookiePswd="";
  out.println("저장된 쿠키는?<br/>");
  
  for(int i=0; i<cookies.length; i++) {
  	if(cookies[i].getName().equals("cId")  ){
  		cookieId = cookies[i].getValue();
    	out.println(cookies[i].getName() + " 쿠키값 : " + cookies[i].getValue() + " <br/> ");
  	} else if( cookies[i].getName().equals("cPswd") ){
  		cookiePswd = cookies[i].getValue();
    	out.println(cookies[i].getName() + " 쿠키값 : " + cookies[i].getValue() + "");
  	}
  }

%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>t2_SessionMain.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <style>
    div {margin: 20px;}
  </style>
</head>
<body>
<p><br/></p>
<div class="container">
  <h2>세션연습 메인메뉴</h2>
  <hr/>
       
  <form name="myform" method="post" action="cookieCk.jsp">
    <div>아이디 :
      <input type="text" name="mid" value="<%=cookieId%>" autofocus class="form-control" />
    </div>
    <div>비밀번호 :
      <input type="password" name="pswd" value="<%=cookiePswd%>" class="form-control" />
    </div>
    <input type="checkbox" name="idCheck" id="idCheck" value="true" />로그인 유지(24시간) &nbsp;
    <hr/>
	  <div class="row">
	    <div class="col"><button type="submit" class="btn btn-success form-control">로그인</button></div>
  	<input type="hidden" name="path" value="<%= request.getRequestURI() %>" />
  </div>
  </form>
</div>
<p><br/></p>
</body>
</html>