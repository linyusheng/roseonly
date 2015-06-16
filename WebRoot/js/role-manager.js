$(function() {
	//显示添加角色对话框
	$("#addButton").click(function(){
		$("#addDialog").modal("show");
	});
	//对话框关闭事件
	$('#addDialog,#editDialog').on('hide.bs.modal', function () {
		$(".reset").click();
	});
	//修改角色
	$('.edit').click(function(e){
		//获取数据
		var a = $(this).siblings();
		var typeId = a.eq(1).text();
		var typeName = a.eq(2).text();
		console.info(typeId+typeName);
		$("#editForm input[name='typeId']").val(typeId);
		$("#editForm input[name='typeName']").val(typeName);
	});
});