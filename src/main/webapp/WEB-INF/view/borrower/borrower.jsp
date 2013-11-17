<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<div>
	<form class="form-search">
		<input type="text" class="input-large card-number" placeholder="请输入借阅者号">
		<select class="span2 borrower-select">
		</select>
		<a id="search-borrower" class="btn">搜索</a>
		<a class="btn btn-success add-borrower-btn">添加借阅者</a>
	</form>
	<div class="data-borrower thumbnail" style="width:50%;float:left;display:none;">
		<div class="caption borrower-caption">
			<h1 class="borrower-name">陈洪晶<small class="borrower-sex">男</small></h1>
			<hr>
			<p>卡号:<span class="borrower-card-number">100</span></p>
			<p>电话号码:<span class="borrower-phone">13750376797</span></p>
			<p>身份证号码:<span class="borrower-id-card">440782199109133911</span></p>
			<p>工作单位: <span class="borrower-work-place">五邑大学</span></p>
			<p>地址:<span class="borrower-address">五邑大学学生宿舍18栋610</span></p>
			<p>类型:<span class="borrower-type">超级会员</span></p>
			<p>创建时间:<span class="borrower-create-time"></span></p>
			<p>借书数量:<span class="borrower-borrowed-book">2</span></p>
			<p>是否挂失:<span class="borrower-lost">否</span></p>
			<div class="form-actions">
				<button class="btn btn-primary borrower-modify">修改</button>
				<button class="btn btn-danger borrower-delete">删除</button>
			</div>
		</div>
	</div>
	<div class="no-record thumbnail" style="width:50%;float:left;display:none;">
		<p>没有相关记录</p>
	</div>
	<div class="modify-borrower thumbnail" style="width:50%;float:left;display:none;">
		<div class="caption borrower-caption">
			<h1>修改借阅者</h1>
			<hr>
			<%@ include file="modify_borrower.jsp" %>
		</div>
	</div>
	<div class="add-borrower thumbnail" style="width:50%;float:left;display:none;">
		<div class="caption borrower-caption">
			<h1>添加借阅者</h1>
			<hr>
			<%@ include file="add_borrower.jsp" %>
		</div>
	</div>
</div>
<script>
$(document).ready(function() {
	$("#search-borrower").click(function() {
		var cardNumber = $(".card-number").val();
		if (cardNumber == "undefined" || cardNumber == "" || cardNumber == null) {
			alert("借阅者卡号不能为空");
			return ;
		}
		if (isNaN(cardNumber)) {
			alert("借阅者卡号只能是数字");
			return ;
		}
		var borrowerType = $(".borrower-select").val();
		searchBorrower({cardNumber:cardNumber, borrowerType:borrowerType});
	});
	
	$(".add-borrower-btn").click(function() {
		$(".add-borrower-cancel").click();
		$(".data-borrower").hide();
		$(".no-record").hide();
		$(".modify-borrower").hide();
		$(".add-borrower").slideDown("slow");
		$.post(baseUrl + "borrower/getNewCardNumber.do",
				{},
				function(data) {
					$("input[name='cardNumber']").val(data);
				},
				'json'
		);
	});
	// 修改借阅者
	$(".borrower-modify").click(function() {
		$(".data-borrower").hide();
		$(".no-record").hide();
		$(".add-borrower").hide();
		$(".modify-borrower").slideDown("slow");
		var cardNumber = $(".borrower-card-number").html();
		var borrowerType = $(".borrower-type").html();
		$.post(baseUrl + "borrower/searchBorrower.do", 
				{cardNumber:cardNumber, borrowerType:borrowerType},
				function(result) {
					var data = result.borrower;
					$(".borrower-card-number").val(data['cardNumber']);
					$(".borrower-name").val(data['name']);
					if(data['sex'] == '男') {
						$("input[value='男']").attr("checked", true);
						$("input[value='女']").attr("checked", false);
					} else {
						$("input[value='女']").attr("checked", true);
						$("input[value='男']").attr("checked", false);
					}
					$(".borrower-id-card").val(data['idCardNumber']);
					$(".borrower-work-place").val(data['workPlace']);
					$(".borrower-address").val(data['address']);
					$(".borrower-phone").val(data['phone']);
					$(".borrower-borrowed-book").val(data['borrowed']);
					$(".borrower-select-lost").val(data['isLost']);
				},
				'json'
		);
	});
	
	// 删除借阅者
	$(".borrower-delete").click(function(){
		if(confirm("确认删除？")) {
			$.post(baseUrl + "borrower/deleteBorrower.do",{cardNumber:$(".borrower-card-number").html()},
					function(result){
						if (result.status == '200') {
							$(".data-borrower").hide();
							alert("删除成功");
						}
					},
			'json');
		}
		
	});
});
function dateParser(milliSeconds) {
	var date = new Date();
	date.setMilliseconds(milliSeconds);
	var dateStr = date.getFullYear() + "-" + (date.getMonth()+1) + "-" + date.getDate();
	return dateStr;
}

// 搜索借阅者
// data: {cardNumber:.., borrowerType:..}
function searchBorrower(data) {
	$(".data-borrower").hide();
	$(".no-record").hide();
	$(".add-borrower").hide();
	$(".modify-borrower").hide();
	$.post(baseUrl + "borrower/searchBorrower.do",
			data,
			function(map) {
				if(map.status == "300" ) {
					$(".no-record").show();
					return;
				}
				var data = map.borrower;
				$(".borrower-name").html(data['name'] + "<small>" + data["sex"] + "</small>");
				$(".borrower-sex").html(data['sex']);
				$(".borrower-card-number").html(data['cardNumber']);
				$(".borrower-phone").html(data['phone']);
				$(".borrower-id-card").html(data['idCardNumber']);
				$(".borrower-work-place").html(data['workPlace']);
				$(".borrower-address").html(data['address']);
				$(".borrower-type").html(data['type']);
				$(".borrower-create-time").html(dateParser(data['createTime']));
				$(".borrower-borrowed-book").html(data['borrowed']);
				$(".borrower-lost").html(data['isLost'] == "0" ? "否" : "是");
				$(".data-borrower").slideDown("slow");
			},
			'json');
	
}
</script>

