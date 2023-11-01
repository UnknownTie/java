<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!-- page import="javaCollect.diamond_20231011.DiamondPaint" -->
<%@ page import="newJavaCollect.education.javaLink" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
  String flag = request.getParameter("flag")==null ? "" : request.getParameter("flag");
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width , initial-scale=1">
	<title>JSP 기본</title>
	<jsp:include page="/include/bs4Include.jsp" />

  
  <script>
    'use strict';
    
    function fCheck() {
    	let name = myform.name.value;
    	let age = document.getElementById("age").value;
    	
    	if(name.trim() == "") {
    		alert("성명을 입력하세요");
    		myform.name.focus();
    	}
    	else if(age.trim() == "") {
    		alert("나이를 입력하세요");
    		document.getElementById("age").focus();
    	}
    	else {
    		// location.href = `test2Ok.jsp?name=${name}&age=${age}`;	// 백엔드처리시 오류발생...
    		// location.href = "test2Ok.jsp?name="+name+"&age="+age;
    		myform.submit();
    	}
    }
  </script>
  
</head>

<body>
	<p><br/></p>
		<div class="container">
			helloWorld
				
			
			<p><br/></p>
			<div class="vTabletype">
				  <%@ include file = "BaseNav.jsp" %>
			</div>
			
			<p><br/></p>
			<div class="vTabletype">
				<%  if(flag.equals("JAVA")) { %>
				  <h2>JAVA(Servlet)</h2>
				  <h4>값의 전송(GET/POST) 전송하기</h4>
				  <form name="myform" method="post" action="<%= request.getContextPath() %>/comGet">
				  	<div>성명
				  	  <input type="text" name="name" value="집" class="form-control mb-3" autofocus />
				  	</div>
				  	<div>나이
				  	  <input type="number" name="age" id="age" value="12" class="form-control mb-3" />
				  	</div>
				  	<div>
				  	  <input type="button" value="전송(JAVA servlet)" onclick="fCheck()" class="btn btn-primary form-control" />
				  	</div>
				  	<!-- <input type="hidden" name="path" value="<%= request.getRequestURL() %>" /> -->
				  		<input type="hidden" name="path" value="<%= request.getRequestURI() %>" />
				  </form>
				<%  } else if(flag.equals("JSP")){ %>
					<h2>JSP 전송 </h2>
				  <h4>회 원 정 보</h4>
				  <form name="myform" method="post" action="BaseJsp.jsp">
				    <div class="cont">성명
				  	  <input type="text" name="name" value="홍길동" class="form-control mb-3" autofocus />
				  	</div>
				  	<div class="cont">나이
				  	  <input type="number" name="age" id="age" value="20" class="form-control mb-3" />
				  	</div>
				  	<div class="cont">성별
				  	  <input type="radio" name="gender" value="남자" />남자
				  	  <input type="radio" name="gender" value="여자" checked />여자
				  	</div>
				  	<div class="cont">취미
				  	  <input type="checkbox" name="hobby" value="등산" checked />등산 &nbsp;
				  	  <input type="checkbox" name="hobby" value="낚시" />낚시 &nbsp;
				  	  <input type="checkbox" name="hobby" value="수영" checked />수영 &nbsp;
				  	  <input type="checkbox" name="hobby" value="바둑" checked />바둑 &nbsp;
				  	  <input type="checkbox" name="hobby" value="싸이클" checked />싸이클 &nbsp;
				  	  <input type="checkbox" name="hobby" value="배드민턴" />배드민턴
				  	</div>
				  	<div class="cont">직업
				  	  <select name="job" class="form-control mb-3">
				  	    <option selected>학생</option>
				  	    <option>회사원</option>
				  	    <option>군인</option>
				  	    <option>공무원</option>
				  	    <option>웹프로그래머</option>
				  	    <option>기타</option>
				  	  </select>
				  	</div>
				  	<div class="cont">
				  	  주소 : <input type="text" name="address" value="청주" class="form-control" />
				  	</div>
				  	<div class="cont mt-3">
				  	  <input type="submit" value="전송(JSP)" class="btn btn-primary form-control" />
				  	  <input type="hidden" name="path" value="<%= request.getRequestURI() %>" />
				  	</div>
				  </form>
				<%  } else if(flag.equals("DataCtr")){ %>
					<h2>1. 쿠키 연습 메인 메뉴</h2>
				  <hr/>
				   <form name="myform" method="post" action="useCookies.jsp?type=save">
				    <div>아이디 :
				      <input type="text" name="cId" value="${cId}" autofocus class="form-control" />
				    </div>
				    <div>비밀번호 :
				      <input type="password" name="cPswd" value="${cPswd}" class="form-control" />
				    </div>
				   	<hr/>
					  <div class="row mt-3">
					    <div class="col"><button type="submit" class="btn btn-success form-control">쿠키저장</button></div>
					    <div class="col"><a href="useCookies.jsp?type=Check" class="btn btn-primary form-control">쿠키확인</a></div>
					    <div class="col"><a href="useCookies.jsp?type=Delete" class="btn btn-info form-control">전체 쿠키삭제</a></div>
					    <div class="col"><a href="useCookies.jsp?type=PwdDelete" class="btn btn-info form-control">비번 쿠키삭제</a></div>
					  </div>
			      <input type="hidden" name="path" value="<%= request.getRequestURI() %>" />
			      
				  </form>
				  
				  <br/>
				  <h3>*참고 (유효성 범위) </h3>
					&nbsp;request < session < application(ServletContext)<br/>
				  &nbsp;- request의 유효범위 : response 할 때까지<br/>
					&nbsp;- session의 유효범위 :<br/>
				  &nbsp; &nbsp; 1) 로그아웃(서버에서 session.invalidate() ) 시 소멸	<br/>
				  &nbsp; &nbsp; 2) 클라이언트(브라우저) 종료 시 소멸	<br/>
				  &nbsp; &nbsp; 3) 지정한 session timeout까지 재접속이 없을 경우 소면	<br/>
					&nbsp;- application(ServletConext) : 웹 어플리케이션 서비스가 종료될 때까지 유효 <br/>
				  
				  
				  <p><br/><br/><br/></p>
				  <h2>2. 세션연습 메인메뉴</h2>
				  <hr/>
				  <form name="myform" method="post" action="useSession.jsp?type=save">
				    <div>아이디 :
				      <input type="text" name="sId" value="${sId}" autofocus class="form-control" />
				    </div>
				    <div>닉네임 :
				      <input type="text" name="sNickName" value="${sNickName}" class="form-control" />
				    </div>
				    <div>세션 ID : <%=session.getId() %></div>
				    <hr/>
					  <div class="row">
					    <div class="col"><button type="submit" class="btn btn-success form-control">세션저장</button></div>
					    <div class="col"><a href="useSession.jsp?type=Check" class="btn btn-primary form-control">세션확인</a></div>
					    <div class="col"><a href="useSession.jsp?type=Delete" class="btn btn-info form-control">전체 세션삭제</a></div>
					    <div class="col"><a href="useSession.jsp?type=IdDelete" class="btn btn-info form-control">아이디 세션삭제</a></div>
					  </div>
				  </form>
				  
				  <p><br/><br/><br/></p>
			    <h2>3. Application연습 메인메뉴</h2>
				  <hr/>
				  <form name="myform" method="post" action="useApplication.jsp?type=save">
				    <div>아이디 :
				      <input type="text" name="aId" value="${aId}" autofocus class="form-control" />
				    </div>
				    <div>성명 :
				      <input type="text" name="aName" value="${aName}" class="form-control" />
				    </div>
				    <hr/>
					  <div class="row">
					    <div class="col"><button type="submit" class="btn btn-success form-control">어클리케이션저장</button></div>
					    <div class="col"><a href="useApplication.jsp?type=Check" class="btn btn-primary form-control">어플리케이션값확인</a></div>
					    <div class="col"><a href="useApplication.jsp?type=IdDelete" class="btn btn-info form-control">(어플리케이션)아이디 삭제</a></div>
					  </div>
				  </form>
				<%  } else if(flag.equals("JSTL")){ %>
				
				<h2>JSTL(Java Standard Tag Library)</h2>
			  <table class="table border-bordered">
			    <tr>
			      <th>라이브러리명</th>
			      <th>주소(URI)</th>
			      <th>접두어</th>
			      <th>기본문법</th>
			    </tr>
			    <tr>
			      <td>Core</td>
			      <td>http://java.sun.com/jsp/jstl/core</td>
			      <td>c</td>
			      <td>< c : 태그명.... ></td>
			    </tr>
			    <tr>
			      <td>Formatting</td>
			      <td>http://java.sun.com/jsp/jstl/fmt</td>
			      <td>fmt</td>
			      <td>< fmt : 태그명.... ></td>
			    </tr>
			    <tr>
			      <td>Function</td>
			      <td>http://java.sun.com/jsp/jstl/functoin</td>
			      <td>fn</td>
			      <td>$ { fn : 태그명.... }</td>
			    </tr>
			    <tr>
			      <td>SQL</td>
			      <td>http://java.sun.com/jsp/jstl/sql</td>
			      <td>sql</td>
			      <td>< sql : 태그명.... ></td>
			    </tr>
			  </table>
			  <hr/>
			  <p><b>위의 라이브러리를 사용할 경우에는 상단에 jsp지시자(taglib)를 이용하여 먼저 선언후 사용할 수 있다.</b></p>
			  <hr/>
			  <h3>Core라이브러리 : 변수제어(선언/값할당/출력/제거), 제어문(조건, 반복문)</h3>
			  <pre>
			    변수선언 : < c : set var="변수명" value="값" />
			    변수출력 : < c : out value="변수/값/수식" />    또는  EL로 사용.... $ {변수}
			    변수제거 : < c : remove var="변수명" />"
			  </pre>
			  <p>사용예</p>
			  su1변수를 선언후 초기값으로 100을 할당? <c:set var="su1" value="100" /><br/>
			  su1변수의 값을 출력? <c:out value="100+200"></c:out> / ${su1}<br/>
			  su1변수의 수식을 출력? <c:out value="${100+200}"></c:out> / ${100+200}<br/>
			  스크립틀릿 출력? <c:out value='<%="아톰" %>'></c:out><br/>
			  <hr/>
			  <h3>JSTL 제어문(core라이브러리와 el을 함께 활용)</h3>
			  <p>사용법 : < c : if test="$ { 조건식  }" > 조건식에 처리할 내용 < / c : if ></p>
			  <div>단점1 : jstl의 숫자비교는 문자형식으로 비교한다.(해결:숫자형문자변수+0)</div>
			  <div>단점2 : else문장이 없다.(배타적으로 비교한다. 또는 다중조건비교를 수행할수 있다.)</div>
			  <p>사용예(su3=300, su4=400)</p>
			  <c:set var="su3" value="100" />
			  <c:set var="su4" value="20" />
			  <div>su3 : ${su3} / su4 : ${su4}</div>
			  <div>1. su3 == su4 : <c:if test="${su3 == su4}">su3와 su4는 같다.</c:if> </div>
			  <div>2. su3 != su4 : <c:if test="${su3 != su4}">su3와 su4는 다르다.</c:if> </div>
			  <div>2-1. su3과 su4  관계  :<br/>
				  <c:choose>
				    <c:when test="${Integer.valueOf(su3) > Integer.valueOf(su4)}"> <!-- if -->
			    		su3 > su4 (1)
				    </c:when>
				   	<c:when test="${Integer.valueOf(su3) > Integer.valueOf(su4)}"> <!-- else if -->
			    		su3 > su4 (2)
				    </c:when>
				    <c:when test="${Integer.valueOf(su3) < Integer.valueOf(su4)}"> <!-- else if -->
			    		su3 < su4 (1) 
				    </c:when>
				   	<c:when test="${Integer.valueOf(su3) < Integer.valueOf(su4)}"> <!-- else if -->
			    		su3 < su4 (2) 
				    </c:when>
				    <c:otherwise> <!-- else -->
				        su3 == su4 
				    </c:otherwise>
					</c:choose>
			  </div>
			  <div>3. su3 > su4 : <c:if test="${su3 > su4}">su3는 su4보다 크다.</c:if> </div>
			  <div>4. su3 < su4 : <c:if test="${su3 < su4}">su3는 su4보다 작다.</c:if> </div>
			  <div>5-1. su3 > su4 : <c:if test="${su3+0 > su4+0}">su3는 su4보다 크다.</c:if> </div>
			  <div>6-1. su3 < su4 : <c:if test="${su3+0 < su4+0}">su3는 su4보다 작다.</c:if> </div>
			  <div>5-2. su3 < su4 : <c:if test="${Integer.valueOf(su3) > Integer.valueOf(su4)}">형변환 su3는 su4보다 크다.</c:if> </div>
			  <div>6-2. su3 < su4 : <c:if test="${Integer.valueOf(su3) < Integer.valueOf(su4)}">형변환 su3는 su4보다 작다.</c:if> </div>
			  <div>7. su3 >= su4 : <c:if test="${su3+0 >= su4+0}">su3는 su4보다 크거나같다.</c:if> </div>
			  <div>8. su3 <= su4 : <c:if test="${su3+0 <= su4+0}">su3는 su4보다 작거나같다.</c:if> </div>
			  <div>9. su3 gt su4 : <c:if test="${su3+0 gt su4+0}">su3는 su4보다 크다.</c:if> </div>
			  <div>10. su3 lt su4 : <c:if test="${su3+0 lt su4+0}">su3는 su4보다 작다.</c:if> </div>
			  <div>11. su3 ge su4 : <c:if test="${su3+0 ge su4+0}">su3는 su4보다 크거나같다.</c:if> </div>
			  <div>12. su3 le su4 : <c:if test="${su3+0 le su4+0}">su3는 su4보다 작거나같다.</c:if> </div>
			  
			  <div>예제 : URL에 jumsu를 입력받아서 학점을 구하시오?</div>
			  <div>
			    <c:set var="jum" value="${param.jumsu}"/>
			    <c:if test="${jum+0 >= 60}"><c:set var="grade" value="D"/></c:if>
			    <c:if test="${jum+0 >= 70}"><c:set var="grade" value="C"/></c:if>
			    <c:if test="${jum+0 >= 80}"><c:set var="grade" value="B"/></c:if>
			    <c:if test="${jum+0 >= 90}"><c:set var="grade" value="A"/></c:if>
			    <c:if test="${jum+0 < 60}"><c:set var="grade" value="F"/></c:if>
			    학점은 : ${grade}
			  </div>
			  <h3>다중조건비교 : choose ~ when</h3>
			  <pre>
			    사용법 :
			    < c : choose >
			      < c : when test="조건식1">수행할 내용1< / c:when >
			      < c : when test="조건식2">수행할 내용2< / c:when >
			      < c : when test="조건식3">수행할 내용3< / c:when >
			      < c : when test="조건식4">수행할 내용4< / c:when >
			      ~~~ ~~~ ~~~
			      < c : otherwise >기타 수행할 내용< / :otherwise >
			    < / c : choose >
			  </pre>
			  <div>학점은?
			    <c:choose>
			      <c:when test="${jum >= 90}">A</c:when>
			      <c:when test="${jum >= 80}">B</c:when>
			      <c:when test="${jum >= 70}">C</c:when>
			      <c:when test="${jum >= 60}">D</c:when>
			      <c:otherwise>F</c:otherwise>
			    </c:choose>
			  </div>
				<br/><br/>
				<h3>반복문(core라이브러리 사용... - forEach문)</h3>

			  <p>사용법1 :<br/> < c : forEach var="변수" begin="초기값" end="최종값" step="증감값" varStatus="매개변수" >
			    < /c : forEach ><br/>
			    <%-- <c:forEach var="i" begin="1" end="10" step="1">   step 1일경우는 생략가능 --%>
			    <c:forEach var="i" begin="1" end="10">
			      ${i} /
			    </c:forEach>
			  </p>
			  <p>	사용법2 :<br/> < c : forEach var="변수" items=" $ {객체명/배열}" varStatus="매개변수" >
			    < /c : forEach ><br/>
			<%
			    String[] cards = {"국민","BC","현대","삼성","비자","LG","농협"};
			    pageContext.setAttribute("cards", cards);
			%>
			    <c:forEach var="card" items="${cards}">
			    	${card} /
			    </c:forEach>
			  </p>
			  <p>사용법3 :<br/> < c : forTokens var="변수" items=" $ {객체명/배열}" delims="구분기호" >
			    < /c : forEach ><br/>
			    <c:set var="hobbys" value="등산/낚시/수영/바둑/바이크/승마/독서" />
			    취미 : ${hobbys}<br/>
			    <c:forTokens var="hobby" items="${hobbys}" delims="/">
			      ${hobby},
			    </c:forTokens>
			  </p>
			  <hr/>
			  <p><b>각종 사용예제</b><br/>
					-조건 : <br/>
					첫번째카드: 빨강색<br/>
					BC 카드 : 파랑색<br/> 
					삼성 : 빨강색 <br/>
					마지막 카드는 파랑색<br/>
				  <c:forEach var="card" items="${cards}" varStatus="st">
				    <c:if test="${st.first}"> <font color ="red"> </c:if>
				  	<c:if test="${st.last}"> <font color ="blue"> </c:if>
				  	<c:if test="${card == 'BC'}"> <font color ="blue"> </c:if>
				  	<c:if test="${card == '삼성'}"> <font color ="red"> </c:if>
				  	
				  	<br/>${st.index}(${st.count}).${card} 	
				  	
				  	<c:if test="${card == 'BC' || card == '삼성'}"> </font > </c:if>
				  	<c:if test="${st.first || st.last}"> </font > </c:if>
				  </c:forEach>
			  </p><br/>
			  
			  


				<%}	else { %>
						  <h2>이곳은 메인 화면(Home) 입니다.</h2>
						 	<% 	out.println("이미지 5개 출력");	%>
							<div>
							  <p>
							    <%
							    	for(int i=1; i<=5; i++) {
							    		out.println("<img src='"+request.getContextPath()+"/images/"+i+".jpg' width='200px' /> &nbsp;");
							    	}
							    %>
							  </p>
							</div>	
				<%  } %>
			</div>

		</div>	
	<p><br/></p>
	
	

</body>
	
</html>
