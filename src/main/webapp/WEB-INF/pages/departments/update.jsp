
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditDepartment</title>
</head>
<body>
    <form method="post" action="/dep/SaveUpdated">
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
