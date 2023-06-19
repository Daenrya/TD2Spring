<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/jsp/Menu.jsp" %>
<meta charset="UTF-8">
<title>Modifier Produit</title>
</head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">	
<body>
	<form method="post" action="/produit/saveProduit" modelAttribute="prod">
		<div class="mb-3">
			<label for="id" class="form-label">Id</label> 
			<input type="text" name="id" class="form-control" id="id" value="${ produit.getId() }">
		</div>
	
		<div class="mb-3">
			<label for="nom" class="form-label">Nom</label> 
			<input type="text" name="nom" class="form-control" id="nom" value="${ produit.getNom() }">
		</div>
		<div class="mb-3">
			<label for="reference" class="form-label">Référence</label> 
			<input type="text" name="reference" class="form-control" id="reference" value="${ produit.getReference() }">
		</div>
		<div class="mb-3">
			<label for="prix" class="form-label">Prix</label> 
			<input type="text" name="prix" class="form-control" id="prix" value="${ produit.getPrix() }">
		</div>
		<div class="mb-3">
			<label for="poids" class="form-label">Poids</label> 
			<input type="text" name="poids" class="form-control" id="poids" value="${ produit.getPoids() }">
		</div>
		
		<button type="submit" class="btn btn-outline-success btn-sm">Valider</button>
		<button type="reset" class="btn btn-outline-secondary btn-sm">Annuler</button>

	</form>
</body>
</html>