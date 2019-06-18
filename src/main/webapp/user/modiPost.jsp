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

<title>사용자 등록</title>

<!-- css, js -->
<%@include file="/common/basicLib.jsp"%>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<script>
	$(document).ready(function() {

		var msg = '${msg}';
		if (msg != "")
			alert(msg);

		// 주소 찾기 버튼 클릭 이벤트 핸들러
		$("#addrSearchBtn").on("click", function() {
			new daum.Postcode({
				oncomplete : function(data) {
					// 주소 input value에 설정 data.roadAddress
					// 우편번호 input value에 설정 data.zonecode	
					$("#addr1").val(data.roadAddress);
					$("#zipcd").val(data.zonecode);

					// console.log(data);
					// console.log(data.roadAddress);
					// console.log(data.zonecode);
				}
			}).open();
		});

		$("#postModiBtn").on("click", function() {

			var userIdd = $("#userIdd").text();
			$("#userId").val(userIdd);
			
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
						<h2 class="sub-header">게시글수정</h2>

						<form id="frm" class="form-horizontal" role="form"
							action="${pageContext.request.contextPath}/userModify"
							enctype="multipart/form-data" method="post">

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">제목</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="pass"
										name="pass" placeholder="제목" value="${userVo.pass}">
								</div>
							</div>
							
							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">글내용</label>
								<div class="col-sm-10">
									<input type="password" class="form-control" id="pass"
										name="pass" placeholder="사용자 비밀번호" value="${userVo.pass}">
								</div>
							</div>

							<div class="form-group">
								<label for="userNm" class="col-sm-2 control-label">첨부파일</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" id="name" name="name"
										placeholder="사용자 이름" value="${userVo.name}">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button id="postModiBtn" type="button" class="btn btn-default">게시글수정</button>
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