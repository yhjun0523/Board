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
<title>write</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<form action="write.do" method="post">
		<div style="text-align: right;">
			<input type="submit" value="작성"><input type="button"
				value="행추가">
		</div>
		<div>
			<table>
				<tr>
					<td>Type</td>
					<td><select name="boardType">
						<c:forEach items="${menuList }" var="menu">
							<option value="${menu.codeId }">${menu.codeName }</option>
						</c:forEach>
					</select>
				</tr>
				<tr>
					<td>Title</td>
					<td><input name="boardTitle" type="text"></td>
				</tr>
				<tr>
					<td>Comment</td>
					<td><textarea name="boardComment"></textarea></td>
				</tr>
				<tr>
					<td>Writer</td>
					<td><input name="creator" type="text" value="${userName }" readonly="readonly"></td>
				</tr>
			</table>
		</div>
		<div style="text-align: right;">
			<a href="list.do">List</a>
		</div>
	</form>
</body>

</html>