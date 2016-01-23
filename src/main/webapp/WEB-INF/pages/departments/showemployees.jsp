<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employees of the department</title>
</head>
<body>
<c:choose>
    <c:when test="${employeesCount > 0}">
        <jsp:include page="employeeslist.jsp"/>
    </c:when>
    <c:otherwise>
        The department '${department.name}' has no any employees
    </c:otherwise>
</c:choose>

</body>
</html>