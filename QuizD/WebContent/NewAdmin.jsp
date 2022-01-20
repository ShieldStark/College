<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>NewAdmin</title>
</head>
<link rel ="stylesheet" href ="style.css">
<section>
<p><img src="nitp.jpg" width="128" height="128"></p>
<body bgcolor="#E6E6FA">
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expire", "0");
if(session.getAttribute("username")==null)
	response.sendRedirect("AdminLogin.jsp");

%>
<nav>
			<a href="#" class="logo"></a>
			<ul>
				<li><a href="AdminWelcome.jsp" class="active">Welcome</a></li>
				<li><a href="About.jsp">About</a></li>
				<li><a href="Contacts.jsp">Contacts</a></li>
				<li><a href="AdminLogOut">LogOut</a></li>
			</ul>
</nav>
<div class="admin-signup-box">
  <h1>Admin SignUp</h1>
    <form action="AdminSignUpServlet" method="get">
    <input type="text" name="fname" placeholder="Firstname" required="required">
    <input type="text" name="lname" placeholder="Lastname" required="required">
    <input type="text" name="empid" placeholder="Employee Id" required="required" />
    <input type="text" name="email" placeholder="Email" required="required" />
    <input type="text" name="mobile" placeholder="Mobile" required="required" />
    <input type="password" name="pass" placeholder="Password" required="required" />
    <br>
    <p>Gender:</p>
    <select style="width: 100%" id="select" name="gender">
    <option value="">Select</option>
    <option value="Male">Male</option>
    <option value="female">Female</option>    
    </select>
    <br>
    <br>
    <input type="submit" value="Signup">
    </form>
</div>

</body>
</section>

</html>