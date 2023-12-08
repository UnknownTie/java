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

		    <c:if test="${!empty vos}">
					<c:forEach var="vo" items="${vos}" varStatus="st">
					 	<%-- <c:forEach begin="1" end="8" varStatus="st">  --%>
						<!-- 한페이지에 3개씩 -->
						<c:if test="${st.count % 2 == 1}">
			        <div class="swiper-slide slide">
			        	<div class="title" style="margin-top: 1vh;"><h2>제 품</h2></div>
						</c:if>
						
						<form  action="BuyProductView.bp" method="post" name="myform${vo.idx}" class="logform">
						    <input type="hidden" name="productSerial" value="${vo.productsSerial}" />
						    <input type="hidden" name="productIdx" value="${vo.productsIdx}" />
						    <input type="hidden" name="productName" value="${productName}" />
						    <input type="hidden" name="address" value="${vo.address}" />
						    <input type="hidden" name="temp" value="${vo.temp}" />
						    <input type="hidden" name="humid" value="${vo.humid}" />
						    <input type="hidden" name="state" value="${vo.state}" />
						    <input type="hidden" name="ckTime" value="${fn:substring(vo.ckTime,0,10)}" />
          	</form>
          	
	          <div class="DeviceListBox viewBox Boxhover" onclick="location.href='javascript:document.myform${vo.idx}.submit();'"  >
	            <div class="top">
 
              <button class="ChangeBtn"  onclick="location.href='#'">
                디바이스 정보
              </button>
              
            </div>

            <div class="center">
              <div  class="photo">
                ${vo.photo}

                <div  class="btnL">
                  ${productName}
                </div>
                <div  class="btnR">
                   ${vo.address}
                </div>
              </div>
              <!-- 다른 방식 사용 여부 확인 필요 -->
              <table>
                <tr>
                  <td>온도</td>
                  <td>${vo.temp}</td>
                  <td>습도</td>
                  <td>${vo.humid}</td>
                  <!-- <td>상태</td> -->
                  <c:if test="${vo.state}"> <td>정상</td></c:if>
                  <c:if test="${!vo.state}"><td style="background-color: #d22;">이상</td>   </c:if>
                  <td>시간</td>
                  <td style="width:15vw">${fn:substring(vo.ckTime,0,10)}</td>
                </tr>
              </table>
            </div>

            <div class="bottom">
              <div class="chartView" id="chartView${st.count}">
                차트
              </div>
            </div>

            </div>
						<!-- 한페이지에 3개씩 -->
					  <c:if test="${st.count % 2 == 0}">
				     	</div>
						</c:if>
			  	</c:forEach>
			  	<!-- 총 길이가 페이지 하나가 마무리 되지 않았다면, div 처리 -->
		  		<c:if test="${fn:length(vos) % 2 != 0}">
			     	</div>
					</c:if> 
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


