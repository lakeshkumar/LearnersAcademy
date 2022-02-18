<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<%@ include file="header.html" %>
<center>
	<a href="index.jsp">HOME</a>
	<br>
	<h3>Administrator Login</h3>
	<form action="loginservlet" method="post">
		<table border="1" cellpadding="10">
			<tr>
				<th>Username</th>
				<td><input type="text" name="username" required></td>
			</tr>
			<tr>
				<th>Password</th>
				<td><input type="password" name="password" required></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align : center"><input type="reset" value="Reset"> &nbsp;&nbsp;
				<input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</center>

</body>
</html>