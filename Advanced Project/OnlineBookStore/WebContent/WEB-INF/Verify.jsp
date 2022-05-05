<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
 <style type="text/css">
 
   span{
       color:red;
   }
   button {
	cursor: pointer;
}
 </style>
</head>
<body>
  <jsp:include page="./Home.jsp"></jsp:include>
  <center>
   
   <c:if test="${flag3}">
     <span>Inavlid email or Username !!</span>
   </c:if>
    <h4>Enter Information here</h4>
    <form action="./verify" method="post">
      Enter Email : <input type="text" name="email" required/><br><br>
      Enter user name :  <input type="text" name="uname" required/><br><br>
      
      <button type="submit">Submit</button>
    </form>
  </center>
</body>
</html>