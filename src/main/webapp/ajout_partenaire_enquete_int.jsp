<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div class="container">
    <jsp:include page="header.jsp"/>

    <h1 class="page-header">Ajouter un partenaire � l'enqu�te : ${enqueteInternet.name}</h1>


    <form:form method="POST" modelAttribute="partenaire" action="ajoutPartEnquInt">
    <form>
        <input type="hidden" value="${enqueteInternet.idEnquete}" name="ID_ENQUETE"/>
        <p>Num�ro de l'enqu�te : ${enqueteInternet.idEnquete}</p>
        <p>Partenaire(s) actuel(s) de l'enqu�te : </p>
        <c:forEach items="${enqueteInternet.partenaires}" var="partenaire">
            <li>
                    ${partenaire.namePartenaire} (${partenaire.siteWebPartenaire})
            </li>
        </c:forEach>

        <br>
        <label>
            <p>Choisissez un partenaire � ajouter � votre enqu�te :</p>
            <p>(Attention, vous ne pouvez choisir qu'un partenaire � la fois)</p>
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
