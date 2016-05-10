<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sergey Matevitsky app | Edit User Details</title>
</head>
<body>
	<center>

		<div style="color: teal; font-size: 30px">Sergey Matevitsky app | Edit Details</div>

		<c:url var="userRegistration" value="updteUser.html" />
		<form:form id="updateForm" modelAttribute="user" method="post"
			action="update?id=${user.id}">
			<table width="400px" height="150px">
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name"  value="${user.name}"/><form:errors path="name" /></td> <%--  --%>
				</tr>
				<tr>
					<td><form:label path="age">Age</form:label></td>
					<td><form:input path="age" value="${user.age}"/><form:errors path="age" /></td><%--  --%>
				</tr>
				<tr>
					<td><form:checkbox path="admin" value="${user.admin}"/><form:label path="admin">isAdmin</form:label></td><%-- " --%>
					<td></td>
				</tr>
 				<tr>
 				<td><form:input type="hidden" readonly="true" path="createdDate" value="${user.createdDate}" /></td>
<%-- 				<td><form:input type="hidden" readonly="true" path="createdDate" value="${user.createdDate}"/></td> --%>
 				<td><form:input type="hidden" readonly="true" path="id" value="${user.id}" /></td>
 				</tr>
<!-- 				<tr> -->
<%-- 					<td><form:label path="createdDate">createdDate</form:label></td> --%>
<%-- 					<td><form:input path="createdDate" value="${userObject.createdDate}"/></td> --%>
<!-- 				</tr> -->
				<tr>
					<td></td>
					<td><input type="submit" value="Update" /><a href="list"><input type="button" value="Cancel"/></a><a href="delete?id=${user.id}"><input type="button" value="remove"/></a>
					</td>
				</tr>
			</table>
		</form:form>


		
	</center>
</body>
</html>
