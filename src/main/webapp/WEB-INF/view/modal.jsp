<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
		<h3 id="myModalLabel">提示</h3>
	</div>
	<div class="modal-body">
		<h3 class="msg"></h3>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">确认</button>
	</div>
</div>
<script>
	function modal(msg, fn) {
		if (fn) {
			$("#myModal").on('hidden',fn);
		}
		$(".modal-body .msg").html(msg);
		$("#myModal").modal();
	}
</script>