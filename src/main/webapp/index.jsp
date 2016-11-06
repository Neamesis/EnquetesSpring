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

<p>Nombre d'enquêtes : ${enquetes.size()}</p>

<p>Liste des enquêtes : </p>

<a href="/EnquetesSpring/index">Récupérer les enquêtes</a>
<br><br>
<c:forEach items="${enquetes}" var="enquete">
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
</c:forEach>


<%--<a id="loadListEnquetes" href="/EnquetesSpring/index" style="display: none"></a>
<script type="text/javascript">
    document.getElementById("loadListEnquetes").click()
</script>--%>
</body>
</html>
