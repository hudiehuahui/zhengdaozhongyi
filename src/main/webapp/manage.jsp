<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/common/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>子午流注诊疗系统</title>

<meta http-equiv="content-type" content="text/html; charset=UTF-8" />

<link rel="stylesheet" href="<c:url value="/static/css/bootstrap.min.css"/>" type="text/css" />
<script type="text/javascript" src="<c:url value="/static/1.9.1/jquery.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/jquery.tips.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/jquery.cookie.js"/>"></script>
<link href="<c:url value="/platform/stage/css/style.css"/>" rel="stylesheet" type="text/css" />
<link href="<c:url value="/platform/stage/css/main.css"/>" rel="stylesheet" type="text/css" />
</head>

<body style="overflow: hidden; ">
		<div class="backlogin-img">
				<img src="<c:url value='platform/stage/image/portals/back-ground.png'/>"></img>
				
		</div>
		<div class="backlogin-content">
				<div class="login-content">
						<p>
								子午流注诊疗系统
						</p>
						<img src="<c:url value='platform/stage/image/portals/back-user.png'/>"></img>
						<form action="<c:url value='/system/login.do'/>" method="post" name="loginForm" id="loginForm">
							<span>用户名：</span>
							<input type="text" name="j_username" id="loginname" value="" placeholder="请输入用户名"/>
							<hr />
							<img src="<c:url value='platform/stage/image/portals/back-psw.png'/>"></img>
							<span>&nbsp;密&nbsp;&nbsp;&nbsp;码：</span>
							<input type="password" name="keypassword" id="keypassword" value=""  placeholder="请输入密码"/>
							<hr style="margin: 0 0 24px 0;" />
							<div class="slideThree">
									<input type="checkbox" value="None" id="saveid" name="check" checked onclick="savePaw();" />
									<label for="saveid"></label>
							</div>
							<span class="remenberPsw">记住密码</span>
	
							<button type="button" class="portalBtn " onclick="severCheck();">登录</button>
							<button class="portalBtn " style="margin: 0px;" type="button" onclick="quxiao();">取消</button>
						</form>
				</div>
		</div>
		<script type="text/javascript" color="0,0,255" opacity='0.7' zIndex="-2" count="99" src="<c:url value='static/hm/canvas-nest.js'/>"></script>
<script type="text/javascript">
	<c:if test='${not empty sessionScope.flag}'>
	<c:if test="${flag eq 'usererror'}">
	alert('用户名或密码错误');
	</c:if>
	<c:if test="${flag eq 'passwordError'}">
	alert('用户名或密码错误');
	</c:if>
	<c:if test="${flag eq 'invalidname'}">
	alert('该用户名已经锁定');
	</c:if>
	<c:remove var='rs' scope='session'/>
	<c:remove var='flag' scope='session'/>
	</c:if>
//服务器校验
	function severCheck() {
		if (check()) {
			savePaw();
			$("#loginForm").submit();
		}else{
			return false;
		}
	}
	//客户端校验
	function check() {
		//证书登录校验   便于测试开放用户名密码登录 正式只有key登录
		/* var keyid = document.getElementById("keyid").value;
		if (keyid != "") {
			if (!checkCert()) {
				return false;
			}
		} */
		if ($("#loginname").val() == "") {

			$("#loginname").tips({
				side : 2,
				msg : '用户名不得为空',
				bg : '#AE81FF',
				time : 3
			});

			$("#loginname").focus();
			return false;
		} else {
			$("#loginname").val(jQuery.trim($('#loginname').val()));
		}

		if ($("#keypassword").val() == "") {

			$("#keypassword").tips({
				side : 2,
				msg : '密码不得为空',
				bg : '#AE81FF',
				time : 3
			});

			$("#keypassword").focus();
			return false;
		}
		/* $("#loginbox").tips({
			side : 1,
			msg : '正在登录 , 请稍后 ...',
			bg : '#68B500',
			time : 10
		}); */

		return true;
	}
	function savePaw() {
		var loginname=$("#loginname").val();
		var keypassword= $("#keypassword").val();
		var flag=$("#saveid").attr("checked");
		$.cookie('flag', flag, {
					expires : 60 * 60 * 24 * 3
				});
	 	if ($("#saveid").attr("checked")) {
				$.cookie('loginname', escape(loginname), {
					expires : 60 * 60 * 24 * 3
				});
				$.cookie('keypassword', escape(keypassword), {
					expires : 60 * 60 * 24 * 3
				});
			}else{
				$.cookie('loginname', "");
				$.cookie('keypassword', "");
			}
	}
	function quxiao() {
		$("#loginname").val('');
		$("#keypassword").val('');
	}
	jQuery(function() {
		var loginname= $.cookie('loginname');
		var keypassword= $.cookie('keypassword');
		if ( typeof (loginname) != "undefined"&&loginname!="" && typeof (keypassword) != "undefined"&&keypassword!="") {
			$("#loginname").val(unescape(loginname));
			$("#keypassword").val(unescape(keypassword));
			$("#saveid").attr("checked", true);
		}
	});
</script>
</body>
</html>
