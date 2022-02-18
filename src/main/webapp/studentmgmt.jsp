<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Management</title>
</head>
<body>
<%@ include file="header.html" %> 
<center>
 	<a href="dashboard.jsp">DASHBOARD</a>
 	<br>
 	<br>
 	<a href="logoutservlet">LOGOUT</a>
 	
 	<h2>Student Management</h2>
 	<button><a href="addstudent.jsp">Add Student</a></button> &nbsp;&nbsp;&nbsp;&nbsp;
 	<button><a href="showstudent">Show Student</a></button>    
 </center>
</body>  
</html>