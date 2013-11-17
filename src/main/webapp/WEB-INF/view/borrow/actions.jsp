<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div>
	<form class="form-search borrow-form-search" action="searchBorrow.do" method="GET">
		<input type="text" class="input-large borrower-number" placeholder="请输入借阅者卡号" name="borrowerNumber" value="${borrowerNumber }">
		<input type="text" class="input-large book-number" placeholder="请输入图书号" name="bookNumber" value="${bookNumber }">
		<input type="hidden" class="input-pagination" name="page">
		<button id="search-borrow-record" class="btn" >搜索</button>
		<a href="${basePath }borrow/borrow.do" class="btn btn-success borrow-book-btn">借书</a>
		<button class="btn btn-success return-book-btn">借书记录</button>
	</form>
</div>