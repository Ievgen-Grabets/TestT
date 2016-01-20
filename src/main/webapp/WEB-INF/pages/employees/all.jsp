<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AllEmployee</title>
</head>
<body>
    <p><b>Department = ${department.name}</b></p>
    <table>
        <tr>
            <td>First Name</td>
            <td>Second Name</td>
            <td>Date of birthday</td>
        </tr>
        <c:forEach var="employee" items="${department.employees}">
        <tr>
                <td>${employee.firstName}</td>
                <td>${employee.secondName}</td>
                <td>${employee.dateOfBirthday}</td>
                <td>
                    <form method="post" action="/emplDelete">
                       <input type="hidden" name="id" value=${employee.id}>
                       <input type="submit" value="Delete">
                    </form>
                </td>
                <td>
                    <form method="post" action="/emplUpdate">
                       <input type="hidden" name="id" value=${employee.id}>
                       <input type="submit" value="Update">
                    </form>
                </td>
        </tr>
        </c:forEach>
    </table>
    <a href="/emplAdd?department_id=${department.id}">Add new Employye</a><br /><br />
    <a href="/">Home</a>
</body>
</html>
