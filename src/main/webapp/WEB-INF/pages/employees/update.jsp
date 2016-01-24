<%--
  Created by IntelliJ IDEA.
  User: funtusthan
  Date: 17.01.16
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<form:form method="post" action="/empUpdateNow">
    <table>
        <tr>
            <td>firstName:</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
        </tr>
        <tr>
            <td>secondName:</td>
            <td><input type="text" name="secondName" value="${employee.secondName}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
    <input type="hidden" name="id" value="${employee.id}">
</form:form>
</body>
</html>
