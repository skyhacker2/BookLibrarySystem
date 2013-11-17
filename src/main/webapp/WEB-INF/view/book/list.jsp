<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<style>
div {  
 white-space:nowrap;  
 text-overflow:ellipsis;  
 -o-text-overflow:ellipsis;  
 overflow: hidden;  
 }  
</style>

<ul class="thumbnails">
	<c:forEach var="book" items="${books }">
		<li class="span5 clearfix" id="${book.bookNumber }">
			<div class="thumbnail clearfix">
				<img style="width: auto; height: 100px; margin-right: 10px;"
					name="${book.bookNumber }"
					class="book-image pull-left span2 clearfix">
				<div class="caption">
					
					<h4>
						<a target="_blank"
							href="${basePath }book/getBookDetail.do?bookNumber=${book.bookNumber}">《${book.bookName }》</a>
					</h4>
					<p>作者：${book.author }</p>
					<p>书号：${book.bookNumber }</p>
					<p>可借/馆藏：${book.number-book.borrowedNumber }/${book.number}</p>
					<c:if test="${!empty user }">
						<a style = "margin-left:10px;" class="btn btn-primary pull-right" href="${basePath }book/modifyBook.do?bookNumber=${book.bookNumber}">修改</a>
						<button class="btn btn-danger book-delete pull-right" bookNumber="${book.bookNumber }">删除</button>
					</c:if>
				</div>
			</div>
		</li>
	</c:forEach>
</ul>
<script>
	$(".book-delete").click(function() {
		if (!confirm("确定删除吗？"))
			return;
		var bookNumber = $(this).attr("bookNumber");
		$.post(baseUrl + "book/deleteBook.do",{bookNumber:bookNumber},
				function(data){
					if (data == '200') {
						$("#"+bookNumber).html('<div class="alert alert-success">删除成功</div>');
						setTimeout(function(){
							$("#"+bookNumber).hide();
						}, 2000);
					}
				},'json'
		);
	});
</script>