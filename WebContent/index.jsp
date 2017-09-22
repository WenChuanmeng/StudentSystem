<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Login</title>
 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/lib/bootstrap/css/bootstrap.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/lib/jquery/jquery-1.11.1.js" ></script>
<style type="text/css">
	.col-sm-10,.form-control{
		width: 100%;
	}
	h1{
		font-family: "宋体";
	}
</style>
<script type="text/javascript">
	$(function () {
		$("#clickImg").click(function(){
			$("#changeImg").attr("src", "${pageContext.request.contextPath }/checkImg?"+Math.random());
		});
	});
	
	$(function(){
		$("#userName").blur(function(){
				var userName = $("#userName").val();
				$.post(
					"${pageContext.request.contextPath }/login/checkUserName",
					{"userName":userName},
					function (data) {
						if (data.isExist) {
							$("#info").html("用户名存在，输入正确密码即可登录");
							$("#info").css("color", "green");
						} else {
							$("#info").html("用户名不存在,请先申请账号再登录");
							$("#info").css("color", "red");
						}
					},
					"json"
				);
		});
	});

</script>
</head>
<body style="background-image: url('${pageContext.request.contextPath }/img/index.jpg');">
	<div class="container" style="margin-top:150px; width: 500px; ">
		<form class="form-horizontal" action="${pageContext.request.contextPath }/login/loginIn.action" method="post">
			<h1>Student Management System</h1>
			
				<div>
					<span style="color: red;" >${error }</span>
				</div>
			
			 <div class="form-group">
			    <div class="col-sm-10">
			      <input type="text" name="uname" value="${cookie_userName }" class="form-control" id="userName" id="userName" placeholder="UserName">
			      <span id="info"></span>
			    </div>
			 </div>
			 <div class="form-group">
			    <div class="col-sm-10">
			      <input type="password" name="password" value="${cookie_password }" class="form-control" id="inputPassword3" placeholder="Password">
			    </div>
			  </div>
			   <div class="form-group" style="width: 100%; margin-left: 1px; margin-bottom: 5px;" >
					<select class="form-control" id="banji_id" name="permission"  >
						<option value="" >角色选择</option>
						<option value="1" >超级管理员</option>
						<option value="2" >普通管理员</option>
					</select>
			  </div>
			  <div class="form-group" style="width: 100%; margin-bottom: 5px;" >
			    <div class="col-sm-10" >
				    <div class="checkbox" >
						<label> 
							<input type="checkbox" name="rememberPassword" value="rememberPassword"> 记住密码
						</label>
					</div>
			    </div>
			  </div>
			  <div class="form-group">
			    <div class="col-sm-10">
			      <input type="text" class="form-control" name="checkCode" id="inputEmail3" id="checkCode" placeholder="CheckCode">
			    	<img id="changeImg" alt="图片加载失败" src="${pageContext.request.contextPath}/checkImg">
			    	<!-- <span style="font-size: 10px;" >看不清，换一张</span> -->
			    	<a style="font-size: 10px; margin-top: 15px;" id="clickImg" >看不清，换一张</a>
			    </div>
			 </div>
			  <div class="form-group" >
			    <div class=" col-sm-10">
			      <button type="submit" class="btn btn-primary" style="width: 470px;" align="left" >Sign in</button>
			    </div>
			  </div>
		</form>
	</div>
</body>
</html>