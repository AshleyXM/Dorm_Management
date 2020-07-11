<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
<style>
h2 {
	margin-left: 40%;
}

table {
	margin-left:30%;
	margin-top:15px;
	text-align:center;
}
</style>
</head>
<!--引入jQuery-->
<script src="http://apps.bdimg.com/libs/jquery/1.8.3/jquery.js"></script>
<script type="text/javascript">
	function changeDormById(sid){
		$.ajax({
			url:"<%=path%>/Student/getStudentBySid.do",
			data:{sid:sid},
			type:"post",
			datatype:"json",
			success:function(data){
				location="<%=path%>/Student/changeDorm.do?student_sid="+data.student_sid+"&student_name="+data.student_name+"&student_gender="+
						data.student_gender+"&student_institute="+data.student_institute+"&student_dorm_id="+data.student_dorm_id;         
			}
		});
	}
	
	function checkChangeRecord(sid){
		location="<%=path%>/Student/checkChangeRecord.do?sid="+sid;
	}
	
	function keywordSearch(){
		var keyword=$("#keyword").val();
		location="<%=path%>/Student/keywordSearch.do?keyword="+keyword;
	}
	
	function addDorm(){
		var newDormId=$("#newDormId").val();
		if(newDormId==""){
			alert("请输入一个宿舍编号！");
		}else{
			$.ajax({
				url:"<%=path%>/Student/addNewDorm.do",
				data:{newDormId:newDormId},
				type:"post",
				dataType:"text",
				success:function(data){
					if(data=="y"){
						alert("宿舍添加成功！");
						location="<%=path%>/Student/getAllStudent.do";
					}else{
						alert("请勿添加已存在的宿舍编号！");
					}
				}
			});
		}
	}
	
	function addStudent(){
		location="<%=path%>/Student/addStudent.do";
	}
	
</script>
<body>
	<h2>学生信息管理平台-宿舍管理</h2>
	<div style="margin-left:30%;margin-top:15px;">
		学生姓名 : <input type="text" id="keyword" autocomplete="off"><!-- autocomplete属性为off时表示禁止弹出之前输入过的内容 -->
		<button onclick="keywordSearch()">查询</button>             
		<button onclick="addStudent()" style="margin-left:36px;">添加学生</button>
		<input type="text" placeholder="输入新宿舍的编号" style="width:120px;font-size:14px;" id="newDormId">
		<button onclick="addDorm()">添加宿舍</button>
	</div>
	<table border="1" cellspacing="1">
		<tr>
			<th>学生姓名</th>
			<th>性别</th>
			<th>所属学院</th>
			<th>入校时间</th>
			<th>当前宿舍</th>
			<th>宿舍人数</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${studentList}" var="student">
			<tr>
				<td>${student.sname}</td>
				<td>${student.gender}</td>
				<td>${student.institute}</td>
				<td>${student.inschool_date}</td>
				<td>${student.dorm_id}</td>
				<td>${student.dorm_capacity}</td>
				<td>
					<button onclick="changeDormById(${student.sid})">更换宿舍</button>
					<button onclick="checkChangeRecord(${student.sid})">宿舍更换记录</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
