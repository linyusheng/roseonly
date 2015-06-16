$(function() {
	//对话框关闭事件
	$('#addDialog,#editDialog').on('hide.bs.modal', function () {
		$(".reset").click();
	});
	//编辑用户
	$('.edit').click(function(e){
		//获取数据
		var tds = $(this).parent().siblings();
		var menuId = tds.eq(1).text();
		var menuName = tds.eq(2).text();
		var menuUrl = tds.eq(3).text();
		var target = tds.eq(4).text();
		var status = tds.eq(5).text();
		$("#editForm input[name='menuId']").val(menuId);
		$("#editForm input[name='menuName']").val(menuName);
		$("#editForm input[name='menuUrl']").val(menuUrl);
		$("#editForm select[name='target']").find("option[value='"+target+"']").attr("selected",true);
		$("#editForm select[name='status']").find("option[value='"+status+"']").attr("selected",true);
	});
	var menuId = null;
	//获取菜单Id
	$('.delete').click(function(e) {
		menuId = $(this).parent().siblings().eq(1).text();
	});
	//确定删除菜单事件
	$('#btn-delete').click(function(){
		$.post("menuManager?method=delete",{menuId:menuId},function(r){
			if(r == 1){
				$('#deleteDialog').modal('hide');
				window.location.href = "menuManager";
			}else{
				tip("icon-warning-sign","删除出错！");
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
	$('#deletes').click(function(){
		//获取选择的ID数组
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
			tip("icon-warning-sign","请选择一个菜单！");
		}
	});
	//确定批量删除事件
	$('#btn-deletes').click(function(e) {
		$.post("menuManager?method=deletes",{ids:ids.toString()},function(r){
			if(r == 1){
				$('#deletesDialog').modal('hide');
				window.location.href = "menuManager";
			}else{
				tip("icon-warning-sign","删除出错！");
			}
		});
	});
	//静态化菜单
//	$("#staticMenu").click(function(){
//		$.post("menuManager?method=staticMenu",{},function(r){
//			$('#staticDialog').modal('hide');
//			if(r == 1){
//				tip("icon-ok","静态化成功！");
//			}else{
//				tip("icon-warning-sign","静态化失败！");
//			}
//		});
//		
//	});
});
/**
 * 封装提示框
 * @param title
 */
function tip(icon,title){
	$('#tip_content').html("<i class='"+icon+"'></i>&nbsp;"+title);
	$('#tip_dialog').modal("show");
}
