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
<form id="selectform" action="userManager" method="post">
	<div style="float：left;margin-right: 20px;">
		<ul class="pagination" style="margin: 0;">
			<c:choose>
				<c:when test="${pageVO.page == 1}">
					<li class="disabled"><a href="javascript:void(0);">&laquo;</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="userManager?method=pageFindUser&page=${pageVO.page-1}">&laquo;</a></li>	
				</c:otherwise>
			</c:choose>
			<c:forEach begin="1" end="${pageVO.totalPage}" varStatus="i">
				<c:choose>
					<c:when test="${pageVO.page == i.index }">
						<li class="active"><a href="javascript:void(0);">${i.index }</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="userManager?method=pageFindUser&page=${i.index}">${i.index }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:choose>
				<c:when test="${pageVO.page < pageVO.totalPage}">
					<li><a href="userManager?method=pageFindUser&page=${pageVO.page+1}">&raquo;</a></li>
				</c:when>
				<c:otherwise>
					<li class="disabled"><a href="javascript:void(0);">&raquo;</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
</form>