<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>To DO CheckList</h1>

<form action="add" method="post">
Subject: <input type="text" name="subject"/>
<br><br>
Detail: <input type="text" name="detail"/>
<br><br>
Date of Assignments: <input type="date" name="assigndate"/>
<br><br>
Target Date: <input type="date" name="targetdate"/>
<br><br>
Target Time:<input type="text" name="time"/>
<br><br>
<input type="submit" value="Add Task"/>

</form>

<h2>Todo List</h2>
<c:set var="list"  value="${requestScope.list }"></c:set>
<table border="1">
<tr>
<th>ToDoId</th>
<th>Subject</th>
<th>Detail</th>
<th>Date</th>
<th>Target Date</th>
<th>Target Time</th>
<th>Status</th>
</tr>
<tr>
<td>${list.toDoId }</td>
<td>${list.subject }</td>
<td>${list.detail }</td>
<td>${list.assignmentDate }</td>
<td>${list.targetDate }</td>
<td>${list.targetTime }</td>
<td>${list.status }</td>
</tr>
</table>
</body>
</html>