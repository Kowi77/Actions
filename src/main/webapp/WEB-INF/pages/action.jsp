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
    <title>Акция ${action.name}</title>
    <style>
        .jumbotron{
            padding: 80px 120px;
        }
    </style>
</head>
<body>

<div class="container">

    <h1>Акция ${action.name}</h1>
    <br>
    <a href="">
        <span class="glyphicon glyphicon-arrow-left" cursor="pointer" aria-hidden="true"></span>  Вернуться к выбору акции
    </a>
    <br><br>
    <h3>Осталось подарков: ${action.amount}</h3>
    <br><br>
    <form action="filtered/${action.id}" method="get">
        <input type ="${action.amount < 1 ? 'hidden' : ''}" name = "part" value = ${part}>
        <input type ="${action.amount < 1 ? 'hidden' : 'submit'}" class="glyphicon glyphicon-filter" value="Фильтровать">
        <input type="${action.amount < 1 ? 'hidden' : 'button'}" onclick="return location.href =${action.id}"
               class="glyphicon glyphicon-remove" style="color: red" value="Показать все">
    </form>

    <br>
    <div class="jumbotron">
        <c:forEach items="${gifts}" var="gift">
            <form action="${gift.id}" method="post">
                <input type="hidden" name = "currentAction" value = ${action.id}>
                <button type="submit" class="btn btn-success btn-lg" style="margin-bottom: 5px">
                    <span class="glyphicon glyphicon-check" cursor="pointer"></span>  Забрать
                </button>  ${gift.name}
            </form>
        </c:forEach>
    </div>
    <br>
    <br>
    ${message}
</div>
</body>
</html>
