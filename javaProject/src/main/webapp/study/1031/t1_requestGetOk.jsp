<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- t1_requestGetOk.jsp -->
<%
  request.setCharacterEncoding("utf-8");

	String[] hobbys = request.getParameterValues("hobby");
	
	String hobby = "";
	for(String h : hobbys) {
		hobby += h + "/";
	}
	hobby = hobby.substring(0, hobby.length()-1);
%>
<p>전송된 값</p>
<p>성명 : <%=request.getParameter("name")%></p>
<p>취미 : <%=hobby%></p>
<p>호스트IP1 : <%=request.getParameter("hostIp") %></p> <!-- DB에 저장할려면 해당 방식으로 가져와야된다. -->
<p>호스트IP2 : <%=request.getRemoteAddr() %></p>
<p>전송방식 : <%=request.getMethod()%></p>
<p>접속 프로토콜 : <%=request.getProtocol() %></p>
<p>접속 서버이름 : <%=request.getServerName() %></p>
<p>접속 서버포트 : <%=request.getServerPort() %></p> <!-- port명이 다르면, 해킹이 진행중일수 있다. 체크 필요 -->
<p>접속 Context명 : <%=request.getContextPath() %></p>
<p>URL : <%=request.getRequestURL() %></p>
<p>URI : <%=request.getRequestURI() %></p>
<p></p>
<p><input type="button" value="돌아가기" onclick="history.back()" /></p>