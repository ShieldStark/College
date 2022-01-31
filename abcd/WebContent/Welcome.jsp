<%@page import="ab.Cnnt"%>
<%@page import="java.sql.*"%>
<!doctype html>
<html>
<head>
</head>
<style>
.display
{
width: 40%;
 position: absolute;
  top: 190px;
  left: 58%;
  padding-top: 16px;
border-style:solid;
border-radius: 25px;
background-color: #FFAD11;
}

.slide
{ width: 200%;
  position: absolute;
  

  top: 190px;
  left: 220px;
  padding-top: 16px;
}

.sidebar {
  height: 100%;
  width: 160px;
  position: absolute;
  z-index: 1;
  top: 190px;
  left: 20px;
  background-color: #111E6C;
  padding-top: 16px;
  border-radius: 25px;
}

.sidebar a {
  padding: 6px 8px 6px 16px;
  text-decoration: none;
  font-size: 20px;
  color: #FFAD11;
  display: block;
}

.sidebar a:hover {
  color: #f1f1f1;
}
img
{
width: 100%
}
</style>
<body bgcolor="#E6E6FA">
<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expire", "0");
	%>
	<%
		if (session.getAttribute("username") == null) {
			response.sendRedirect("Signin.jsp");
		}
	%>
<p> <img src="bsphcl.jpeg" width="128" height="128"></p>
<br>
<br>
<div class="slide" style="max-width:500px">
  <img class="mySlides" src="slide4.jpeg"  height="350">
  <img class="mySlides" src="slide2.jpeg"  height="350">
  <img class="mySlides" src="slide3.jpeg"  height="350">
  <img class="mySlides" src="slide1.jpeg"  height="350">
<img class="mySlides" src="slide5.jpeg"  height="350">
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

<div class="sidebar">
  <a href="Welcome.jsp"> Home</a>
  <a href="Form.jsp"> New Connection</a>
  <a href="#services"> Services</a>
  <a href="#clients"> Clients</a>
  <a href="Contact.jsp"> Contacts</a>
  <a href="Logout"> Logout</a>
  <a href="About.jsp"> About</a>
</div>
<div class="display">
<%
try
{
	String user= (String)session.getAttribute("username");
	System.out.println(user);
	String sql="select firstname,lastname,email,mobile from login where email=?";
	Cnnt con = new Cnnt();
	PreparedStatement st=con.getDbConnection().prepareStatement(sql);
	st.setString(1, user);
	ResultSet rs=st.executeQuery();
	while(rs.next())
	{%>
	<p><b>Name:</b><%= rs.getString("firstname") %> </p>
	<p><b>Mobile:</b><%= rs.getString("mobile") %> </p>
	<p><b>Email:</b><%= rs.getString("email") %> </p>
	<%	
	}
	
	
	
}catch (Exception e)
{System.out.println(e);
	
}
%>
</div>

</body>
</html>  