<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee</title>
    <link rel="stylesheet" type="text/css" href="../../css/style.css" />
</head>
<body>
<h2>Table of Employee</h2>
<table width="600px">
    <tr>
        <td><b>firstName</b></td>
        <td><b>secondName</b></td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td><a href="/empUpdate?id=${employee.id}">Update</a></td>>
            <td><a href="/empDelete?id=${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/empAdd">Add new one Employee</a>
        </td>
    </tr>
    <a href="/dep">All departments</a>
</table>
</body>
</html>
