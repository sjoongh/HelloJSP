<%@page import="com.example.emaillist.vo.EmailVo"%>
<%@page import="java.util.List"%>
<%@page import="com.example.emaillist.dao.EmaillistDaoImpl"%>
<%@page import="com.example.emaillist.dao.EmaillistDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
EmaillistDao dao = new EmaillistDaoImpl();
//	이메일 리스트 받아오기
List<EmailVo> list = dao.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Emaillist (Model 1)</title>
</head>
<body>
	<h1>메일링 리스트(Model 1)</h1>
	
	<!-- 이메일 리스트: 목록 -->
	<!-- 루프 시작 -->
	<% for (EmailVo vo: list) { %>
	<table border="1">
		<!-- 행 -->
		<tr>
			<th>성</th>
			<td><%= vo.getLastName() %></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><%= vo.getFirstName() %></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><%= vo.getEmail() %></td>
		</tr>
		<tr>
			<td colspan="2">
			<!-- 삭제 폼 -->
				<form action="<%= request.getContextPath() %>/emaillist/delete.jsp"
				method="POST">
				<input type="hidden" name="no" value="<%= vo.getNo() %>" />
				<input type="submit" value="삭제" />
				</form>
			</td>
		</tr>
	</table>
	<br />
	<% } %>
	<!-- 루프의 끝 -->
	
	<!-- 작성 폼으로 이동 -->
	<p>
		<a href="<%= request.getContextPath() %>/emaillist/form.jsp">추가 이메일 등록</a>
	</p>
	
</body>
</html>