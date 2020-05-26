<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index MySQL Java Databas</title>
</head>
<body>

<div align="center">
	<h1>Contact Manager</h1>
	
	<form action ="ControllerServlet" method="post">
		<table>
			<tr>
				<td>Name: </td> 
				<td><input type="text" name="name" placeholder="enter name"></td>
			</tr>
			<tr>
				<td>Password: </td>
				<td><input type="password" name="password" placeholder="enter password"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>

