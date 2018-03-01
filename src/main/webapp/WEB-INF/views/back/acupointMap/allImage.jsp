<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ include file="/common/include/back_authority.jsp"%>
<div class="bjui-pageContent">
	<div>
		<c:forEach items="${queryAcupointMapList.results}" var="AcupointMap" varStatus="s">
			<ul>
				<li>
					<a href="<c:url value="/back/acupointMap/detailImage.do?path=${AcupointMap.path}"/>" class="btn btn-orange" type="button" data-icon="fa-cog" data-toggle="navtab" data-id="mynavtab">${AcupointMap.acupointMapName}</a>
				</li>
			</ul>
		</c:forEach>
	</div>
</div>
<div class="bjui-pageFooter">
    <ul>
        <li><button type="button" class="btn-close" data-icon="close">取消</button></li>
    </ul>
</div>
<script type="text/javascript">
</script>