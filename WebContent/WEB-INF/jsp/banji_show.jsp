<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/jquery-1.11.1.js"></script>
<style type="text/css">
	.form-group{
		width: 130px;
	}
	.form-group .form-control{
		width: 80px;
	}
</style>
<script type="text/javascript">
	function goPage(pageIndex) {
		$("#pageIndex").val(pageIndex);
		$("#searchForm").submit();
	}
	function delBanji(bid) {
		var isDelEle = confirm("确定删除？");
		if (isDelEle) {
			location.href="${pageContext.request.contextPath }/banji/delBanJi.action?id=" + bid;
		}
	}
</script>
</head>
<body>
	<%@include file="common/header.jsp" %>
	<div class="container" >
		<div class="row">
			<!-- 左边导航栏开始  -->
			<div class="col-md-2" >
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation" class="active"><a href="${pageContext.request.contextPath }/banji/pageList.action">班级管理</a></li>
					<li role="presentation"><a href="${pageContext.request.contextPath }/banji/toAddBanJI.action">添加班级</a></li>
				</ul>
			</div>
			<!-- 左边导航栏结束  -->
			<!-- 右边栏开始  -->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li role="presentation" class="active"><a href="${pageContext.request.contextPath }/banji/pageList.action">班级管理</a></li>
					<li role="presentation"><a href="${pageContext.request.contextPath }/banji/toAddBanJI.action">添加班级</a></li>
				</ul>
				<!-- 查询条件 开始 -->
				<form id="searchForm" action="${pageContext.request.contextPath}/banji/seacherByCondition.action" method="post" class="form-inline" style="float: left; margin-top: 10px;margin-bottom: 10px;" >
					<!-- 用于查找+分页 记录反的页数 -->
					<input type="hidden" name="pageIndex" id="pageIndex" />
					<div class="form-group"  >
						<label for="exampleInputName2">班级编号</label>
					    <input type="text" name="banji.bno" value="${condition.banji.bno }" class="form-control" id="exampleInputName2" placeholder="班级编号">
				 	</div>
					<div class="form-group"  >
						<label for="exampleInputName2">班级</label>
					    <input type="text" name="banji.bname" value="${condition.banji.bname }" class="form-control" id="exampleInputName2" placeholder="班级">
				 	</div>
				 	<button type="submit" class="btn btn-primary">查询</button>
				 	<button type="reset" class="btn btn-default">重置</button>
				</form>
				<!-- 查询条件 结束 -->
				<!-- 学生列表开始 -->
				<table class="table table-striped table-bordered table-hover" style="margin-top: 10px;" >
					<tr>
						<td>班级编号</td>
						<td>班级</td>
						<td>人数</td>
						<td>所选课程</td>
						<td>删除</td>
						<td>修改</td>
					</tr>
					<c:forEach items="${pageBean.list }" var="banji">
						<tr>
							<td>${banji.bno }</td>
							<td>${banji.bname }</td>
							<td>
								<c:forEach items="${pList }" var="persons" >
									<c:if test="${banji.bid==persons.bid }">
										${persons.totalPersonNum }
									</c:if >
								</c:forEach>
							</td>
							<td>
								<c:forEach items="${banji.list }" var="bc">
										${bc.cname } 
								</c:forEach>
								
							</td>
							<td><a href="javascript:delBanji('${banji.bid}')" >删除</a></td>
							<td><a href="${pageContext.request.contextPath}/banji/toUpdate.action?id=${banji.bid}">修改</a></td>
						</tr>
					</c:forEach>
				</table>
				<!-- 学生列表结束 -->
				<!-- 分页 开始 -->
				<nav aria-label="Page navigation">
					<ul class="pagination">
						<!-- 左箭头开始 -->
						<c:if test="${pageBean.pageIndex == 1 }">
							<li class="disabled">
							<a href="javascript:void(0)" aria-label="Previous">
								<span aria-hidden="true"  >&laquo;</span>
							</a>
							</li>
						</c:if>
						<c:if test="${pageBean.pageIndex != 1 }">
							<li>
							<a href="javascript:goPage('${pageBean.pageIndex - 1}');" aria-label="Previous">
								<span aria-hidden="true">&laquo;</span>
							</a>
							</li>
						</c:if>
						<!--左箭头 结束  -->
						<!-- 中间数字开始 -->
						
						<c:forEach begin="1" end="${pageBean.totalPage }" var="page">
							<c:if test="${pageBean.pageIndex == page }">
								<li class="active"><a href="javascript:goPage('${page }');">${page }</a></li>
							</c:if>
							<c:if test="${pageBean.pageIndex != page }">
								<li><a href="javascript:goPage('${page }');">${page }</a></li>
							</c:if>
						</c:forEach>
						
						<!-- 中间数字 结束 -->
						<!-- 右边箭头 开始 -->
						<c:if test="${pageBean.pageIndex == pageBean.totalPage }">
							<li class="disabled">
							<a href="javascript:void(0)" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
							</li>
						</c:if>
						<c:if test="${pageBean.pageIndex != pageBean.totalPage }">
							<li>
							<a href="javascript:goPage('${pageBean.pageIndex + 1}');" aria-label="Next">
								<span aria-hidden="true">&raquo;</span>
							</a>
							</li>
						</c:if>
						
						<!-- 右边箭头 结束 -->
					</ul>
				</nav>
				<!-- 分页 结束 -->
			</div>
			<!-- 右边栏结束  -->
		</div>
	</div>
	
	
	
</body>
</html>