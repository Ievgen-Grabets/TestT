<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 9/28/15
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/empSave">
    <table>
        <tr>
            <td>firstName:</td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td>secondName:</td>
            <td><input type="text" name="secondName"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="text" name="dep_id" value="${department.id}">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
