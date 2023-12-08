<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
  int level = session.getAttribute("sLevel")==null ? 99 : (int) session.getAttribute("sLevel");
  pageContext.setAttribute("level", level);  
%>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<script>
  function memberDelcheck() {
	  let ans = confirm("회원 탈퇴 하시겠습니까?");
	  if(ans) {
		  let ans2 = confirm("탈퇴후 같은 아이디로는 1개월간 재가입하실수 없습니다.\n그래도 탈퇴 하시겠습니까?");
		  if(!ans2) return false; 
	  }
	  else return false;
	  
	  // 회원 탈퇴(ajax처리)
	  $.ajax({
		  url  : "memberDelelteCheck.mem",
		  type : "post",
		  success:function(res) {
			  if(res != '1') alert("회원 탈퇴 실패~~");
			  else location.href = 'memberLogout.mem';
		  },
		  error : function() {
			  alert("전송오류");
		  }
	  });
  }
</script>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	<!-- 햄버거버튼 -->
	<h1 class="logo">
    <a href="http://192.168.50.70:9090/javaProjectj7">
    	<img src="${ctp}/images/common/Logo.jpg" style="height: 70%;" alt="로고">
    </a>
  </h1>

  <a class="navbar-brand" href="http://192.168.50.70:9090/javaProjectj7">Home</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
  
	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	  <ul class="navbar-nav">
	    <li class="nav-item">
	      <a class="nav-link" href="${ctp}/GuestList">Guest</a>
	    </li>
	      <li class="nav-item">
	        <a class="nav-link" href="boardList.bo">Board</a>
	      </li>
	      <li class="nav-item">
	        <c:if test="${level != 1}"><a class="nav-link" href="pdsList.pds">Pds</a></c:if>
	      </li>
	          
	      <li class="nav-item ml-2 mr-2">
	        <div class="dropdown">
				    <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown">Study1</button>
				    <div class="dropdown-menu">
				      <a class="dropdown-item" href="${ctp}/study/password/passForm.jsp">암호화연습</a>
				      <a class="dropdown-item" href="${ctp}/mapping/test1">디렉토리패턴</a>
				    </div>
				  </div>
	      </li>
	      <li class="nav-item">
	        <c:if test="${level > 4}"><a class="nav-link" href="memberLogin.mem">Login</a></c:if>
	        <c:if test="${level <= 4}"><a class="nav-link" href="memberLogout.mem">Logout</a></c:if>
	      </li>
	    </ul>
	  </div>  
</nav>