<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirm</title>
<style type="text/css">
  button{
  cursor: pointer;
  }
  small {
	color: red;
}
  
</style>
</head>
<body>
   <jsp:include page="./Home.jsp"></jsp:include>
   <center>
     <h4>Order confirmation</h4>
     
     <form method="post" action="./confirm">
       Customer Name : <input type="text" name="custname" required/><br><br>
       Address : <input type="text" name="address" required/><br><br>
       Phone Number : <input type="text" name="phone" required  pattern="[789][0-9]{9}"/><br><br>
               
       <h4>Purchased Book details are as follows : </h4>
       Book Id : ${book.id}<br><br>
       Book Name : ${book.bookname}<br><br>
       Author : ${book.author}<br><br>
       Price : ${book.price}<br><br>
       Quantity : ${quantity}<br><br>
       
       <button type="submit">Confirm</button>
     </form>
     
     <br>
     
     <a href="./dashboard"><button>Cancel</button></a>
     
   </center>
</body>
</html>