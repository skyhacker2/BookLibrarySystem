<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<form class="form-horizontal add-borrower-form">
	<div class="control-group">
		<label class="control-label" for="inputCardNumber">借阅者卡号</label>
		<div class="controls">
			<input type="text" id="inputCardNumber" name="cardNumber" disabled> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputName">姓名</label>
		<div class="controls">
			<input type="text" id="inputName" name="name" onblur="validateInput(this)"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label">性别</label>
		<div class="controls">
			<label class="radio inline"> <input type="radio" value="男"
				name="sex" checked>男
			</label> 
			<label class="radio inline"> <input type="radio" value="女"
				name="sex">女
			</label>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputIdCard">身份证</label>
		<div class="controls">
			<input type="text" id="inputIdCard" name="idCardNumber" onblur="validateInput(this,isNaN,'只能输入数字')"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputWorkPlace">工作单位</label>
		<div class="controls">
			<input type="text" id="inputWorkPlace" name="workPlace" onblur="validateInput(this)"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="control-group">
		<label class="control-label" for="inputAddress">地址</label>
		<div class="controls">
			<input type="text" id="inputAddress" name="address" onblur="validateInput(this)"> <span class="help-inline"></span>
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
			<input type="text" id="inputPhone" name="phone" onblur="validateInput(this,isNaN,'只能输入数字')"> <span class="help-inline"></span>
		</div>
	</div>
	<div class="form-actions">
    	<a class="btn btn-primary add-borrower-submit">添加</a>
    	<button type="reset" class="btn btn-danger add-borrower-cancel">取消</button>
    </div>
</form>
<script>
	function validateInput(input, fn, msg) {
		var value = $(input).val();
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
	// 取消添加借阅者
	$(".add-borrower-cancel").click(function() {
		$(".add-borrower-form .control-group").removeClass("error success");	// 删除错误和成功样式
		$(".add-borrower-form input").next().html("");			// 删除span的提示信息
		$(".add-borrower").hide();
	});
	$(".add-borrower-submit").click(function() {
		
		if (!validateInput($(".add-borrower-form #inputName")))
			return;
		else if (!validateInput($(".add-borrower-form #inputIdCard"),isNaN,"只能输入数字"))
			return;
		else if (!validateInput($(".add-borrower-form #inputWorkPlace")))
			return;
		else if (!validateInput($(".add-borrower-form #inputAddress")))
			return;
		else if(!validateInput($(".add-borrower-form #inputPhone"), isNaN, "只能输入数字"))
			return;
		// 添加借阅者
		$.post(baseUrl + 'borrower/addBorrower.do', 
				$(".add-borrower-form").serialize(),
				function(data) {
					if (data.status != '200') {
						alert('添加借阅者失败');
					} else {
						searchBorrower({cardNumber:data.cardNumber,borrowerType:data.type});
					}
				},
				'json'
		);
	});
</script>