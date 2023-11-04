<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jstl5.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<p><br/></p>
<div class="container">
  <h2>회원 자료 출력하기</h2>
  <form name="myform" method="post" action="${ctp}/j1101/jstl5Ok">
		<div>회원이름 :
      <input type="text" name="name" value="홍길동" autofocus class="form-control" />
    </div>	
		<input  type="submit" value="회원 검색" class="btn btn-success mb-3 mt-3" />
  </form>
  
  <form name="myform" method="post" action="${ctp}/j1101/jstl5Ok">
		<div>성별선택 :
	  	<input type="radio" name="gender" value="남자" checked/>남자
	  	<input type="radio" name="gender" value="여자" />여자
    </div>	
		<input  type="submit" value="성별별 회원 " class="btn btn-success mb-3 mt-3" />
  </form>
  
  <div ><a href="${ctp}/j1101/jstl5Ok" class="btn btn-success">회원전체 리스트 </a></div>
</div>
<p><br/></p>
</body>
</html>