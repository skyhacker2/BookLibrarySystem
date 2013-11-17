<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="com.eleven.booklibrary.model.Book" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
	Book book = (Book)request.getAttribute("book");
	String pubdate = null;
	String storeDate = null;
	if (book != null) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		pubdate = format.format(book.getPublishDate());
		storeDate = format.format(book.getStoreDate());
	}
%>
<div class="data-borrower thumbnail" style="width:50%;float:left;display:block;">
		<div class="caption">
			<c:choose>
				<c:when test="${empty book }">
					<p>没有相关记录</p>
				</c:when>
				<c:otherwise>
					<h1>${book.bookName}</h1>
					<hr>
					<%@ include file="../alert_bar.jsp" %>
					<p>书号:<span class="bookNumber">${book.bookNumber }</span></p>
					<p>作者:<span>${book.author }</span></p>
					<p>出版社:<span>${book.publisher }</span></p>
					<p>出版日期: <span><%=pubdate %></span></p>
					<p>价格:<span>${book.price }</span></p>
					<p>图书类型:<span>${book.bookType }</span></p>
					<p>存放位置:<span>${book.storeLocation }</span></p>
					<p>入库时间:<span ><%=storeDate %></span></p>
					<p>已借:<span>${book.borrowedNumber }</span></p>
					<p>数量:<span>${book.number}</span></p>
					<div class="form-actions">
						<a href="${basePath }book/modifyBook.do?bookNumber=${book.bookNumber}" class="btn btn-primary book-modify">修改</a>
						<button class="btn btn-danger book-delete">删除</button>
					</div>
				</c:otherwise>
			</c:choose>
			
		</div>
</div>
<script>
	$(".book-delete").click(function() {
		if (!confirm("确定删除吗？"))
			return;
		var bookNumber = $(".bookNumber").html();
		$.post(baseUrl + "book/deleteBook.do",{bookNumber:bookNumber},
				function(data){
					if (data == '200') {
						$('.caption').html('<div class="alert alert-success">删除成功</div>');
					}
				},'json'
		);
	});
</script>