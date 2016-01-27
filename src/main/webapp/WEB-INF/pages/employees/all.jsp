<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> AllEmployee </title>
</head>
<body>
<table width="600px">
    <tr>
        <td>Department: ${department.name}</td>
    </tr>
    <c:forEach var="employee" items="${employees}">
    <tr>
        <td>${employee.firstName}</td>
        <td>${employee.secondName}</td>
        <td>${employee.age}</td>
        </tr>>
    </c:forEach>
</table>>

</body>
</html>
