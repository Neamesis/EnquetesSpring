<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enquêtes</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css" rel="stylesheet">
    <%--<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet">--%>
    <meta charset="UTF-8">
</head>

<style>
    .navbar {
        min-height: 70px;
        padding-top: 10px;
        margin-bottom: 0px;
    }

    .navbar-brand {
        font-family: 'Raleway', sans-serif;
        font-weight: 900;
    }

    .navbar-header .navbar-brand {
        color: white;
    }

    .navbar-default .navbar-nav > li > a {
        color: white;
        font-weight: 700;
        font-size: 15px;
    }

    .navbar-default .navbar-nav > li > a:hover {
        color: rgba(172, 186, 191, 0.82);
    }

    .navbar-default .navbar-nav > .active > a, .navbar-default .navbar-nav > .active > a:hover, .navbar-default .navbar-nav > .active > a:focus {
        color: rgba(172, 186, 191, 0.82);
        background: transparent;
    }

    .navbar-default {
        background-color: #384452;
        border-color: transparent;
    }
</style>

<body>
<div class="navbar navbar-default navbar-form" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle"data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle Navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/EnquetesSpring/index">Des enquêtes pour plus de requêtes</a>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/EnquetesSpring/creerEnqueteTel">Proposer une enquête téléphonique</a></li>
                    <li><a href="/EnquetesSpring/creerEnqueteInt">Proposer une enquête internet</a></li>
                    <li><a href="/EnquetesSpring/triEnquetesParDate">Trier par date</a></li>
                    <li><a href="/EnquetesSpring/triEnquetesParNom">Trier par nom</a></li>
                    <li><a href="/EnquetesSpring/index">Récupérer les enquêtes</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<br>
<p>Nombre d'enquêtes : ${enquetes.size()}</p>

<p>Liste des enquêtes : </p>

<br><br>
<div class="container-fluid">
    <c:forEach items="${enquetes}" var="enquete">

        <article class="col-md-3" style="border:1px solid grey;box-shadow:0 0 15px 2px gray; padding: 5px; height: 350px">
            <p> Nom : ${enquete.name}</p>
            <p> Date : ${enquete.dateEnquete}</p>
            <c:if test="${enquete['class'].simpleName == 'EnqueteTelephone'}">
                <p> Texte d'accroche : ${enquete.texteAccroche}</p>
            </c:if>
            <c:if test="${enquete['class'].simpleName == 'EnqueteInternet'}">
                <p> Liste des partenaires : ${enquete.partenaires}</p>
                <br>
                <a href="ajoutPartEnquInt?id=${enquete.idEnquete}" >
                    Ajouter un partenaire à l'enquête n°${enquete.idEnquete}
                </a>
            </c:if>
            <br><br>
        </article>
        <article class="col-md-1"></article>

    </c:forEach>
</div>


<%--<a id="loadListEnquetes" href="/EnquetesSpring/index" style="display: none"></a>
<script type="text/javascript">
    document.getElementById("loadListEnquetes").click()
</script>--%>
</body>
</html>
