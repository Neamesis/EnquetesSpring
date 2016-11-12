<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Enquêtes</title>
    <link href="<c:url value="../${pageContext.request.contextPath}/resources/css/bootstrap.css"/>" rel="stylesheet">
    <link href="<c:url value="../${pageContext.request.contextPath}/resources/css/justified-nav.css"/>" rel="stylesheet">
    <meta charset="UTF-8">
</head>

<style>
    .nav-link.active, .nav-link.active:hover, .nav-link.active:focus {
        height: 80px;
</style>

<body>
<div class="container">
    <div class="masthead">
        <h3 class="text-muted">Des enquêtes en folie</h3>
        <nav>
            <ul class="nav nav-justified" style="max-height: 80px">
                <li class="nav-item">
                    <a class="nav-link active" href="/EnquetesSpring/creerEnqueteTel">Proposer une enquête téléphonique</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/EnquetesSpring/creerEnqueteInt">Proposer une enquête internet</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/EnquetesSpring/triEnquetesParDate">Trier par date</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/EnquetesSpring/triEnquetesParNom">Trier par nom</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="/EnquetesSpring/index">Récupérer les enquêtes</a>
                </li>
            </ul>
        </nav>
    </div>
    <%--    <div class="navbar navbar-default navbar-form" role="navigation">
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

                        </ul>
                    </div>
                </div>
            </div>
        </div>--%>
    <br>
    <p>Nombre d'enquêtes : ${enquetes.size()}</p>

    <br>
    <div class="container-fluid">
        <%--<c:set var="count" value="0" scope="page" />--%>
        <c:forEach items="${enquetes}" var="enquete" varStatus="counter">
            <%--<c:set var="count" value="${count + 1}" scope="page"/>--%>

            <article class="col-xs-6 col-lg-4" style="padding: 15px; height: 350px">
            <div class="color-rect-border" style="border:1px solid grey;box-shadow:0 0 15px 2px gray; padding: 10px; height: 320px">
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
                <c:out value="${counter.count}">Couter : ${counter.count}</c:out>

            </div>
            </article>
            <%-- <c:if test="${counter.count%3 != 0}">
                 <article class="col-md-1"></article>
             </c:if>--%>


        </c:forEach>
    </div>


    <%--<a id="loadListEnquetes" href="/EnquetesSpring/index" style="display: none"></a>
    <script type="text/javascript">
        document.getElementById("loadListEnquetes").click()
    </script>--%>
</div>
</body>
</html>
