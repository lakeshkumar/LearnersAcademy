<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Subject</title> 
</head>
<body>
<%@ include file="header.html" %> 
<center>
 	<a href="dashboard.jsp">DASHBOARD</a>
 	<br>
 	<br>
 	<a href="logoutservlet">LOGOUT</a>
 	
 	<h2>Add New Subject</h2> 
 	<form action="addsubject" method="get">
		<table border="1" cellpadding="10">
			<tr>
				<th>Subject Name</th>
				<td><input type="text" name="subjectname" required></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align : center"><input type="reset" value="Reset">&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="submit" value="Add Subject"></td>
			</tr>
		</table>
	</form>
</body>
</html>