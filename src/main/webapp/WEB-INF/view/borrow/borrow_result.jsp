<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<style>
	span {
		color:#0088CC;
	}
</style>
<div class="thumbnail">
		<div class="caption">
			<h1>借书记录</h1>
			<hr>
			<%@ include file="../alert_bar.jsp" %>
			<ul class="thumbnails">
				<c:forEach var="x" varStatus="status" items="${records }">
				<li style="width:250px;">
				<div class="thumbnail">
					<div class="caption">
					<div>
						<h1 style="display:inline;">${status.index+1 }</h1>
						<div style="float:right;">
							<c:if test="${empty x.returnDate }">
								<a href="javascript:void(0);"class="btn btn-primary" onclick="returnBook(${x.borrowerNumber},${x.bookNumber})">还书</a>
							</c:if>
							<a href="javascript:void(0);" class="btn btn-danger" onclick="deleteBook(${x.borrowerNumber},${x.bookNumber})">删除</a>
						</div>
					</div>
					<hr>
					<p><strong>借阅者卡号:   </strong><span class="borrower-number">${x.borrowerNumber }</span></p>
					<p><strong>姓名:  </strong><span class="borrower-name">${x.borrowerName }</span></p>
					<p><strong>书号:  </strong><span class="book-number">${x.bookNumber }</span></p>
					<p><strong>书名:  </strong><span class="book-name">${x.bookName }</span></p>
					<p><strong>借书日期:  </strong><span class="borrow-date"><fmt:formatDate value="${x.borrowedDate }" pattern="yyyy-MM-dd"/></span></p>
					<p><strong>归还日期:  </strong><span class="return-date">
						<c:choose>
							<c:when test="${!empty x.returnDate }">
								<fmt:formatDate value="${x.returnDate }" pattern="yyyy-MM-dd"/>
							</c:when>
							<c:otherwise>
								未归还
							</c:otherwise>
						</c:choose>
					</span></p>
					</div>
				</div>
				</li>
				</c:forEach>
			</ul>
			<%@ include file="../pagination.jsp" %>
		</div>
</div>
<%@ include file="../modal.jsp" %>

<script>
	function returnBook(borrowerNumber, bookNumber) {
		$.post(baseUrl + "borrow/returnBook.do",
			{
				borrowerNumber:borrowerNumber,
				bookNumber:bookNumber
			},
			function(data){
				if (data.status == "300") {
					modal(data.msg);
					return ;
				} else {
					var msg = "还书成功！";
					if (data.borrow.fine > 0) {
						msg += "罚款: <span style='color:red;'>" + data.borrow.fine + "元";
					}
					modal(msg,function(){
						$(".borrow-form-search").submit();
					});
				}
			},
			'json'
		);
	}
	
	function deleteBook(borrowerNumber, bookNumber) {
		if (!confirm("确定删除吗？"))
			return;
		$.post(baseUrl + "borrow/deleteBook.do",
			{borrowerNumber:borrowerNumber,bookNumber:bookNumber},
			function(data){
				modal("删除成功");
			},'json');
	}
	function pageClick(page) {
		$(".input-pagination").val(page);
		$(".borrow-form-search").submit();
	}
</script>