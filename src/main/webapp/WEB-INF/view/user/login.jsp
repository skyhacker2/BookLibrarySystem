<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ include file="../header.jsp"%>
<div class="container">
	<%@ include file="../alert_bar.jsp" %>
	<form class="form-horizontal" method="post" action="login.do">
		<fieldset>
			<legend>用户登入</legend>
			<div class="control-group">
				<label class="control-label" for="username">用户名</label>
				<div class="controls">
					<input type="text" class="input-xlarge" id="username" name="username">
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="password">口令</label>
				<div class="controls">
					<input type="password" class="input-xlarge" id="password" name="password">
				</div>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-primary">登入</button>
			</div>
		</fieldset>
	</form>
</div>
<%@ include file="../footer.jsp"%>