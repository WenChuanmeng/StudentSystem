<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/bootstrap/js/bootstrap.js"></script>
</head>
<body>
	<!-- head begin -->
		<%@include file="common/header.jsp" %>
	<!-- head end -->
	<div class="container" >
		<div class="row">
			<!-- 左边导航栏开始  -->
			
			<div class="col-md-2" >
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation" ><a href="${pageContext.request.contextPath }/course/pageList.action">课程管理</a></li>
					<li role="presentation" class="active"><a href="${pageContext.request.contextPath }/course/toAddCourse.action">添加课程</a></li>
				</ul>
			</div>
			
			<!-- 左边导航栏结束  -->
			<!-- 右边栏开始  -->
			
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li role="presentation" ><a href="${pageContext.request.contextPath }/course/pageList.action">课程管理</a></li>
					<li role="presentation" class="active"><a href="${pageContext.request.contextPath }/course/toAddCourse.action">添加课程</a></li>
				</ul>
				
				<!-- 添加班级 开始 -->
				
				<form style="margin-top: 10px;" action="${pageContext.request.contextPath }/course/addCourse.action" method="post" >
					<div class="form-group">
					   <label for="exampleInputEmail1">课程编号</label>
					   <input type="text" name="cno" class="form-control" id="exampleInputEmail1" placeholder="课程编号">
				  </div>
					<div class="form-group">
					   <label for="exampleInputEmail1">课程</label>
					   <input type="text" name="cname" class="form-control" id="exampleInputEmail1" placeholder="课程名">
				  </div>
				  <button type="submit" class="btn btn-primary">Submit</button>
				  <button type="reset" class="btn btn-primary">Reset</button>
				</form>
				
				<!-- 添加学生 结束 -->
			</div>
			<!-- 右边栏结束  -->
		</div>
	</div>
	
	
	
</body>
</html>