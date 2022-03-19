<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<head>
<meta charset="windows-1256">
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><title>Liste Produits</title> -->

<title>Créer un Produit</title>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-6">

			<h1 class="container mt-4" >
			creer des Produits
			</h1>
			<form action="saveProduit" method="post">
			  <div class="mb-3">
			    <label class="form-label">nom :</label>
			    <input type="text" class="form-control" name="nomProduit">
			  </div>
			  <div class="mb-3">
			    <label class="form-label">prix :</label>
			    <input type="text" class="form-control" name="prixProduit">
			  </div>
			   <div class="mb-3">
			    <label class="form-label">date création :</label>
			    <input type="date" class="form-control" name="date">
			  </div>
			  <div class="row">
				  <div class="col-6">
				  	<button type="submit" class="btn btn-primary" value="ajouter">ajouter</button>
				  </div>
				  <div class="col-6 ">
					<a href="ListeProduits" class="mt-3 float-end" >Liste Produits</a>
				  </div>
			  </div>
			</form>
			${msg}
			
		</div>
	</div>
</div>
</body> 

</html>