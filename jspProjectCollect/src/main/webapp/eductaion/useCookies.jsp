<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%
  String strType = request.getParameter("type")==null ? "" : request.getParameter("type");
	
	String id = request.getParameter("cId")== null ? "" : request.getParameter("cId");
	String pswd = request.getParameter("cPswd")== null ? "" : request.getParameter("cPswd");

%>

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width , initial-scale=1">
	<title>sample</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>

<body>
	<p><br/></p>
		<div class="container">
				<%  if(strType.equals("save")) { %>
				<h2> 쿠키 저장 </h2>
				<%
			    Cookie cookieId = new Cookie("cId", id);	    
			    cookieId.setMaxAge(60*60*24);	// 쿠키의 만료시간(초) : 60*60*24  - 1일
	
			    Cookie cookiePwd = new Cookie("cPswd", pswd);
			    cookiePwd.setMaxAge(60*60*24);
				  out.println("id : " + id);
				  out.println("pswd : " + pswd);

			    response.addCookie(cookieId);
			    response.addCookie(cookiePwd);			  
				  out.println("저장완료<br/>");
				%>
			  <p>
			    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
			  </p>
				<%  } else if(strType.equals("Check")){ %>
				  <h2>저장된 쿠키 확인하기</h2>
				  <hr/>
				<%
				  Cookie[] cookies = request.getCookies();
				
				  out.println("저장된 쿠키는?<br/>");
				  for(int i=0; i<cookies.length; i++) {
				  	out.println("쿠키명 : " + cookies[i].getName() + " <br/> ");
				  	out.println("쿠키값 : " + cookies[i].getValue() + " <br/> ");
				  	out.println("만료시간 : " + cookies[i].getMaxAge() + " <br/> <hr/>");
				  }
				
				%>
				  <hr/>
				  <p>
				    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
				  </p>
				<%  } else if(strType.equals("Delete")){ %>
					<h2> 쿠키 정보 제거 </h2>
				<% // 쿠키 정보 제거 
				  Cookie[] cookies = request.getCookies();
	
					for(int i=0; i<cookies.length; i++) {
						// 재사용이 불가능하도록 다른 값읖 덮어쓰고 날려버린다.
						cookies[i].setPath("/");
		        cookies[i].setValue("");
						cookies[i].setMaxAge(0);
						response.addCookie(cookies[i]);
					}
				%>
				  <hr/>
				  <p>
				    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
				  </p>
				<%  } else if(strType.equals("PwdDelete")){ %>
					<h2>쿠키 비밀번호 제거 </h2>
					<%
					// 쿠키 비밀번호 제거 
					  Cookie[] cookies = request.getCookies();
						for(int i=0; i<cookies.length; i++) {
							if(cookies[i].getName().equals("cPswd")) {
								cookies[i].setMaxAge(0);
								response.addCookie(cookies[i]);
							}
						}
					%>
				  <hr/>
				  <p>
				    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
				  </p>
				<%}	else { %>
					<h2>기타</h2>
				  <hr/>
				  <p>
				    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
				  </p>
				<%  } %>

		</div>	
	<p><br/></p>
</body>
	
</html>
