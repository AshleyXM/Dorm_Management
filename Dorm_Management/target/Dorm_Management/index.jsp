<%@ page pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<style>
table {
	margin-top: 10px;
}
</style>
</head>
<body>
	<h2>学生信息管理平台-宿舍管理</h2>
	学生姓名 :
	<input type="text">
	<input type="button" value="查询">
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
				<td>${student.institue}</td>
				<td>${student.inschool_date}</td>
				<td>${student.dorm_id}</td>
				<td>${student.dorm_capacity}</td>
				<td>
					<button>更换宿舍</button>
					<button>宿舍更换记录</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
