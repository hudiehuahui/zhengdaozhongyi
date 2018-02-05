<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<script type="text/javascript">
	function delModuleById(id){
		$("#bt11").alertmsg('confirm', '确认删除？',{ okCall:function(){
			toConfirm(id);
		}});
	}
	function toConfirm(id){
		$.ajax({
			type:"POST",
			data:{id:id},
			url:'<c:url value="/back/module/removeModule.do"/>',
			success:function(msg){
				if("success"==msg){
					$.CurrentNavtab.navtab("refresh");
				}
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
        <div class="bjui-searchBar">
        <a href="<c:url value="/back/module/addModuleForm.do?"/>" class="btn btn-green" data-on-close="beforeClose" data-on-load="DonLoad" data-toggle="dialog" data-width="800" data-height="300" data-id="dialog-mask" data-mask="true">添加模块</a>
        </div>
    </form>
</div>
<div class="bjui-pageContent tableContent">
    <table class="table table-bordered table-hover table-striped table-top" data-selected-multi="true">
        <thead>
            <tr>
			    <th>模块名称</th>
                <th>模块编号</th>
                <th>模块描述</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${po.results}" var="info" varStatus="s">
            <tr data-id="${info.id}">
				<td>${info.name}</td>
                <td>${info.number}</td>
                <td>${info.descb}</td>
                <td>
				    <button id="bt11" data-on-close="beforeClose" data-on-load="DonLoad" type="button" class="btn-orange" onclick="delModuleById('${info.id}')">删除</button>
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