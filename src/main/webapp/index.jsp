<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
    <title>Enquêtes</title>
    <link href="<c:url value="../${pageContext.request.contextPath}/resources/css/bootstrap.css"/>" rel="stylesheet">
    <meta charset="UTF-8">
</head>

<body>
<div class="container">
    <jsp:include page="header.jsp"/>
    <br>
    <p class="text-muted">Nombre d'enquêtes : ${enquetes.size()}</p>

    <br>
    <div class="container-fluid">
        <c:forEach items="${enquetes}" var="enquete" varStatus="counter">
            <article class="col-xs-6 col-lg-4" style="padding: 15px; height: 350px; ">
                <div class="color-rect-border" style="border:1px solid grey;box-shadow:0 0 15px 2px gray; padding: 10px; height: 320px; overflow-y: scroll ">
                    <h4 class="text-muted"> Nom : ${enquete.name}</h4>
                    <p> Date : ${enquete.dateEnquete}</p>
                    <c:if test="${enquete['class'].simpleName == 'EnqueteTelephone'}">
                        <p> Texte d'accroche : ${enquete.texteAccroche}</p>
                    </c:if>
                    <c:if test="${enquete['class'].simpleName == 'EnqueteInternet'}">
                        <p> Liste des partenaires : </p>
                        <ul>
                            <c:forEach items="${enquete.partenaires}" var="partenaire">
                                <li><c:out value="${partenaire.namePartenaire}"></c:out>
                                    (<c:out value="${partenaire.siteWebPartenaire}"></c:out>)
                                </li>
                                <br>
                            </c:forEach>
                        </ul>
                        <br>
                        <a href="ajoutPartEnquInt?id=${enquete.idEnquete}" >
                            Ajouter un partenaire à l'enquête n°${enquete.idEnquete}
                        </a>
                    </c:if>
                    <br><br>
                </div>
            </article>
        </c:forEach>
    </div>
</div> <!-- Fin container -->

<jsp:include page="footer.jsp"/>
</body>
</html>
