<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");

	String[] hobbys = request.getParameterValues("hobby");
	
	String strhobby = "";
	for(String h : hobbys) {
		strhobby += h + "/";
	}
	strhobby = strhobby.substring(0, strhobby.length()-1);
%>

<jsp:useBean id="dto" class="newEductaion.DtoTest" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>JSP DTO 테스트</title>
  
  <jsp:setProperty property="*" name="dto" />
  
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
  <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/test.css" >
  
</head>

<body>
<p><br/></p>
<div class="container">
  <h2>처리된 자료를 View에 출력시켜보자</h2>
  <table class="table table-bordered">
  	<tr>
  		<td>자료명</td>
  		<td>EL param</td>
  		<td>java DTO</td>
  	</tr>
    <tr>
      <td>성명</td>
      <td>${param.name}</td>
      <td>${dto.name}</td>
    </tr>
    <tr>
      <th>나이</th>
      <td>${param.age}</td>
      <td>${dto.age}</td>
    </tr>
    <tr>
      <th>성별</th>
      <td>${param.gender}</td>
      <td>${dto.gender}</td>
    </tr>
    <tr>
      <th>취미</th>
      <td style="color:blue;">${param.hobby}</td>
      <td style="color:blue;">${dto.hobby}</td>
    </tr>
    <tr>
      <th>직업</th>
      <td >${param.job}</td>
      <td>${dto.job}</td>
    </tr>
    <tr>
      <th>주소</th>
      <td>${param.address}</td>
      <td>${dto.address}</td>
    </tr>
  </table>
  
  <p>전송된 값</p>
	<p>성명 : <%=request.getParameter("name")%></p>
	<p style="color:blue;">취미 : <%=strhobby%></p>
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
  
  <p><a href="${param.path}" class="btn btn-success">돌아가기</a></p>
</div>
<p><br/></p>
</body>
</html>
