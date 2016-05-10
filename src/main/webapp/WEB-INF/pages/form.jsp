<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sergey Matevitsky app| Registration Form</title>
</head>
<body>
<center>

    <div style="color: teal; font-size: 30px">Sergey Matevitsky app | Registration Form</div>


    <c:url var="userRegistration" value="saveUser.html"/>
    <form:form id="registerForm" modelAttribute="user" method="post"
               action="register">
        <table width="800px" height="150px">
            <tr>
                <td><form:label path="name">Name</form:label></td>
                <td><form:input path="name"/> <form:errors path="name"/></td>

            </tr>
            <tr>
                <td><form:label path="age">Age</form:label></td>
                <td><form:input path="age"/><form:errors path="age"/></td>
            </tr>
            <tr>
                <td><form:checkbox path="admin"/><form:label path="admin">isAdmin</form:label></td>
                <td></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="submit" value="Register"/>
                </td>
            </tr>
        </table>
    </form:form>


    <a href="list"><input type="button" value="Click Here to see User List"/></a>
</center>
</body>
</html>
