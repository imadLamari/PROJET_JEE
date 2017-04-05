<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
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

button, select{
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
<layout:admin pageTitle="Liste des investisseurs">
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br> <br>
      <div class="row center">
        <div class="col s12">
          <c:choose>
            <c:when test="${empty listeUsers }">
              <p>Liste des investisseurs est vide !!</p>
            </c:when>
            <c:otherwise>
              <table class="bordered centered">
                <thead>
                  <tr>
                    <th>Id utilisateur</th>
                    <th>Prénom</th>
                    <th>Nom</th>
                    <th>Login</th>
                    <th>Role</th>
                    <th>Nom société</th>
                    <th>Etat</th>
                  </tr>
                </thead>

                <c:forEach var="user" items="${listeUsers}">
                  <tbody>
                    <tr>
                      <td>${user.id}</td>
                      <td>${user.prenom}</td>
                      <td>${user.nom}</td>
                      <td>${user.login}</td>
					  
					  <td>
					    <form action="${pageContext.request.contextPath}/ChangerRoleServlet" style="display: inline;">
                      	<select name="roleSelect">
    						<c:forEach var="role" items="${Roles}">
        					<option value="${role}" ${ role == user.role ? 'selected="selected"' : ''}>
        					    ${role}
        					  </option>
    						</c:forEach>
						</select>
						<input id="id" type="text" name="id" value="${user.id}" style="display: none" />
						<button class="waves-effect waves-light btn" type="submit">Changer</button>
					   </form>
                      </td>
                      
					  <td>
                      	<c:choose>
                          <c:when test="${user.entreprise==null}">
                            <p>Aucune</p>
                          </c:when>
                          <c:otherwise>
                            ${user.entreprise.nom}
                          </c:otherwise>
                        </c:choose>	
					  </td>
					 	
                      

                      <td>
                        <c:choose>
                          <c:when test="${user.valide==0}">
                            <form method="post" action="${pageContext.request.contextPath}/DesactiverUser">
                              <input id="role" type="text" name="role" value="Investisseur" style="display: none" /> 
                              <input id="id" type="text" name="id" value="${user.id}" style="display: none" />
                              <button class="waves-effect waves-light btn" type="submit">INACTIF</button>
                            </form>
                          </c:when>
                          <c:otherwise>
                            <form method="post" action="${pageContext.request.contextPath}/ActiverUser">
                              <input id="role" type="text" name="role" value="investor" style="display: none" />
                              <input id="id" type="text" name="id" value="${user.id}" style="display: none" />
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
