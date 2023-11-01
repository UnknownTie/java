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
</head>
	
<body>
	<p><br/></p>
		<div class="container">
		
			<form method="post" action="<%= request.getContextPath() %>/HtmlChange" enctype="multipart/form-data">
				<input type="file" name="file"><br>
				<input type="submit" value="Upload">
			</form>
				
			<form name="myform" method="post" action="<%= request.getContextPath() %>/HtmlChange">
			  <input type="file" name="filePath" id="filePath" accept=".html,.txt" onchange=" document.getElementById('filePath').value = this.value" required/>
			  <input type="submit">
			  <input type="hidden" name="path" value="<%= request.getRequestURI() %>" />
			</form>

		</div>	
	<p><br/></p>
</body>
	
</html>