<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rename</title>
</head>
<body>
<form:form method="post" action="/depSave1">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text"  name="name" value="${departments.name}"/></td>
            <td><input type="hidden" name="id" value="${departments.id}"/></td>

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
