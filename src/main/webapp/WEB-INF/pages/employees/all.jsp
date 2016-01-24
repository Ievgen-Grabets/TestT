<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All</title>
</head>
<table width="600px">
    <tr>
        <td><b>departmentID</b></td>
        <td><b>firstName</b></td>
        <td><b>secondName</b></td>
        <td><b>date</b></td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.department.getId()}</td>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
            <td>${employee.date}</td>
            <form:form method="post" action="/empEdit">
                <input type="hidden" name="employeeID" value="${employee.id}"/>
                <td><input type="submit" value="Edit"/></td>
            </form:form>
            <form:form method="post" action="/empDel">
                <input type="hidden" name="employeeID" value="${employee.id}"/>
                <td><input type="submit" value="Delete"/></td>
            </form:form>
                <%--<td><a href="/depAdd?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a></td>--%>
        </tr>
    </c:forEach>
    <%
        final String departmentID = (String) request.getParameter("departmentID");
    %>
    <tr>
        <td colspan="5">
            <a href="/empAdd?departmentID=<%= departmentID%>">Add new one</a>
        </td>
    </tr>
</table>
</html>