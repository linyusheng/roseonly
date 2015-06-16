$(function() {
	$('.radio_address:eq(0)').attr("checked",true);
	$("input[name='address_id']").click(function(){
		if($("input[name='address_id']:checked").val() != 0){
			$('#consignee_addr').hide();
		}
	});
	//console.info($("input[name='address_id']:checked").val());
});

//验证手机号码
function checkmobile(obj) 
{ 
	var reg=obj.value.match(/^1[3458]\d{9}$/);
	if(obj.value==""){
		document.getElementById("mobile_tip").innerHTML='<font style="color: #D40000;">请输入有效的手机号码！</font>';
	}
	else if (!reg) {
		document.getElementById("mobile_tip").innerHTML='<font style="color: #D40000;">请输入有效的手机号码！</font>';
	}
}

//清除手机号码提示
function cleanmobileTip(){
	document.getElementById("mobile_tip").innerHTML="";
}

//验证邮箱
function checkemail(obj) 
{ 
	var reg=obj.value.match(/[_a-z\d\-\./]+@[_a-z\d\-]+(\.[_a-z\d\-]+)*(\.(info|biz|com|edu|gov|net|am|bz|cn|cx|hk|jp|tw|vc|vn))$/);
	if(obj.value==""){
		document.getElementById("email_tip").innerHTML='<font style="color: #D40000;">请输入有效的电子邮箱！</font>';
	}
	else if (!reg) {
		document.getElementById("email_tip").innerHTML='<font style="color: #D40000;">请输入有效的电子邮箱！</font>';
	}
}
//清除邮箱提示
function cleanemailTip(){
	document.getElementById("email_tip").innerHTML="";
}
//验证邮编
function checkzip(obj) 
{ 
	var reg=obj.value.match(/^[0-9]{6}$/);
	if(obj.value==""){
		document.getElementById("zip_tip").innerHTML='<font style="color: #D40000;">请输入有效的邮编！</font>';
	}
	else if (!reg) {
		document.getElementById("zip_tip").innerHTML='<font style="color: #D40000;">请输入有效的邮编！</font>';
	}
}

//清除邮编提示
function cleanzipTip(){
	document.getElementById("zip_tip").innerHTML="";
}
