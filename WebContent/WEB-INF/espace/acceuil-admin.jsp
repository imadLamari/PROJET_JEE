<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate_auth.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style_auth.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>
	<body>
     	<div class="container" >
			<div class="top">
				<h1 id="title" class="hidden"><span id="logo"><span>Acceuil administrateur</span></span></h1>
			</div >
			<div class="login-box">
			  <center>
                <br/>
                <br/>
   				<center style="background-color: #665851;height: 50px;">
    			  <div>
    			     <a style="color: white; height: 100%;" href="${pageContext.request.contextPath}/AllInvestisseurServlet"> Utilisateurs</a>
    			  </div>			
   				</center>
   				
   				<br/>
   				<br/>
   				<center  style="background-color: #665851; height: 50px;">
   			       <div>
      				  <a style="color: white; height: 100%;" href="${pageContext.request.contextPath}/AllEntrepriseServlet"> Entreprises</a>  			   
   					</div>
   				</center>
   				<br/>
   				
   				<a href="${pageContext.request.contextPath}/DeconnexionServlet" > Deconnexion </a> 
			</div>
           </center>                 
    	</div>   
	</body>
</html>