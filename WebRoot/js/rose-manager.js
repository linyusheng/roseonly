$(function() {
	//激活工具提示（Tooltip）插件
	$("[data-toggle='tooltip']").tooltip();
	
	//检查用户账号是否唯一
	$("#account").on("change", function(){
		var ele = $(this),v = ele.val();
		ele.data("status",0);
		$.post("register?method=checkUser",{account:v},function(r){
			if(r == 1){
				ele.tooltip('hide');
				ele.data("status",1);
			}else{
				ele.tooltip({
					title:"该用户名已被注册！",
					placement: "right",
					trigger: "manual"
				});
				ele.tooltip('show');
				ele.data("status",0);
			}
		});
	});
	//添加用户表单提交
	$('#addForm').submit(function(){
		var b = true;
		if(!$('#account').data('status')){
			b = false;
		}
		return b;
	});
	//对话框关闭事件
	$('#addDialog,#editDialog').on('hide.bs.modal', function () {
		$("#account").tooltip('destroy');
		$(".reset").click();
	});
	//编辑用户
	$('.edit').click(function(e){
		//获取数据
		var tds = $(this).parent().siblings();
		var userId = tds.eq(1).text();
		var typeId = tds.eq(2).text();
		var account = tds.eq(4).text();
		var password = tds.eq(5).text();
		var mobile = tds.eq(6).text();
		var email = tds.eq(7).text();
		var createTime = tds.eq(8).text();
		$("#editForm input[name='userId']").val(userId);
		$("#editForm select").find("option[value='"+typeId+"']").attr("selected",true);
		$("#editForm input[name='account']").val(account);
		$("#editForm input[name='password']").val(password);
		$("#editForm input[name='mobile']").val(mobile);
		$("#editForm input[name='email']").val(email);
		$("#editForm input[name='createTime']").val(createTime);
	});
	var userId = null;
	//获取用户Id
	$('.delete').click(function(e) {
		userId = $(this).parent().siblings().eq(1).text();
	});
	//确定删除用户事件
	$('#btn-delete-user').click(function(){
		$.post("userManager?method=delete",{userId:userId},function(r){
			if(r == 1){
				$('#deleteDialog').modal('hide');
				window.location.href = "userManager";
			}else{
				tip("删除出错！");
			}
		});
	});
	//全选所有
	$('#all-check').click(function(e) {
		if (this.checked) {
			$('.checkbox').attr('checked', true);
		} else {
			$('.checkbox').attr('checked', false);
		}
	});
	var ids = null;
	//判断用户是否选择了行数据
	$('#delete-users').click(function(){
		//获取选择的用户ID数组
		ids = [];
		$('.checkbox').each(function(i, val) {
			if (this.checked) {
				var id = $('tbody tr:eq(' + i + ') td:nth-child(2)').html();
				ids.push(id);
			}
		});
		if(ids.length > 0){
			$('#deletesDialog').modal("show");
		}else{
			tip("请选择一个用户！");
		}
	});
	//确定批量删除事件
	$('#btn-deletes-user').click(function(e) {
		console.info(ids);
		$.post("userManager?method=deletes",{ids:ids.toString()},function(r){
			if(r == 1){
				$('#deletesDialog').modal('hide');
				window.location.href = "userManager";
			}else{
				tip("删除出错！");
			}
		});
	});
	//搜索用户
	$("#search").click(function(){
		$("#searchSubmit").click();
	});
});
/**
 * 封装提示框
 * @param title
 */
function tip(title){
	$('#tip_content').html("<i class='icon-warning-sign'></i>&nbsp;"+title);
	$('#tip_dialog').modal("show");
}
