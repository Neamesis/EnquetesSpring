<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proposition d'enquête internet</title>
</head>
<body>

<h1>Proposer une enquête internet</h1>

<a href="/EnquetesSpring/genererPartenaires">Générer une liste de partenaires</a>
<p>Partenaires : </p>
<ul>
    <c:forEach items="${partenaires}" var="partenaire">
        <li>
            <c:out value="${partenaire.namePartenaire}"/>
            <c:out value="${partenaire.siteWebPartenaire}"/>
        </li>
    </c:forEach>
</ul>


<form:form modelAttribute="enqueteInternet" action="creerEnqueteInt" method="POST">
    <label>Nom de l'enquête : </label>
    <br>
    <form:input path="name" type="text" placeholder="Nom de l'enquête"/>
    <br> <br>

    <label>Texte d'accroche : </label>
    <br>

    <br> <br>

    <input type="date" name="DATE"/>
    <br> <br>

    <input type="submit" value="Valider" class="button"/>
</form:form>

<!-- TODO Afficher liste des partenaires et pouvoir en choisir -->

</body>
</html>
