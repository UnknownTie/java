<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<script>
  function logoutCheck() {
	  let ans = confirm("로그아웃 하시겠습니까?");
	  //if(ans) {
		//  location.href = "${pageContext.request.contextPath}/j1030/logout4?mid=${param.mid}";
	  //}
  }
</script>

<body>
	<p><br/></p>
		<div style="height:80px; text-align:center">
		  <a href="BaseType.jsp?" class="btn btn-outline-primary">Home</a> |
		  <a href="BaseType.jsp?flag=JAVA" class="btn btn-outline-primary">JAVA 전송</a> |
		  <a href="BaseType.jsp?flag=JSP" class="btn btn-outline-primary">JSP 전송</a> |
		  <a href="BaseType.jsp?flag=DataCtr" class="btn btn-outline-primary">데이터 저장</a> |
		 	<a href="BaseType.jsp?flag=JSTL" class="btn btn-outline-primary">JSTL</a> |
		  <a href="javascript:logoutCheck()" class="btn btn-outline-warning">Logout</a>
		</div>
</body>
	
</html>
