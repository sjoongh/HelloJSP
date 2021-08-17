<%@ page language="java" 
	contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello HTML</title>
</head>
<body>
	<h3>Hello HTML</h3>
	<p>이것은 namsk가 작성한 첫번째 HTML 입니다.</p>
	
	<ul>
		<li><a href="<%= request.getContextPath() %>/users?a=joinform">회원가입</a></li>
		<li><a href="<%= request.getContextPath() %>/users?a=loginform">로그인</a></li>
	</ul>
	
	<h4>GET 전송</h4>
	<p>
		<a href="hs?name=Servlet">HelloServlet 호출</a>
	</p>
	
	<h4>POST 전송</h4>
	<form action="hs" method="POST">
		<label for="last_name">성</label>
		<input type="text" name="last_name" id="last_name" /><br />
		<label for="first_name">이름</label>
		<input type="text" name="first_name" id="first_name" /><br />
		
		<input type="submit" value="전송" />
	</form>
	
	<h4>Emaillist (Model 1)</h4>
	<p><a href="/web/emaillist/">이메일리스트 (Model 1)</a>
	
	<h4>Emaillist (Model 2:MVC)</h4>
	<p><a href="/web/el">이메일리스트 (Model 2)</a>
</body>
</html>