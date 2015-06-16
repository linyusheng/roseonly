$(function(){
	//添加收货信息
	$('#J_FormDeliver').submit(function(e){
		$.post('recaddress?method=add',$(this).serialize(),function(r){
			if(r == 1)
			window.location.href="recaddress?method=getAddress";
		});
	});
	
	//修改收货信息
	$('.edit').click(function(recinfoId){
		//获取原始数据
		var tds = $(this).parent().siblings();
		var consignee = tds.eq(0).text();
		var province = tds.eq(1).text();
		var city = tds.eq(2).text();
		var area = tds.eq(3).text();
		var address = tds.eq(4).text();
		var postcode = tds.eq(5).text();
		var mobile = tds.eq(6).text();
		var recInfoId = tds.eq(7).text();
		//将原始数据放回输入框
		$("#Province i").text(province);
		$("#Province input[name='cho_Province']").val(province);
		$("#City i").text(city);
		$("#City input[name='cho_City']").val(city);
		$("#Area i").text(area);
		$("#Area input[name='cho_Area']").val(area);
		$("#J_FormDeliver textarea[name='address']").val(address);
		$("#J_FormDeliver input[name='consignee']").val(consignee);
		$("#J_FormDeliver input[name='postcode']").val(postcode);
		$("#J_FormDeliver input[name='mobile']").val(mobile);
		$("#J_FormDeliver input[name='recinfoId']").val(recInfoId);
	});
	
});