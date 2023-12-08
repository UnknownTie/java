<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />

<header>
  <div class="hd wrap">            
    <div class="logo "><span class="logo" onclick="location.href='#'">T-SCADA</span></div>
    <div class="introduce container">
      <!-- <span class="introduce-title" onclick="wh()">회사소개</span> -->
      <span onclick="location.href='${ctp}/ProductList.p'" class="introduce-title">제품소개</span>
      <!-- <span onclick="location.href='#'" class="introduce-title">제품등록</span> -->
    </div>
    <!-- <div class="search">
      <input class="search-win" placeholder="검색어 입력"></span>
      <span class="search-icon">icon</span>
    </div> -->
    <div class="login-menu container">
      <div class="login-box">
	      <c:if test="${!empty sId}">
	      	<a onclick="location.href='${ctp}/Login.u'" class="login">로그아웃</a> 
	      </c:if>
	      <c:if test="${empty sId}">
	      	<a onclick="location.href='${ctp}/Login.u'" class="login">로그인</a> 
	      </c:if>
        <!-- <span class="logout">icon</span> -->
      </div>

      <!-- 메뉴바 -->
      <div class="menu-box">
        <span class="menu-line"></span>
        <span class="menu-line"></span>
        <span class="menu-line"></span>
      </div>  
    </div>
  </div>  
</header>