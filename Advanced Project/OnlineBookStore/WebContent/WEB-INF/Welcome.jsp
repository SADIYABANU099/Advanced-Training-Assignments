<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ page isELIgnored = "false" %>
         
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
<style type="text/css">
  span {
	 color: red;
}
</style>
</head>
<body>
  <jsp:include page="./Home.jsp"></jsp:include>
  
  <center>
    <h4>List of Books Available</h4>
     
     <c:if test="${flag2}">
      <span>Not enough Stock !!</span>
    </c:if><br><br>
    <table border="2px solid black">
       <tr>
         <th>Book Id</th>
         <th>Book Name</th>
         <th>Author</th>
         <th>Price</th>
         <th>Stocks</th>
         <th>Select</th>
       </tr>
        
         <c:forEach items="${books}" var="book">
            <tr>
              <td>${book.id}</td>
              <td>${book.bookname}</td>
              <td>${book.author}</td>
              <td>${book.price}</td>
              <td>${book.stocks}</td>
              <td><a href="./purchase?bookid=${book.id}">Select</a></td>
            </tr>
    	</c:forEach>
    
    </table>
   <br>
     <jsp:include page="./Logout.jsp"></jsp:include>
   
  </center>
</body>
</html>