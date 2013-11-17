<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ include file="header.jsp"%>

<div class="container">
	<c:choose>
		<c:when test="${!empty success }">
			<div class="alert alert-success">${success}</div>
		</c:when>
		<c:when test="${!empty error}">
			<div class="alert alert-error">${success }</div>
		</c:when>
	</c:choose>
	<div class="hero-unit">
		<h1>欢迎使用图书管理系统</h1>
		<p>这是一个为中小图书馆设计的图书管理系统</p>
	</div>
	<div >
		<div class="span2">
			<h1>图书分类</h1>
			<hr>
			<ul class="nav nav-list">
				<li class="active"><a href="#">全部</a></li>
				<c:forEach var="type" items="${bookTypes}">
					<li><a href="${basePath}book/searchBookUserType.do?type=${type.type}">${type.type}</a></li>
				</c:forEach>
   			</ul>
		</div>
		<div class="span9">
		<h1>最新图书</h1>
		<hr>
		<ul class="thumbnails">
			  <c:forEach var="book" items="${books }">
              <li class="span7 clearfix">
                <div class="thumbnail clearfix">
                  <img style="width:auto;height:100px;margin-right:10px;" name="${book.bookNumber }" class="book-image pull-left span2 clearfix" >
                  <div class="caption">
                    <h4><a target="_blank" href="${basePath }book/getBookDetail.do?bookNumber=${book.bookNumber}">《${book.bookName }》</a></h4>
                    <p>作者：${book.author }</p>
                    <p>可借/馆藏：${book.number-book.borrowedNumber }/${book.number}</p>
                    <!--<p><a target="_blank" class="btn btn-primary btn-block" href="${basePath }book/getBookDetail.do?bookNumber=${book.bookNumber}">查看</a>-->
                  </div>
                </div>
              </li>
              </c:forEach>
        </ul>
        <a href="javascript:void(0);" class="see-more" >查看更多...</a>
        </div>
        <!--
        <div id="masonry" style="width:100%;">
        	<c:forEach var="book" items="${books }">
                <div class="item thumbnail" style="float:left;width:250px;margin-bottom:20px;margin-right:20px;">
                  <img style="width: auto; height:220px;" name="${book.bookNumber }" class="book-image clearfix" src="${basePath }img/loading.gif">
                  <div class="caption">
                    <h5>《${book.bookName }》</h5>
                    <p>作者：${book.author }</p>
                    <p>可借/馆藏：${book.number-book.borrowedNumber }/${book.number}</p>
                    <p><a target="_blank" class="btn btn-primary" href="${basePath }book/getBookDetail.do?bookNumber=${book.bookNumber}">查看</a>
                  </div>
                </div>
              </c:forEach>
        </div>
        -->
	</div>
</div>
<script>
	$(document).ready(function(){
		$.each($(".book-image"), function(i,x) {
			$.post(baseUrl + "book/getBookImage.do",{id:x.name},function(data){
				x.src = data.images.large;
			},'json');
		});
		var $container = $('#masonry');
		// initialize
		$container.masonry({
		  itemSelector: '.item'
		});
		
		$(".see-more").click(function(){
			$(".form-book-search").submit();
		});
	});
	
</script>

<%@ include file="footer.jsp"%>