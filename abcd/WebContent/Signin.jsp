<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script type="text/javascript">
function validate()
{
	var username=document.getElementById("uname");
	var password=document.getElementById("pass");
	Signindao dao=new Signindao();
	if(username.value.trim()=="")
		{
		alert("No blank values allowed");
		username.style.border="solid 3px red";
		return false;
		}
	else if( password.value.trim()=="")
		{
		alert("No blank values allowed");
		password.style.border="solid 3px red";
		return false;
		}
	else 
		{
		return true
		}
	}
</script>
<style>
div {
  width: 65%;
  height: 100px;
  padding: 0px 0px 70px 30px;	
}
img
{
width: 100%
}
body
{
margin: 0;
padding: 0;
font-family: sans-serif;
}
.login-box
{
width: 320px;
height: 420px;
top: 65%;
left: 85%;
position: absolute;
transform: translate(-50%,-50%);
box-sizing: border-box;
padding: 70px 30px;
background-color: #FFAD11;
border-radius: 25px;
}
h1{
margin: 0;
padding: 0 0 20px;
text-align: center;
font-size: 22px;
color: #111E6C;
}
.login-box p{
margin: 0;
padding: 0;
font-weight: bold;
}
.login-box input{
width: 100%;
margin-bottom:20px;
}
.login-box input[type="text"], input[type="password"]
{
border: none;
border-bottom:1px solid #fff;
background: transparent;
outline: none;
height: 40px;
font-size: 16px;
}
.login-box input[type="submit"]
{
border: none;
outline: none;
height: 40px;
background: #111E6C;
color: #fff;
font-size: 18px;
border-radius: 20px;
}
.login-box a
{
text-decoration: none;
font-size: 16px;
line-height: 20px;
color: #111E6C;
}
</style>
</head>
<body bgcolor="#E6E6FA">



<p> <img src="bsphcl.jpeg" width="128" height="128"></p>
<br>
<br>
<div class="display" >
  <img class="mySlides" src="slide4.jpeg"  height="350">
  <img class="mySlides" src="slide2.jpeg"  height="350">
  <img class="mySlides" src="slide3.jpeg"  height="350">
</div>

<script>
var myIndex = 0;
carousel();

function carousel() 
{
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) 
  {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 2000); 
}
</script>
<div class="login-box">
<h1>Login Here</h1>
<form action="Signon" method="get" onsubmit="validate()">
<p>Username</p>
<input type="text" name="uname" placeholder="Enter Username" id="uname">
<%
if(request.getParameter("error")!=null)
{
System.out.println("At jsp"+request.getParameter("error"));
%>
<p style="color: red;font-size: 50"> <%=request.getParameter("error")%><p>
<%	}
%>
<p>Password</p>
<input type="password" name="pass" placeholder="Enter Password" id="pass">
<input type="submit" value="Login">
<a href="#"> Forgot Password?</a><br>
<a href="Signup.jsp">Don't have an account?</a>
</form>
</div>
</body>
</html>