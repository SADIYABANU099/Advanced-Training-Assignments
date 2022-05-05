<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
         <%@ page isELIgnored = "false" %>
         
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<style type="text/css">
   button{
     cursor: pointer;
   }
   span {
	color : red;
}
</style>
</head>
<body>
  <jsp:include page="./Home.jsp"></jsp:include>
    <% 
    	boolean flag5 = Boolean.parseBoolean(request.getParameter("flag5")); 
        boolean regflag = Boolean.parseBoolean(request.getParameter("regflag")); 
    
    %>
  
  
 <center>
 
  	<c:if test="<%= flag5 %>">
      <h4>Password Updated successfully !!</h4>
    </c:if>
     <c:if test="<%= regflag %>">
      <h4>successfully registered!!</h4>
    </c:if>
    <h2>Please Login Here</h2>
   
    <form method="post" action="./login">
       <input type="text" name="username" placeholder="Enter Username..." required/><br><br>
       <input type="password" name="password" placeholder="Enter password...." required/><br><br>
       <button type="submit">Login</button><br><br>
       <c:if test="${flag1}">
         <span>Invalid Login credentials !!</span>
       </c:if>
    </form>
    <br>
     Not Registered !! <a href="./register">Click here to Register</a><br><br>
     Forgot password ? <a href="./verify">Click here</a>
 </center> 
</body>
</html>