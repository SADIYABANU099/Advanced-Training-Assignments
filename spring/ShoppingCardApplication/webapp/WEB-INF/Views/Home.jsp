<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product-Summary</title>
<style type="text/css">
 button {
	cursor: pointer;
}
</style>
</head>
<body bgcolor="cyan">
   <center>
     <h3>${mssg}</h3><br><br>
     
     <h4>**** Added Product Details ***</h4>
     
     Product Id : ${product.productId}<br><br>
     Product Name : ${product.productName}<br><br>
     Product Price : ${product.productPrice}<br><br>
     Quantity: ${product.productQuantity}<br><br>
     
     <a href="../"><button>Back To Home</button></a>
     
   </center>
</body>
</html>
    