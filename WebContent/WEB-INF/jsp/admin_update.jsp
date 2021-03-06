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
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/jquery-1.11.1.js"></script>
<script type="text/javascript">
$(function(){
	$("#permission option[value='${user.permission }']").prop("selected",true);
});
</script>

</head>
<body>
	<!-- head begin -->
		<%@include file="common/ad_header.jsp" %>
	<!-- head end -->
	<div class="container" >
		<div class="row">
			<!-- 左边导航栏开始  -->
			<div class="col-md-2" >
				<ul class="nav nav-pills nav-stacked">
					<li role="presentation" ><a href="${pageContext.request.contextPath }/user/pageList.action">用户管理</a></li>
					<li role="presentation" class="active"><a href="${pageContext.request.contextPath }/user/toAddUser.action">添加用户</a></li>
				    <li role="presentation"><a href="${pageContext.request.contextPath }/user/onlineUser.action">在线用户</a></li>
				    <li role="presentation" class="active"><a href="">修改用户</a></li>
				</ul>
			</div>
			<!-- 左边导航栏结束  -->
			<!-- 右边栏开始  -->
			<div class="col-md-10">
				<ul class="nav nav-tabs">
					<li role="presentation" ><a href="${pageContext.request.contextPath }/user/pageList.action">用户管理</a></li>
					<li role="presentation" class="active"><a href="${pageContext.request.contextPath }/user/toAddUser.action">添加用户</a></li>
				    <li role="presentation"><a href="${pageContext.request.contextPath }/user/onlineUser.action">在线用户</a></li>
				    <li role="presentation" class="active"><a href="">修改用户</a></li>
				</ul>
				<!-- 添加学生 开始 -->
				<form style="margin-top: 10px;" action="${pageContext.request.contextPath }/user/update.action" method="post" >
					<div class="form-group">
					   <label for="exampleInputEmail1">id</label>
					   <input type="text" name="uid" value="${user.uid }" readonly="readonly" class="form-control" id="exampleInputEmail1" placeholder="姓名">
				  </div>
					<div class="form-group">
					   <label for="exampleInputEmail1">用户名</label>
					   <input type="text" name="uname" value="${user.uname }" class="form-control" id="exampleInputEmail1" placeholder="姓名">
				  </div>
				  <div class="form-group">
					  <label for="exampleInputPassword1">密码</label>
					  <input type="text" name="password" value="${user.password }" class="form-control" id="exampleInputPassword1" placeholder="年龄">
				  </div>
				  <div class="form-group">
						<label for="exampleInputName2">权限</label>
						<select class="form-control" id="permission" name="permission" >
							<option value="" >请选择</option>
							<option value="1" >超级管理员</option>								
							<option value="2" >普通管理员</option>								
						</select>
				 	</div>
				  
				  <button type="submit" class="btn btn-primary">Submit</button>
				</form>
				<!-- 添加学生 结束 -->
			</div>
			<!-- 右边栏结束  -->
		</div>
	</div>
	
	
	
</body>
</html>