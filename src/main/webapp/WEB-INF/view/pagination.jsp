<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<div class="pagination pagination-large">
	<ul>
		<!-- 上一页 -->
		<c:choose>
			<c:when test="${pagination.curPage > 1}">
				<li><a href="javascript:void(0);" class="page-prev" onclick="pageClick(${pagination.curPage-1})">上一页</a></li>
			</c:when>
			<c:otherwise>
				<li class="disabled"><a href="javascript:void(0);" >上一页</a></li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="x" begin="1" end="${pagination.pageNumber}" step="1">
			<c:choose>
				<c:when test="${pagination.curPage == x }">
					<li class="active"><a href="javascript:void(0);" class="page-item">${x }</a></li>
				</c:when>
				<c:when test="${pagination.curPage-x <= 3 }">
					<li><a href="javascript:void(0);" class="page-item" onclick="pageClick(${x})">${x }</a></li>
				</c:when>
				<c:when test="${x - pagination.curPage <=3 }">
					<li><a  href="javascript:void(0);"class="page-item" onclick="pageClick(${x})">${x }</a></li>
				</c:when>
			</c:choose>
		</c:forEach>
		
		<!-- 下一页 -->
		<c:choose>
			<c:when test="${pagination.curPage < pagination.pageNumber}">
				<li><a href="javascript:void(0);" class=".page-next" onclick="pageClick(${pagination.curPage+1})">下一页</a></li>
			</c:when>
			<c:otherwise>
				<li class="disabled"><a href="javascript:void(0);" >下一页</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
