<!DOCTYPE html>
<base href="${pageContext.request.contextPath}/"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javascript" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
    <script type="text/javascript" src="webjars/bootstrap/3.3.7-1/js/bootstrap.min.js" defer></script>
    <title>Акция "${action.name}"</title>
    <style>
        body { font-size: 20px; }
    </style>
</head>
<body>

<div class="container">
    <h1>Акция ${action.name}</h1>
        <br>
        <a href="">
            <span class="glyphicon glyphicon-arrow-left" cursor="pointer" aria-hidden="true"></span>  Вернуться к выбору акции
        </a>
        <br>
        <h3>Осталось подарков: ${action.amount}</h3>
        <br>
    <div class="jumbotron" style="${action.amount < 1 ? 'display:none' : ''}">
        <form action="filtered/${action.id}" method="get">
            <input name = "part" value = ${part}>
            <button type ="submit" class="btn btn-primary btn-lg">
                <span class="glyphicon glyphicon-filter" cursor="pointer"></span> Фильтровать
            </button>
            <button type="reset" onclick="return location.href =${action.id}" class="btn btn-primary btn-lg">
                <span class="glyphicon glyphicon-remove" style="color: red" cursor="pointer"></span> Показать все
            </button>
        </form>
        <br>

        <c:forEach items="${gifts}" var="gift">
            <form action="${gift.id}" method="post">
                <input type="hidden" name = "currentAction" value = ${action.id}>
                <button type="submit" class="btn btn-success btn-lg" style="margin-bottom: 5px">
                    <span class="glyphicon glyphicon-check" cursor="pointer"></span>  Забрать
                </button>  ${gift.name}
            </form>
        </c:forEach>
    </div>
    <div type="${message.isEmpty() ? 'hidden' : ''}" class="${message.startsWith("К") ? "alert alert-warning" : "alert alert-success"}">
        <strong>${message}</strong>
    </div>
</div>
</body>
</html>
