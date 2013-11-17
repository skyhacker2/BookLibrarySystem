<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<style>
	span {
		color:#0088CC;
	}
</style>
<div class="thumbnail" style="width:50%;float:left;display:block;">
		<div class="caption">
			<h1>借书</h1>
			<hr>
			<%@ include file="../alert_bar.jsp" %>
			<ul class="thumbnails">
				<li class="span5">
				<div class="thumbnail">
					<div class="caption">
					<form class="form-inline">
						<strong>借阅者卡号:</strong>
						<input type="text" class="input-small card-number">
						<a class="btn btn-primary borrower-search">查找</a>
						<span class="borrower-msg" style="color:red;"></span>
					</form>
					<p><strong>姓名:  </strong><span class="borrower-name"></span></p>
					<p><strong>借阅者类型:  </strong><span class="borrower-type"></span></p>
					<p><strong>能借书数量:  </strong><span class="borrow-number"></span></p>
					<p><strong>已借书数目:  </strong><span class="borrower-borrowed"></span></p>
					</div>
				</div></li>
				<li class="span5">
				<div class="thumbnail">
					<div class="caption">
					<form class="form-inline">
						<strong>图书号:</strong>
						<input type="text" class="input-small input-book-number">
						<a class="btn btn-primary book-search">查找</a>
						<span class="book-msg" style="color:red;"></span>
					</form>
					<p><strong>书名:  </strong><span class="book-name"></span></p>
					<p><strong>作者:  </strong><span class="author"></span></p>
					<p><strong>图书类别:  </strong><span class="book-type"></span></p>
					<p><strong>可借天数:  </strong><span class="borrow-day"></span></p>
					<p><strong>书本数量:  </strong><span class="number"></span></p>
					<p><strong>可借:  </strong><span class="can-borrow"></span></p>
					</div>
				</div></li>
			</ul>
			<div class="form-actions">
				<a class="btn btn-primary borrow-submit">确认借书</a>
				<button class="btn btn-danger borrow-cancel">取消</button>
			</div>
		</div>
</div>
<script>
	$(".borrower-search").click(function(){
		if ($(".card-number").val() == "") {
			$(".borrower-msg").html("请输入卡号");
			return;
		}
		$(".borrower-msg").html("");
		$.post(baseUrl + "borrow/getBorrowerInfo.do",
			{borrowerNumber:$(".card-number").val()},
			function(data){
				if (data.status == '300')
					$(".borrower-msg").html(data.msg);
				else {
					$(".borrower-name").html(data.name);
					$(".borrower-type").html(data.type);
					$(".borrow-number").html(data.canBorrowNumber);
					$(".borrower-borrowed").html(data.borrowedNumber);
				}
			}, 
			'json'
		);
	});
	$(".book-search").click(function(){
		var bookNumber = $(".input-book-number").val();
		if (bookNumber == "") {
			$(".book-msg").html("请输入书号");
			return ;
		}
		$(".book-msg").html("");
		$.post(baseUrl + "borrow/getBookInfo.do",{bookNumber:bookNumber},
			function(data) {
				if (data.status == '300') {
					$(".book-msg").html(data.msg);
					return;
				} else {
					$(".book-name").html(data.name);
					$(".author").html(data.author);
					$(".book-type").html(data.type);
					$(".borrow-day").html(data.day);
					$(".number").html(data.number);
					$(".can-borrow").html(data.canBorrow);
				}
			},'json'
		);
	});
	$('.borrow-submit').click(function() {
		var borrowerName = $('.borrower-name').html();
		var borrowerNumber =$(".card-number").val();
		if (borrowerName == "" || borrowerNumber == "") {
			alert("请输入借阅者卡号");
			return;
		}
		var bookName = $(".book-name").html();
		var bookNumber = $(".input-book-number").val();
		if (bookName == "" || bookNumber == "") {
			alert("请输入书号");
			return;
		}
		if ($(".borrow-number").html() - $(".borrower-borrowed").html() == 0) {
			alert("借阅者借书数量已够，不能再借书");
			return;
		}
		if ($(".can-borrow").html() == '0') {
			alert("该本书已借完");
			return ;
		}
		location.href = baseUrl + "borrow/borrowBook.do?borrowerNumber=" + borrowerNumber + "&bookNumber=" + bookNumber;
	});
</script>