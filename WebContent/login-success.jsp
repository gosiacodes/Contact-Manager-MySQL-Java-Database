<%@page import="a.Package.aBean"%>

<p>You are successfully logged in!</p>

<%
aBean bean=(aBean)request.getAttribute("bean");
out.print("Welcome, " + bean.getName());
%>

<br><br>

	<div align="center">
		<h1>Contact Manager</h1>
		<h3>Add new contact</h3>
		<form name="registration" action="RegisterServlet" method="post">
			<p><label for = "table">Register to: </label> 
				<select name="table">
				<option> - Select Table - </option>
				<option value = "contact"> Contact </option>
				<option value = "customer"> Customer </option>
			</select> </p>
			<table cellpadding="5">
				<tr>
					<td>Name: </td>
					<td><input type="text" name="nameContact" value="" placeholder="enter name"></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><input type="email" name="email" value="" placeholder="enter email"></td>
				</tr>
				<tr>
					<td>Address: </td>
					<td><input type="text" name="address" value="" placeholder="enter address"></td>
				</tr>
				<tr>
					<td>Phone: </td>
					<td><input type="tel" name="phone" value="" placeholder="enter phone number"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit" value="Save"/></td>
				</tr>
			</table>
		</form>	
	</div>
	
	