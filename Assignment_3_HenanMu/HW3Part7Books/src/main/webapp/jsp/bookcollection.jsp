<%--
  Created by IntelliJ IDEA.
  User: muhenan
  Date: 2/18/23
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>book collection</title>
</head>
<body>
<h1>Book Collection</h1>

<table border='1'>
    <thead>
    <tr>
        <th>ISBN</th>
        <th>Title</th>
        <th>Authors</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td>${book.isbn}</td>
            <td>${book.title}</td>
            <td>${book.authors}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>

<a href="${pageContext.request.contextPath}/jsp/howmanybooks.jsp">Add books</a>

</body>
</html>
