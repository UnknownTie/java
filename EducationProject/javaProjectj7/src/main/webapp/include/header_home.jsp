<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<head>

  <jsp:include page="/include/linkCss.jsp" />

	
</head>


	<div>

		  <div class="header">
    <div class="inner clearfix">
      <div class="gnb">
        <ul>
          <li class="depth1">
            <a href="#">이벤트/혜택</a>
            <ul class="depth2">
              <li><a href="#">이벤트</a>
                  <ul class="depth3">
                    <li><a href="#">진행중인 이벤트</a></li>
                    <li><a href="#">지난 이벤트</a></li>
                    <li><a href="#">대상자 발표</a></li>
                  </ul>
              </li>
              <li><a href="#">가족/친구 추천</a>
                  <ul class="depth3">
                    <li><a href="#">가족/친구 추천 혜택 안내</a></li>
                    <li><a href="#">내 추천내역</a></li>
                    <li><a href="#">추천 유심 선물하기</a></li>
                  </ul>
              </li>
              <li><a href="#">U Point</a></li>
              <li><a href="#">제휴카드 혜택/할인</a></li>
            </ul>
          </li>
            
      <div class="tnb">
        <div class="tnb-wrap">
          <div class="search">
          <input id="check-btn" type="checkbox"><label for="check-btn">Click Me!</label>
            <ul class="menubars">
                <li>메뉴</li>
                <li>메뉴</li>
                <li>메뉴</li>
                <li>메뉴</li>

            </ul>    
          </div>
        </div>  
        <div class="tnb-wrap">
          <ul>
            <li class="icon">
              <a href="#"><img src="./img/header-btn-search.svg" alt="검색"></a>
              <div class="search-tab"></div>
            </li> 
            <li class="icon">
              <a href="#"><img src="./img/header-btn-my.svg" alt="마이메뉴"></a>
              <div class="my-tab"></div>
            </li>
          </ul>
        </div>
      </div>
    </div>  
  </div>
	</div>