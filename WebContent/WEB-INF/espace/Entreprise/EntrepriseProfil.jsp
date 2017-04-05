<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<head>
	<meta charset="utf-8">
	<title>SecondMarket</title>

	<!-- Google Fonts -->
	<link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700|Lato:400,100,300,700,900' rel='stylesheet' type='text/css'>

	<link rel="stylesheet" href="css/animate_auth.css">
	<!-- Custom Stylesheet -->
	<link rel="stylesheet" href="css/style_auth.css">

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<style type="text/css">
		select{
			margin-top: 0px;
			border: 0;
			border-radius: 2px;
			color: white;
			padding: 10px;
			text-transform: uppercase;
			font-weight: 400;
			font-size: 0.7em;
			letter-spacing: 1px;
			background-color: #665851;
			cursor:pointer;
			outline: none;
		}
	</style>
</head>

<layout:company pageTitle="Ma société">
    <div class="container">
        <div class="top">
			<h1 id="title" class="hidden"><span id="logo"><span>Profil entreprise</span></span></h1>
		</div>
		
        <form class="login-box" method="post" action="${pageContext.request.contextPath}/EntrepriseNouveauServlet">		
            <label for="nom">Nom</label> 
            <br/>
            <input id="nom" name="nom" type="text" value="${ entreprise !=null ? entreprise.nom : ''}" class="validate" required aria-required="true"> 
            <br/>		
     
            <label for="chiffreAffaire">Chiffre d'affaire</label>
            <br/>
            <input id="chiffreAffaire" name="chiffreAffaire" value="${ entreprise !=null ? entreprise.chiffreAffaire : ''}" type="text" class="validate" required aria-required="true"> 
            <br/>
            
            <label for="siteWeb">Site web</label>
            <br/>
            <input id="siteWeb" name="siteWeb" value="${ entreprise !=null ? entreprise.siteWeb : ''}" type="text" class="validate" > 
            <br/>
              	
            <label for="effectif">Nombre d'employés</label>
            <br/>
            <input id="effectif" name="effectif" type="text" value="${ entreprise !=null ? entreprise.effectif : ''}" class="validate" required aria-required="true"> 
            <br/>
            
            <label for="secteurSelect">Secteur</label>
            <br/>
            <select id="secteurSelect" name="secteurSelect" class="validate">
                <option value="" disabled selected>Choisir un secteur</option>
                <c:forEach var="secteur" items="${secteurs}">
                    <option value="${ secteur }" 
                    	${ secteur == entreprise.secteur ? 'selected="selected"' : ''}>
                    	${ secteur }
                    </option>
                </c:forEach>
            </select> 
            <br/>
            <br/>
            <input id="type" type="text" name="type" value="${entreprise==null ? 'add' : 'update'}" style="display: none" />   	
			
			<button type="submit">Appliquer</button>
        
        </form>
    </div>
</layout:company>