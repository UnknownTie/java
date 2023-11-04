<!-- test2Ok.jsp -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");

	//데이터를 받을때,
	//데이터가 없으면 예외 처리해주는 조건이 필요
  String name = request.getParameter("name");
	
	//int로 변환할때, 값이 없으면 오류 발생 
	//string 존재 여부 확인 후 int로 전환해야된다. 
	String strAge = request.getParameter("age");
	Integer age = null;
	//if(!strAge.isEmpty()){
	//	age = Integer.parseInt(request.getParameter("age"));
	//}

  String flag = request.getParameter("flag");
%>
  <hr/>
  <!-- 데이터가 없으면 예외 처리해주는 조건이 필요  -->
  <p>성명3 : <%=name %></p>
  <p>나이3 : <%=strAge %></p>
  <p>flag : <%=flag %></p>
  <hr/>
  <p><a href="test2.jsp">돌아가기</a></p> 
  
	<script>
		alert("회원가입");
		//해당 페이지로 이동한다.
		location.href = "test2.jsp"
	</script>
