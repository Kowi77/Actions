
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Акция "Времена года"</title>
</head>
<body>
    <h1>Список доступных акций</h1>
    <br>
    <br>
    <c:forEach items="${actions}" var="action">
        <%--<jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.MealWithExceed"/>
        <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
            <td>
                    &lt;%&ndash;${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}&ndash;%&gt;
                    &lt;%&ndash;<%=TimeUtil.toString(meal.getDateTime())%>&ndash;%&gt;
                    &lt;%&ndash;${fn:replace(meal.dateTime, 'T', ' ')}&ndash;%&gt;
                    ${fn:formatDateTime(meal.dateTime)}
            </td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>--%>
            <a href="${action.id}">${action.name}</a><br>
           <%-- <td><a href="meals/delete?id=${meal.id}"><spring:message code="common.delete"/></a></td>
        </tr>--%>
    </c:forEach>

</body>
</html>
