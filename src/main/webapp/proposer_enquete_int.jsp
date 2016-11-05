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

<a href="/EnquetesSpring/genererPartenaires">Générer une liste de partenaires (à utiliser avec parcimonie...)</a>

<form:form modelAttribute="enqueteInternet" action="creerEnqueteInt" method="POST">
    <label>Nom de l'enquête : </label>
    <br>
    <form:input path="name" type="text" placeholder="Nom de l'enquête"/>
    <br> <br>

    <label>Date de début d'enquête : </label>
    <br>
    <input type="date" name="DATE"/>
    <br> <br>

    <label>Choisissez le ou les partenaire(s) pour cette enquête : </label> <br>
<%--    <c:forEach items="${partenaires}" var="partenaire" varStatus="status">
        <tr>
            <td>${partenaire.namePartenaire}</td>
            <td>
                <form:checkbox path="partenaires"/>
            </td>
        </tr>

    </c:forEach>--%>

    <form:checkboxes items="${partenaires}" path="partenaires" itemLabel="namePartenaire" delimiter="<br/>"/>

    <br> <br>
    <input type="submit" value="Valider" class="button"/>
</form:form>

<p>Liste des partenaires et leur site : </p>
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
