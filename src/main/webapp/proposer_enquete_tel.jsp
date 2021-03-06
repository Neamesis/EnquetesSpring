<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Proposition d'enqu�te t�l�phonique</title>
    <link href="<c:url value="../${pageContext.request.contextPath}/resources/css/bootstrap.css"/>" rel="stylesheet">
    <meta charset="UTF-8">
</head>

<body>
<div class="container">
    <jsp:include page="header.jsp"/>

    <h1 class="page-header">Proposer une enqu�te t�l�phonique</h1>

    <form:form modelAttribute="enqueteTelephone" action="creerEnqueteTel" method="POST">
    <form>
        <div class="form-group col-md-6">
            <label>Nom de l'enqu�te : </label>
            <br>
            <form:input class="form-control" path="name" type="text" placeholder="Nom de l'enqu�te" required="true"/>
            <br> <br>
        </div>

        <div class="form-group col-md-6">
            <label>Texte d'accroche : </label>
            <br>
            <form:input class="form-control" path="texteAccroche" type="text" placeholder="Texte de l'accroche" required="true"/>
            <br> <br>
        </div>

        <div class="form-group col-md-12">
            <label>Date de d�but d'enqu�te : (aaaa-MM-jj)</label>
            <br>
            <input class="form-control" type="date" name="DATE" required="true" placeholder="aaaa-MM-jj" />
            <br> <br>
        </div>

        <div class="col-md-12">
            <input type="submit" value="Valider" class="btn btn-danger col-md-1"/>
        </div>
    </form>
    </form:form>
</div>
</body>

</html>
