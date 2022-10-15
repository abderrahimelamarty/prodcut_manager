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
<div class="panel-heading text-center"> Add Product</div>
<div class="panel-body">
<form action="addProduct.do" method="post">
<div class="form-group">
<label class="control-label"> Designation</label>
<input type="text" name="Designation" class="form-control" value="${produit.designation }" required="required">
</div>
<div class="form-group">
<label class="control-label"> Quantite</label>
<input type="number" name="Quantite" class="form-control" value="${produit.quantite}" required="required">
</div>
<div class="form-group">
<label class="control-label"> Prix</label>
<input type="number" name="Prix" class="form-control" value="${produit.prix}" required="required">
</div>
 
<button type="submit" class="btn btn-primary">add</button>
</form>


</div>
</div>


</div>
</body>
</html>