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
			<li><a href="${basePath }type/bookType.do">图书类别管理</a></li>
			<li class="active"><a href="${basePath }user/manageUser.do">用户管理</a></li>
		</ul>
	</div>
	<!-- tab-panes -->
	<div class="tab-content">
		<div class="tab-pane active">
			<%@ include file="../alert_bar.jsp" %>
			<h4>添加用户</h4>
			<form class="form-horizontal form-add-user" action="addUser.do" method="POST">
				<div class="control-group">
					<div class="controls" style="margin-left:30px;">
						<input type="text" id="input-username" name="username" placeholder="用户名称">
						<input id="input-password"  type="text" name="password" placeholder="密码">
						<select name="isAdmin" class="span2">
							<option value="1">管理员</option>
						</select>
						<a class="btn btn-success add-user">添加</a>
						<span class="help-inline"></span>
					</div>
				</div>
			</form>
			<hr>
			<h4>系统管理员</h4>
			<table class="table table-bordered span6">
				<thead>
					<tr>
						<th>序号</th>
						<th>用户名称</th>
						<th>密码</th>
						<th>类型</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="t" items="${userList }" varStatus="status">
						<tr>
							<td>${status.index }</td>
							<td class="user-name">${t.username }</td>
							<td>${t.password }</td>
							<td>管理员</td>
							<td><a href="javascript:void(0);" onclick="deleteUser('${t.username}')" class="btn btn-danger">删除</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
<script>
	$(".add-user").click(function(){
		var username = $("#input-username").val();
		var password = $("#input-password").val();
		var exist = false;
		$.each($(".user-name"), function(i,name) {
			if ($(name).html() == username) {
				$(".control-group").addClass("error");
				$(".add-user").next().html("该用户已存在");
				exist = true;
				return;
			}
		});
		if (exist) return;
		if (username == "") {
			$(".control-group").addClass("error");
			$(".add-user").next().html("用户名不能为空");
			return ;
		} else if(password == ""){
			$(".control-group").addClass("error");
			$(".add-user").next().html("密码不能为空");
			return;
		} 
		
		$(".form-add-user").submit();
	});
	$(".form-add-user input").click(function(){
		$(".control-group").removeClass("error");
		$(".add-user").next().html("");
	});
	function deleteUser(name) {
		$.post(baseUrl + "user/deleteUser.do",{name:name},
			function(data) {
				window.location.href = baseUrl + "user/manageUser.do";
		},'json');
	}
</script>