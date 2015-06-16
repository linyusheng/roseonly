$(function() {
	//修改个人信息表单提交
	$('#myInfo_form').submit(function(e) {
		$.post('admin?method=editMyInfo',$(this).serialize(),function(r){
			if(r == "true"){
				$("#myInfo_dialog").modal("hide");
				$("#tip_content").html("<span class='icon-ok'></span>&nbsp;修改成功！");
				$("#tip_dialog").modal("show");
			}else{
				$("#tip_content").html("<span class='icon-remove '></span>&nbsp;修改失败！");
				$("#tip_dialog").modal("show");
			}
		});
		return false;
	});
	//修改密码表单提交
	$('#editPsw_form').submit(function(e) {
		$.post('admin?method=editPsw',$(this).serialize(),function(r){
			if(r == "true"){
				$("#editPsw_dialog").modal("hide");
				$("#tip_content").html("<span class='icon-ok'></span>&nbsp;修改成功！");
				$("#tip_dialog").modal("show");
			}else{
				$("#tip_content").html("<span class='icon-remove '></span>&nbsp;修改失败！");
				$("#tip_dialog").modal("show");
			}
		});
		return false;
	});
	//修改密码对话框关闭事件
	$('#editPsw_dialog').on('hide.bs.modal', function () {
		$("#reset").click();
	});
	//验证原始密码
	$("#editPsw_dialog input[name='oldPsd']").on("blur",function(){
		$.post('admin?method=checkOldPsw',{oldPsd:$(this).val()},function(r){
			if(r == "false"){
				$(this).tooltip({
					titile:"原始密码输入不正确！",
					trigger:"manual"
				});
				$(this).show();
			}
		});
		
	});
	
	
});