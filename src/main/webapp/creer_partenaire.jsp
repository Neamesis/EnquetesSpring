<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Nea
  Date: 06/11/2016
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Créer un partenaire</title>
</head>
<body>
<h1>Ajouter un partenaire </h1>
<form:form method="POST" modelAttribute="partenaire" action="creerPartenaire">
    <label>Nom du partenaire : </label>
    <br>
    <form:input path="namePartenaire" type="text" placeholder="Nom du partenaire" required="true"/>
    <br>
    <label>Site web du partenaire : </label>
    <br>
    <form:input path="siteWebPartenaire" type="text" placeholder="Nom du partenaire" required="true"/>
    <br>
    <input type="submit" value="Valider" class="button">
</form:form>


<p>Liste des partenaires actuels et leur site : </p>
<ul>
    <c:forEach items="${partenaires}" var="partenaire">
        <li>
            <c:out value="Nom : ${partenaire.namePartenaire}"/> <br>
            <c:out value="Site : ${partenaire.siteWebPartenaire}"/>
        </li>
    </c:forEach>
</ul>

</body>
</html>
