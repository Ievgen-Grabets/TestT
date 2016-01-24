<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: milu
  Date: 21.01.16
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/empUpdate">
    <table>
        <tr>
            <td>First name:</td>
            <td><input value="${employee.firstName}" type="text" name="firstName"/></td>
            <td>Second name:</td>
            <td><input value="${employee.secondName}" type="text" name="secondName"/> </td>
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
