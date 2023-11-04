<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jstl2.jsp</title>
  <jsp:include page="/include/bs4.jsp" />
</head>
<body>
<p><br/></p>
<div class="container">
  <h2>JSTL(Java Standard Tag Library)</h2>
  <h3>반복문(core라이브러리 사용... - forEach문)</h3>
  <pre>
    사용법1 : < c : forEach var="변수" begin="초기값" end="최종값" step="증감값" varStatus="매개변수" >
            < /c : forEach >
    사용법2 : < c : forEach var="변수" items=" $ {객체명/배열}" varStatus="매개변수" >
            < /c : forEach >
    사용법3 : < c : forTokens var="변수" items=" $ {객체명/배열}" delims="구분기호" >
            < /c : forEach >
  </pre>
  <p>사용법1 :<br/>
    <%-- <c:forEach var="i" begin="1" end="10" step="1">   step 1일경우는 생략가능 --%>
    <c:forEach var="i" begin="1" end="10">
      ${i} /
    </c:forEach>
  </p>
  <p>사용법2 :<br/>
<%
    String[] cards = {"국민","BC","현대","삼성","비자","LG","농협"};
    pageContext.setAttribute("cards", cards);
%>
    <c:forEach var="card" items="${cards}">
    	${card} /
    </c:forEach>
  </p>
  <p>사용법3 :<br/>
    <c:set var="hobbys" value="등산/낚시/수영/바둑/바이크/승마/독서" />
    취미 : ${hobbys}<br/>
    <c:forTokens var="hobby" items="${hobbys}" delims="/">
      ${hobby},
    </c:forTokens>
  </p>
  <hr/>
  <p><b>각종 사용예제</b><br/>
    <c:forEach var="card" items="${cards}" varStatus="st">
    	${st.index}(${st.count}).${card}<br/>
    </c:forEach>
  </p>
  
  <br/>
	-문제 1 : 국민 카드는 파랑색, 삼성카드는 빨강색으로 출력 
  <c:forEach var="card" items="${cards}" varStatus="st">
    
  	<c:if test="${card == '국민'}"> <font color ="blue"> </c:if>
  	<c:if test="${card == '삼성'}"> <font color ="red"> </c:if>
  	
  	<br/>${st.index}(${st.count}).${card} 	
  	<c:if test="${card == '국민' || card == '삼성'}"> </font > </c:if>
  </c:forEach>
  
	<br/>
	- 문제 2 : 첫번째카드는 빨강색 , 마지막카드는 파랑색 출력 
	<c:forEach var="card" items="${cards}" varStatus="st">

  	<c:if test="${st.first}"> <br/><font color ="red">${st.index}(${st.count}).${card}  </c:if>
  	<c:if test="${st.last}"> <br/><font color ="blue">${st.index}(${st.count}).${card}  </c:if>
  	
  	<c:if test="${st.first || st.last}"> </font > </c:if>
  </c:forEach>
  <br/>
	- 문제 3: 모든 카드를 출력하되, 첫번째카드는 빨강색 , 마지막 카드는 파랑색 출력
	<c:forEach var="card" items="${cards}" varStatus="st">

  	<c:if test="${st.first}"> <font color ="red"> </c:if>
  	<c:if test="${st.last}"> <font color ="blue"> </c:if>
  	
  	<br/>${st.index}(${st.count}).${card} 	
  	<c:if test="${st.first || st.last}"> </font > </c:if>
  </c:forEach>

  	
    	
    	

  
  
  
</div>
<p><br/></p>
</body>
</html>