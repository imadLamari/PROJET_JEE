<%@page import="jdk.nashorn.internal.runtime.regexp.RegExp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<title>SecondMarket</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate_auth.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style_auth.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
</head>

<body>
	<div class="container">
		<div class="top">
			<h1 id="title" class="hidden"><span id="logo"><span>Connexion</span></span></h1>
		</div>
		<form class="login-box animated fadeInUp" action="${pageContext.request.contextPath}/signup" method="get">
			<div class="box-header">
				<h2>Connexion</h2>
			</div>
			<label for="login">Login</label>
			<br/>
			<input type="text" name="login">
			<br/>
			<label for="password">Password</label>
			<br/>
			<input type="password" name="password">
            	<br/><button type="submit">Se connecter</button>
			<br/>
			<%
             String s=request.getAttribute("javax.servlet.forward.request_uri").toString();				
			 String url=s.substring(0,s.lastIndexOf('/')-1);
			%>
			<a href="${url}/JAVAEE_PROJET/faces/InscriptionServlet"><p class="small">Vous inscrire</p></a>		
		</form>  
	</div>
</body>

<script>
	$(document).ready(function () {
    	$('#logo').addClass('animated fadeInDown');
    	$("input:text:visible:first").focus();
	});
	$('#login').focus(function() {
		$('label[for="login"]').addClass('selected');
	});
	$('#login').blur(function() {
		$('label[for="login"]').removeClass('selected');
	});
	$('#password').focus(function() {
		$('label[for="password"]').addClass('selected');
	});
	$('#password').blur(function() {
		$('label[for="password"]').removeClass('selected');
	});
</script>

</html>