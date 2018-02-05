//工具类的js

checkIsEmpty = function(obj) {// 输入框非空性验证，空：false，非空，true
	if ($.trim((obj).val()) == "")
		return false;
	else
		return true;
}

trimValue = function(obj) {// 输入框去空格
	return $.trim($(obj).val());
}

checkMobile = function(str) {// 手机号格式验证
	var reg = /^1[3|4|5|8][0-9]\d{4,8}$/;
	return reg.test($.trim(str));
}

checkEmail = function(str) {// 邮箱格式验证
	var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
	return reg.test(str);
}