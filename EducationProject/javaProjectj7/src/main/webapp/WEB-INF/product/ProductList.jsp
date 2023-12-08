<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctp" value="${pageContext.request.contextPath}" />
<jsp:include page="/include/linkCss.jsp" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width , initial-scale=1">
	<title>sample</title>

</head>

<body>
	<div class="container">

		<!-- ! Header -->
	 	<jsp:include page="/include/header.jsp" />

		<main>
    	<!-- 상품 list 예시 -->
		  <div class="swiper han1 visual" >
		    <div class="swiper-wrapper">
					<c:forEach var="vo" items="${vos}" varStatus="st">
					<%-- 	<c:forEach begin="1" end="8" varStatus="st"> --%>
						<!-- 한페이지에 3개씩 -->
						<c:if test="${st.count % 3 == 1}">
			        <div class="swiper-slide slide">
			        	<div class="title"><h2>제 품</h2></div>
						</c:if>
						
						<form  action="BuyProductList.bp" method="post" name="myform${vo.idx}" class="logform">
						    <input type="hidden" name="idx" value="${vo.idx}" />
						    <input type="hidden" name="productName" value="${vo.name}" />
						    
          	</form>
	          <div class="ProductBox viewBox Boxhover" onclick="location.href='javascript:document.myform${vo.idx}.submit();'"  >
	            <div  class="title" >
	              ${vo.name}
	            </div>
	            <div  class="desc" >
	              ${vo.explain}
	            </div>
	            <div  class="photo" >
	             <img src="${ctp}/images/product/${vo.photo}" style="width: 100%; height: 100%;"/>
	            </div>
	          </div>
						<!-- 한페이지에 3개씩 -->
					  <c:if test="${st.count % 3 == 0}">
				     	</div>
						</c:if>
			  	</c:forEach>
			  	<!-- 총 길이가 페이지 하나가 마무리 되지 않았다면, div 처리 -->
		  		<c:if test="${fn:length(vos) % 3 != 0}">
			     	</div>
					</c:if> 
		  	</div>
				<div class="swiper-button-next"></div>
	      <div class="swiper-button-prev"></div>
	      <div class="swiper-pagination"></div>
		  </div>
	  </main>
		    
		  <!-- ! Footer -->
		<jsp:include page="/include/footer.jsp" />
	</div>
	<!-- Initialize Swiper -->
  <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
	<script>
	  var swiper = new Swiper(".han1", {
	    slidesPerView: 1,
	    spaceBetween: 0,
	    loop: true,
	    pagination: {
	      el: ".swiper-pagination",
	      clickable: true,
	    },
	    navigation: {
	      nextEl: ".swiper-button-next",
	      prevEl: ".swiper-button-prev",
	    },
	  });

	</script>
	
</body>
	
</html>


