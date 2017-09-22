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
		width: 950px;
	}
	.form-group .form-control{
		width: 150px;
	}
</style>
<script type="text/javascript">
	function goPage(pageIndex) {
		$("#pageIndex").val(pageIndex);
		$("#searchForm").submit();
	}
	function delCourses() {
		var isDel = confirm("确定删除？");
		if (isDel) {
		$("#delForm").attr("src", "${pageContext.request.contextPath }/eduAdmin/delCourses.action");
		$("#delForm").submit();
		}
	}
	
	function delCourse(bid,cid) {
		
		var isdDel = confirm("确定删除？");
		if (isdDel) {
			location.href="${pageContext.request.contextPath }/eduAdmin/delCourse.action?bid=" + bid + "&cid=" + cid;
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
					<li role="presentation" ><a href="${pageContext.request.contextPath }/eduAdmin/pageList.action">班级选课</a></li>
				    <li role="presentation"><a href="${pageContext.request.contextPath }/eduAdmin/toBanjiAddCourse.action">添加课程</a></li>
				    <li role="presentation" class="active"><a href="${pageContext.request.contextPath }/eduAdmin/toStuSelectCourses.action">学生选课</a></li>
				</ul>
			</div>
			<!-- 左边导航栏结束  -->
			<!-- 右边栏开始  -->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li role="presentation" ><a href="${pageContext.request.contextPath }/eduAdmin/pageList.action">班级选课</a></li>
					<li role="presentation"><a href="${pageContext.request.contextPath }/eduAdmin/toBanjiAddCourse.action">添加课程</a></li>
					<li role="presentation" class="active"><a href="${pageContext.request.contextPath }/eduAdmin/toStuSelectCourses.action">学生选课</a></li>
				</ul>
				<!-- 查询条件 开始 -->
				<form id="searchForm" action="${pageContext.request.contextPath}/eduAdmin/stuSelectCourses.action" method="post" class="form-inline" style="float: left; margin-top: 10px;margin-bottom: 10px;" >
					<!-- 用于查找+分页 记录反的页数 -->
					<input type="hidden" name="pageIndex" id="pageIndex" />
					<div class="form-group"  >
						<label for="exampleInputName2">学号</label>
					    <input type="text" name="sno" value="${student.sno }" class="form-control" id="exampleInputName2" placeholder="学号">
				 	<button type="submit" class="btn btn-default">查询</button>
				 	</div>
				</form>
				<!-- 查询条件 结束 -->
				<!-- 学生列表开始 -->
				<br/>
				<h4>
					学号 ：${student.sno}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学生姓名：${student.sname}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					班级编号：${student.banji.bno}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;班级：${student.banji.bname}
				</h4>
				<table class="table table-striped table-bordered table-hover" style="margin-top: 10px;" >
					<tr>
						<td>课程编号</td>
						<td>所选课程</td>
						<td>学分</td>
					</tr>
					<c:forEach items="${student.banji.list }" var="course">
							<tr>
								<td>${course.cno}</td>
								<td>${course.cname}</td>
								<td>${course.credit}</td>
							</tr>
					</c:forEach>
				</table>
				<!-- 学生列表结束 -->
				
		</div>
	</div>
	
	
	
</body>
</html>