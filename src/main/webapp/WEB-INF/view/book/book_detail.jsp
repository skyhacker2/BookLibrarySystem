<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<%@ include file="../header.jsp"%>
<style>
	.p1{
		color:#666666;
	}
</style>
<div class="container">
	<h1>${book.bookName }</h1>
	<hr>
	<div>
		<div style="float:left;">
			<img class="book-img" src="${basePath }img/loading.gif" style="width:200px;height=:auto;">
		</div>
		<div style="float:left;margin-left:10px;">
			<p><span class="p1">书号: </span><span class="book-number">${book.bookNumber }</span></p>
			<p><span class="p1">作者: </span>${book.author }</p>
			<p><span class="p1">出版社: </span>${book.publisher }</p>
			<p><span class="p1">出版日期: </span><fmt:formatDate value="${book.publishDate }" pattern="yyyy-MM"></fmt:formatDate></p>
			<p><span class="p1">价格: </span>${book.price}.00元</p>
			<p><span class="p1">图书类型: </span>${book.bookType }</p>
			<p><span class="p1">存放位置: </span>${book.storeLocation }</p>
			<p><span class="p1">入库时间: </span><fmt:formatDate value="${book.storeDate }" pattern="yyyy-MM"></fmt:formatDate></p>
			<p><span class="p1">已借: </span>${book.borrowedNumber }</p>
			<p><span class="p1">数量: </span>${book.number }</p>
		</div>
	</div>
	
</div>
<div class="container">
		<hr>
	<div>
		<h2>作者简介</h2>
		<p class="author-intro">暂无简介</p>
	</div>
	<div>
		<h2>内容简介</h2>
		<p class="summary">暂无简介</p>
	</div>
	<div>
		<h2>目录</h2>
		<p class="catalog">暂无目录</p>
	</div>
</div>
<script>
	$(document).ready(function(){
		
		$.post(baseUrl + "book/getBookImage.do",{id:$(".book-number").html()},
			function(data) {
				$(".book-img").attr("src", data.images.large);
		},'json');

		$.post(baseUrl + "book/getBookInfo.do", {id:$(".book-number").html()},
			function(data) {
				if (data['author_intro'])
					$(".author-intro").html(data['author_intro']);
				if (data['summary'])
					$(".summary").html(data['summary']);
				if (data['catalog'])
					$(".catalog").html(data['catalog']);
		},'json');
	});
</script>

<%@ include file="../footer.jsp"%>