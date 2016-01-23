<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddEnmloyee</title>
</head>
<body>
    <h2>Enter new Employee</h2>
    <form method="post" action="/empl/Save">
        <p>Department = ${department.name}</p>
        <table>
            <tr>
                <td>Enter Fist name</td>
                <td><input name="firstName" type="text"></td>
            <tr>
            <tr>
                <td>Enter Second name</td>
                <td><input name="secondName" type="text"></td>
            <tr>
            <tr>
                <td>Enter Date of birthday</td>
                <td><input name="dateOfBirthday" type="text"></td>
            <tr>
            <tr>
                <td><input type="hidden" name="department_id" value=${department.id}></td>
                <td><input type="submit" value="Add new Employee"></td>
            </tr>
        </table>
    </form>
</body>
</html>
