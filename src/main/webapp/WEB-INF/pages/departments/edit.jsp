<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<form:form method="post" action="/depSave">
    <table>
        <tr>
            <td>Name Department:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="Add Department"/>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
