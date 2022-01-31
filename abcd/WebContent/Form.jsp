<%@page import="ab.Cnnt"%>
<%@page import="java.sql.*"%>
<!doctype html>
<html>
<head>
</head>

<style>
.sidebar {
	height: 130%;
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

img {
	width: 100%
}





.login-box {
	width: 80%;
	height: 142%;
	top: 100%;
	left: 55%;
	background-color: #FFAD11;
	position: absolute;
	transform: translate(-50%, -50%);
	box-sizing: border-box;
	border-radius: 25px;
	padding: 0 0 0 20px;
	
}
.login-box a
{padding: 0 0 0 20px;
}

h1 {
	margin: 0;
	padding: 10px 0 20px;
	font-size: 22px;
	color: #111E6C;
	
	
}

.login-box input[type="submit"] {
	border: none;
	outline: none;
	height: 40px;
	background: #111E6C;
	color: #fff;
	font-size: 18px;
	border-radius: 20px;
	
	
}
</style>
<body bgcolor="#E6E6FA" >
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

	<p>
		<img src="bsphcl.jpeg" width="128" height="128">
	</p>
	<br>
	<br>
	<div class="sidebar">
		<a href="Welcome.jsp"> Home</a> <a href="Form.jsp"> New Connection</a>
		<a href="#services"> Services</a> <a href="#clients"> Clients</a> <a
			href="Contact.jsp"> Contacts</a> <a href="Logout"> Logout</a> <a
			href="About.jsp"> About</a>
	</div>
	<script>
      function myfunction()
      { 
        var xhttp;
        //if (str.length == 0) { 
         // document.getElementById("test").innerHTML = "";
         // return;
        //}
        
        var val=document.getElementById("company").value;
        
        xhttp = new XMLHttpRequest();
        
        xhttp.onreadystatechange = function() {
          if (this.readyState == 4 && this.status == 200) {
            document.getElementById("circle").innerHTML = this.responseText;
          }
        };
        xhttp.open("GET", "CircleServlet?valajax="+val, true);
        xhttp.send();
      	}
      function chgdivision()
      { 
        var xhttp;
        //if (str.length == 0) { 
         // document.getElementById("test").innerHTML = "";
         // return;
        //}
        
        var val=document.getElementById("circle").value;
          
        xhttp = new XMLHttpRequest();
        
        xhttp.onreadystatechange = function() {
          if (this.readyState == 4 && this.status == 200) {
            document.getElementById("division").innerHTML = this.responseText;
          }
        };
        xhttp.open("GET", "DivisionServlet?valajax="+val, true);
        xhttp.send();
      	}
      function chgsubdivision()
      { 
        var xhttp;
        
      	  var val=document.getElementById("division").value;
      	    
        xhttp = new XMLHttpRequest();
        
        xhttp.onreadystatechange = function()
        {
        if (this.readyState === 4 && this.status === 200)
        	{document.getElementById("subdivision").innerHTML = this.responseText;
        	}
        
        };
        	  
        	  xhttp.open("GET", "SubDivisionServlet?valajax="+val, true);
        	  xhttp.send();
        }
      function chgsection()
      { 
        var xhttp;
        
      	  var val=document.getElementById("subdivision").value;
      	    
        xhttp = new XMLHttpRequest();
        
        xhttp.onreadystatechange = function()
        {
        if (this.readyState === 4 && this.status === 200)
        	{document.getElementById("section").innerHTML = this.responseText;
        	}
        
        };
        	  
        	  xhttp.open("GET", "SectionServlet?valajax="+val, true);
        	  xhttp.send();
        }
      </script>
	<div class="login-box">
		<form action="ApplicationServlet" enctype="multipart/form-data" method="post">
			<br>
			<h1>A)Application Type:</h1>
			<br> <label> Company: </label> <select id="company"
				name="company" style="width: 150px" onchange="myfunction()">
				<option value="">select</option>
				<%
					try {
						Cnnt con = new Cnnt();
						java.sql.Statement st = con.getDbConnection().createStatement();
						ResultSet rs = st.executeQuery("select * from company");
						while (rs.next()) {
							System.out.println(rs.getString("company_name"));
				%>
				<option value="<%=rs.getString("company_id")%>"><%=rs.getString("company_name")%></option>
				<%
					}
					} catch (Exception e) {
						System.out.println(e);
					}
				%>

			</select> <label> Circle: </label> <select id="circle" name="circle"
				style="width: 150px" onchange="chgdivision()">
				<option value="">select</option>
			</select> <label> Division: </label> <select id="division" name="division"
				style="width: 150px" onchange="chgsubdivision()">
				<option value="">select</option>
			</select> <br> <br> <label> SubDivision: </label> <select
				id="subdivision" name="subdivision" style="width: 150px"  onchange="chgsection()" >
				<option value="">select</option>
			</select> <label> Section: </label> <select id="section" name="section" style="width: 150px">
				<option value="">select</option>
			</select>
				 <br> <br>

			<h1>B)Personal Information:</h1>
			<label> Title: </label> <select id="title" name="title" style="width: 100px" name="title">
				<option value="shri">Shri</option>
				<option value="smt">Smt</option>
				<option value="smt">kumari</option>
				
			</select> 
			
			<label> Applicant name: </label> 
			<input type="text" id="name" name="name"> <br> <br> 
			<label> Father's name: </label> 
			<input type="text" id="faname" name="faname"> <br>
			<h1>C)Address:</h1>
			<br> 
			<label> Address: </label> 
			<input type="text" id="add" name="add" size="100"> <br> <br> 
			<label>District: </label> 
			<input type="text" id="district" name="district">
			<label for="block"> Block: </label> <input type="text" id="block"
				name="block"> <br> <br> <label> Panchayat:
			</label> <input type="text" id="panchayat" name="panchayat"> <label>
				Village: </label> <input type="text" id="village" name="village"> <br>
			<br> <label> Tola: </label> <input type="text" id="tola"
				name="tola"> <br> <br>
			<h1>D)Document:</h1>
			<br> <label> Identity Card: </label> <select
				style="width: 100px">
				<option value="passport">Passport</option>
				<option value="pancard">Pan Card</option>
				<option value="adhar">Adhar Card</option>
				<option value="voter">Voter id</option>
				<option value="dl">Driving License</option>
				<option value="idbygov">Id issued by government</option>
				<option value="rationcard">Ration Card</option>
				<option value="bplcard">BPL Card</option>
			</select> <input type="file" id="ifile" name="ifile"> <br> <br> <label>
				ID no: </label> <input type="text" id="id" name="id"> <br> <br>
			<label> Residential Proof: </label> <select style="width: 100px">
				<option value="passport">Passport</option>
				<option value="pancard">Pan Card</option>
				<option value="adhar">Adhar Card</option>
				<option value="voter">Voter id</option>
				<option value="dl">Driving License</option>
				<option value="idbygov">Id issued by government</option>
				<option value="rationcard">Ration Card</option>
				<option value="bplcard">BPL Card</option>
			</select> <input type="file" id="rfile" name="rfile"> <br> <br> <label>
				Residential Proof no: </label> <input type="text" id="rid" name="rid">
			<br> <br> <input type="submit" value="submit" width="30%">
		</form>
		<br>
	</div>
</body>
</html>
