<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JavaRush | Registration Form</title>
</head>
<body>
<center>


    </form>
    <form action="/searchUser" method="post">
        <div style="color: teal; font-size: 30px">JavaRush | Search Form</div>

        <form class="form-wrapper cf">
            <input type="text" placeholder="Type name here" required>
            <button type="submit">Search</button>
        </form>


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
            <c:if test="${!empty searchUser}">
                <c:forEach items="${searchUser}" var="user">
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
</center>
</body>
</html>