<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div>
	<form class="form-search book-form-search" action="searchBook.do", method="POST">
		<input type="text" class="input-large book-number" placeholder="书号/书名" name="query">
		<select class="span2 book-type-select" name="bookType">
		</select>
		<a id="search-book" class="btn" >搜索</a>
		<a href="${basePath }book/addBook.do" class="btn btn-success add-book-btn">添加图书</a>
	</form>
</div>
<script>
	$.post(baseUrl +"book/getBookTypes.do",{},function(data) {
		$('.book-type-select').empty();
		$(".book-type-select").append("<option value=''>全部</option>");
		for(var i in data) {
			var option = "<option value='" + data[i]['type'] + "'>" + data[i]['type'] + "</option>";
			$(".book-type-select").append(option);
		}
	}, 'json');
	
	$("#search-book").click(function(){
		/*
		var bookNumber = $(".book-number").val();
		if (bookNumber == "" || bookNumber == null) {
			alert("请输入书号");
			return ;
		}
		else if (isNaN(bookNumber)) {
			alert("书号只能是数字");
			return ;
		}
		*/
		$(".book-form-search").submit();
	});
	
</script>