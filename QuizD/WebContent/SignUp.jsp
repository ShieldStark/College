<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<link rel ="stylesheet" href ="style.css">
<section>
<p><img src="nitp.jpg" width="128" height="128"></p>
<br>
<br>
<body bgcolor="#E6E6FA">
<div class="signup-box">
  <h1>Sign Up</h1>
    <form action="StudentSignUpServlet" method="get">
    <p>Firstname:</p>
    <input type="text" name="fname" placeholder="Firstname" required="required" />
    <p>Lastname:</p>
    <input type="text" name="lname" placeholder="Lastname" required="required" />
    <p>Roll No:</p>
    <input type="text" name="roll" placeholder="Roll No" required="required" />
    <p>Email:</p>
    <input type="text" name="email" placeholder="Email" required="required" />
    <p>Mobile:</p>
    <input type="text" name="mobile" placeholder="Mobile" required="required" />
    <p>Password:</p>
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