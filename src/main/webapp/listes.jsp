<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<HTML>
<head>
<link rel = "stylesheet" href = "styles.css">
</head>

<BODY>

<div class = "row">
    <div class = "column">
    Liste femmes : <BR/>
    <TABLE>
        <c:forEach var="joueur" items="${listeFemmes}">
            <tr>
                <td>${joueur.prenom}</td><td>${joueur.nom}</td>
            </tr>
        </c:forEach>
      </TABLE>

    </div>

    <div class = "column">
        Liste hommes : <BR/>

        <TABLE>
         <c:forEach var="joueur" items="${listesHomes}">
             <tr>
                 <td>${joueur.prenom}</td><td>${joueur.nom}</td>
             </tr>
         </c:forEach>

              	</c:forEach>
        </TABLE>
    </div>
</div>


</body>
</html>
