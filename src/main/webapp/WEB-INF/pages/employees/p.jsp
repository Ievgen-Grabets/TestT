
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/empInDep">
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
