<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/taglib.jsp"%>
<html>

<head>
</head>
<body>

	
	<div>
		<a href="<c:url value="/admin/initAccount.do?type=1"/>">1初始化个人用户</a><br>
		<a href="<c:url value="/admin/initAccount.do?type=2"/>">3初始化企业用户</a><br>
		<c:if test="${not empty account }">
		登录名称 :${account.userName }<br />
		邮箱 :${account.email }<br />
		类型 :${account.accountType }
		<c:if test="${account.accountType eq '1' }">
			个人
		</c:if>
			<c:if test="${account.accountType eq '2' }">
			企业
		</c:if>
			<br />
		登录名称 :${account.userName }<br />
		账号状态 :${account.accountState }
			<c:if test="${account.accountState eq '1' }">
			已注册
		</c:if>
			<c:if test="${account.accountState eq '2' }">
			正常
		</c:if>
			<c:if test="${account.accountState eq '3' }">
			停用
		</c:if>
			<br />
			<c:if test="${not empty personalInfo}">
				个人生成成功
			</c:if><br />
			<c:if test="${not empty companyInfo}">
				企业生成成功
			</c:if><br />
			<c:if test="${not empty order}">
				订单相关内容生成OK
			</c:if><br />
			<a href="<c:url value="/admin/initPersonalinfo.do?accountID=${account.id}"/>">2生成个人认证信息4</a>
			<a href="<c:url value="/admin/initCompanyInfo.do?accountID=${account.id}&personalInfoID="/>${personalInfo.id}">5生成企业认证信息</a>
			<a href="<c:url value="/admin/initOrder.do?accountid=${account.id}"/>">初始化订单</a>
		</c:if>
		<c:if test=""></c:if>

	</div>
	
	
</body>
</html>
