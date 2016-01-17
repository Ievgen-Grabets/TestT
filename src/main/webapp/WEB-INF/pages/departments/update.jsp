<%--
  Created by IntelliJ IDEA.
  User: alex
  Date: 17.01.16
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
    <form method="post" action="/depSaveUpdated">
        <table>
            <tr>
                <td>Old name of Deparyment is:</td>
                <td>${departmentForUpdate.name}</td>
            </tr>
            <tr>
                <td>Enter new name of Department:</td>
                <td><input type="text" name="name"></td>
            </tr>
            <tr>
                <td><input type="hidden" name="id" value=${departmentForUpdate.id}></td>
                <td><input type="submit" value="Aply"></td>
            </tr>
        </table>
    </form>
</body>
</html>
