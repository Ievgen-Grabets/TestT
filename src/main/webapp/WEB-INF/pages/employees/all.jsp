<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>AllEmployee</title>
</head>
<table width="600px">
    <tr>
        <td><b>Department: ${department.name}</b></td>
    </tr>
    <tr>
        <th align="left">First name</th>
        <th align="left">Second name</th>

    </tr>
    <c:forEach var="employee" items="${employees}">

        <tr>
            <td>${employee.firstName} </td>
            <td>${employee.secondName} </td>
            <td>
            <form method="post" action="/empDelete">
                <input type="hidden" name="id" value=${employee.id}>
                <input type="submit" value="Delete">
            </form>
        </td>
            <td>
                <form method="post" action="/empEdit">
                    <input type="hidden" name="id" value="${employee.id}">
                    <input type="submit" value="Update">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
<form method="post" action="/empEdit">
    <input type="hidden" name="department_id" value="${department.id}">
    <input type="submit" value="Add new one">
</form>        </td>
    </tr>


</table>
</html>
