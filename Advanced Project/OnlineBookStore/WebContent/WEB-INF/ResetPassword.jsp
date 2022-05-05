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
 span {
	color:red;
}
button{
  cursor : pointer;
}
</style>
</head>
<body>
  <jsp:include page="./Home.jsp"></jsp:include>
  
  
  <center>
    <h2>Set Password page </h2>
    <% String email = request.getParameter("email");
     	String username = request.getParameter("username");
    %>
    <h4>Enter information here :</h4>
    
    <c:if test="${flag6}">
      <span>Password Doesn't match...</span>
    </c:if>
   <form method="post" action="./resetpassword?email=<%= email %>&username=<%= username %>" > 
    
      Enter new password : <input type="password" name="newpass" required/><br><br>
      Confirm Password : <input type="password"  name="confirmpass" required/><br><br>
      <button type="submit">Update Password</button>
    </form>
  </center>
</body>
</html>