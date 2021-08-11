<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>join</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

	});

	function vali() {
		var pw = $("#userPw").val();
		var pwVali = $("#pwVali").val();
		var postNo = /^\d{3}-\d{3}$/;
		var phone2 = /^\d{4}$/;
		var phone3 = /^\d{4}$/;
		if (pw.length < 6 || pw.length > 12) {
			alert("비밀번호는 6~12자리 이내로 입력하세요.");
			return false;
		}
		if (pw != "" || pwVali != "") {
			if (pw != pwVali) {
				alert("비밀번호가 일치하지 않습니다.");
	            return false;
			}
		}
		
		if(!postNo.test($("input[id='postNo']").val())) {
			alert("우편번호는 XXX-XXX 형식으로 입력해주세요.");
			return false;
		}
		
		if(!phone2.test($("input[id='phone2']").val())) {
			alert("휴대폰 번호는 4자리 입력해주세요.");
			return false;
		}

		if(!phone3.test($("input[id='phone3']").val())) {
			alert("휴대폰 번호는 4자리 입력해주세요.");
			return false;
		}
	}

	function fn_idChk() {
		$.ajax({
			url: 'idChk.do',
			type: 'post',
			dataType : 'json',
			data : {'userId' : $('#userId').val()},
			success : function(data) {
				if(data == 1) {
					alert("중복된 아이디입니다.");
				} else if (data == 0) {
					$('#idChk').attr("value", "Y");
					alert("사용 가능한 아이디입니다.");
				}
			}
		});
	}
</script>
</head>

<body>
	<form name="join" action="join.do" method="post">
		<div style="line-height: 2rem;">
			<a href="list.do">List</a>
		</div>

		<div>
			<table>
				<tr>
					<td>id</td>
					<td><input type="text" id="userId" name="userId">
						<button class="idChk" type="button" id="idChk"
							onclick="fn_idChk();" value="N">중복확인</button></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="password" id="userPw" name="userPw"></td>
				</tr>
				<tr>
					<td>pw 확인</td>
					<td><input type="password" id="pwVali"> <!--  <a
						id="alert-success">비밀번호가 일치합니다.</a> <a id="alert-danger">비밀번호가
							일치하지 않습니다.</a></td> -->
				</tr>
				<tr>
					<td>name</td>
					<td><input type="text" name="userName"></td>
				</tr>
				<tr>
					<td>phone</td>
					<td><select name="userPhone1">
							<c:forEach items="${phoneList }" var="phone">
							<option value="${phone.codeId }">${phone.codeName }</option>
							</c:forEach>
					</select>-<input type="text" size="3" id="phone2" name="userPhone2">-<input
						type="text" size="3" id="phone3" name="userPhone3"></td>
				</tr>
				<tr>
					<td>postNo</td>
					<td><input type="text" id="postNo" name="userAddr1"></td>
				</tr>
				<tr>
					<td>address</td>
					<td><input type="text" name="userAddr2"></td>
				</tr>
				<tr>
					<td>company</td>
					<td><input type="text" name="userCompany"></td>
				</tr>

			</table>
		</div>
		<div style="text-align: right;">
			<button type="submit" onclick="return vali();">join</button>
		</div>

	</form>
</body>

</html>