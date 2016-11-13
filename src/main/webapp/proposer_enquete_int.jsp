<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Proposition d'enqu�te internet</title>
</head>
<body>
<div class="container">
    <jsp:include page="header.jsp"/>


    <h1 class="page-header">Proposer une enqu�te internet</h1>

    <p>G�n�rer une liste de partenaires (� utiliser avec parcimonie...)
        <a href="/EnquetesSpring/genererPartenaires" class="btn btn-default">G�n�rer</a></p>

    </br>

    <form:form method="POST" modelAttribute="enqueteInternet" action="creerEnqueteInt">
        <form>
            <div class="form-group col-md-6">
                <label>Nom de l'enqu�te : </label>
                <br>
                <form:input class="form-control" path="name" type="text" placeholder="Nom de l'enqu�te" required="true"/>
                <br> <br>
            </div>

            <div class="form-group col-md-6">
                <label>Date de d�but d'enqu�te : (aaaa-MM-jj) </label>
                <br>
                <input class="form-control" type="date" name="DATE" required="true" placeholder="aaaa-MM-jj"/>
                <br> <br>
            </div>

            <label>
                <p>Choisissez un partenaire � ajouter � votre enqu�te : (Attention, vous ne pouvez choisir qu'un partenaire � la fois)</p>
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

</div>
</body>
</html>
