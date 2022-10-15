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
<div class="panel-heading text-center"> Confirmation</div>
<div class="panel-body">
 <div class="form-group"> 
 <label>ID:</label>
 <label >${produit.id}</label>
 </div>
 <div class="form-group">
 <label>Designation:</label>
 <label>${produit.designation}</label>
 </div>
  <div class="form-group">
 <label>Prix:</label>
 <label>${produit.prix}</label>
 </div>
 <div class="form-group">
 <label>Quantite:</label>
 <label>${produit.quantite}</label>
</div>
 
 


</div>
</div>


</div>
</body>
</html>