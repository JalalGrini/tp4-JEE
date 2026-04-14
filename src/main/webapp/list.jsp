<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1" cellpadding="5">
	<tr>
		<th>ID</th>
		<th>Nom</th>
		<th>Description</th>
		<th>Prix</th>
		<th>Actions</th>
	</tr>
	<c:forEach var="p" items="${listeProduits}">
		<tr>
			<td>${p.idProduit}</td>
			<td>${p.nom}</td>
			<td>${p.description}</td>
			<td>${p.prix}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>