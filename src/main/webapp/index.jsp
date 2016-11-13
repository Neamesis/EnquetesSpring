<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <p>Nombre d'enquêtes : ${enquetes.size()}</p>

    <br>
    <div class="container-fluid">
        <c:forEach items="${enquetes}" var="enquete" varStatus="counter">
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
        </c:forEach>
    </div>

</div> <!-- Fin container -->

<jsp:include page="footer.jsp"/>



</body>



</html>
