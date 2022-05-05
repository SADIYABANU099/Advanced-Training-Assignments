 <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>
 <style type="text/css">
   button {
	cursor: pointer;
}
 </style>
</head>
<body bgcolor="cyan">

   <center>
     <h4>Add Product Information Here : </h4>
     
     <form method="post" action="./add/product">
     
       <input type="text" name="productName" placeholder="Enter product name...." required/><br><br>
       <input type="text" name="productPrice" placeholder="Enter product price..." required/><br><br>
       <input type="text" name="productQuantity" placeholder="Enter product quantity..." required/><br><br>
       <button type="submit">Add</button>
       
     </form>
   </center>
</body>
</html>
    