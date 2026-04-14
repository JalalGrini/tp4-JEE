<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion des Produits MVC1</title>
</head>
<body>
<h2>Gestion des Produits (MVC1)</h2>
<form action="${produitEdit != null ? 'updateProduit' : 'addProduit'}" method="post">
	<!-- Champ caché pour l'ID du produit à modifier -->
	<input type="hidden" name="idProduit" value="${produitEdit.idProduit}" />
	Nom: <input type="text" name="nom" value="${produitEdit.nom}" required />
	Description: <input type="text" name="description" value="${produitEdit.description}" required />
	Prix: <input type="text" name="prix" value="${produitEdit.prix}" required />
	<!-- Champ caché pour l'ID du produit à modifier -->
	<input type="submit" value="${produitEdit != null ? 'Modifier' : 'Ajouter'}" />
</form>

<hr/>

<!--
	Formulaire Recherche
	- Redirige vers ListProduitServlet
	- Si un ID est fourni, seul ce produit est affiché
	- Sinon, tous les produits sont listés
-->
<form action="listProduits" method="get">
ID: <input type="text" name="idProduit" />
<input type="submit" value="Rechercher" />
</form>

<hr/>

<!--

Tableau affichant la liste des produits

- Utilise JSTL cForEach pour parcourir listeProduits

- Les actions "Modifier" et "Supprimer" appellent respectivement

EditProduitServlet et DeleteProduitServlet

-->

<table style="border: 1px solid black; border-collapse: collapse;">
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
			<td>
			<!-- Modifier : charge le produit dans le formulaire pour édition -->
				<a href="editProduit?id=${p.idProduit}">Modifier</a> |
				<!-- Modifier : charge le produit dans le formulaire pour édition -->
				<a href="deleteProduit?id=${p.idProduit}" onclick="return confirm('Voulez-vous vraiment supprimer ce
				produit ?');">Supprimer</a>
			</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>