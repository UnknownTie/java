<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@page import="java.util.Enumeration"%>
<%
request.setCharacterEncoding("utf-8");

  String strType = request.getParameter("type")==null ? "" : request.getParameter("type");
	
	String id = request.getParameter("aId")==null ? "guest" : request.getParameter("aId");
	String name = request.getParameter("aName")==null ? "방문자" : request.getParameter("aName");

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
					<h2> Application 저장 </h2>
				<%
					application.setAttribute("aMid", id);
					application.setAttribute("aName", name);
					response.sendRedirect("BaseType.jsp?flag=DataCtr"); // 제거 후 바로 복귀
				%>
					<hr/>
				  <p>
				    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
				  </p>
				<%  } else if(strType.equals("Check")){ %>
			  <h2>저장된 Application 확인하기</h2>
				<%
				  Enumeration names = application.getAttributeNames();
					
					while(names.hasMoreElements()) {
						name = (String) names.nextElement();
						out.println("어플리케이션명 : " + name + "<br/>");
					}
					out.println("<br/><hr/>");
				  id = (String) application.getAttribute("aMid");
				  name = (String) application.getAttribute("aName");
				%>
			  <h2>세션값 출력?</h2>
			  <p>아이디 : <%=id %></p>
			  <p>성명 : <%=name %></p>
			  <hr/>
			  <p>
			    <a href="BaseType.jsp?flag=DataCtr" class="btn btn-secondary">돌아가기</a>
			  </p>
				<%  } else if(strType.equals("IdDelete")){ %>
				<h2>Application Id 제거 </h2>
				<%
					application.removeAttribute("aMid");
					response.sendRedirect("BaseType.jsp?flag=DataCtr"); // 제거 후 바로 복귀
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
