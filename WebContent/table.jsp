<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="bootstrap11/css/bootstrap.min.css">
<style type="text/css">
.divPage {
	width: 500px;
	margin: 0px auto;
	text-align: center;
	border: 1px solid red;
}
</style>
</head>
<body>
	<table class="table table-bordered table-hover">
		<caption>边框表格布局</caption>
		<thead>

			<tr>
				<th>名字</th>
				<th>更新时间</th>
				<th>创建时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tb" items="${tbList}">
				<tr>
					<td>${tb.name}</td>
					<td>${tb.updated}</td>
					<td>${tb.created}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div class="divPage">
		<ul class="pagination">
			<li><a href="#">&laquo;</a></li>
			<li class="disabled"><a href="#">显示1到10项，共13项 </a></li>
			<li class="disabled"><a href="#">当前第1页，共2页 </a></li>
			<li><a href="#"> <select class="active">
						<option selected="selected" value="5">5条/页</option>
						<option value="10">10条/页</option>
						<option value="20">20条/页</option>
						<option value="30">30条/页</option>
				</select>
			</a></li>
			<li><a href="#">&raquo;</a></li>
		</ul>
	</div>
</body>
</html>