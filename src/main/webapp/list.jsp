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
<title>list</title>
<link rel="stylesheet" href="css/style.css">
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		//페이지 번호 이동
		$('#pagingDiv a').click(function(e) {
			e.preventDefault();
			$('#pageNum').val($(this).attr("href"));
			pagingForm.submit();
		});

		$('#pagingDiv a').click(function(e) {
			e.preventDefault();
			$('#pageNum2').val($(this).attr("href"));
			pagingForm2.submit();
		});

		$('#total').on('click', function() { // 전체 id="total"에 클릭 이벤트 함수 실행
			if ($('#total').prop('checked')) { // 전체 checkbox가 checked(선택)되어있는 경우 
				$('input[type="checkbox"]').prop('checked', true); // 모든 checkbox 선택 처리 하기
			} else {
				$('input[type="checkbox"]').prop('checked', false); // 모든 checkbox 선택해제 하기
			}
		});

		$('input[name="boardType"]').on('click', function() { // 해당 name속성을 가진 checkbox에 클릭 이벤트 부여
			if ($('input[name="boardType"]:checked').length == 4) { // 선택된 개수가 4개일 때
				$('#total').prop('checked', true); // id가 total인 checkbox 선택
			} else {
				$('#total').prop('checked', false); // id가 total인 checkbox 선택해제
			}
		});

	});
</script>
</head>

<body>
	<div>
		<c:if test="${userName == null }">
			<a href="login.jsp">login</a>&nbsp;<a href="register.do">join</a>
		</c:if>
		<c:if test="${userName != null }">
			${userName }
		</c:if>
	</div>
	<div style="text-align: right;">total: ${paging.total }</div>
	<div>
		<table>
			<tr>
				<td>Type</td>
				<td>No</td>
				<td>Title</td>
			</tr>
			<c:forEach items="${boardList }" var="board">
				<tr>
					<td>${board.codeName }</td>
					<td>${board.boardNum }</td>
					<td><a href="detail.do?boardNum=${board.boardNum}">${board.boardTitle }</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div style="text-align: right;">
		<a href="create.do">글쓰기</a>
		<c:if test="${userName != null }">
			<a href="logout.do">로그아웃</a>
		</c:if>
	</div>
	<div>
		<form action="searchList.do">
			<input type="checkbox" id="total">전체
			<c:forEach items="${menuList }" var="menu">
				<input type="checkbox" name="boardType_${menu.codeId }"
					value="${menu.codeId }">${menu.codeName }
		</c:forEach>
			<input type="submit" value="조회">
		</form>
	</div>
	<div id="pagingDiv" style="text-align: right">
		<c:if test="${paging.prev}">
			<a href="${paging.startPage - 1 }">〈</a>
		</c:if>
		<c:forEach var="num" begin="${paging.startPage}"
			end="${paging.endPage }">
			<a href="${num }">${num }</a>
		</c:forEach>
		<c:if test="${paging.next}">
			<a id="next" href="${paging.endPage + 1 }">〉</a>
		</c:if>
	</div>
	<form id="pagingFrm" name="pagingForm" action="list.do" method="get">
		<input type="hidden" id="pageNum" name="pageNum"
			value="${paging.cri.pageNum }"> <input type="hidden"
			id="amount" name="amount" value="${paging.cri.amount }">
	</form>

	<form id="pagingFrm2" name="pagingForm2" action="searchList.do"
		method="get">
		<input type="hidden" id="boardType_a01" name="boardType_a01"
			value="${paging.cri.boardType_a01 }"> <input type="hidden"
			id="boardType_a02" name="boardType_a02"
			value="${paging.cri.boardType_a02 }"> <input type="hidden"
			id="boardType_a03" name="boardType_a03"
			value="${paging.cri.boardType_a03 }"> <input type="hidden"
			id="boardType_a04" name="boardType_a04"
			value="${paging.cri.boardType_a04 }"> <input type="hidden"
			id="pageNum2" name="pageNum" value="${paging.cri.pageNum }">
		<input type="hidden" id="amount2" name="amount"
			value="${paging.cri.amount }">
	</form>



</body>

</html>