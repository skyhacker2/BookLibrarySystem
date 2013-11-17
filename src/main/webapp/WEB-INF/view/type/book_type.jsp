<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ include file="../header.jsp" %>
<div class="container">
	<div class="tabbable">
		<ul class="nav nav-tabs">
			<li><a href="${basePath}user/user_center.do">借阅者管理</a></li>
			<li><a href="${basePath}book/book.do">图书管理</a></li>
			<li><a href="${basePath}borrow/borrow.do">借阅管理</a></li>
			<li><a href="${basePath }type/borrowerType.do">借阅者类别管理</a></li>
			<li class="active"><a href="${basePath }type/bookType.do">图书类别管理</a></li>
			<li><a href="${basePath }user/manageUser.do">用户管理</a></li>
		</ul>
	</div>
	<!-- tab-panes -->
	<div class="tab-content">
		<div class="tab-pane active">
			<h4>添加分类</h4>
			<form class="form-horizontal" action="addBookType.do" method="POST">
				<div class="control-group">
					<div class="controls" style="margin-left:30px;">
						<input type="text" id="input-book-type" name="type" placeholder="类别名称">
						<input id="input-borrow-day" class="input-small" type="text" name="borrowDay" placeholder="能借天数">
						<div class="input-append">
							<input id="input-day-fine" class="input-small" type="text" name="dayFine" placeholder="每天罚款">
							<span class="add-on">角</span>
						</div>
						<button class="btn btn-success add-type">添加</button>
						<span class="help-inline"></span>
					</div>
				</div>
			</form>
			<hr>
			<h4>书本分类</h4>
			<table class="table table-bordered span6">
				<thead>
					<tr>
						<th>序号</th>
						<th>分类名</th>
						<th>能借天数</th>
						<th>每天罚款</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${typeList }" varStatus="status">
						<tr>
							<td>${status.index }</td>
							<td class="type-name">${t.type }</td>
							<td>${t.borrowDay }</td>
							<td>${t.dayFine }角</td>
							<td><a href="javascript:void(0);" onclick="deleteType('${t.type}')" class="btn btn-danger">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script>
	$(".add-type").attr("disabled",true);
	$("#input-book-type , #input-borrow-day, #input-day-fine").keyup(function(){
		var typeNames = $(".type-name");
		for (var i = 0; i < typeNames.length; i++) {
			if ($(typeNames.get(i)).html() == $("#input-book-type").val()) {
				$(".control-group").addClass("error");
				$(".add-type").next().html("该类别已存在");
				$(".add-type").attr("disabled",true);
				return;
			}
		}
		var num = $("#input-borrow-day").val();
		var dayfine = $("#input-day-fine").val();
		if (num != "" && dayfine != "" && !isNaN(num) && !isNaN(dayfine)) {
			$(".add-type").attr("disabled",false);
		} else {
			$(".add-type").attr("disabled",true);
		}
		$(".control-group").removeClass("error");
		$(".add-type").next().html("");
	});
	function deleteType(type) {
		$.post(baseUrl +"type/deleteBookType.do",{type:type},
			function(data) {
				window.location.href=baseUrl +"type/bookType.do";
		},'json');
		
	}
</script>
<%@ include file="../footer.jsp" %>