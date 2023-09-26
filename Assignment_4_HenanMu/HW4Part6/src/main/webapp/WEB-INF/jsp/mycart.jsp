<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: muhenan
  Date: 2/28/23
  Time: 22:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your Shopping Cart</title>
</head>
<body>
<h1>Your Shopping Cart</h1>
<c:if test="${empty cart}">
    <p>Now your Shopping Cart is empty</p>
</c:if>
<c:if test="${not empty cart}">
    <p>Now that's your Shopping Cart</p>
    <table border='1'>
        <c:forEach items="${cart}" var="item" varStatus="status">
            <tr>
                <td>${item}</td>
                <td>
                    <a href='remove?removeIndex=${status.index}'>remove</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<a href="shoppingcart">Go to Shopping Mall</a>
</body>
</html>
