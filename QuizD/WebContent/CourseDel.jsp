<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Quiz App</title>
</head>
<link rel ="stylesheet" href ="style.css">
<section>
<p><img src="nitp.jpg" width="128" height="128"></p>
<body bgcolor = "#E6E6FA">
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
				<li><a href="delete.jsp" class="active">Delete</a></li>
				<li><a href="About.jsp">About</a></li>
				<li><a href="AdminContacts.jsp">Contacts</a></li>
				<li><a href="AdminLogOut">LogOut</a></li>
			</ul>
</nav>
<div class="login-box">
  <h1>Course</h1>
    <form action="CourseDelete" method="get">
      <input type="text" name="cid" placeholder="CourseId" required="required" />
      <input type="submit" value="Delete Course">
    </form>
</div>

<%-- <div class="container">
	<div class="flex-box-container">
		<div><button class="button">Admin</button></div>
		<div><button class="button">Student</button></div>
	</div>

</div> --%>

</body>
</section>
</html>