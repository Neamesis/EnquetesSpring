<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
