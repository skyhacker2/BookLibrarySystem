<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<form class="form-horizontal modify-borrower-form">
	<div class="control-group">
		<label class="control-label" for="inputCardNumber">借阅者卡号</label>
		<div class="controls">
			<input class="borrower-card-number" type="text" id="inputCardNumber" name="cardNumber" disabled> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputName">姓名</label>
		<div class="controls">
			<input class="borrower-name" type="text" id="inputName" name="name" onblur="validateInput(this)"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">性别</label>
		<div class="controls">
			<label class="radio inline"> <input type="radio" value="男"
				name="sex">男
			</label> 
			<label class="radio inline"> <input type="radio" value="女"
				name="sex">女
			</label>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputIdCard">身份证</label>
		<div class="controls">
			<input class="borrower-id-card" type="text" id="inputIdCard" name="idCardNumber" onblur="validateInput(this,isNaN,'只能输入数字')"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputWorkPlace">工作单位</label>
		<div class="controls">
			<input class="borrower-work-place" type="text" id="inputWorkPlace" name="workPlace" onblur="validateInput(this)"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputAddress">地址</label>
		<div class="controls">
			<input class="borrower-address" type="text" id="inputAddress" name="address" onblur="validateInput(this)"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputType">类型</label>
		<div class="controls">
			<select class="span2 borrower-select" id="inputType" name="type">
			</select> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputPhone">电话</label>
		<div class="controls">
			<input class="borrower-phone" type="text" id="inputPhone" name="phone" onblur="validateInput(this,isNaN,'只能输入数字')"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputBorrowedNum">借书数量</label>
		<div class="controls">
			<input class="borrower-borrowed-book" type="text" id="inputBorrowedNum" name="borrowed" onblur="validateInput(this,isNaN,'只能输入数字')"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputIsLost">是否挂失</label>
		<div class="controls">
			<select class="span2 borrower-select-lost" id="inputIsLost" name="isLost">
				<option value="0">否</option>
				<option value="1">是</option>
			</select> <span class="help-inline"></span>
		</div>
	</div>
	<div class="form-actions">
    	<a class="btn btn-primary modify-borrower-submit">修改</a>
    	<button type="reset" class="btn btn-danger modify-borrower-cancel">取消</button>
    </div>
</form>
<script>
	$(".modify-borrower-cancel").click(function(){
		$(".modify-borrower").hide();
	});
	$(".modify-borrower-submit").click(function() {
		$(".borrower-card-number").attr("disabled", false);
		var data = $(".modify-borrower-form").serialize();
		$(".borrower-card-number").attr("disabled", true);
		console.log(data);
		$.post(baseUrl + "borrower/updateBorrower.do",
				data,
				function(result) {
					if (result.status != '200') {
						alert('修改借阅者失败');
					} else {
						searchBorrower({cardNumber:result.cardNumber,borrowerType:result.type});
					}
				},
				'json'
		);
	});
</script>