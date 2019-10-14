<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chavis 로그인 페이지</title>
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
			document.form1.action = "${path}/Member/login.do"
			document.form1.submit();
		});
	});
</script>
</head>
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
					<button type="button" id="btnLogin">로그인</button> <c:if
						test="${msg == 'failure }">
						<div style="color: red">
						아이디 또는 비밀번호가 일치하지 않습니다.
						</div>
					</c:if>
					<c:if test="${msg == 'logout'}">
						<div style="color: red">
							로그아웃하였습니다.
						</div>
					</c:if>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>