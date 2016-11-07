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
<br>

<form:form method="POST" modelAttribute="enqueteInternet" action="creerEnqueteInt">
    <label>Nom de l'enquête : </label>
    <br>
    <form:input path="name" type="text" placeholder="Nom de l'enquête" required="true"/>
    <br> <br>

    <label>Date de début d'enquête : (aaaa-MM-jj) </label>
    <br>
    <input type="date" name="DATE" required="true" placeholder="aaaa-MM-jj"/>
    <br> <br>

    <label>
        <p>Choisissez un partenaire à ajouter à votre enquête :</p>
        <p>(Attention, vous ne pouvez choisir qu'un partenaire à la fois)</p>
    </label>
    <br>
    <c:forEach items="${partenaires}" var="partenaire" varStatus="status">
        <c:if test="${partenaire.enqueteInternet == null}">
            <tr>
                <td>
                    <input type="radio" name="ID_PARTENAIRE" value="${partenaire.idPartenaire}" required="required"/>
                </td>
                <td>${partenaire.namePartenaire} (${partenaire.siteWebPartenaire})</td>
                <br>
            </tr>
        </c:if>
    </c:forEach>
    <%--    <form:checkboxes items="${partenaires}" path="partenaires" itemLabel="namePartenaire"
                         delimiter="<br/>" itemValue="idPartenaire"/>--%>
    <br>
    <p>Votre partenaire ne se trouve pas dans la liste ?
        <a href="/EnquetesSpring/creerPartenaire"> Ajouter un partenaire</a>
    </p>
    <br>
    <input type="submit" value="Valider" class="button"/>
</form:form>

</body>
</html>
