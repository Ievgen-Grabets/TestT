<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <title>All</title>
</head>

<body>
<table width="600px">
  <tr>
    <td><b>Department name</b></td>
  </tr>
  <c:forEach var="department" items="${departments}">
    <tr>
      <td><a href="/empl?department_id=${department.id}">${department.name}</a></td>
      <td>
        <form method="post" action="/depDelete">
          <input type="hidden" name="id" value=${department.id}>
          <input type="submit" value="Delete">
        </form>
      </td>
      <td>
        <form method="post" action="/depUpdate">
          <input type="hidden" name="id" value=${department.id}>
          <input type="submit" value="Update">
        </form>
      </td>
    </tr>
  </c:forEach>
</table>
<a href="/depAdd">Add new one</a>
<br><br>
<a href="/">Home</a>
</body>
</html>