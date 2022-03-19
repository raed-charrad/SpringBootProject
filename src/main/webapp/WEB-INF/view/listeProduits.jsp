<%@ page language="java" contentType="text/html; charset=windows-1256"
pageEncoding="windows-1256"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css"
href="webjars/bootstrap/4.3.1/css/bootstrap.min.css" />
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<script type="text/javascript"
src="webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous"><title>Liste Produits</title> -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-6">
			
			<h1 >
			Liste des Produits
			</h1>		
			 	<a href="showCreate" class="float-end"><button type="button" class="btn btn-primary" onclick="">Create</button></a>
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Nom Produit</th>
			      <th scope="col">Prix</th>
			      <th scope="col">Date Création</th>
			      <th scope="col">Action</th>
			    </tr>
			  </thead>
			  <tbody>
			  <c:forEach items="${produits}" var="p">
			    <tr>
			      <th scope="row">${p.idProduit }</th>
			      <td>${p.nomProduit }</td>
			      <td>${p.prixProduit }</td>
			      <td><fmt:formatDate pattern="dd/MM/yyyy" value="${p.dateCreation}" /></td>
			      <td class="float-center">
			      <div class="row">
			      	<div class="col-6">
			      		<a onclick="return confirm('Etes-vous sûr ?')"href="supprimerProduit?id=${p.idProduit }"><i class="bi bi-trash-fill "></i></a>
			      	</div>
			      	<div class="col-6">
			      		<a href="modifierProduit?id=${p.idProduit }"><i class="bi bi-pencil-square"></i></a>
			      	</div>
			      </div>
			      </td>
			    </tr>
			 </c:forEach>
			   
			  </tbody>
			
			</table>
		</div>
	</div>
</div>
</body>
</html>