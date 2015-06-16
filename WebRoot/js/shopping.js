$(function(){
	countTotal();
	$('#cart_pay').click(function(){
		if($("table tr").length == 1){
			alert("你的购物车没有产品！");
			return;
		}
		window.location.href = "shopping?method=cartPay";
		
	});
});

//购买数量的减法运算
function sub(e,shoppingId){
	var input_num = $(e).siblings().eq(0);
	var input_max = $(e).siblings().eq(1);
	var num = parseInt(input_num.val());
	var max = parseInt(input_max.val());
	if(num > 1 && num <= max){
		input_num.val(num-1);
	}
	else if(num <= 1){
		input_num.val(1);
	}
	else if(num > max){
		input_num.val(max);
	}
	//刷新价格
	var td_price = $(e).parent().siblings().eq(4);
	var td_total = $(e).parent().siblings().eq(5);
	td_total.text(parseFloat(td_price.text()) * parseFloat(input_num.val()));
	changeNum(shoppingId,parseInt(input_num.val()));
}
//购买数量的加法运算
function add(e,shoppingId){
	var input_num = $(e).siblings().eq(1);
	var input_max = $(e).siblings().eq(2);
	var num = parseInt(input_num.val());
	var max = parseInt(input_max.val());
	if(num > 0 && num < max){
		input_num.val(num + 1);
	}
	else if(num <= 0){
		input_num.val(1);
	}
	else if(num >= max){
		input_num.val(max);
	}
	//刷新价格
	var td_price = $(e).parent().siblings().eq(4);
	var td_total = $(e).parent().siblings().eq(5);
	td_total.text(parseFloat(td_price.text()) * parseFloat(input_num.val()));
	changeNum(shoppingId,parseInt(input_num.val()));
}
//改变购物车的数量
function changeNum(shoppingId,num){
	var data = {
		shoppingId:shoppingId,
		num:num
	};
	$.post('shopping?method=changeNum', data, function(r){
		if(r == 1){
			countTotal();
		}else{
			alert();
		}
	});
}
//计算总金额
function countTotal(){
	var total = 0;
	$(".total_price").each(function(i,ele){
		total += parseFloat($(ele).text());
	});
	$("#cart_total").text(total);
}











