<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Form</title>
</head>
<body>
<h1> Update Form</h1>
<form action="UpdateController" method="post">
			<table style="with: 50%">
				
				<tr>
					<td>UserName</td>
					<td><input type="text" name="user" required/></td>
				</tr>
				<tr>
					<td> Old Password</td>
					<td><input type="password" name="oldPassword" required/></td>
				</tr>
					<tr>
					<td> New Password</td>
					<td><input type="password" name="newPassword" required/></td>
				</tr>
				
			</table>
			<input type="submit" value="Submit" /></form>
			
			
			<form action="read.jsp">
<input type="submit" value="Read Operation">
</form>
</body>

</html>