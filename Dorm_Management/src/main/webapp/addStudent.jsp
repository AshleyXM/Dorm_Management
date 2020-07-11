<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<style>
h2 {
	margin-left: 45%;
}

#container {
	margin-left: 35%;
}

div {
	margin-top: 10px;
}

input {
	width: 120px;
	height: 20px;
	font-size: 13px;
}

select {
	width: 128px;
	height: 26px;
	font-size: 13px;
}
</style>
</head>
<!--引入jQuery-->
<script src="http://apps.bdimg.com/libs/jquery/1.8.3/jquery.js"></script>
<script type="text/javascript">
	function onSubmit() {
		var name=$("#name").val();
		var gender=$("#gender").val();
		var institute=$("#institute").val();
		var inschool_date=$("#inschool_date").val();
		var dorm_id=$("#dorm_id").val();
		$.ajax({
			url:"<%=path%>/Student/insertStudent.do",
			data:{name:name,gender:gender,institute:institute,inschool_date:inschool_date,dorm_id:dorm_id},
			type:"post",
			dataType:"text",
			success:function(data){
				if(data=="y"){
					alert("学生添加成功！");
					location="<%=path%>/Student/getAllStudent.do";
				}else{
					alert("学生添加失败");
				}
			}
		});
	}
</script>
<body>
	<h2>添加学生</h2>
	<hr />
	<div id="container">
		<div>
			&emsp;&emsp;姓名：<input type="text" id="name" autocomplete="off">
		</div>
		<div>
			&emsp;&emsp;性别：<select id="gender">
				<option value="男">男</option>
				<option value="女">女</option>
			</select>
		</div>
		<div>
			&emsp;&emsp;学院：<input type="text" id="institute">
		</div>
		<div>
			入校时间：<input type="date" id="inschool_date">
		</div>
		<div>
			&emsp;&emsp;宿舍：<select id="dorm_id">
				<c:forEach items="${dorm_ids}" var="id">
					<option value="${id}">${id}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<button id="submit" style="margin-left: 165px; margin-top: 2px;"
				onclick="onSubmit()">提交</button>
		</div>
	</div>
</body>
</html>