<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
</head>
<body>
<% 
    String erreur = (String) request.getAttribute("erreur");
    if(erreur != null) { 
%>
    <p style="color:red;"><%= erreur %></p>
<% } %>

<form action="loginhandler" method="post" >
login: <input type="text" name="login" ><br>
mot de pass: <input type="password" name="password" ><br>
<input type="submit" value="login">
</form>
</body>
</html>