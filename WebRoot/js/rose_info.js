//购买数量的减法运算
function sub(){
	var num = parseInt($("#num").val());
	var max = parseInt($("#hide").val());
	if(num > 1 && num <= max){
		$("#num").val(num-1);
	}
	else if(num <= 1){
		$("#num").val(1);
	}
	else if(num > max){
		$("#num").val(max);
	}
}
//购买数量的加法运算
function add(){
	var num = parseInt($("#num").val());
	var max = parseInt($("#hide").val());
	if(num > 0 && num < max){
		$("#num").val(num + 1);
	}
	else if(num <= 0){
		$("#num").val(1);
	}
	else if(num >= max){
		$("#num").val(max);
	}
}
//加入购物车
function shopping(roseId,brandId){
	$.post('shopping', {}, function(r){
		if(r == 1){
			var num = $("#num").val();
			window.location.href="shopping?method=getList&roseId="+roseId+"&brandId="+brandId+"&num="+num;
		}else{
			$(".alogin").show();
			$(".login").show();
		}
	});
}
//立即购买
function nowBuy(roseId,brandId){
	$.post('shopping', {}, function(r){
		if(r == 1){
			var num = $("#num").val();
			window.location.href="shopping?method=getList&roseId="+roseId
			+"&brandId="+brandId+"&num="+num+"&nowBuy=true";
		}else{
			$(".alogin").show();
			$(".login").show();
		}
	});
}






