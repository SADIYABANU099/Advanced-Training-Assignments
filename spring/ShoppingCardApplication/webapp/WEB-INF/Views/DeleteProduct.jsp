<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@ page isELIgnored = "false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>

<style type="text/css">
 button {
	cursor: pointer;
}
</style>
</head>

<body bgcolor="cyan">
  <center>
    <h4>*** Edit Your Product here ***</h4>
    
    <form method="post" action="../edit/product">
    
      <input type="text" name="productId" value="${productid}"/><br><br>
      <input type="text" name="productName" placeholder="Enter new product name..." required/><br><br>
      <input type="text" name="productPrice" placeholder="Enter new Product price..." required/><br><br>
      <input type="text" name="productQuantity" placeholder="Enter new Product quantity..." required/><br><br>
      
      <button type="submit">Edit</button>
      
    </form>
  
  </center>
</body>
</html>
