<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new employee</title>
</head>
<body>
<form:form  method="post" action="/saveEmployee">
    <table>
        <tr>
            <td>FirstName:</td>
            <td>SecondName:</td>
            <td>Department:</td>
        </tr>
        <tr>

            <td><input type="text" name="firstName"/></td>
            <td><input type="text" name="secondName"/></td>

                <td>
                <select size=1 name="departmentId">
                    <c:forEach var="department" items="${departments}">
                    <option value=${department.id}>${department.name}</option>
                    </c:forEach>
                </select>
                </td>

            <%--

              <p><select size="3" multiple name="hero[]">
    <option disabled>Выберите героя</option>
    <option value="Чебурашка">Чебурашка</option>
    <option selected value="Крокодил Гена">Крокодил Гена</option>
    <option value="Шапокляк">Шапокляк</option>
    <option value="Крыса Лариса">Крыса Лариса</option>
   </select></p>



              --%>




            <%-- <td><form:input path="depName" /></td>
            <td><form:input path="" /></td>
            --%>
        </tr>

       <%-- <tr>
            <td>E-mail:</td>
            <td><form:input path="email" /></td>
        </tr>  --%>
        <tr>
            <td colspan="3">
                <input type="submit" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>