<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/empSaveOrUpdate" modelAttribute="employee">
    <input type="hidden" name="departmentId" value="${employee.department.id}">
    <table>
        <tr>
            <td>First name:</td>
            <td><input type="text" name="firstName" value="${employee.firstName}"/></td>
            <td>Second name:</td>
            <td><input type="text" name="secondName" value="${employee.secondName}"/></td>
        </tr>
        <tr>
            <td colspan="2">

                <input type="submit" value="Save" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
