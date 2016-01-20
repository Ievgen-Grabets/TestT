
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditEmployee</title>
</head>
<body>
    <form method="post" action="/emplSaveUpdated">
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName" value=${employeeForUpdate.firstName}></td>
            </tr>
            <tr>
                <td>Second Name</td>
                <td><input type="text" name="secondName" value=${employeeForUpdate.secondName}></td>
            </tr>
            <tr>
                <td>Day of birthday</td>
                <td><input type="text" name="dayOfBirthday" value=${employeeForUpdate.dateOfBirthday}></td>
            </tr>
            <tr>
                <td><input type="hidden" name="id" value=${employeeForUpdate.id}></td>
                <td><input type="submit" value="Apply"></td>
            </tr>
        </table>
    </form>
</body>
</html>
