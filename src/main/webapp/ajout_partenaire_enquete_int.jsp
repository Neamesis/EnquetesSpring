<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nea
  Date: 06/11/2016
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Ajouter un partenaire à une enquête</h1>

<form:form method="POST" modelAttribute="partenaire" action="ajoutPartEnquInt">
    <input type="hidden" value="${enqueteInternet.idEnquete}" name="ID_ENQUETE"/>
    <p>id enquête : ${enqueteInternet.idEnquete}</p>
    <label>
        <p>Choisissez un partenaire à ajouter à votre enquête :</p>
        <p>(Attention, vous ne pouvez choisir qu'un partenaire à la fois)</p>
    </label>
    <br>
    <c:forEach items="${partenaires}" var="partenaire" varStatus="status">
        <c:if test="${partenaire.enqueteInternet == null}">
            <tr>
                <td>
                    <input type="radio" name="ID_PARTENAIRE" value="${partenaire.idPartenaire}" required="required"/>
                </td>
                <td>${partenaire.namePartenaire} (${partenaire.siteWebPartenaire})</td>
                <br>
            </tr>
        </c:if>
    </c:forEach>
    <br>
    <p>Votre partenaire ne se trouve pas dans la liste ?
        <a href="/EnquetesSpring/creerPartenaire"> Ajouter un partenaire</a>
    </p>
    <br>
    <input type="submit" value="Valider" class="button"/>
</form:form>


</body>
</html>
