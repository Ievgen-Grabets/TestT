<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="no-js">
<head>
  <title>All</title>
</head>
<table width="600px">
  <tr>
    <td><b>Name</b></td>
  </tr>
  <c:forEach var="contact" items="${contacts}">
    <tr>
      <td>${contact.id}</td>
      <td><a href="/edit?id=${contact.id}">Edit</a> | <a href="/delete?id=${contact.id}">Delete</a></td>
    </tr>
  </c:forEach>
  <tr>
    <td colspan="5">
      <a href="/add">Add new one</a>
    </td>
  </tr>
</table>