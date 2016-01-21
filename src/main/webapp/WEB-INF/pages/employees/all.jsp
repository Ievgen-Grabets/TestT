<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All empl</title>
</head>
<table width="600px">
    <tr>
        <td><b>Name</b></td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${department.name}</td>                                                                 // сделана ссылкой
            <<td><a href="/depEdit?id=${department.id}">Edit</a> | <a href="/depDelete?id=${department.id}">Delete</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/empAdd">Add new one</a>
        </td>
    </tr>


</table>
