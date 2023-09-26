<%--
  Created by IntelliJ IDEA.
  User: muhenan
  Date: 2/18/23
  Time: 09:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>search result</title>
</head>
<body>
<h1>Search Result</h1>

<c:if test="${empty movies}">
    <p>No movies found with the keyword ${keyword}</p>
</c:if>
<c:if test="${not empty movies}">
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Director</th>
        </tr>
        <c:forEach var="movie" items="${movies}">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.name}</td>
                <td>${movie.director}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<br>
<a href="MovieServlet">Go back to movie list page</a>

</body>
</html>
