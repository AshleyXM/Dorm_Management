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
	margin-left: 40%;
}

table {
	margin-left: 25%;
	margin-top:10px;
}

td {
	width: 120px;
	text-align: center;
}
</style>
</head>

<!--引入jQuery-->
<script src="http://apps.bdimg.com/libs/jquery/1.8.3/jquery.js"></script>
<body>
	<h2>宿舍更换记录</h2>
	<div style="margin-left: 25%;">
		学生姓名：${student.sname}；性别：${student.gender}；入学时间：${student.inschool_date}
	</div>
	<table border="1">
		<tr>
			<th>宿舍编号</th>
			<th>宿舍人数</th>
			<th>进入日期</th>
			<th>离开日期</th>
		</tr>
		<c:forEach items="${dorm_records}" var="record">
			<tr>
				<td>${record.dorm_id}</td>
				<td>${record.dorm_capacity}</td>
				<td>${record.in_date}</td>
				<td>${record.out_date}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>