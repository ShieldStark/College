<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<style>
div {
  width: 65%;
  height: 150px;
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
.signup-box
{
width: 420px;
height: 675px;
top: 80%;
left: 85%;
position: absolute;
transform: translate(-50%,-50%);
box-sizing: border-box;
padding: 70px 30px;
background-color: #FFAD11;
border-radius: 25px;
}
.signup-box p{
margin: 0;
padding: 0;
font-weight: bold;
}
.signup-box input{
width: 100%;
margin-bottom:20px;
}
.signup-box input[type="text"], input[type="password"] ,select
{
border: none;
border-bottom:1px solid #fff;
background: transparent;
outline: none;
height: 40px;
font-size: 16px;
width: 100%
}
.signup-box input[type="submit"]
{
border: none;
outline: none;
height: 40px;
background: #111E6C;
color: #fff;
font-size: 18px;
border-radius: 20px;
}
h1{
margin: 0;
padding: 0 0 20px;
text-align: center;
font-size: 22px;
color:#111E6C;
}

</style>
</head>
<body bgcolor="#E6E6FA">
<p> <img src="bsphcl.jpeg" width="128" height="128"></p>
<br>
<br>
<div class="display" >
  <img class="mySlides" src="slide4.jpeg"  height="400">
  <img class="mySlides" src="slide2.jpeg"  height="400">
  <img class="mySlides" src="slide3.jpeg"  height="400">
</div>
<script>
var myIndex = 0;
carousel();

function carousel() {
  var i;
  var x = document.getElementsByClassName("mySlides");
  for (i = 0; i < x.length; i++) {
    x[i].style.display = "none";  
  }
  myIndex++;
  if (myIndex > x.length) {myIndex = 1}    
  x[myIndex-1].style.display = "block";  
  setTimeout(carousel, 2000); // Change image every 2 seconds
}
</script>
<div class="signup-box">
<h1>Sign Up</h1>
<form action="Signup">
<p>Firstname:<p>
<input type="text" name="fname" placeholder="Firstname">
<br>
<p>Lastname:<p>
<input type="text" name="lname" placeholder="Lastname">
<br>
<p>Email:<p>
<input type="text" name="email" placeholder="Email">
<br>
<p>Mobile:<p>
<input type="text" name="mobile" placeholder="Mobile" maxlength="10">
<br>
<p>Password:<p>
<input type="password" name="password" placeholder="Enter Password">
<br>
<p>Gender:<p>
<select style="width: 100%" id="select" name="gender" >
<option value="">Select</option>
<option value="Male">Male</option>
<option value="Female">Female</option>
</select>
<br>
<br>
<input type="submit" value="Signup">
</form>
</div>
</body>
</html>