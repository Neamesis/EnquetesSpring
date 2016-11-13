<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nea
  Date: 06/11/2016
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <jsp:include page="header.jsp"/>

    <h1 class="page-header">Ajouter un partenaire à l'enquête : ${enqueteInternet.name}</h1>


    <form:form method="POST" modelAttribute="partenaire" action="ajoutPartEnquInt">
    <form>
        <input type="hidden" value="${enqueteInternet.idEnquete}" name="ID_ENQUETE"/>
        <p>Numéro de l'enquête : ${enqueteInternet.idEnquete}</p>
        <p>Partenaire(s) actuel(s) de l'enquête : </p>
        <c:forEach items="${enqueteInternet.partenaires}" var="partenaire">
            <li>
                    ${partenaire.namePartenaire} (${partenaire.siteWebPartenaire})
            </li>
        </c:forEach>

        <br>
        <label>
            <p>Choisissez un partenaire à ajouter à votre enquête :</p>
            <p>(Attention, vous ne pouvez choisir qu'un partenaire à la fois)</p>
        </label>
        <br>
        <select class="form-control" name="ID_PARTENAIRE">
            <c:forEach items="${partenaires}" var="partenaire" varStatus="status">
                <c:if test="${partenaire.enqueteInternet == null}">
                    <option value="${partenaire.idPartenaire}" required="required" id="${partenaire.idPartenaire}">
                            ${partenaire.namePartenaire} (${partenaire.siteWebPartenaire})
                    </option>
                </c:if>
            </c:forEach>
        </select>
        <br>
        <p>Votre partenaire ne se trouve pas dans la liste ?
            <a href="/EnquetesSpring/creerPartenaire"> Ajouter un partenaire</a>
        </p>
        <br>
        <input type="submit" value="Valider" class="btn btn-danger"/>
    </form>
    </form:form>
</body>
</html>
