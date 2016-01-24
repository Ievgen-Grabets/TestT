<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
    <title>All</title>
</head>
<table width="600px">
    <tr>
        <td><b>Name</b></td>
    </tr>
    <c:forEach var="employee" items="${employees}">
        <td>${employee.department.getName()}</td>
        <td>${employee.firstName}</td>
        <td>${employee.secondName}</td>
        <td>${employee.date}</td>
        <form:form method="post" action="/empEdit">
            <td><input type="submit" value="edit"></td>
            <input type="hidden" name="empId" value="${employee.id}">
        </form:form>
        <form:form method="post" action="/empDel">
            <td><input type="submit" value="delete"></td>
            <input type="hidden" name="empId" value="${employee.id}">
        </form:form>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="/empAdd?depId=<%=request.getParameter("depId")%>">Add new one</a>
        </td>
        <td colspan="5">
            <a href="/dep">GOBack</a>
        </td>
    </tr>
</table>