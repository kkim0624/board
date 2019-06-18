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
	$(".postTr").on("click",function(){
	
		var postId = $(this).find(".postId").text();
		$("#hidden").val(postId);
		console.log(postId);
		
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
						<h2 class="sub-header">자유게시판pagin</h2>
						
						<!-- 사용자 상세조회 : userId가 필요 -->
						<form id="frm" action="${pageContext.request.contextPath}/showPost" method="get">
							<input type="hidden" id="hidden" name="postId">
						</form>
						
						<div class="table-responsive">
							<table class="table table-striped">
								<tr>
									<th>게시글번호</th>
									<th>제목</th>
									<th>작성자아이디</th>
									<th>작성일시</th>
								</tr>
								
								<!-- 향상된 for -->
								<c:forEach items="${postPagingList}" var="post">
									<tr class="postTr" data-postId="${post.postId}">
										<td class="postId">${post.postId}</td>
<%-- 									<td>${post.postTitile}</td> 지우지 말것 4시간 짜리 --%>
										<td>${post.postTitle}</td>
										<td>${post.userId}</td>
										<td><fmt:formatDate value="${post.postWriteDate}"
										pattern="yyyy-MM-dd hh:mm:ss" var="date" />${date}</td>
									</tr>
								</c:forEach>
								
							</table>
						</div>
						
<%-- 					<a href="${pageContext.request.contextPath}/userForm" class="btn btn-default pull-right">새글 등록</a> --%>
						<a href="${pageContext.request.contextPath}/SE2/index.jsp" class="btn btn-default pull-right">새글 등록</a>
						
						<div class="text-center">
							
							<ul class="pagination">
								<c:choose>
									<c:when test="${pageVo.page==1}">
									<li class="disabled"><span>«</span></li>
									</c:when>
									<c:otherwise>
									<li>
										<a href="${pageContext.request.contextPath}/board?page=${pageVo.page-1}&pageSize=${pageVo.pageSize}">
											<span>«</span>
										</a>
									</li>
									</c:otherwise>
								</c:choose>
								
								<c:forEach begin="1" end="${paginationSize}" step="1" var="i">
									<c:choose>
										<c:when test="${pageVo.getPage()==i}">
											<li class="active">	
												<span>${i}</span>
											</li>
										</c:when>
										<c:otherwise>
											<li>
												<a href="${pageContext.request.contextPath}/board?page=${i}&pageSize=${pageVo.pageSize}">${i}</a>
											</li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
								
								<c:choose>
									<c:when test="${pagVo.getPage()==paginationSize}">
										<li class="disabled">
											<span>»</span>
										</li>
									</c:when>
									<c:otherwise>
										<li>
											<a href="${pageContext.request.contextPath}/board?page=${pageVo.getPage()+1}&pageSize=${pageVo.getPageSize()}">
												<span>»</span>
											</a>
										</li>									
									</c:otherwise>
								</c:choose>
								
							</ul>
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
