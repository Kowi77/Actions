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
<a href="/">Вернуться к выбору акции</a>
<br><br>
<strong>Осталось подарков ${action.amount}</strong>
<br><br>
<form action="filtered/${action.id}" method="get">
    <input type ="${gifts.isEmpty() ? 'hidden' : ''}" name = "part" value = ${part}>
    <input type ="${gifts.isEmpty() ? 'hidden' : 'submit'}" value="Фильтровать">
    <input type="${gifts.isEmpty() ? 'hidden' : 'button'}" onclick="return location.href =${action.id}" value="Показать все">
</form>

<br>
<c:forEach items="${gifts}" var="gift">
    <form action="${gift.id}" method="post">${gift.name}
        <input type="hidden" name = "currentAction" value = ${action.id}>
        <button type="submit">Забрать</button>
    </form>
</c:forEach>
<br>
<br>${message}</br>

</body>
</html>
