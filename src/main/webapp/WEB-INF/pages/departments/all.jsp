<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <title>All Departmets</title>
</head>
<table width="200px">
  <tr>
    <td width="200"><b>Departments:</b></td>
  </tr>
</table>
<table width="400px" border="1">
  <td width="50" align="center"><b>ID</b></td>
  <td width="100" align="center"><b>Name</b></td>
  <td width="100" align="center"><b>Actions</b></td>
  <c:forEach var="department" items="${departments}">
    <tr>
      <td width="50" align="center">${department.id}</td>
      <td width="100"><a href="/empDep?depId=${department.id}">${department.name}</a></td>
      <td width="100" align="center"><a href="/depEdit?id=${department.id}">Edit</a> | <a href="/depDelete?id=${department.id}">Delete</a> </td>
    </tr>
  </c:forEach>
</table>
<table width="200">
  <tr>
    <td width="300" align="center">
      <a href="/depAdd">Add new Department</a>
    </td>
  </tr>
</table>