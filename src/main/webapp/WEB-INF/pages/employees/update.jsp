<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>

<form:form  method="post" action="/saveEmployee" modelAttribute="editEmployee">
    <form:hidden path="id"/>
    <table>
        <tr>
            <td><b>FirstName:</b></td>
            <td><b>SecondName:</b></td>
            <td><b>Department:</b></td>
        </tr>
        <tr>
            <td><form:input path="firstName"/></td>
            <td><form:input path="secondName"/></td>
            <td><form:select path="department.id">
                <c:if test="${department.id != null}">
                    <form:option value="${department.id}" label="${department.name}"/>
                </c:if>
                <c:forEach var="dep" items="${departments}">
                    <c:if test="${dep.id != department.id}">
                        <form:option value="${dep.id}" label="${dep.name}"/>
                    </c:if>
                </c:forEach>
            </form:select></td>
        </tr>

        <tr>
            <td colspan="3">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>