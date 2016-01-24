<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All</title>
</head>
<table width="600px">
    <tr>
        <td><b>D</b></td>
    </tr>
    <tr>
        <th align="left">First name</th>
        <th align="left">Second name</th>

    </tr>
    <c:forEach var="employee" items="${employees}">

        <tr>
            <td>${employee.firstName} </td>
            <td>${employee.secondName} </td>
            <<td><a href="/empEdit?id=${employee.id}">Edit</a> | <a href="/empDelete?id=${employee.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/empAdd">Add new one</a>
        </td>
    </tr>


</table>
