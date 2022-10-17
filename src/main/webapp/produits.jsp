<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  

<title>Produits</title>
</head>
<body>
<%@include file="header.jsp" %>
<br>
<br>

<div class="container">
<div class="panel panel-primary " >
<div class="panel-heading text-center"> Recherche des produits</div>
<div class="panel-body">
<form action="chercher.do" method="get">
<label> Mot Clé</label>
<input type="text" name="motCle" value="${model.motCle}">
<button type="submit" class="btn btn-primary">chercher</button>
</form>
<br>
<table class="table table-striped">
<tr>
<th> ID</th> <th> DESINATION</th> <th> PRIX</th> <th>QUANTITE</th><th></th> <th></th></tr>
   <c:forEach items="${model.produits}" var="p">
     <tr>
     <td>${p.id}</td>
     <td>${p.designation}</td>
     <td>${p.prix} DH</td>
     <td>${p.quantite}</td>
      <td><a  onclick="return confirm('Etes vous sur ?')" href="delete.do?id=${p.id }">delete <span class="glyphicon glyphicon-trash"></span></a></td>
      <td><a href="edit.do?id=${p.id }">update <span class="glyphicon glyphicon-pencil"></span></a></td>
      
     
     </tr>


   </c:forEach>
</table>
</div>
</div>


</div>
</body>
</html>