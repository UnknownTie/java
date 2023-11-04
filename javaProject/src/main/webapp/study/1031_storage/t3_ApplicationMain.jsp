<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>t3_ApplicationMain.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
  <style>
    div {margin: 20px;}
  </style>
</head>
<body>
<p><br/></p>
<div class="container">
	<%
	  Cookie[] cookies = request.getCookies();
 		String cNickNameA="";
	  out.println("저장된 쿠키는?<br/>");
	  for(int i=0; i<cookies.length; i++) {
	  	if(cookies[i].getName().equals("aMidA")){
		  	out.println("쿠키명 : " + cookies[i].getName() + " <br/> ");
		  	out.println("쿠키값 : " + cookies[i].getValue() + " <br/> ");
		  	out.println("만료시간 : " + cookies[i].getMaxAge() + " <br/> <hr/>");
		  	cNickNameA = cookies[i].getValue();
	  	}
	  }

	%>

	
  <h2>Application연습 메인메뉴</h2>
  <hr/>
  
  <form name="myform" method="post" action="t3_ApplicationSave.jsp">
    <div>아이디 :
      <input type="text" name="aMidAA" value="${aMidA}" autofocus class="form-control" />
    </div>
    <div>닉네임 :
      <!--
      <input type="text" name="nickName" value="<%=cNickNameA%>" class="form-control" />
        -->      
      <input type="text" name="nickName" value="${cookie.aMidA.value}" class="form-control" />
    </div>
    <div>성명 :
      <input type="text" name="name" value="${sNameA}" class="form-control" />
    </div>
    <hr/>
	  <div class="row">
	    <div class="col"><button type="submit" class="btn btn-success form-control">어클리케이션저장</button></div>
	    <div class="col"><a href="t3_ApplicationCheck.jsp" class="btn btn-primary form-control">어플리케이션값확인</a></div>
	    <div class="col"><a href="t3_ApplicationNameCheck.jsp" class="btn btn-info form-control">전체 어플리케이션이름확인</a></div>
	    <div class="col"><a href="t3_ApplicationMidDelete.jsp" class="btn btn-info form-control">(어플리케이션)아이디 삭제</a></div>
	  </div>
	  <c:set var="aMidA" value="100" />
  </form>

</div>
<p><br/></p>
</body>
</html>