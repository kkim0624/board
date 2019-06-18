<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<title>게시글 상세조회</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
	
	$(document).ready(function(){
		$("#postModiBtn").on("click", function() {

			var postId = $("#sendId").text();
			$("#postModi").val(postId);
	
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
						<h2 class="sub-header">게시글 상세test</h2>

						<form id="frm" class="form-horizontal" role="form" action="${pageContext.request.contextPath}/modiPost">
							
							<div class="form-group">
								<label for="postTitle" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<label id="sendId" class="control-label">${postVo.postTitle}</label>
								</div>
							</div>
							
							<div class="form-group">
								<label for="postContent" class="col-sm-2 control-label">글내용</label>
								<div class="col-sm-10">
									<label class="control-label">${postVo.postContent}</label>
								</div>
							</div>

							<div class="form-group">
								<label for="attachFile" class="col-sm-2 control-label">첨부파일</label>
								<div class="col-sm-10">
									<label class="control-label">${postVo.parentId}</label>
								</div>
							</div>

							<div class="form-group">
								<label for="comment" class="col-sm-2 control-label">댓글</label>
								<div class="col-sm-10">
									<label class="control-label">${postVo.boardId}</label>
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="postModiBtn" type="button" class="btn btn-default">게시글 수정</button>
									<input type="hidden" id="postModi" name="postModi">
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