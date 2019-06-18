<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>게시글 등록</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
$(document).ready(function(){
	$("#regPostBtn").on("click", function(){
		$("#frm").submit();	
	});
	
	$("#addAttachBtn").on("click", function(){
		$("#frm").submit();	
	});
	
	$("#delAttachBtn").on("click", function(){
		$("#frm").submit();	
	});
	
});

</script>

</head>

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
						<h2 class="sub-header">게시글 등록</h2>

						<form id="frm" class="form-horizontal" role="form"
							action="${pageContext.request.contextPath}/regPost"
							method="post" enctype="multipart/form-data">

							<div class="form-group">
								<div class="col-sm-10">
									<input type="hidden" class="form-control" id="postId"
										name="postId" placeholder="게시글아이디" value="${param.postId}">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-10">
									<input type="hidden" class="form-control" id="userId"
										name="userId" placeholder="게시글작성자" value="${param.userId}">
								</div>
							</div>

							<div class="form-group">
								<label for="regContent" class="col-sm-2 control-label">게시글제목</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="postTitle"
										name="postTitle" placeholder="글 내용"
										value="${param.postTitle}">
								</div>
							</div>

							<div class="form-group">
								<label for="regFile" class="col-sm-2 control-label">게시글내용</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="postContent"
										name="postContent" placeholder="게시글내용" value="${param.postContent}">
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-10">
									<input type="hidden" class="form-control" id="postWriteDate"
										name="postWriteDate" placeholder="게시글작성일시" value="${param.postWriteDate}">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-10">
									<input type="hidden" class="form-control" id="postIsActive"
										name="postIsActive" placeholder="게시글사용여부" value="${param.postIsActive}">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-10">
									<input type="hidden" class="form-control" id="parentId"
										name="parentId" placeholder="글 내용"
										value="${param.parentId}">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-10">
									<input type="hidden" class="form-control" id="regFile"
										name="boardId" placeholder="게시판아이디" value="${param.boardId}">
								</div>
							</div>

							<div class="form-group">
								<label for="regFile" class="col-sm-2 control-label">첨부파일</label>
								<div class="col-sm-10">
									<input type="file" class="form-control" id="attachFileId"
										name="attachFileId" placeholder="첨부파일" value="${param.attachFileId}">
								</div>
							</div>
							
							<div>
								<div class="col-sm-offset-2 col-sm-10">
									<button id="addAttachBtn" type="button" class="btn btn-default">+</button>
									<button id="delAttachBtn" type="button" class="btn btn-default">-</button>
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="regPostBtn" type="button" class="btn btn-default">게시글 등록</button>
								</div>
							</div>
							
						</form>
						
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>