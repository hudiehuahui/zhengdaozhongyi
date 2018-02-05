<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<script type="text/javascript">
	//接收表单验证通过的事件
	$('#admin-form').bind('valid.form', function(){
	    $.ajax({
	        url: '<c:url value="/back/system/updateAdmin.do"/>',
	        type: 'POST',
	        data: {
			id:'${adminForm.ID}',
			password:$("#password").val(),
			email:$("#email").val(),
			phone:$("#phone").val(),
			relName:$("#relName").val(),
			role:$("#station").val(),
			loginName:$("#loginName").val(),
			state:$("#state").val(),
			authorizationcode:$("#authorizationcode").val(),
			},
	        success: function(){
       			 ok();	
	        }
	    });
	});
	function ok(){
		$.CurrentDialog.dialog("closeCurrent");
	}
</script>
<div class="bjui-pageContent">
	<form method="post" id='admin-form' name="adminForm" action="<c:url value=""/>" data-toggle="validate" data-alertmsg="false" autocomplete="off" data-validator-option="{theme:'simple_right'}">
		<input type="hidden" name="custom.id"
			value="edce142bc2ed4ec6b623aacaf602a4de">
			<table class="table table-condensed table-hover" width="100%">
				<tbody>
					<spring:bind path="adminForm.ID">
				    	<input name="<c:out value="${status.expression}"/>" value="${status.value}" type="hidden" size="15" />
					</spring:bind>
					<c:if test="${flag eq '1'}">
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">登录名称：</label>
								${adminForm.loginName}
							</td>
							<td>
								<label for="j_custom_name" class="control-label x150">电子邮箱：</label>
								${adminForm.email}
							</td>
						</tr>
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">手机：</label>
								${adminForm.phone}
							    </td>
							<td>
								<label for="j_custom_name" class="control-label x150">真实姓名：</label>
								${adminForm.relName}
							</td>
						</tr>
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">角色：</label>
				                <c:if test="${adminForm.roleId eq bxt:getEnumValue('AdminRoleStatusEnum','ADMIN')}">${bxt:getEnumName("AdminRoleStatusEnum","ADMIN")}</c:if>
							</td>
							<td>
								<label for="j_custom_name" class="control-label x150">状态：</label>
				                <c:if test="${adminForm.state eq bxt:getEnumValue('AdminRoleStatusEnum','ACTIVATE')}">${bxt:getEnumName("AdminRoleStatusEnum","ACTIVATE")}</c:if>
				               	<c:if test="${adminForm.state eq bxt:getEnumValue('AdminRoleStatusEnum','ABANDONED')}">${bxt:getEnumName("AdminRoleStatusEnum","ABANDONED")}</c:if>
				               	<c:if test="${adminForm.state eq bxt:getEnumValue('AdminRoleStatusEnum','INVALID')}">${bxt:getEnumName("AdminRoleStatusEnum","INVALID")}</c:if>
			                </td>
						</tr>
						<%-- <tr>
							<td>
								<label for="j_custom_name" class="control-label x150">授权码：</label>
								${adminForm.authorizationcode}
						    </td>
							<td>
							</td>
						</tr> --%>
					</c:if>
					<c:if test="${flag eq '2'}">
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">登录名称：</label>
								<spring:bind path="adminForm.loginName">
									<input
										<c:if test="${not empty adminForm.ID}">disabled="disabled"</c:if>
										name="<c:out value="${status.expression}"/>" id="loginName"
										value="<c:out value="${status.value}"/>" type="text"
										data-rule="required;username" size="15" onkeyup="validateName()" />
									<font color="red" id="erroInfo">${erroInfo}</font>
								</spring:bind>
							</td>
							<td>
								<label for="j_custom_name" class="control-label x150">登录密码：</label>
								<spring:bind path="adminForm.password">
									<input <c:if test="${not empty adminForm.ID}">value=""</c:if>
										id="password" type="password"
										name="adminForm.password" data-rule="密码:required; password"
										value="${status.value}" size="15"
										 />
								</spring:bind>
							</td>
						</tr>
							<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">确认密码：</label>
								<input id="password2" name="password2" type="password" value=""
								type="text" size="15" data-rule="确认密码:required;match(adminForm.password)" />
							</td>
							<td>
								<label for="j_custom_name" class="control-label x150">电子邮箱：</label>
								<spring:bind path="adminForm.email">
									<input name="<c:out value="${status.expression}"/>" id="email"
										value="${status.value}" type="text" size="15"
										data-rule="required;email" />
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">手机：</label>
								<spring:bind path="adminForm.phone">
									<input name="<c:out value="${status.expression}"/>"
										value="${status.value}" type="text" size="15"
										data-rule="required;mobile" id="phone"/>
								</spring:bind>
							    </td>
							<td>
								<label for="j_custom_name" class="control-label x150">真实姓名：</label>
								<spring:bind path="adminForm.relName">
									<input name="<c:out value="${status.expression}"/>"
										value="${status.value}" type="text" size="15"
										data-rule="required" id="relName"/>
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">角色：</label>
								<spring:bind path="adminForm.roleId">
								    <select  name="${status.expression}" id="station" data-toggle="selectpicker" data-rule="required">
								       <option value="${ bxt:getEnumValue('AdminRoleStatusEnum','ADMIN')}" <c:if test="${adminForm.roleId eq bxt:getEnumValue('AdminRoleStatusEnum','ADMIN')}">selected</c:if>>${bxt:getEnumName("AdminRoleStatusEnum","ADMIN")}</option>
								    </select>
								</spring:bind>
							</td>
							<td>
								<label for="j_custom_name" class="control-label x150">状态：</label>
								<spring:bind path="adminForm.state">
								    <select  name="${status.expression}" id="state" data-toggle="selectpicker" data-rule="required">
								        <option value="${bxt:getEnumValue('AdminRoleStatusEnum','ACTIVATE')}" <c:if test="${adminForm.state eq bxt:getEnumValue('AdminRoleStatusEnum','ACTIVATE')}">selected</c:if>>${bxt:getEnumName("AdminRoleStatusEnum","ACTIVATE")}</option>
										<option value="${bxt:getEnumValue('AdminRoleStatusEnum','ABANDONED')}" <c:if test="${adminForm.state eq bxt:getEnumValue('AdminRoleStatusEnum','ABANDONED')}">selected</c:if>>${bxt:getEnumName("AdminRoleStatusEnum","ABANDONED")}</option>
										<option value="${bxt:getEnumValue('AdminRoleStatusEnum','INVALID')}" <c:if test="${adminForm.state eq bxt:getEnumValue('AdminRoleStatusEnum','INVALID')}">selected</c:if>>${bxt:getEnumName("AdminRoleStatusEnum","INVALID")}</option>
								    </select>
								</spring:bind>
							</td>
						</tr>
						<tr>
							<td>
								<label for="j_custom_name" class="control-label x150">授权码：</label>
								<spring:bind path="adminForm.authorizationcode">
									<input name="<c:out value="${status.expression}"/>"
										value="${status.value}" type="password" size="15"
										data-rule="required" id="authorizationcode"/>
								</spring:bind>
							    </td>
							<td>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">
							<input type="reset" value="重置" />
							</td>
						</tr>
					</c:if>
				</tbody>
			</table>
	</form>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
        <c:if test="${flag eq 2}">
        	<li><button id="qr1" type="submit" class="btn-green" >保存</button></li>
        </c:if>
    </ul>
</div>