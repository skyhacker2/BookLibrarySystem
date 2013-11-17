<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<div class="data-book thumbnail span6 clearfix">
	<div class="caption clearfix">
		<h1>添加图书</h1>
		<hr>
		<form class="form-horizontal add-book-form" action="addBook.do" method="POST">
			<div class="control-group">
				<label class="control-label" for="inputISBN">ISBN</label>
				<div class="controls">
					<input type="text" id="inputISBN" name="isbn" placeholder="978-7-111-29195-4"> <a class="btn btn-primary search-isbn">查找</a><span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputBookNumber">书号</label>
				<div class="controls">
					<input type="text" id="inputBookNumber" name="bookNumber" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputBookName">书名</label>
				<div class="controls">
					<input type="text" id="inputBookName" name="bookName" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputAuthor">作者</label>
				<div class="controls">
					<input type="text" id="inputAuthor" name="author" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPublisher">出版社</label>
				<div class="controls">
					<input type="text" id="inputPublisher" name="publisher" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPublishDate">出版日期</label>
				<div class="controls">
					<input type="text" id="inputPublishDate" name="pubdate" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPrice">价格</label>
				<div class="controls">
					<input type="text" id="inputPrice" name="priceVo" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputType">类型</label>
				<div class="controls">
					<select class="span2 book-type-select" id="inputType" name="bookType">
					</select> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputStoreLocation">存放位置</label>
				<div class="controls">
					<input type="text" id="inputStoreLocation" name="storeLocation" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputNumber">数量</label>
				<div class="controls">
					<input type="text" id="inputNumber" name="number" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="form-actions">
		    	<a class="btn btn-primary add-book-submit">添加</a>
		    	<button type="reset" class="btn btn-danger add-book-cancel">取消</button>
		    </div>
		</form>
	</div>
	
</div>

	<div class="caption span5 clearfix">
		<img class="book-image" src="" style="widht:auto;height:auto;">
	</div>


<script>
	function validateInput(input, fn, msg) {
		var value = $(input).val();
		console.log(value);
		if (value =="") {
			$(input).closest(".control-group").removeClass("success").addClass("error");
			$(input).next().html("此项不能空");
			$(input).focus();
			return false;
		}
		else if (fn != null && fn(value)) {
			$(input).closest(".control-group").removeClass("success").addClass("error");
			$(input).next().html(msg);
			$(input).focus();
			return false;

		}
		else {
			$(input).closest(".control-group").removeClass("error").addClass("success");
			$(input).next().html("");
			return true;
		}
	}
	$(".search-isbn").click(function(){
		$(".search-isbn").html("正在查找...");
		$.post(baseUrl + "book/searchBookByISBN.do",
				{isbn:$("#inputISBN").val()},
				function(data){
					if (data.msg == "book_not_found") {
						$(".search-isbn").next().html("没有找到，ISBN是否输入正确？");
						$(".search-ibsn").focus();
						return ;
					}
					$(".search-isbn").html("查找");
					$(".search-isbn").next().html("");
					$("#inputBookNumber").val(data['id']);
					$("#inputBookName").val(data['title']);
					$("#inputAuthor").val(data['author'].join(" "));
					$("#inputPublisher").val(data['publisher']);
					$("#inputPublishDate").val(data['pubdate'].replace('.','-'));
					$("#inputPrice").val(data['price']);
					$(".book-image").attr("src",data['images']['large']);
				},
				'json'
		);
	});
	$(".add-book-submit").click(function() {
		var inputs = $(".add-book-form input");	
		for (var i = 0; i < inputs.length; i++) {
			var name = inputs.get(i).name;
			console.log(name);
			if (name == 'isbn') continue;
			else if (name == 'bookNumber' || name == 'number') {
				if (!validateInput(inputs.get(i), isNaN, "只能输入数字"))
					return false;
			}
			else if(name != ""){
				if(!validateInput(inputs.get(i)))
					return false;
			}
		}
		// 检查书号是否存在
		$.post(baseUrl + "book/checkBookNumber.do",
				{bookNumber:$("#inputBookNumber").val()},
				function(data){
					if(data == '300') {
						$("#inputBookNumber").closest(".control-group").removeClass("success").addClass("error");
						$("#inputBookNumber").next().html("书号已存在");
						$("#inputBookNumber").focus();
						return false;
					} else {
						$("#inputBookNumber").closest(".control-group").removeClass("error").addClass("success");
						$("#inputBookNumber").next().html("");
						$(".add-book-form").submit();
					}
				},
				'json'
		);
		
	});
	
	$(".add-book-cancel").click(function(){
		$(".data-book").hide();
	});
</script>