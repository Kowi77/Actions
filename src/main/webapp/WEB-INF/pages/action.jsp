<!DOCTYPE html>
<base href="${pageContext.request.contextPath}/"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="javascript" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Акция ${action.name}</title>
</head>
<body>
<h1>Акция ${action.name}</h1>
<br>
<a href="">Вернуться к выбору акции</a>
<br><br>
<h3>Осталось подарков: ${action.amount}</h3>
<br><br>
<form action="filtered/${action.id}" method="get">
    <input type ="${action.amount < 1 ? 'hidden' : ''}" name = "part" value = ${part}>
    <input type ="${action.amount < 1 ? 'hidden' : 'submit'}" value="Фильтровать">
    <input type="${action.amount < 1 ? 'hidden' : 'button'}" onclick="return location.href =${action.id}" value="Показать все">
</form>

<br>
<c:forEach items="${gifts}" var="gift">
    <form action="${gift.id}" method="post">
        <input type="hidden" name = "currentAction" value = ${action.id}>
        <button type="submit">Забрать</button>  ${gift.name}
    </form>

</c:forEach>
<br>
<br>
${message}
</body>
</html>
