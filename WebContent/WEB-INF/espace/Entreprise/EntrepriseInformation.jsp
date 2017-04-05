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

.header {
    display: -moz-inline-stack;
    display: inline-block;
    zoom: 1; /* inline-block hack for IE7 */
    *display: inline; /* inline-block hack for IE7 */
    
    
}
h3 {
    float: left;
    display: inline;
    padding: 1em 0;
    width: 400px;
}

.Fields { float: left;}

.Fields ul li { float: left; margin-right: 10px;}

.Fields ul  {list-style-type: none;}

.Fields ul .Password a { display: block;}

</style>
  <div >
    <div class="container">
       <table class="bordered centered">
          <thead>
             <tr>
                <th>Type</th>
                <th>Descriptif</th>
             </tr>
          </thead>
          <c:forEach var="info" items="${infos}">
             <tbody>
               <tr>
                 <td>${info.type}</td>
                 <td>${info.descriptif}</td>
               </tr>
             </tbody>
          </c:forEach>
       </table>
       
    	<div id="login" class="section">
    		<form class = "Fields" action="${pageContext.request.contextPath}/InformationNouveau" method="post">
      			<ul>  
        			<li class = "UserName">
        			     <div>
        			    	<label> Type</label>
        			    </div>     			
            			<input id="type"  class ="Value" type = "text" />
            			
        			</li>
        			<li class = "Password">	
        			  <div>
        			   	  <label > Descriptif</label>
        			   </div>	   
            		  <textarea id="descriptif" rows="5" cols="50"></textarea>
            		  
        			</li>
        			<li class = "Login">
        			    <button type="submit"> Ajoutter</button>
        			</li>
    			</ul>
    		</form>
		</div>  
    
    </div>
  </div>
</layout:admin>
