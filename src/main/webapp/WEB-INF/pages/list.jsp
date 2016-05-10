<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Sergey Matevitsky | CRUD Application</title>
</head>
<body>
<center>

    <div style="color: teal; font-size: 30px">Sergey Matevitsky | CRUD Application</div>


    <table border="1" bgcolor="black" width="600px">
        <tr
                style="background-color: teal; color: white; text-align: center;"
                height="40px">

            <td>Name</td>
            <td>Age</td>
            <td>isAdmin</td>
            <td>created Date</td>

        </tr>
        <c:if test="${!empty userList}">
            <c:forEach items="${userList}" var="user">
                <tr
                        style="background-color: white; color: black; text-align: center;"
                        height="30px">

                    <td><a href="edit?id=${user.id}"><c:out value="${user.name}"/></a>
                    </td>
                    <td><c:out value="${user.age}"/>
                    </td>
                    <td><c:out value="${user.admin}"/>
                    </td>
                    <td><c:out value="${user.createdDate}"/>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>

    <table border="0" bgcolor="white" width="600px">
        <tr style="background-color: white; text-align: center;">
            <td><a href="previous"><input type="button" value="Previos. page"/></a>
                <a href="next"><input type="button" value="Next page"/></a></td>
        </tr>
        <tr style="background-color: white; text-align: center;">
            <td><a href="form"><input type="button" value="Click Here to add new User"/></a></td>
        </tr>
        <tr style="background-color: white; text-align: center;">

        </tr>
        </tr>
    </table>

    <%---------------------------------------------%>
<%--

    <form method= get action="/searchUser">
        <input type="text" name="Search">


    </form>
--%>

    <%--<form action="/searchUser" method="GET">
        Search Name: <input type="text" name="Search">--%>









</center>
</body>
</html>
