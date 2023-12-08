<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<jsp:include page="/include/linkCss.jsp" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width , initial-scale=1">
	<title>sample</title>
	
	<script >
		function JoinCk() {
			let id = $("#id").val();
			let pswd = $("#pswd").val();
			let pswdCk = $("#pswdCk").val();
			console.log("pswd : "+pswd);
			console.log("pswdCk : "+pswdCk);
		  if(id == ""){
			  alert("아이디를 입력하세요");
			  return;
		  }
			else if(pswd != pswdCk){
			  alert("비밀번호를 확인하세요");
			  return;
		  }
		  else{
				let query = {
						id  : id,
						pswd  : pswd
				}
				
				$.ajax({
					url  : "JoinCk.u",
					type : "post",
					data : query,
					success:function(res) {
						if(res == "1") alert("신청완료");
						else alert("이미 존재하는 아이디입니다.");
							location.reload();
					},
					error : function() {
						alert("전송오류!");
					}
				});
		  }
		}
	</script>

</head>

<body>
	<div class="container">
  <!-- ! Header -->
 	<jsp:include page="/include/header.jsp" />
	<main>
    <div class="JoginBox viewBox">
      <div class="title"> 
        <h2>가 입 신 청</h2>
      </div>
      <div class="Join">
        <form  action="/JoinCk.u" method="post" name="myform" >
          <input type="text" name="id"  id="id" placeholder="아이디" required/>
          <input type="password" name="pswd" id="pswd" placeholder="비밀번호" required/>
          <input type="password" name="pswdCk" id="pswdCk" placeholder="비밀번호 확인" required/>
          <input type="text" name="serial" id="serial" placeholder="시리얼번호" />
          <input type="text" style=" display: inline-block; height:20vh;" name="explain" id="explain" placeholder="참고" />
          <input type="button" onclick="JoinCk()" value="가입 신청"/>
          <input type="button" onclick="location.href='${ctp}/Login.u'" value="로그인 하기"/>
      </form>
      </div>
    </div>
  </main>
	    
	  <!-- ! Footer -->
	<jsp:include page="/include/footer.jsp" />

	</div>

	
</body>
	
</html>


