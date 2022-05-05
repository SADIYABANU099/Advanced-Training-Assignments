<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
<style type="text/css">
  #note{
     color: red;
  }
   button{
     cursor: pointer;
   }
   span{
      color:red;
   }
</style>
</head>
<body>
  <jsp:include page="./Home.jsp"></jsp:include>
  
  <center>
    <h2>Customer Registration form</h2>
    <h4>Enter Information below</h4>
    <form method="post" action="./register">
       <input type="text" name="fullname" placeholder="Enter full name..." required/> <span>*</span><br><br>
       <input type="text" name="address" placeholder="Enter address..." required/> <span>*</span><br><br>
       <input type="text" name="email" placeholder="Enter email...." required/> <span>*</span><br><br>
       <input type="text" name="username" placeholder="Enter username..." required/> <span>*</span><br><br>
       <input type="password" name="password" placeholder="Enter password..." required/> <span>*</span><br><br>
       <button type="submit">Register</button>
    </form>
    <br><br>
    Already Registered !!! <a href="./login">Login here</a><br><br>
    <p id="note">Fields marked with * are mandatory</p>
  </center>
  
</body>
</html>