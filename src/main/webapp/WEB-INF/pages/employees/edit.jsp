<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form method="post" action="/empSave">
    <table>
        <tr>
            <td>FirstName:</td>
            <td><input type="text" name="firstName"/></td>
            <td>SecondName:</td>
            <td><input type="text" name="secondName"/></td>
            <input type="hidden" name="depId" value="<%=request.getParameter("depId")%>">
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
