<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<div class="bjui-pageContent">
	<form method="post" id='account-form' name="accountForm" 
	action="<c:url value='/back/member/saveAccount.do'/>"
		data-toggle="validate" data-alertmsg="false">
		<input type="hidden" name="custom.id"
			value="edce142bc2ed4ec6b623aacaf602a4de">
			<table class="table table-condensed table-hover" width="100%">
				<tbody>
					<tr>
						<td>
							<label for="j_custom_name" class="control-label x150">登录名称：</label>
							${accountForm.userName}
							<input type="hidden" name="id" id="id" value="${accountForm.id}" />
						</td>
						<td>
							<label for="j_custom_name" class="control-label x150">邮箱：</label>
							${accountForm.email}
						</td>
					</tr>
					<tr>
						<td>
							<label for="j_custom_name" class="control-label x150">帐号类型：</label>
							<c:if test="${accountForm.accountType eq 1}">教师</c:if>
			               	<c:if test="${accountForm.accountType eq 2}">学生</c:if>
						</td>
						<td>
							<label for="j_custom_name" class="control-label x150">民族：</label>
							${accountForm.nation}
						</td>
					</tr>
					<tr>
						<td>
							<label for="j_custom_name" class="control-label x150">性别：</label>
							<c:if test="${accountForm.sex eq 0}">女</c:if>
			               	<c:if test="${accountForm.sex eq 1}">男</c:if>
						</td>
						<td>
							<label for="j_custom_name" class="control-label x150">电话号码：</label>
							${accountForm.phoneNumber}
						</td>
					</tr>
					<tr>
						<td>
							<label for="j_custom_name" class="control-label x150">登录时间：</label>
							<fmt:formatDate pattern="yyyy-MM-dd HH:MM:SS" value="${accountForm.lastLogTime}" />
						</td>
						<td>
							<label for="j_custom_name" class="control-label x150">创建时间：</label>
							<fmt:formatDate pattern="yyyy-MM-dd HH:MM:SS" value="${accountForm.registTime}" />
						</td>
					</tr>
				</tbody>
			</table>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
    </ul>
</div>