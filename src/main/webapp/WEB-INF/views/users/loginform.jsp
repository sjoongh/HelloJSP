<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Home: Login Form</title>
</head>
<body>

	<h1>Login</h1>
	<form method="POST"
		action="<%= request.getContextPath() %>/users">
		<!-- action 파라미터 -->
		<input type="hidden" name="a" value="login" />
		<label for="email">이메일</label>
		<input type="text" name="email" id="email" /><br />
		<label for="password">비밀번호</label>
		<input type="password" name="password" id="password" /><br />
		<input type="submit" value="로그인" />
	</form>
</body>
</html>