<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ include file="../header.jsp" %>
<div class="container">
	<div class="tabbable">
		<ul class="nav nav-tabs">
			<li><a href="${basePath}user/user_center.do">借阅者管理</a></li>
			<li class="active"><a href="${basePath}book/book.do">图书管理</a></li>
			<li><a href="${basePath}borrow/borrow.do">借阅管理</a></li>
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
				<c:when test="${!empty bookResult }">
					<%@ include file="book_result.jsp" %>
				</c:when>
				<c:when test="${!empty addBook }">
					<%@ include file="add_book.jsp" %>
				</c:when>
				<c:when test="${!empty modifyBook }">
					<%@ include file="modify_book.jsp" %>
				</c:when>
				<c:when test="${!empty books }">
					<h1>搜索结果<small>${searchName } <span class="search-type">${searchType}</span> ${pagination.items}条记录</small></h1>
					<hr>
					<%@ include file="list.jsp" %>
					<script>
						$(document).ready(function(){
							$.each($(".book-image"), function(i,x) {
								$.post(baseUrl + "book/getBookImage.do",{id:x.name},function(data){
									x.src = data.images.large;
								},'json');
							});
						});
					</script>
				</c:when>
			</c:choose>
		</div>
	</div>
</div>
<script>
	$("[href='#tab-borrower']").click(function() {
		$.post(baseUrl +'borrower/getBorrowerType.do',
				{},
				function(data) {
					$(".borrower-select").empty();
					for(var i in data) {
						var option = "<option value='" + data[i]['type'] + "'>" + data[i]['type'] + "</option>";
						$(".borrower-select").append(option);
					}
				}, 
				'json');
	});
</script>
<%@ include file="../footer.jsp" %>
