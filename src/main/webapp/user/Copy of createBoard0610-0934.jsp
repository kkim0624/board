<%@page import="kr.or.ddit.paging.model.PageVo"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>사용자 리스트</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp"%>

</head>

<style>
.postTr:hover {
	cursor: pointer;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	$("#createBoadBtn").on("click",function(){
	
		var boardId = $(this).find(".boardId").text();
		$("#boardFrm").val(boardId);
		console.log(boardId);
		
		$("#frm").submit();
	})
})
</script>

<body>

	<!-- header -->
	<%@include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">게시판생성0608</h2>
						
						<!-- 사용자 상세조회 : userId가 필요 -->
						<form id="frm" action="${pageContext.request.contextPath}/createBoard" method="get">
							<input type="hidden" id="boardFrm" name="postId">
						</form>
						
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글이름</th>
									<th><input type="text" value=""></th>
									<th>
										<select>
												<option id="active" >사용</option>
												<option id="disabled">미사용</option>
										</select>
									</th>
									<th><button type="button" id="createBoadBtn">생성</button></th>
								</tr>
								
								<!-- 향상된 for -->
								<c:forEach items="${boardList}" var="board">
									<tr class="boardTr" data-boardId="${board.boardId}">
										<td>게시판이름</td>
										<td><input class="boardNm" type="text" value="${board.boardNm}"></td>
<%-- 									<td class="boardNm">${board.boardNm}</td> --%>
										<td>
											<c:choose>
												<c:when test="${board.boardIsActive == 'Y'}">
													<select>
														<option>사용</option>
													</select>
												</c:when>
												<c:otherwise>
													<select>
														<option>미사용</option>
													</select>
												</c:otherwise>
											</c:choose>
										</td>
										<td><button type="button" id="modifyBoadBtn">수정</button></td>
									</tr>
								</c:forEach>
								
							</table>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
