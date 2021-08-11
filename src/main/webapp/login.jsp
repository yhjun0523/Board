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
<title>login</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>

<body>
	<form action="login.do" method="post">
	<a href="list.do">List</a>
		<div>
			<table>
				<tr>
					<td>id</td>
					<td><input type="text" name="userId"></td>
				</tr>
				<tr>
					<td>pw</td>
					<td><input type="password" name="userPw"></td>
				</tr>

			</table>
		</div>
		<div style="text-align: right;">
			<button type="submit">login</button>
		</div>
	</form>
</body>

</html>