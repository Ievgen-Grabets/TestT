<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/depSave1">
    <table>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value="departments.name"/></td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>

