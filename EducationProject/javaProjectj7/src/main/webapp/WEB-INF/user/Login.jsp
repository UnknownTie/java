<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<jsp:include page="/include/linkCss.jsp" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width , initial-scale=1">
	<title>sample</title>

</head>

<body>
	<div class="container">
	  <!-- ! Header -->
	 <jsp:include page="/include/header.jsp" />
	<main>
  	<div class="LoginBox viewBox">
  	<br/>
  		<div class="title" >
	      <h2>로 그 인</h2>
	    </div>
	    <div class="login">
	      <div class="logo" > </div>
	      <form  action="${ctp}/LoginCk.u" method="post" name="myform" class="logform">
	        <input type="text" name="mid" id="mid" value="admin"  placeholder="ID"class="form-control" autofocus required />
	        <input type="password" name="pswd" id="pswd" value="1234"  placeholder="비밀번호"  class="form-control" required />
	        <input type="submit" value="로그인" /> 
	        <input type="button" value="가입요청" onclick="location.href='${ctp}/Join.u';" class="btn btn-info" />
	        <input type="button" value="비밀번호찾기" onclick="location.href='${ctp}/Join.u';" class="btn btn-info" />
	      </form>
	    </div>
	  </div>
  </main>
	    
	  <!-- ! Footer -->
	<jsp:include page="/include/footer.jsp" />

	</div>

	
</body>
	
</html>


