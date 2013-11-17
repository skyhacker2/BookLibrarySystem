<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page import="com.eleven.booklibrary.model.Book" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%
	Book book = (Book)request.getAttribute("book");
	String pubdate = null;
	if (book != null) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		pubdate = format.format(book.getPublishDate());
	}
%>
<div class="data-book thumbnail" style="width:50%;float:left;display:block;">
	<div class="caption">
		<h1>修改图书</h1>
		<hr>
		<form class="form-horizontal modify-book-form" action="modifyBook.do" method="POST">
			<input type="hidden" name="bookNumber" value="${book.bookNumber }">
			<input type="hidden" name="storeDate" value="${book.storeDate }">
			<div class="control-group">
				<label class="control-label" for="inputBookName">书名</label>
				<div class="controls">
					<input value="${book.bookName }" type="text" id="inputBookName" name="bookName" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputAuthor">作者</label>
				<div class="controls">
					<input value="${book.author }" type="text" id="inputAuthor" name="author" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPublisher">出版社</label>
				<div class="controls">
					<input value="${book.publisher }" type="text" id="inputPublisher" name="publisher" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPublishDate">出版日期</label>
				<div class="controls">
					<input value="<%=pubdate %>" type="text" id="inputPublishDate" name="pubdate" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputPrice">价格</label>
				<div class="controls">
					<input value="${book.price }.00元" type="text" id="inputPrice" name="priceVo" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputType">类型</label>
				<div class="controls">
					<select class="span2" id="inputType" name="bookType">
						<c:forEach var="t" items="${bookTypes }">
							<c:choose>
								<c:when test="${t.type == book.bookType }">
									<option value="${t.type }" selected>${t.type }</option>
								</c:when>
								<c:otherwise>
									<option value="${t.type }">${t.type }</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputStoreLocation">存放位置</label>
				<div class="controls">
					<input value="${book.storeLocation }" type="text" id="inputStoreLocation" name="storeLocation" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="inputNumber">数量</label>
				<div class="controls">
					<input value="${book.number }" type="text" id="inputNumber" name="number" onblur="validateInput(this)"> <span class="help-inline"></span>
				</div>
			</div>
			<div class="form-actions">
		    	<a class="btn btn-primary modify-book-submit">确认</a>
		    	<button type="reset" class="btn btn-danger modify-book-cancel">取消</button>
		    </div>
		</form>
	</div>
</div>
<script>
function validateInput(input, fn, msg) {
	var value = $(input).val();
	console.log(value);
	if (value =="") {
		$(input).closest(".control-group").removeClass("success").addClass("error");
		$(input).next().html("此项不能空");
		return false;
	}
	else if (fn != null && fn(value)) {
		$(input).closest(".control-group").removeClass("success").addClass("error");
		$(input).next().html(msg);
		return false;

	}
	else {
		$(input).closest(".control-group").removeClass("error").addClass("success");
		$(input).next().html("");
		return true;
	}
}
$(".modify-book-submit").click(function() {
	var inputs = $(".modify-book-form input");	
	for (var i = 2; i < inputs.length; i++) {
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
	$(".modify-book-form").submit();
});
$(".modify-book-cancel").click(function(){
	history.back();
});
</script>