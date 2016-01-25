<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rename</title>
</head>
<body>
<form:form method="post" action="/empRename">
    <table>
        <tr>
            <td>First Name:</td>
            <td><input type="text"  name="firstName" value="${employee.firstName}"/></td>
        </tr>
        <tr>
            <td>Second Name:</td>
            <td><input type="text" name="secondName" value="${employee.secondName}"/></td>
            <td><input type="hidden" name="empID" value="${employee.id}"/></td>
            <td><input type="hidden" name="depID" value="${employee.department.id}"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Rename"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>