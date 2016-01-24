<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
</htm class="no-js">
<head>
  <title>All</title>
  <link rel="stylesheet" type="text/css" href="../../css/style.css" />
  <style type="text/css">
    body {
      color:#000066
    }
    table {
      border-collapse: collapse;
      border: 2px solid black;
    }

    td {
      padding: 5px;
      padding-right: 30px;
      border: 1px solid lightgray;
    }
  </style>
</head>
<body>
<table width="600px">
  <tr>
    <td><b>Name</b></td>
  </tr>
  <c:forEach var="department" items="${departments}">
    <tr>
      <td><a href="/emp?dep_id=${department.id}">${department.name}</a></td>
        <%--<td><a href="de/WEB-INF/pages/employees/all.jsp">${department.name}</a></td>--%>
        <%--<td>${department.name}</td>--%>
      <td><a href="/depUpdate?id=${department.id}">Update</a>|
        <a href="/depDelete?id=${department.id}">Delete</a></td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <a href="/depAdd">Add new one Department</a>
    </td>
  </tr>
</table>
</body>
</html>