<%--
  Created by IntelliJ IDEA.
  User: funtusthan
  Date: 17.01.16
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form method="post" action="/depUpdateNow">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="${department.name}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
    <input type="hidden" name="id" value="${department.id}">
</form:form>
</body>
</html>
