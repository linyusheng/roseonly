<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript">
	//分页查询
	function searchForPage(page) {
		document.selectform.currentpage.value = page;
		if (document.selectform.currentpage.value != null) {
			document.selectform.submit();
		} else {
			window.alert("当前页面值不能为空!");
		}
	}
</script>
<form id="selectform" action="roseManager" method="post">
	<div style="float：left;margin-right: 20px;">
		<ul class="pagination" style="margin: 0;">
			<c:choose>
				<c:when test="${pageVO.page == 1}">
					<li class="disabled"><a href="javascript:void(0);">&laquo;上一页</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="roseManager?method=pageFindRose&page=${pageVO.page-1}">&laquo;上一页</a></li>	
				</c:otherwise>
			</c:choose>
			
			<c:choose>
				<c:when test="${pageVO.page < pageVO.totalPage}">
					<li><a href="roseManager?method=pageFindRose&page=${pageVO.page+1}">下一页&raquo;</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a href="javascript:void(0);">下一页&raquo;</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</form>