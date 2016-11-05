<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enquêtes</title>
</head>
<body>
<h1>Bienvenue sur notre site d'enquêtes</h1>

<a href="/EnquetesSpring/creerEnqueteTel">Proposer une enquête téléphonique</a>
<br>
<a href="/EnquetesSpring/creerEnqueteInt">Proposer une enquête internet</a>

<p>Liste des enquêtes : </p>
<ul>
    <c:forEach items="${enquetes}" var="enquete">
        <li>
            <c:out value="Nom :  ${enquete.name}"/> <br>
            <c:out value="Date : ${enquete.dateEnquete}"/>
        </li>
    </c:forEach>
</ul>


</body>
</html>
