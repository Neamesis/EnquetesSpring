<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Enquêtes</title>
    <link href="<c:url value="../${pageContext.request.contextPath}/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="../${pageContext.request.contextPath}/resources/css/justified-nav.css"/>" rel="stylesheet">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="../${pageContext.request.contextPath}/resources/css/bootstrap.min.js"></script>
    <meta charset="UTF-8">
</head>

<body>
<div class="masthead">
    <h1 class="text-muted">Enquêtes de réponses</h1>
    <nav>
        <ul class="nav nav-justified">
            <li class="nav-item" role="button">
                <a  class="nav-link active" id="dLabel" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                Enquêtes
                <span class="caret"></span>
                    <ul class="dropdown-menu" aria-labelledby="dLabel">
                        <li>
                            <a href="/EnquetesSpring/creerEnqueteTel">Proposer une enquête téléphonique</a>
                        </li>
                        <li>
                            <a href="/EnquetesSpring/creerEnqueteInt">Proposer une enquête internet</a>
                        </li>
                        <li>
                            <a href="/EnquetesSpring/triEnquetesParDate">Trier par date</a>
                        </li>
                        <li>
                            <a href="/EnquetesSpring/triEnquetesParNom">Trier par nom</a>
                        </li>
                        <li >
                            <a href="/EnquetesSpring/index">Récupérer les enquêtes</a>
                        </li>
                    </ul>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="/EnquetesSpring/index">Accueil</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="/EnquetesSpring/...">À propos</a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="/EnquetesSpring/...">Contact</a>
            </li>

        </ul>
    </nav>
</div>




</body>
</html>
