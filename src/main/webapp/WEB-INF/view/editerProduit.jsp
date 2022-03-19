<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><title>Liste Produits</title>

<title>Modifier un Produit</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-6">
			
			<h1 >
			editer des Produits
			</h1>
			<form action="updateProduit" method="post">
			<div class="mb-3">
			    <label class="form-label">id :</label>
			    <input type="text" class="form-control" name="idProduit" value="${produit.idProduit}" disabled>
			  </div>
			  <div class="mb-3">
			    <label class="form-label">nom :</label>
			    <input type="text" class="form-control" name="nomProduit" value="${produit.nomProduit}">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">prix :</label>
			    <input type="text" class="form-control" name="prixProduit" value="${produit.prixProduit}">
			  </div>
			   <div class="mb-3">
			    <label class="form-label">date création :</label>
			    <fmt:formatDate pattern="yyyy-MM-dd" value="${produit.dateCreation}" var="formatDate"/>
			
			    <input type="date" class="form-control" name="date" value="${formatDate}">
			  </div>
			 <div class="row">
				  <div class="col-6">
				  	<button type="submit" class="btn btn-primary">Modifier</button>
				  </div>
				  <div class="col-6 ">
					<a href="ListeProduits" class="mt-3 float-end" >Liste Produits</a>
				  </div>
			  </div>
			</form>		
		</div>
	</div>
</div>
</body>
</html> 
