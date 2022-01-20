
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Quiz App</title>
</head>
<link rel ="stylesheet" href ="style.css">
<section>
<p><img src="nitp.jpg" width="128" height="128"></p>
<br>
<br>
<body bgcolor = "#E6E6FA">
<%
response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expire", "0");
if(session.getAttribute("username")==null)
	response.sendRedirect("Login.jsp");

%>
<nav>
			<a href="#" class="logo"></a>
			<ul>
				<li><a href="Welcome.jsp" class="active">Welcome</a></li>
				<li><a href="About.jsp">About</a></li>
				<li><a href="Contacts.jsp">Contacts</a></li>
				<li><a href="LogOut">LogOut</a></li>
			</ul>
</nav>
	<div class="container-2" >
		<div class="flex-box-container-2">
		<% try 
			{
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb","root","8824497447Pa@");
			String sql="select * from course";
			PreparedStatement ps= con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next())
			{
			%>
			<div class="click-button">
        	<button class="click" name='<%=i++ %>' onclick="document.location='Quiz.jsp?course=<%=i-1%>'"><img src="quiz-icon.jpg"></button>
        	<p><%= rs.getString("courseName") %></p>
    		</div> 
    	<%}
		}
		catch(Exception e){
			System.out.println(e);
		}
    		%>
            
        </div>
	</div>

</body>
</section>
</html>