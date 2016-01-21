<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/depUpdate">
    <table>
        <tr>
            <td>Name:</td>
            <td><input value="${sas.name}" type="text" name="name"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
    <input type="hidden" name="id" value="${sas.id}">
</form:form>
</body>
</html>
