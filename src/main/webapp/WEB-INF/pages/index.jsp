
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Акция "Времена года"</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <style>
        body { font-size: 30px; }
    </style>
</head>
<body>
<div class="jumbotron">
    <h1>Список доступных акций:</h1>
    <br>
    <c:forEach items="${actions}" var="action">
        <a href="${action.id}">
                  ${action.name}  <span class="glyphicon glyphicon-arrow-right" cursor="pointer" aria-hidden="true" style="color: green"></span>
        </a>
        <br><br>
    </c:forEach>
</div>
</body>
</html>
