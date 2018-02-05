<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<script type="text/javascript">
function delAccountById(id){
	$("#bt2").alertmsg('confirm', '确认删除？',{ okCall:function(){
		toOK(id);
	}});
}
function toOK(id){
	$.ajax({
		type:"POST",
		data:{id:id},
		url:'<c:url value="/back/member/deleteAccount.do"/>',
		success:function(msg){
			if("success"==msg){
				operationSuccess();
			};
			if("fail"==msg){
				operationFail();
			};
		}
	});
}
function operationSuccess(){
	$("#bt2").alertmsg('ok','删除成功！');
	$.CurrentNavtab.navtab("refresh");
}
function operationFail(){
	$("#bt2").alertmsg('error','删除用户失败！');
	$.CurrentNavtab.navtab("refresh");
}
</script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<c:url value="/back/member/accountList.do"/>" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}">
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}">
        <input type="hidden" name="orderField" value="${param.orderField}">
        <input type="hidden" name="orderDirection" value="${param.orderDirection}">
        <div class="bjui-searchBar">
        	<label>登录名：</label><input type="text" id="userName" value="${userName}" name="userName" size="15" class="form-control">&nbsp;
        	<label>邮箱：</label><input type="text" id="email" value="${email}" name="email" size="15" class="form-control">&nbsp;
        	<label>民族：</label><input type="text" id="nation" value="${nation}" name="nation" size="10" class="form-control">&nbsp;
        	<label>电话号码：</label><input type="text" id="phoneNumber" value="${phoneNumber}" name="phoneNumber" size="15" class="form-control">&nbsp;
        	<br/>
            <label>性别:</label>
            <select name="sex" data-toggle="selectpicker">
				<option value="" >请选择</option>
				<option value="0" <c:if test="${sex eq 0}">selected</c:if>>女</option>
				<option value="1" <c:if test="${sex eq 1}">selected</c:if>>男</option>
			</select>&nbsp;
            <label>帐号状态:</label>
            <select name="accountState" data-toggle="selectpicker">
				<option value="" >请选择</option>
				<option value="${bxt:getEnumValue('AccountStatusEnum','WAIT_ACTIVATE')}" <c:if test="${accountState eq bxt:getEnumValue('AccountStatusEnum','WAIT_ACTIVATE')}">selected</c:if>>${bxt:getEnumName("AccountStatusEnum","WAIT_ACTIVATE")}</option>
				<option value="${bxt:getEnumValue('AccountStatusEnum','SUCCESS_ACTIVATE')}" <c:if test="${accountState eq bxt:getEnumValue('AccountStatusEnum','SUCCESS_ACTIVATE')}">selected</c:if>>${bxt:getEnumName("AccountStatusEnum","SUCCESS_ACTIVATE")}</option>
				<option value="${bxt:getEnumValue('AccountStatusEnum','FAILURE_ACTIVATE')}" <c:if test="${accountState eq bxt:getEnumValue('AccountStatusEnum','FAILURE_ACTIVATE')}">selected</c:if>>${bxt:getEnumName("AccountStatusEnum","FAILURE_ACTIVATE")}</option>
			</select>&nbsp;
            <button type="submit" class="btn-default" data-icon="search">查询</button>&nbsp;
            <a class="btn btn-orange" href="javascript:;" data-toggle="reloadsearch" data-clear-query="true" data-icon="undo">清空查询</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
        
            <tr>
                <th>登录名</th>
                <th>邮箱</th>
                <th>性别</th>
                <th>民族</th>
                <th>电话号码</th>
                <th>帐号状态</th>
                <th>创建时间</th>
                <th>最后登录</th>
                <th width="100">操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${po.results}" var="info" varStatus="s">
            <tr data-id="${info.id}">
                <td>${info.userName}</td>
                <td>${info.email}</td>
                <td>
	                <c:if test="${info.sex eq 0}">女</c:if>
	                <c:if test="${info.sex eq 1}">男</c:if>
                </td>
                <td>${info.nation}</td>
                <td>${info.phoneNumber}</td>
               	<td>
					<c:if test="${info.accountState eq bxt:getEnumValue('AccountStatusEnum','WAIT_ACTIVATE')}">${bxt:getEnumName("AccountStatusEnum","WAIT_ACTIVATE")}</c:if>
	               	<c:if test="${info.accountState eq bxt:getEnumValue('AccountStatusEnum','SUCCESS_ACTIVATE')}">${bxt:getEnumName("AccountStatusEnum","SUCCESS_ACTIVATE")}</c:if>
	               	<c:if test="${info.accountState eq bxt:getEnumValue('AccountStatusEnum','FAILURE_ACTIVATE')}">${bxt:getEnumName("AccountStatusEnum","FAILURE_ACTIVATE")}</c:if>
                </td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${info.registTime}" /></td>
                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${info.lastLogTime}" /></td>
                <td>
                	<a href="<c:url value="/back/member/accountForm.do?id=${info.id}"/>" class="btn btn-green" data-icon="fa-eye" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-mask" data-mask="true">信息查看</a>
                	<a href="<c:url value="/back/member/accountUpdateForm.do?id=${info.id}"/>" data-icon="fa-pencil" class="btn btn-blue" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-mask" data-mask="true">编辑</a>
                	<button id="bt2" data-on-close="beforeClose" data-on-load="DonLoad" type="button" data-icon="fa-times" class="btn-red" onclick="delAccountById('${info.id}')">删除</button>
                	<a href="<c:url value="/back/member/moduleOfAccountForm.do?id=${info.id}"/>" class="btn btn-orange" type="button" data-icon="fa-cog" data-toggle="dialog" data-width="800" data-height="400" data-id="dialog-mask" data-mask="true">权限分配</a>
                </td>
            </tr>
            </c:forEach>
            
        </tbody>
    </table>
</div>
<div class="bjui-pageFooter">
    <div class="pages">
        <span>每页&nbsp;</span>
        <div class="selectPagesize">
            <select data-toggle="selectpicker" data-toggle-change="changepagesize">
                <option value="20">20</option>
                <option value="30">30</option>
                <option value="60">60</option>
                <option value="120">120</option>
                <option value="150">150</option>
            </select>
        </div>
        <span>&nbsp;条，共 ${po.total} 条</span>
    </div>
    <div class="pagination-box" data-toggle="pagination" data-total="${po.total}" data-page-size="${po.neverypage}" data-page-current="1">
    </div>
</div>
<script type="text/javascript">
//加载前
 function DonLoad(){
	 $.CurrentNavtab.navtab("refresh");
	return true;
} 
//页面关闭刷新当前页面
 function beforeClose(){
	 $.CurrentNavtab.navtab("refresh");
	return true;
} 
</script>
