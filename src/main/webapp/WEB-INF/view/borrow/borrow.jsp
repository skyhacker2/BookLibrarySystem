<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ include file="../header.jsp" %>
<div class="container">
	<div class="tabbable">
		<ul class="nav nav-tabs">
			<li><a href="${basePath}user/user_center.do">借阅者管理</a></li>
			<li><a href="${basePath}book/book.do">图书管理</a></li>
			<li class="active"><a href="${basePath}borrow/borrow.do">借阅管理</a></li>
			<li><a href="${basePath }type/borrowerType.do">借阅者类别管理</a></li>
			<li><a href="${basePath }type/bookType.do">图书类别管理</a></li>
			<li><a href="${basePath }user/manageUser.do">用户管理</a></li>
		</ul>
	</div>
	<!-- tab-panes -->
	<div class="tab-content">
		<div class="tab-pane active">
			<%@ include file="actions.jsp" %>
			<c:choose>
				<c:when test="${!empty borrowResult }">
					<%@ include file="borrow_result.jsp" %>
				</c:when>
				<c:otherwise>
					<%@ include file="borrow_book.jsp" %>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</div>
<%@ include file="../footer.jsp" %>