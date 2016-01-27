<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All Employees</title>
</head>
<table width="200px">
    <tr>
        <td width="200"><b>${department.name}:</b></td>
    </tr>
</table>
<table width="400px" border="1">
    <td width="50" align="center"><b>ID</b></td>
    <td width="200" align="center"><b>Name</b></td>
    <td width="100" align="center"><b>Actions</b></td>
    <c:forEach var="employee" items="${department.employees}">
        <tr>
            <td width="50" align="center">${employee.id}</td>
            <td width="200">${employee.firstName} ${employee.secondName}</td>
            <td width="100" align="center"><a href="/empEdit?empID=${employee.id}">Edit</a> | <a href="/empDelete?empID=${employee.id}&depID=${department.id}">Delete</a> </td>
        </tr>
    </c:forEach>
</table>
<table width="200">
    <tr>
        <td width="300" align="center"><a href="/empAdd?id=${department.id}">Add new</a></td>
        <td width="300" align="center"><a href="/dep">List Departments</a></td>
    </tr>
</table>