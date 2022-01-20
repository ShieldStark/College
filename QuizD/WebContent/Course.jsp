<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">

</script>

<meta charset="ISO-8859-1">
<title>Admin Portal</title>
</head>
<link rel ="stylesheet" href ="style.css">
<body bgcolor="#E6E6FA">
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expire", "0");
if(session.getAttribute("username")==null)
	response.sendRedirect("AdminLogin.jsp");

%>

<section>
<p><img src="nitp.jpg" width="128" height="128"></p>
<nav>
			<a href="#" class="logo"></a>
			<ul>
				<li><a href="AdminWelcome.jsp" class="active">Welcome</a></li>
				<li><a href="About.jsp">About</a></li>
				<li><a href="Contacts.jsp">Contacts</a></li>
				<li><a href="AdminLogOut">LogOut</a></li>
			</ul>
</nav>
<div class="login-box">
  <h1>Course</h1>
    <form action="CourseServlet" method="get">
      <input type="text" name="cname" placeholder="CourseName" required="required" />
      <input type="text" name="cid" placeholder="CourseId" required="required" />
      <input type="text" name="adm" placeholder="AdminName" required="required" />
      <input type="submit" value="Create Course">
    </form>
</div>
</section>


</body>
</html>