<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<script type="text/javascript">
	$(function(){
		
	//接收表单验证通过的事件
	$('#account-form').bind('valid.form', function(){
	    $.ajax({
	        url: '<c:url value="/back/member/updateAccount.do"/>',
	        type: 'POST',
	        data: {
				id:'${accountForm.id}',
				userName:$("#uuserName").val(),
				password:$("#upassword").val(),
				email:$("#uemail").val(),
				phoneNumber:$("#uphoneNumber").val(),
				sex:$("#usex").val(),
				nation:$("#unation").val(),
				accountState:$("#ustate").val(),
				accountType:$("#utype").val()
			},
	        success: function(){
       			 ok();	
	        }
	    });
	});
	function ok(){
		$.CurrentDialog.alertmsg('ok','编辑并保存成功！');
		$.CurrentDialog.dialog("closeCurrent");
	}
	});
</script>
<div class="bjui-pageContent">
	<form method="post" id='account-form' action="" data-toggle="validate" data-alertmsg="false" autocomplete="off" data-validator-option="{theme:'simple_right'}">
			<table class="table table-condensed table-hover" width="100%">
				<tbody>
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">登录名称：</label>
								<input disabled="disabled" name="userName" id="uuserName"
										value="${accountForm.userName}" type="text"
										data-rule="required;username" size="15" onkeyup="validateName()" />
							</td>
							<td>
								<label for="j_custom_name" class="control-label x150">登录密码：</label>
									<input <c:if test="${not empty accountForm.id}">value=""</c:if>
										id="upassword" type="password"
										name="accountForm.password" data-rule="密码:required; password"
										value="${accountForm.password}" size="15"
										 />
							</td>
						</tr>
							<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">确认密码：</label>
								<input id="password2" name="password2" type="password" value=""
								type="text" size="15" data-rule="确认密码:required;match(accountForm.password)" />
							</td>
							<td>
								<label for="j_custom_name" class="control-label x150">电子邮箱：</label>
								<input name="email" id="uemail" value="${accountForm.email}" type="text" size="15"
										data-rule="required;email" />
							</td>
						</tr>
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">电话号码：</label>
								<input type="text" id="uphoneNumber" value="${accountForm.phoneNumber}" size="15"
										data-rule="required;mobile" />
							    </td>
							<td>
								<label for="j_custom_name" class="control-label x150">性别：</label>
								<select  name="sex" id="usex" data-toggle="selectpicker" data-rule="required">
							       <option value="0" <c:if test="${accountForm.sex eq 0}">selected</c:if>>女</option>
							       <option value="1" <c:if test="${accountForm.sex eq 1}">selected</c:if>>男</option>
							    </select>
							</td>
						</tr>
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">民族：</label>
								<input name="nation" value="${accountForm.nation}" type="text" size="15"
										data-rule="required" id="unation"/>
							</td>
							<td>
								<label for="j_custom_name" class="control-label x150">状态：</label>
							    <select  name="accountState" id="ustate" data-toggle="selectpicker" data-rule="required">
							        <option value="${bxt:getEnumValue('AccountStatusEnum','WAIT_ACTIVATE')}" <c:if test="${accountForm.accountState eq bxt:getEnumValue('AccountStatusEnum','WAIT_ACTIVATE')}">selected</c:if>>${bxt:getEnumName("AccountStatusEnum","WAIT_ACTIVATE")}</option>
							        <option value="${bxt:getEnumValue('AccountStatusEnum','SUCCESS_ACTIVATE')}" <c:if test="${accountForm.accountState eq bxt:getEnumValue('AccountStatusEnum','SUCCESS_ACTIVATE')}">selected</c:if>>${bxt:getEnumName("AccountStatusEnum","SUCCESS_ACTIVATE")}</option>
							        <option value="${bxt:getEnumValue('AccountStatusEnum','FAILURE_ACTIVATE')}" <c:if test="${accountForm.accountState eq bxt:getEnumValue('AccountStatusEnum','WAIT_ACTIVATE')}">selected</c:if>>${bxt:getEnumName("AccountStatusEnum","FAILURE_ACTIVATE")}</option>
							    </select>
							</td>
						</tr>
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">账号类型：</label>
								<select  name="accountType" id="utype" data-toggle="selectpicker" data-rule="required">
							        <option value="1" <c:if test="${accountForm.accountType eq 1}">selected</c:if>>教师</option>
							        <option value="2" <c:if test="${accountForm.accountType eq 2}">selected</c:if>>学生</option>
							    </select>
							    </td>
							<td>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input type="reset" value="重置" />
							</td>
						</tr>
				</tbody>
			</table>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
        <li><button id="qr1" type="submit" class="btn-green">保存</button></li>
    </ul>
</div>