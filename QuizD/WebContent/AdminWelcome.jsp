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
<div class="container-1">
        
        <div class="flex-box-container-2">
            <div class="click-button">
                <button class="click" onclick="document.location='Course.jsp'"><img src="quiz-icon.jpg"></button>
                <br>
                <p>Create Quiz</p>
            </div>
            <div class="click-button">
                <button class="click" onclick="document.location='NewAdmin.jsp'"><img src="Admin.png"></button>
                <br>
                <p>Create Admin</p>
            </div>
        </div>
        
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