
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    a {
        font-size: 30px;
    }
</style>
<head>
    <title>Акция "Времена года"</title>
</head>
<body>
    <h1>Список доступных акций:</h1>
    <br>
    <br>
    <c:forEach items="${actions}" var="action">
        <a href="${action.id}">${action.name}</a>
        <br><br>
    </c:forEach>
</body>
</html>
