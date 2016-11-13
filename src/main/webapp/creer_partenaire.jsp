<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Créer un partenaire</title>
</head>
<body>

<div class="container">
    <jsp:include page="header.jsp"/>

    <h1 class="page-header">Ajouter un partenaire</h1>

    <form:form method="POST" modelAttribute="partenaire" action="creerPartenaire">
        <form>
            <div class="form-group col-md-6">
                <label>Nom du partenaire : </label>
                <br>
                <form:input class="form-control" path="namePartenaire" type="text" placeholder="Nom du partenaire" required="true"/>
                <br>
            </div>
            <div class="form-group col-md-6">
                <label>Site web du partenaire : </label>
                <br>
                <form:input class="form-control" path="siteWebPartenaire" type="text" placeholder="Nom du partenaire" required="true"/>
                <br>
            </div>
            <div class="col-md-12">
                <input type="submit" value="Valider" class="btn btn-danger">
                <br>
                <br>
            </div>
        </form>
    </form:form>


    <p>Liste des partenaires actuels et leur site : </p>

        <c:forEach items="${partenaires}" var="partenaire">
            <div class="col-md-4" style="padding: 15px">
                <div class="color-rect-border" style="border:1px solid gray; padding: 10px">
                        <c:out value="Nom : ${partenaire.namePartenaire}"/> <br>
                        <c:out value="Site : ${partenaire.siteWebPartenaire}"/>
                </div>
            </div>
        </c:forEach>

</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
