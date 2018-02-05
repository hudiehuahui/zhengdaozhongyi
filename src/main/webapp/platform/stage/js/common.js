//前端公用的动效js

$(".login-btn").hover(function() {// 登录注册处的大按钮，鼠标悬浮显示一个小箭头
	$(this).find("img").show();
	$(this).find("a").css("color", "#fff");
}, function() {
	$(this).find("img").hide();
	if ($(this).hasClass("btn-gray")) {
		$(this).find("a").css("color", "#999");
	} else {
		$(this).find("a").css("color", "#1d873f");
	}
});