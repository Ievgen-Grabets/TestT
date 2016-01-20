
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditEmployee</title>
</head>
<body>
    <form method="post" action="/emplSaveUpdated">
       <%-- <p>Department = ${employee.department.name}</p>--%>
        <table>
            <tr>
                <td>First Name</td>
                <td><input type="text" name="firstName" value=${employee.firstName}></td>
            </tr>
            <tr>
                <td>Second Name</td>
                <td><input type="text" name="secondName" value=${employee.secondName}></td>
            </tr>
            <tr>
                <td>Day of birthday</td>
                <td><input type="text" name="dayOfBirthday" value=${employee.dateOfBirthday}></td>
            </tr>
            <tr>
                <td><input type="hidden" name="id" value=${employee.id}>
                <input type="hidden" name="department_id" value=${employee.department.id}></td>
                <td><input type="submit" value="Apply"></td>
            </tr>
        </table>
    </form>
</body>
</html>
