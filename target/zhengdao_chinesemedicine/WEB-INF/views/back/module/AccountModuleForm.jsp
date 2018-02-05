<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<script type="text/javascript">
	function batchPrint(){
		var ids = '';
		var idsObj = document.getElementsByName('ids');
		for(i = 0; i< idsObj.length;i++){
			if (idsObj[i].checked == true) {
				ids = idsObj[i].value + ',' + ids;
			}
		}
		ids = ids.substring(0, ids.length - 1);
		if(ids == ''){
			$("#print-dialogs").alertmsg('confirm','您要取消所有模块的权限吗？',{okCall:function(){
				ToConfirmBatchPrint(ids);
			}});
		}else{
			$("#print-dialogs").alertmsg('confirm','您确定要设置已选中的模块信息？',{okCall:function(){
				ToConfirmBatchPrint(ids);
			}});
		}
	}
	
	function ToConfirmBatchPrint(ids){
		$.ajax({
			type:"POST",
			async:false, 
			url:"<c:url value="/back/member/giveModuleToAccount.do"/>",
			data:{ids:ids,accountId:$("#accountId").val()},
			success:function(msg){
				$("#print-dialogs").alertmsg('info','权限设置成功！');
				$.CurrentDialog.dialog("closeCurrent");
			}
		});
	}
	
</script>
<div class="bjui-pageHeader">
    <form id="pagerForm" data-toggle="ajaxsearch" action="<c:url value=''/>" method="post">
        <input type="hidden" name="pageSize" value="${model.pageSize}"/>
        <input type="hidden" name="pageCurrent" value="${model.pageCurrent}"/>
        <input type="hidden" name="orderField" value="${param.orderField}"/>
        <input type="hidden" name="orderDirection" value="${param.orderDirection}"/>
        <input type="hidden" name="accountId" id="accountId" value="${accountForm.id}"/>
        
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
            <tr>
            	<th width="26"><input type="checkbox" class="checkboxCtrl" data-group="ids" data-toggle="icheck"></th>
			    <th>模块名称</th>
                <th>模块编号</th>
                <th>模块描述</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${po.results}" var="info" varStatus="s">
            <tr data-id="${info.id}">
            	<td><input type="checkbox" name="ids" data-toggle="icheck" value="${info.id}" <c:if test="${fn:contains(ss,info.name)}">checked="checked"</c:if>></td>
				<td>${info.name}</td>
                <td>${info.number}</td>
                <td>${info.descb}</td>
            </tr>
        </c:forEach>
        </tbody>
        <tr>
		    <td colspan="4" align="center" >
		      <a id="print-dialogs" onclick="batchPrint();" class="btn btn-blue" data-toggle="doajax" data-confirm-msg="确定操作选中项吗？" >分配权限</a>
		    </td>
	    </tr>
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