<!-- -->
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width , initial-scale=1">
	<title>test1.jsp</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
  <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
 
 	<style>
	 	/* css 주석 */
 	</style>
  
  <script>
	  // js 1줄 주석 
	  /* js 여러줄 주석 */
  </script>
  
 
</head>

<body>
	<p><br/></p>

		<div class="container">
			<div>
			<h2>JSP 주석 정리</h2>
				<!-- HTML 주석 -->
				<%-- JSP 주석 (본문) --%>

  			<%-- JSP 주석 : 파싱 이후 생성된 HTML에 삽입 X --%>
  		</div>	
  		
  		<div>  		
  			<h2>JAVA Code 사용</h2>
  			<%
  				//스크립틀릿(scriptlet)
  				//java 코드 작성 
  				System.out.println("이곳은 JSP , java 코드 출력 ");
  				
  			%>
  		</div>	
		</div>	
		
		
		
	<p><br/></p>
</body>
	
</html>
