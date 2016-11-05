<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Proposition d'enquête téléphonique</title>
</head>
<body>
<h1>Proposer une enquête téléphone</h1>

<form:form modelAttribute="enqueteTelephone" action="creerEnqueteTel" method="POST">
    <label>Nom de l'enquête : </label>
    <br>
    <form:input path="name" type="text" placeholder="Nom de l'enquête"/>
    <br> <br>

    <label>Texte d'accroche : </label>
    <br>
    <form:input path="texteAccroche" type="text" placeholder="Texte de l'accroche"/>
    <br> <br>

    <label>Date de début d'enquête : </label>
    <br>
    <input type="date" name="DATE"/>

    <br> <br>
    <input type="submit" value="Valider" class="button"/>
</form:form>



</body>
</html>
