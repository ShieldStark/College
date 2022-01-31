<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About</title>
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
p
{padding: 0 0 0 20px;
}
li
{padding: 0 0 0 20px ;
}
</style>
</head>
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
<p> <img src="head.jpeg" width="128" height="128"></p>
<p>As many of you may be aware that Government of Bihar has restructured the erstwhileBihar State Electricity Board into five functionally independent state-owned companiesviz. BSPHCL, SBPDCL, SBPDCL, BSPTCL & BSPGCL with effect from 1st November, 2012under the provision of Bihar State Electricity Reforms Transfer Scheme 2012 andElectricity Act 2003.South Bihar Power Distribution Company Ltd(SBPDCL) has beengiven the status of a Distribution Licensee as per Section 14 of the ElectricityAct 2003 and engaged primarily in the business of distribution of Electricity andis serving more than 18 lacs consumers in 17 districts of South Bihar.
</p>
<br>
<p>Presently, we are providing uninterrupted power supply in PESU, Area, Patna i.eCapital of Bihar and also providing 18-20 Hrs assured powersupply in the entire17 district HQ of South Bihar. We are also giving you the assurance for replacementof defective transformer in the Urban areas in 24 hrs & in rural areas in 72 hrs.Our main objectives are:-<p>
<li> To modernize and strengthen the distribution network</li>
<li> To extend the distribution network to all the villages / tolas.</li>
<li> To provide meter to all the unmetered consumers</li>
<li> To redresses the consumer grievances in the shortest possible time.</li>
<p> Also we have made several new options for payment of energy bills:-<p>
<li> Any Time Payments (ATP) machines for PESU Area</li>
<li> Through Canara bank ATM& Mobile Van for PESU Area</li>
<li> Through SahajVashudhaKendra</li>
<li> Online collection through Canara Bank Debit Card (For Canara Bank Customers) &alsothrough Net Banking ofCanara bank (Bill Desk for 43 Banks and SBI for its own Customers).</li>
<p>We have established a Call Centre for our valued consumers where all types of Complaintsmay be lodged having Toll Free No. 1800-345-198.
We are committed to provide Safe, reliable, Uninterrupted and quality power supplyto all of the valued consumers at affordable tariff.
Save Energy for better & reliable power supply for each of us.<p>
</div>
</body>
</html>