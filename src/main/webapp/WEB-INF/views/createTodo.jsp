<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>create todo</title>
</head>
<body>

	Create a new task - <br/>
	
	<c:if test="${ saved != null }">
		<h4>saved successfully</h4>
	</c:if>
	
	<form:form action="saveTodo" method="POST" modelAttribute="task123" >
	
		Enter task - <form:input path="task"></form:input>
		complete it by - <form:input path="completeItBy"></form:input>
		
		<button type="submit" >Add</button>
		
	</form:form>
	
</body>
</html>