<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Nea
  Date: 06/11/2016
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>L'enquête a été créée</p>
<p>Partenaires : </p>
<c:forEach var="partenaire" items="${enqueteInternet.partenaires}">
    ${partenaire}<br>
</c:forEach>
</body>
</html>
