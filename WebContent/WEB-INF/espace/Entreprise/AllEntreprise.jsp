<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<layout:admin pageTitle="Liste des entreprises">
<style> 
 table {
    border-collapse: collapse;
    width: 100%;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #665851;
    color: white;
}

button {
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
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
           <c:choose>
            <c:when test="${empty listeEntreprise }">
              <p>Liste des entreprises est vide !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id Entreprise</th>
                    <th>Nom</th>
                    <th>Secteur</th>
                    <th>Site web</th>
                    <th>Chiffre d'affaire</th>
                    <th>Effectif</th>            
                    <th>Etat</th>
                  </tr>
                </thead>

                <c:forEach var="entreprise" items="${listeEntreprise}">
                  <tbody>
                    <tr>
                      <td>${entreprise.id}</td>
                      <td>${entreprise.nom}</td>
                      <td>${entreprise.secteur}</td>
                      <td>${entreprise.siteWeb}</td>
					  <td>${entreprise.chiffreAffaire}</td>
					  <td>${entreprise.effectif}</td>
					   
                      <td>
                        <c:choose>
                          <c:when test="${entreprise.valide==0}">
                            <form method="post" action="${pageContext.request.contextPath}/DesactiverEntreprise"> 
                              <input id="id" type="text" name="id" value="${entreprise.id}" style="display: none" />
                              <button class="waves-effect waves-light btn" type="submit">INACTIF</button>
                            </form>
                          </c:when>
                          <c:otherwise>
                            <form method="post" action="${pageContext.request.contextPath}/ActiverEntreprise">
                              <input id="id" type="text" name="id" value="${entreprise.id}" style="display: none" />
                              <button class="waves-effect waves-light btn" type="submit">ACTIF</button>
                            </form>
                          </c:otherwise>
                        </c:choose>
                      </td>
                    </tr>
                  </tbody>
                </c:forEach>
              </table>
            </c:otherwise>
          </c:choose>
        </div>
      </div>
    </div>
  </div>
</layout:admin>
