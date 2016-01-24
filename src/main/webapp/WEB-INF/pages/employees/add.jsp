<%--
  Created by IntelliJ IDEA.
  User: oleg
  Date: 22.01.16
  Time: 5:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/empSave">
    <table>
        <input type="hidden" name="departmentID" value="<%=request.getParameter("departmentID")%>"/>
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="secondName"/></td>
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