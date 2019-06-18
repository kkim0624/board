<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>			
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		
		<li class="active"><a href="${pageContext.request.contextPath}/createBoard">게시판생성</a></li>

		<c:forEach items="${boardList}" var="board">
			<c:if test="${board.boardIsActive eq 'Y'}">
				<li class="active"><a href="${pageContext.request.contextPath}/board?boardId=${board.boardId}">${board.boardNm}</a></li>
			</c:if>
		</c:forEach>
		
	</ul>
</div>