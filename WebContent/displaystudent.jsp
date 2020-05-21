<%@ page language="java" pageEncoding="utf-8"%>
<%-- <%@ page import="com.dw.dao.impl.*"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>显示用户信息</title>
<link
	href="${pageContext.request.contextPath}bootstrap/css/bootstrap.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}bootstrap/css/bootstrap-responsive.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/bootstrap/js/jQuery.js"></script>
<script
	src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.js"></script>
<link rel="stylesheet" href="bootstrap11/css/bootstrap.min.css">
<style type="text/css">
input[type="text"] {
	height: auto;
	margin-bottom: 15px;
	padding: 3px 9px;
}

.divPage {
	width: 80%;
	margin: 0px auto;
	text-align: center;
}
</style>
</head>

<body>

	<form action="studentOperation" method="get">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 学号：<input type="text"
			name="stId" placeholder="学生学号..."> <input type="hidden"
			name="method" value="queryStudentById" />
		<!-- 隐藏标单域 -->
		<i class="icon-search"></i>&nbsp;
		<button type="submit" class="btn btn-inverse">查找</button>
	</form>
	<table class="table table-hover table-condensed">
		<tr>
			<td align="center"><strong>学号</strong></td>
			<td align="center"><strong>姓名</strong></td>
			<td align="center"><strong>性别</strong></td>
			<td align="center"><strong>年龄</strong></td>
			<td align="center"><strong>电话</strong></td>
			<td align="center"><strong>系别</strong></td>
			<td align="center"><strong>地址</strong></td>
			<td align="center"><strong>执行操作</strong></td>
		</tr>
		<c:forEach items="${list}" var="student">
			<tr>
				<td><c:out value="${student.stId}" /></td>
				<td><c:out value="${student.stName}" /></td>
				<td><c:out value="${student.stSex}" /></td>
				<td><c:out value="${student.stAge}" /></td>
				<td><c:out value="${student.stTel}" /></td>
				<td><c:out value="${student.stDept}" /></td>
				<td><c:out value="${student.stAddress}" /></td>
				<td><c:if test="${student.stId != null }">
						<a href="deleteStudent?stId=${student.stId}"
							class="btn btn-danger">删除</a>
						<a
							href="studentOperation?method=updateStudentPage&stId=${student.stId}"
							class="btn btn-primary">更新</a>
					</c:if></td>
			</tr>
		</c:forEach>
	</table>

	<hr>
	<a href="main.jsp" class="btn btn-success">返回主菜单</a>
	<hr>
	<div class="divPage">
		<form action="/StudentManager/page" method="post" id="formPage">
			<ul class="pagination">
				<li><a href="#">&laquo;</a></li>
				<li class="disabled"><a href="#">显示${page.firstNum}到${page.lastNum}项，共${page.totalRows}项
				</a></li>
				<li class="disabled"><a href="#">当前第${page.currentPage}页，共${page.totalPage}页
				</a></li>
				<li><a> <select class="active" name="pageNum">
							<option selected="selected" value="5">5条/页</option>
							<option value="10">10条/页</option>
							<option value="20">20条/页</option>
							<option value="30">30条/页</option>
					</select>
				</a></li>
				<%-- <li><a href='/StudentManager/page?currentPage=${page.currentPage}&totalRows=${page.totalRows}'>&raquo;</a></li>	 --%>
				<li><a onclick="submitForm()">&raquo;</a></li>
				<input type="hidden" name="totalRows" value="${page.totalRows}" />
				<input type="hidden" name="currentPage" value="${page.currentPage}" />
			</ul>
		</form>
	</div>

	<script type="text/javascript">
			function submitForm(){
				var formPage = document.getElementById("formPage");
				formPage.submit();
			}
			window.onload = function(){
				var pageNum = document.getElementById("pageNum").value;
			}
		</script>
</body>
</html>
