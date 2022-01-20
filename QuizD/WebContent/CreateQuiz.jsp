<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Quiz</title>
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
<div class="container-1">
        
        <div class="flex-box-container-3">
            <form action="QuestionServlet" method="get">
            	<p>Course Id:<%=request.getParameter("courseId") %></p>
            	<input type="hidden" name="cid" value="<%=request.getParameter("courseId") %>">
            	<input type="text" name="Question" placeholder="Enter the Question Here" required="required">
            	<input type="text" name="OA" placeholder="Enter the Option A" required="required">
            	<input type="text" name="OB" placeholder="Enter the Option B" required="required">
            	<input type="text" name="OC" placeholder="Enter the Option C" required="required">
            	<input type="text" name="OD" placeholder="Enter the Option D" required="required">
            	<input type="text" name="correct" placeholder="Correct Option" required="required">
            	
            	<br>
            	<br>
            	<input type="submit" value="Add Question">
            </form>
            <button class="click-button1" onclick="document.location='AdminWelcome.jsp'">Done</button>
        </div>
        
</div>

</body>
</section>

</html>