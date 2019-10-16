<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.chavis.biz.vo.BodyshopVO"%>
<%@ page import="com.chavis.biz.vo.ReservationVO"%>
<%@ page import="com.chavis.biz.vo.WebTableVO"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>

<%
	if (session.getAttribute("bodyshop") == null) {
		response.sendRedirect("logout.jsp");
	}
	BodyshopVO bodyshop = (BodyshopVO) session.getAttribute("bodyshop");
	Map<Integer, Integer> chartData = (Map<Integer, Integer>) session.getAttribute("chartData");
	List<WebTableVO> tableData = (List<WebTableVO>) session.getAttribute("tableData");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chavis 정비소용 웹 페이지입니다</title>
<script>
	window.onload = function() {

		var chart = new CanvasJS.Chart("chartContainer", {
			animationEnabled : true,
			exportEnabled : true,
			data : [ {
				type : "column",
				indexLabel : "{y}",
				indexLabelFontColor : "#5A5757",
				indexLabelPlacement : "outside",
				dataPoints : [ {
					y :
<%=chartData.get("0~6")%>
	,
					label : "자정 ~ 오전 06시"
				}, {
					y :
<%=chartData.get("6~12")%>
	,
					label : "오전 06시 ~ 정오"
				}, {
					y :
<%=chartData.get("12~18")%>
	,
					label : "정오 ~ 오후 06시"
				}, {
					y :
<%=chartData.get("18~24")%>
	,
					label : "오후 06시 ~ 자정"
				}, ]
			} ]
		});
		chart.render();

	}
</script>
</head>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
</head>
<body>

	<header> 오늘의 예약 </header>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>


	<div class="main-card mb-3 card">
		<div class="card-body">
			<table class="mb-0 table">
				<thead>
					<tr>
						<th>예약 시간</th>
						<th>회원 이름</th>
						<th>회원 연락처</th>
						<th>차번호</th>
						<th>차종</th>
						<th>원격키</th>
						<th>정비사 이름</th>
						<th>작업 완료 시간</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (WebTableVO row : tableData) {
					%>
					<tr>
						<th><%=row.getReservation_time()%></th>
						<th><%=row.getMember_mname()%></th>
						<th><%=row.getMember_phonenumber()%></th>
						<th><%=row.getCar_id()%></th>
						<th><%=row.getCar_type()%></th>
						<th><%=row.getKey()%></th>
						<th><%=row.getRepaired_person()%></th>
						<th><%=row.getRepaired_time()%></th>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>