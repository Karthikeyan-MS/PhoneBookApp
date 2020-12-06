<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form:form action="saveContact" method="POST" modelAttribute="contact">
		<h1>${Heading}</h1>
		<h2>${successMsg} ${failureMsg}</h2>
		<form:hidden path="id"/>
		<table border=1>			
			<tr>
				<td>Name</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input path="contactNo" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="Email" /></td>
			</tr>
			<tr>
				<td><form:button>Submit</form:button></td>
			</tr>
		</table>
		</br></br>
		<a href="showContacts">View all contacts</a>
	</form:form>
</body>
</html>