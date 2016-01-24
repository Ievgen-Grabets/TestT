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
  <c:forEach var="department" items="${departments}">
    <td>
      <td><a href="/depEmp?depId=${department.id}">${department.name}</a></td>
        <form:form method="post" action="/depEdit">
          <td><input type="submit" value="edit"></td>
          <input type="hidden" name="depId" value="${department.id}">
        </form:form>
        <form:form method="post" action="/depDel">
          <td><input type="submit" value="delete"></td>
          <input type="hidden" name="depId" value="${department.id}">
        </form:form>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <a href="/depAdd">Add new one</a>
    </td>
    <td></td>
    <td colspan="5">
      <a href="/emp">All Employees</a>
    </td>
  </tr>
</table>