<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Purchase</title>
<style type="text/css">
  button{
	cursor: pointer;
}
</style>
</head>
<body>
  <jsp:include page="./Home.jsp"></jsp:include>
  
  <center>
    <h4>Selected Book is displayed</h4>
    
    Book Id :${book.id}<br><br>
    Book Name : ${book.bookname}<br><br>
    Author : ${book.author}<br><br>
    Price : ${book.price}<br><br>
    
    <form method="post" action="./purchase">
     Enter Quantity : <input type="text" name="quantity" required/><br><br>
     <button type="submit">Purchase</button>
    </form>
    <br>
    <a href="./dashboard"><button>Cancel</button></a>
  </center>
</body>
</html>