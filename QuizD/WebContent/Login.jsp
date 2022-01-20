<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Quiz App</title>
<script type="text/javascript">

function validate(){
	 var username=document.getElementById("uname");
	 var password=document.getElementById("pass");
	 if(username.value.trim()==""){
	 	alert("No blank values allowed");
	 	username.style.border="solid 3px red";
	 	return false;
	 	}
	 else if(password.value.trim()=="")
	 		{
	 		alert("No blank values allowed");
	 		password.style.border="solid 3px red";
	 		return false;
	 		}
	 	else 
	 	{
	 	return true;
	 	}
	}

</script>
</head>
<link rel ="stylesheet" href ="style.css">
<body bgcolor="#E6E6FA">
<section>
<p><img src="nitp.jpg" width="128" height="128"></p>
<br>
<br>
<div class="login-box">
  <h1>Student Login Here</h1>
    <form action="SignOn" method="get" onsubmit="validate()">
      	<input type="text" name="uname" placeholder="Username" required="required" />
      	<%
      	if(request.getParameter("error")!=null)
      	{
      		System.out.println("At jsp"+ request.getParameter("error"));%>
      	<p style="color: red; font-size: 50"><%=request.getParameter("error")%></p>
      	<%
      	}
      	%>
        <input type="password" name="pass" placeholder="Password" required="required" />
        <input type="submit" value="Login">
        <a href="#">Forgot Password</a><br>
        <a href="SignUp.jsp">Don't have an account</a><br>
        <a href="Home.jsp">Home</a>
    </form>
</div>
</section>


</body>
</html>