<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>detail</title>
<link rel="stylesheet" href="css/style.css">
</head>

<body>
	<form action="update.do" method="post">
		<input name="boardNum" type="hidden" value="${board.boardNum}" />
		<div>
			<table>
				<tr>
					<td>Title</td>
					<td><input name="boardTitle" type="text"
						value="${board.boardTitle }" /></td>
				</tr>
				<tr>
					<td>Comment</td>
					<td><textarea name="boardComment">${board.boardComment }</textarea></td>
				</tr>
				<tr>
					<td>Writer</td>
					<td><input name="userName" type="text" readonly="readonly"
						value="${board.creator}"></td>
				</tr>
			</table>
		</div>
		<div style="text-align: right;">
			<a href="list.do">List</a> <input type="submit" value="Update">
		</div>
	</form>
</body>

</html>