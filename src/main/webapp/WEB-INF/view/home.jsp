<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<title>Hello</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$('#btnLogin').click(function() {
			var bodyshop_id = $('#bodyshop_id').val();
			var bodyshop_pw = $('#bodyshop_pw').val();

			if (bodyshop_id == "") {
				alert("아이디를 입력하세요.");
				$("#bodyshop_id").focus();
				return;
			}
			if (bodyshop_pw == "") {
				alert("비밀번호를 입력하세요.");
				$("#bodyshop_pw").focus();
				return;
			}
			console.log(bodyshop_id);
			console.log(bodyshop_pw);
			document.form1.action = "${path}/Chavis/dashboard.do"
			document.form1.submit();
		});
	});
</script>
</head>
<link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">
<body>
	<h2>Chavis 로그인</h2>
	<form name="form1" method="POST">
		<table border="1" width="400px">
			<tr>
				<td>ID</td>
				<td><input name="bodyshop_id" id="bodyshop_id" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="bodyshop_pw" id="bodyshop_pw" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<button type="button" id="btnLogin">로그인</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>