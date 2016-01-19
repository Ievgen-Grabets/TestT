<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All employees</title>
</head>
<table width="600px">
    <tr>
        <td><b>FirstName</b></td> <td><b>SecondName</b></td> <td><b>Department</b></td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td>${employee.department.name}</td>
            <td><a href="editEmployee?id=${employee.id}">Edit</a> | <a href="deleteEmployee?id=${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<hr/>
<a href="addEmployee">Add new one</a>