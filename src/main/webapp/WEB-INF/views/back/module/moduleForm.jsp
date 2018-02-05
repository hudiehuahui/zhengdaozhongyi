<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<script type="text/javascript">
		
		$('#module-form').bind('valid.form', function(){
			$.ajax({
				url: '<c:url value="/back/module/saveModule.do"/>',
		        type: 'POST',
		        data: {
					name:$("#name").val(),
					number:$("#number").val(),
					descb:$("#descb").val(),
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
	<form method="post" id="module-form" name="moduleForm"  action="" data-toggle="validate" data-alertmsg="false">
			<table class="table table-condensed table-hover" width="100%">
				<tbody>
					<tr>
						<td>
							<label for="j_custom_name" class="control-label x150">模块名：</label>
							<input type="text" name="name" id="name" value="" data-rule="required"/>
						</td>
						<td>
							<label for="j_custom_name" class="control-label x150">模块编号：</label>
							<input type="text" name="number" id="number" value="" data-rule="required;digits"/>
						</td>
					</tr>
					<tr>
						<td>
							<label for="j_custom_name" class="control-label x150">模块描述：</label>
							<input type="text" name="descb" id="descb" value="" />
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
        <li><button id="toSave" type="submit" class="btn-green">保存</button></li>
    </ul>
</div>