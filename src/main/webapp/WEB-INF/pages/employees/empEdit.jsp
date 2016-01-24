<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/empEditSave">
    <table>
        <tr>
            <td>FirstName:</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
            <td>SecondName:</td>
            <td><input type="text" name="secondName" value="${employee.secondName}"/></td>
            <input type="hidden" name="empId" value="${employee.id}"/>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
