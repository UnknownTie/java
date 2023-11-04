<!-- -->
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
	
	  	function fCheck(testA) {
	  		console.log("checkDigit : " + testA);
		  }

	  </script>
	</head>


	<body>
		<p><br/></p>

			<div class="container">
				<form action="#">
				  <label for="lang">Language</label>
				  <select name="languages" id="lang" onchange="fCheck(this.value)"  >
				    <option value="1">1</option>
				    <option value="2">2</option>
				    <option value="3">4</option>
				    <option value="4">4</option>
				    <option value="5">5</option>
				  </select>
				  <input type="submit" value="Submit" />
				</form>
  		</div>	
		
		<p><br/></p>
	</body>
	
</html>

