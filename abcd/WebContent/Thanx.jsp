<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thank you</title>
<style>
img
{
width: 100%
}
.sidebar a:hover {
  color: #f1f1f1;
}
.sidebar a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: #FFAD11;
  display: block;
}
.sidebar {
  height: 130%;
  width: 160px;
  position: absolute;
  z-index: 1;
  top: 220px;
  left: 20px;
  background-color: #111E6C;
  padding-top: 16px;
  border-radius: 25px;
}
.box
{
width: 80%;
height: 130%;
top: 99%;
left: 55%;
background-color: #FFAD11;
position: absolute;
transform: translate(-50%,-50%);
box-sizing: border-box;
border-radius: 25px;
}
h1{
margin: 0;
padding: 20px;
font-size: 30px;
color: #111E6C;
text-align:center;
}
h2
{color: #111E6C;padding: 20px;
}
a{padding: 20px;
}
</style>
</head>
<body bgcolor="#E6E6FA">
<p> <img src="bsphcl.jpeg" width="128" height="128"></p>
<br>
<br>
<div class="sidebar">
  <a href="Welcome.jsp"> Home</a>
  <a href="Form.jsp"> New Connection</a>
  <a href="#services"> Services</a>
  <a href="#clients"> Clients</a>
  <a href="Contact.jsp"> Contacts</a>
  <a href="Logout"> Logout</a>
  <a href="About.jsp"> About</a>
</div>

<div class="box">

<br><br>
<h1>Thank You. Your request is registered</h1>


</div>
</body>
</html>