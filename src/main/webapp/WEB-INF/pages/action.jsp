
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Акция ${action.name}</title>
</head>
<body>
<h1>Акция ${action.name}</h1>
<br>
<a href="/">Вернуться к выбору акции</a>
<br>
<br>
<strong>Осталось подарков ${action.amount}</strong>
<br>
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