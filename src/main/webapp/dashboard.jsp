<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboard</title>
<style type="text/css">
	div
	{
		margin-left : 357px;  
	}
	li
	{
		float : left;
		display : inline-block;
		margin : 20px;
	}
</style>
</head>
<body>

<%@ include file="header.html" %> 
<center>
 	<a href="logoutservlet">LOGOUT</a>
 	
 	<h2>Administrator Dashboard</h2>
 	<div>
 	<ul>
 		<li><a href="classmgmt.jsp">Class Management</a></li> 
 		<li><a href="studentmgmt.jsp">Student Management</a></li>  
 		<li><a href="teachermgmt.jsp">Teacher Management</a></li> 
 		<li><a href="subjectmgmt.jsp">Subject Management</a></li>  
 	</ul> 
 	</div> 
 </center>
</body> 
</html>