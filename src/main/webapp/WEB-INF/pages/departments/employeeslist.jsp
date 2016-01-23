<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<H1> Employees of the department '${department.name}'</H1>

<table width="600px">
    <tr>
        <td><b>FirstName</b></td> <td><b>SecondName</b></td>
    </tr>
    <c:forEach var="employee" items="${department.employees}">
        <tr>
            <td>${employee.firstName}</td>
            <td>${employee.secondName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
