<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
  
   <script>
    'use strict';
    
    function fCheck() {

 			myform.submit();
    }
  </script>
  
</head>

<body>
	<p><br/></p>
		<div class="container">
			<div >
			  <h2>값의 전송(GET/POST) 전송하기</h2>
			  <form name="myform" method="post" action="<%= request.getContextPath() %>/connDB">

			  	<div>아이디
			  	  <input type="text" name="id" class="form-control mb-3" autofocus />
			  	</div>
			  	<div>비밀번호
			  	  <input type="password" name="pswd" id="pswd" class="form-control mb-3" />
			  	</div>
			  	<div>
			  	  <input type="button" value="전송(button)" onclick="fCheck()" class="btn btn-primary form-control" />
			  	</div>
			  	<!-- <input type="hidden" name="path" value="<%= request.getRequestURL() %>" /> -->
			  		<input type="hidden" name="path" value="<%= request.getRequestURI() %>" />
			  </form>
			</div>

		</div>	
	<p><br/></p>
</body>
	
</html>
