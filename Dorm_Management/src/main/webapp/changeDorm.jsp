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
	margin-left: 30%;
}

div {
	margin-top: 10px;
}
</style>

</head>
<!--引入jQuery-->
<script src="http://apps.bdimg.com/libs/jquery/1.8.3/jquery.js"></script>

<script>
	function onSubmit(sid,old_dorm_id){
		var newDormId=$("#dormlist").val();
		if(newDormId==old_dorm_id){
			alert("更换的宿舍不能和原宿舍相同！");
		}
		else{
			$.ajax({
				url:"<%=path%>/Student/updateDormInfo.do",
				data:{sid:sid,oldDormId:old_dorm_id,newDormId:newDormId},
				dataType:"text",
				success:function(){
					location="<%=path%>/Student/getAllStudent.do";
				}
			});
		}
	}

</script>
<body>
	<h2>更换宿舍</h2>
	<hr />
	<div id="container">
		<div>学生姓名：${student_name}</div>
		<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：${student_gender}</div>
		<div>所属学院：${student_institute}</div>
		<div>当前宿舍：${student_dorm_id}</div>
		<div>
			更换宿舍：<select id="dormlist" name="dormlist"
				style="width: 65px; height: 30px; font-size: 16px;">
				<c:forEach items="${dormids}" var="id">
					<option value="${id}">${id}</option>
				</c:forEach>
			</select>
		</div>
		<button onclick="onSubmit(${student_sid},${student_dorm_id})"
			style="margin-left: 100px; margin-top: 10px;">提交</button>
	</div>
</body>
</html>