 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DeleteConfirmation</title>
 <style type="text/css">
   button {
	cursor: pointer;
}
 </style>
</head>
<body bgcolor="cyan">
  <center>
    <h4>*** Product To be Deleted ***</h4>
    
     Product Id : ${product.productId}<br><br>
     Product Name : ${product.productName}<br><br>
     Product Price : ${product.productPrice}<br><br>
     Quantity: ${product.productQuantity}<br><br>
     
     <a href="../delete/product/${product.productId}"><button>Confirm</button></a><br><br>
     
     <a href="../view/products"><button>Cancel</button></a>
    
  </center>
</body>
</html>
    