<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<%
  String strType = request.getParameter("type")==null ? "" : request.getParameter("type");
	
	String id = request.getParameter("sId")== null ? "" : request.getParameter("sId");
	String nickName = request.getParameter("sNickName")== null ? "" : request.getParameter("sNickName");

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
					<h2> 세션 저장 </h2>
						<%
					  request.setCharacterEncoding("utf-8");
						// 세션값 저장하기..... session.setAttribute("세션변수", 값)
							
						System.out.println("sId : " + id);
						System.out.println("sNickName : " + nickName);
						
						session.setAttribute("sId", id);
						session.setAttribute("sNickName", nickName);

					%>
					<hr/>
				  <p>
				    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
				  </p>
				<%  } else if(strType.equals("Check")){ %>
				  <h2>저장된 세션 확인하기</h2>
					<%
					  request.setCharacterEncoding("utf-8");
			
					  id = (String) session.getAttribute("sId");
					  nickName = (String) session.getAttribute("sNickName");
					  Enumeration names = session.getAttributeNames();
					  
				  	out.println("<hr/><br/>");
					  while(names.hasMoreElements()) {
					  	String sName = (String) names.nextElement();
					  	out.println("세션이름 : " + sName + "<br/>");
					  }
					%>
						<hr/><br/>
					  <h2>세션값 출력?</h2><br/>
					  <p>아이디 : <%=id %></p>
					  <p>닉네임 : <%=nickName %></p>
				  <hr/>
				  <p>
				    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
				  </p>
				<%  } else if(strType.equals("Delete")){ %>
					<h2> 세션 정보 제거 </h2>
					<% // 현재 브라우저에 생성되어 있는 모든 세션 제거
				  	session.invalidate();	
						response.sendRedirect("BaseType.jsp?flag=DataCtr"); // 제거 후 바로 복귀
					%>
				  <hr/>
				  <p>
				    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
				  </p>
				<%  } else if(strType.equals("IdDelete")){ %>
					<h2>세션 아이디 제거 </h2>
						<%
							session.removeAttribute("sId");
							response.sendRedirect("BaseType.jsp?flag=DataCtr"); // 제거 후 바로 복귀 ㅔ
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
