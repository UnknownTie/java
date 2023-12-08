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
	
	<script type="text/javascript">
		'use strict'
	  
        // 페이징 처리를 위한 함수(등급별 조회나 페이지사이즈별 조회나 다음페이지 이전페이지 조회시 이 함수를 부른다)
        // currentPage  : 현재 페이지 
        // paging : 출력할 id 
        // record : 테이블에 id 지정한 위치
        // vlevel : 출력할 아이디 등급 범위 
        
        let currentPage = 1;
        let pageSize = 10;

        function paging(level) {
        	
            $('.record').show();
            let records = $('.record:visible');
            let totalRecord = records.length;
            let totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : parseInt(totalRecord/pageSize) + 1;
            let startIndex = (currentPage - 1) * pageSize;
            let pagedRecords = records.slice(startIndex, parseInt(startIndex) + parseInt(pageSize));
            // 전체 레코드를 다시 hide하고
            $('.record').hide();
            // 현재 페이지에 해당하는 레코드를 show 시킨다.
            for(let record of pagedRecords) {
                record.style.display = 'table-row';
            }
            
            //페이징 시작 
            let str ="";
            
            if(currentPage>1)
            	str += "<a href = 'javascript:pagCh("+(currentPage-1)+")'>이전</a> ";
           	else
              str += "<span>  </span>";
                	
            // 전체 사이즈 < 버튼 보이는 기준
            // 버튼 보이는 기준 = 전체 사이즈
            // 좌우 분할 :  버튼 보이는 기준 /2
						let nPageType = 5; 
            
						if(nPageType > totalPage)
							nPageType = totalPage;
						
            let nvPage = (nPageType/2); 
            nvPage = Math.trunc(nvPage);// 소수점 예외 처리   
            if(nvPage < 1)
            	nvPage = 1; 

            let nSPage = currentPage - nvPage;
            let nEPage = currentPage + nvPage ;

            if(nSPage < 1){
            	nSPage = 1; // 최소 시작 페이지
            	nEPage = nPageType; 
            	if(nEPage > totalPage) // 최대 끝 페이지
            		nEPage = totalPage; 
            }    


            if(nEPage > totalPage){
            	nSPage = currentPage - nvPage - 1; // currentPage의 나자신도 제외
            	if(nSPage < 1) // 최소 시작 페이지
            		nSPage = 1; 
            	nEPage = totalPage;
            }

						//페이지 버튼 생성 
            for(let i = nSPage; i<= nEPage;i++){	
                str += " <a href = 'javascript:pagCh("+i+")'";
            		if(i == currentPage)
            		  str += " style='color:red'>"+i+"</a> ";
          		  else
       	          str += " >"+i+"</a> ";
            }
						
            if(currentPage<totalPage)
            	str += " <a href = 'javascript:pagCh("+(currentPage+1)+")'>다음</a> ";
           	else
              str += "<span>  </span>";
            $('#paging').html(str);
        }
        
        // 등급별조회(현재페이지를 1로 초기화해야함)
        function vLevelChange(currentP) {
       	 		currentPage = 1;
       	    let d = new Date();
	       	  let dYear = leadingZeros(d.getFullYear(), 4);
	       	  let dMonth = leadingZeros(d.getMonth() + 1, 2);
	       	  let dDay = leadingZeros(d.getDate(), 2);
	       	  
       	 		let s =
       	 		dYear + '-' +
	       	 	dMonth + '-' +
	       	 	dDay ;
       	 		
            paging("");
        }
        
        // 페이지 사이즈 변경
        function pageSizeChange() {
        	 currentPage = 1;
           pageSize = $('#pageSize').val();
           paging("");
        }
        
        function pagCh(currentP) {
            currentPage = currentP;
            paging("");
        }
        
        // 모든 리소스가 로드되고 나서 최초 한번 실행되는 페이징처리
        $(function() {
            paging("");
        });
	</script>
	
	
	<script type="text/javascript">
		'use strict'
			
		let memoIdx = 0;
		let MemoDayCk = ${toYear}-${toMonth+1}-${toDay};
		
		function scheduleMemo(day){
			MemoDayCk = day;

		  let str = '<div class="memoDay" id="memoDay" name="memoDay" >'+day+'</div>';
			$("#memoDay").html(str);
			
			console.log("day");
			console.log(day);
			let vos = Array();
			vos = ${ScheduleVOS};
			console.log("vos");
			console.log(vos);
			
			for(let i=0 ;i<vos.length  ;  i++){
				if(vos[i].time.substring(0,10) == day){
					$('#memoBox').val(vos[i].memo);
					console.log('#memoBox');
					console.log(vos[i].memo);
					memoIdx = vos[i].idx;
					return;
				}
			}			
			
			$('#memoBox').val("");
			memoIdx=0;
		}
		
		function scheduleMemoCk(){
			let vos = Array();
			vos = ${ScheduleVOS};

			for(let i=0 ;i<vos.length  ;  i++){
				if(vos[i].Memo !="")
      		document.getElementById(vos[i].time.substring(0,10)).style.color="#f00";
			}	
		}
		
    $(function() {
    	scheduleMemoCk();
    });
    

	    // 일정 등록하기
	    function scheduleInputOk() {

	    	let memo = $('#memoBox').val();
	    	let date = MemoDayCk;

	    	if(memo.trim() == "") {
	    		alert("일정을 입력하세요");
	    		scheduleForm.content.focus();
	    		return false;
	    	}
	    	
	    	console.log("productSerial");
	    	console.log(${productSerial});
	    	
	    	let query = {
	    			memoIdx : memoIdx,
	    			date  : MemoDayCk,
	    			productSerial  : '${productSerial}',
	    			memo: memo
	    	}    	
	    	$.ajax({
	    		url  : "ScheduleOk.bp",
	    		type : "post",
	    		data : query,
	    		success:function(res) {
	    			if(res == "1") {
	    				alert("일정이 등록되었습니다.");
	    				location.reload();
	    				$('#memoBox').load(location.href+'#memoBox'); 
	    			}
	    			else alert("등록 실패~~");
	    		},
	    		error : function() {
	    			alert("전송오류!");
	    		}
	    	});
	    }
		
	    
	    function reLoadDate(yy , mm){
	    	//시간 단위 끝내고 다시 시도
	/*     	let str = '';
	    	str+=' <button type="button" onclick="reLoadDate('+yy+','+mm+');" title="이전년도">이전년도</button>';
	    	str+='<font>${yy}년</font>';
	    	str+='<button type="button" onclick="reLoadDate('+(yy+1)+','+mm+');" title="다음년도">다음년도</button>';
	    	str+=' &nbsp;&nbsp;	&nbsp;';
    		str+='<button type="button" onclick="reLoadDate('+(yy-1)+','+mm+');" title="이전월">이전월</button>';
    		str+='<font>'+(mm+1)+'월</font>';
   			str+='<button type="button" onclick="reLoadDate('+(yy-1)+','+mm+');" title="다음월">다음월</button>';

	    	$("#Month").html(str); */
	    	
	    }
	    
		

			
	</script>
	<script type="text/javascript">
	'use strict'

		function vLevelChange(level){
		
		}
	</script>
		
		
</head>

<body>
	<div class="container">

		<!-- ! Header -->
	 	<jsp:include page="/include/header.jsp" />
<%-- 		<form  action="BuyProductView.bp" method="post" name="myform${vo.idx}" class="logform">
	    <input type="hidden" name="productSerial" value="${vo.productsSerial}" />
	    <input type="hidden" name="productIdx" value="${vo.productsIdx}" />
	    <input type="hidden" name="productName" value="${productName}" />
	    <input type="hidden" name="address" value="${vo.address}" />
	    <input type="hidden" name="temp" value="${vo.temp}" />
	    <input type="hidden" name="humid" value="${vo.humid}" />
	    <input type="hidden" name="state" value="${vo.state}" />
	    <input type="hidden" name="ckTime" value="${fn:substring(vo.ckTime,0,10)}" />
	    
	    <input type="hidden" name="yy" value="${yy}" />
	    <input type="hidden" name="mm" value="${mm}" />
	    <input type="hidden" name="period" value="${period}" />
 		</form> --%>
 		
		<main>
    	<!-- 상품 list 예시 -->
		  <div class="swiper han1 visual" >
		    <div class="swiper-wrapper">
					<%-- <c:forEach var="vo" items="${vos}" varStatus="st"> --%>
				 	<c:forEach begin="1" end="2" varStatus="st">  
					<div class="swiper-slide slide">
		      	<div class="title" style="margin-top: 1vh;"><h2>${productName} :  ${address}</h2></div>
			
						<div class="DeviceBox viewBox" >
	            <div class="top">
	              <div  class="contents">
	                <div class="photo">
		               	<img src="${ctp}/images/product/tempDevice.png" >
	                </div>
	                
	                <div  class="desc">
	               		<div class="btnA"  > 
	               		 디바이스 수정
	               		</div>
	                </div>
	          
	
	              </div>
	              <div  class="contents">
	                <div  class="dayView" id="dayView">


	                  <div  class="Month" id="Month">
	                     	<font>${yy}년</font>	    <font>${mm+1}월</font>
	                     	
									<%-- 	                  
	                    <button type="button" onclick="reLoadDate('${yy-1}','${mm}');" title="이전년도">이전년도</button>
									   	<font>${yy}년</font>
									    <button type="button" onclick="reLoadDate('${yy+1}','${mm}');" title="다음년도">다음년도</button>
									    &nbsp;&nbsp;	&nbsp;
									    <button type="button" onclick="reLoadDate('${yy-1}','${mm}');" title="이전월">이전월</button>
									    <font>${mm+1}월</font>
									    <button type="button" onclick="location.href='${ctp}/BuyProductView.dp?yy=${yy}&mm=${mm+1}';" title="다음월">다음월</button>
									    <button type="button" onclick="location.href='schedule.sc';" style="background-color: #2a2; color:#eee; border: none" title="오늘날짜">오늘</button>
	               --%>  
  									</div>
	                  
	                  <table>
                      <tr >
							        	<th style="width:14%; vertical-align:middle; color:red">일</th>
								        <th style="width:14%; vertical-align:middle;">월</th>
								        <th style="width:14%; vertical-align:middle;">화</th>
								        <th style="width:14%; vertical-align:middle;">수</th>
								        <th style="width:14%; vertical-align:middle;">목</th>
								        <th style="width:14%; vertical-align:middle;">금</th>
								        <th style="width:14%; vertical-align:middle; color:#88f">토</th>
								      </tr>
								      <c:forEach var="prevDay" begin="${prevLastDay - (startWeek - 2)}" end="${prevLastDay}" varStatus="st">
							          <td style="font-size:0.6em;background-color: #aaa;color:#000;">${prevMonth+1}.${prevDay}</td>
							        </c:forEach>
	                  	<c:set var="cell" value="${startWeek}" />
	                  	
							        <c:forEach begin="1" end="${lastDay}" varStatus="st">
							          <c:set var="todaySw" value="${toYear==yy && toMonth==mm && toDay==st.count ? 1 : 0}"/>
							          <td id="td${cell}" ${todaySw==1 ? 'class=today' : ''} >
							          	
							          	<c:if test="${st.count < 10}">
							          		<c:set var="ymd" value="${yy}-${mm+1}-0${st.count}"/>
							          	</c:if>
							           <c:if test="${st.count >= 10}">
							          		<c:set var="ymd" value="${yy}-${mm+1}-${st.count}"/>
							          	</c:if>
							          	<div class="${ymd}"></div>
							            <a href="javascript:scheduleMemo('${ymd}')" id="${ymd}">${st.count}</a><br/>
							          </td>
							          
							          <c:if test="${cell % 7 == 0}"></tr><tr></c:if>
							          <c:set var="cell" value="${cell + 1}" />
							        </c:forEach>
							        
							                <!-- 마지막일 이후를 다음달의 시작일자부터 채워준다. -->
							        <c:if test="${(cell - 1) % 7 != 0}">
							          <c:forEach var="nextDay" begin="${nextStartWeek}" end="7" varStatus="st">
							            <td style="font-size:0.6em;background-color: #aaa;color:#000; ">${nextMonth+1}.${st.count}</td>
							          </c:forEach>
							        </c:if>
	                  </table>
	                </div>
	                <div  class="desc">
	                	<div class="memo">
	                	
	                	 <div id="memoDay" name="memoDay"  class="memoDay">${yy}-${mm+1}-${toDay}</div>
                    	<textarea class="memoBox" name="memoBox" id="memoBox" value="일정" required></textarea>
			                <div  class="periodBtn" onclick="scheduleInputOk()"> 등록 </div> 
	                	</div>	
	                	
                 
	                </div>
	              </div>
	            </div>
	            <div  class="center" >
	              <div  class="contents">
	              <!-- 다른 방식 사용 여부 확인 필요 -->
	              <table>
	                <tr>
	                  <td>온도</td>
	                  <td>${temp} </td>
	                  <td>습도</td>
	                  <td>${humid}</td>
	                  <!-- <td>상태</td> -->
	                  <c:if test="${state}"> <td>정상</td></c:if>
	                  <c:if test="${!state}"><td style="background-color: #d22;">이상</td>   </c:if>
		                <td>시간</td>
	                  <td style="width:15vw">${ckTime}</td>
	                </tr>
	              </table>
	              </div>
	              <div  class="contents">
	                <div  class="periodBtn period1w" onclick="vLevelChange(1)">
	                  1주
	                </div>
	                <div  class="periodBtn period1m" onclick="vLevelChange(2)">
	                  1개월
	                </div>
	                <div  class="periodBtn period3m" onclick="vLevelChange(3)">
	                  3개월
	                </div>
	                <div  class="periodBtn periodAll" onclick="vLevelChange(4)">
	                  전체
	                </div>
	              </div>
	            </div>
	            <div  class="bottom" >
	              <div  class="contents">
	                <div class="chartView" id="chartViewA">
	                  차트
	                </div>
	              </div>
	              <div  class="contents">
	                <div class="chartView" >
	                   <table >
   					            <tr>
													<td >번호</td>
					                <td >온도</td>
					                <td >습도</td>
					                <td >상태</td>
					                <td >시간</td>
						            </tr>
                     <c:forEach var = "vo" items = "${vos}" varStatus = "st">
						            <tr class = "record">
													<td >${st.count}</td>
					                <td >${vo.temp}</td>
					                <td >${vo.humid}</td>
				                  <c:if test="${vo.state}"> <td style=" background-color:#2d2;">정상</td></c:if>
				                  <c:if test="${!vo.state}"><td style="background-color: #d22;">이상</td>   </c:if>
					                <td >${fn:substring(vo.ckTime,0,10)} </td>    
						            </tr>
										    <c:set var="CkTimes" value="${CkTimes},new Date('${vo.ckTime}')"/>
										    <c:set var="Tmeps" value="${Tmeps},new Date('${vo.temp}')"/>
										    <c:set var="humids" value="${humids},new Date('${vo.humid}')"/>
										    
										    <c:if test="${st.count}==1"> 
										     <c:set var="charviewB" value="[${CkTimes},${Tmeps},${humids}],"/>
										    </c:if>
										    <c:if test="${st.count}!=1"> 
										     <c:set var="charviewB" value="${charviewB}[${CkTimes},${Tmeps},${humids}],"/>
										    </c:if>
						        </c:forEach>
						        
                    <c:if test="${fn:length(vo)<=0}"> 
					            <tr class = "record">
												<td ></td>
				                <td ></td>
				                <td ></td>
			                 	<td style="background-color: #d22;">데이터 미입력</td>
				                <td ></td>    
					            </tr>
					          </c:if>
						        </table>
       								<br/><br/>	
	       					  <div id="paging" style="z-index:100"> </div>
	                  <!-- js 생성 -->
	                </div>
	              </div>
	            </div>
	          </div>
          </div>
			  	</c:forEach>
			  	<!-- 총 길이가 페이지 하나가 마무리 되지 않았다면, div 처리 -->
	<%-- 	  		<c:if test="${fn:length(vos) % 2 != 0}">
			     	</div>
					</c:if>  --%>
		  	</div>
<!-- 				<div class="swiper-button-next"></div>
	      <div class="swiper-button-prev"></div>
	      <div class="swiper-pagination"></div> -->
		  </div>
	  </main>
		    
		  <!-- ! Footer -->
		<jsp:include page="/include/footer.jsp" />
	</div>
	
      <script src="https://cdnjs.cloudflare.com/ajax/libs/dygraph/2.1.0/dygraph.min.js"></script>
      <script>
            g = new Dygraph(
                document.getElementById("chartViewA"),[
                  <c:forEach var="vo" items="${vos}" varStatus="st"> 
	                  [new Date('${vo.ckTime}')  // X축 시간
	                  <c:if test="${vo.temp<=0}">  
	                  	,null
	                  </c:if>
	    							<c:if test="${vo.temp>0}">  
	    								,${vo.temp} //Y축 온도
	                  </c:if>
	                  
	                  <c:if test="${vo.humid<=0}">  
	                 	 ,null
	                  </c:if>
	    							<c:if test="${vo.humid>0}">  
	    								,${vo.humid} //Y축 습도
	                  </c:if>
	                  ],
                	</c:forEach>
                	],
                    {
                    legend: "always",
                    animatedZooms: true,
                    drawPoints: true,
                    includeZero : true ,
                    labels: [ "시간", "온도", "습도" ],
                    strokeWidth: 0.0,
                    valueRange: [3, 50],
                    colors: ["red" ,"blue" ],
                    series: {
                            "온도": {
                                axis: "y",
                                drawGrid: true,
                                independentTicks: true,
                                },
                            "전압": {
                                axis: "y2",
                                rollPeriod: 7,
                                errorBars: true,
                                }
                            },
                    axes: {
                            y: {
                                // Left y-axis options
                                valueRange: [0, 100],
                                axisLabelColor: "blue",
                                axisLineColor: "blue",
                            },
                            y2: {
                                // Right y-axis options
                                independentTicks: true,
                                valueRange: [0, 30],
                                axisLabelColor: "red",
                                axisLineColor: "red",
                            },            
                        }
                    });  
        </script>
	
</body>
	
</html>


