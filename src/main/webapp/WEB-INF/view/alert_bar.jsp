<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<c:choose>
	<c:when test="${!empty success }">
		<div class="alert alert-success">${success}</div>
	</c:when>
	<c:when test="${!empty error}">
		<div class="alert alert-error">${error }</div>
	</c:when>
</c:choose>