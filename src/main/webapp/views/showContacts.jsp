<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<table border=1>		
		<tr>
			<th>Name</th>
			<th>Phone Number</th>
			<th>Email</th>
			<th>Edit Contact</th>
			<th>Delete Contact</th>
		</tr>
		<c:forEach items="${contactList}" var="contact">		
			<tr>				
				<td><c:out value = "${contact.name}"/></td>
				<td><c:out value = "${contact.contactNo}"/></td>
				<td><c:out value = "${contact.email}"/></td>
				<td><a href="updateContact?id=${contact.id}">Edit</a></td>
				<td><a href="deleteContact?id=${contact.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>