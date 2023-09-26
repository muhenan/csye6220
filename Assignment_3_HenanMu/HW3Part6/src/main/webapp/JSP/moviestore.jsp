<%--
  Created by IntelliJ IDEA.
  User: muhenan
  Date: 2/17/23
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movie Store</title>
</head>
<body>

<h1>Welcome to our Movie Store</h1>

<h2>Movie List</h2>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Director</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.name}</td>
            <td>${movie.director}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<a href="${pageContext.request.contextPath}/JSP/addmovie.jsp">Add a movie</a><br><br>
<a href="${pageContext.request.contextPath}/JSP/addmultiplemovies.jsp">Add multiple movies</a><br><br>
<a href="${pageContext.request.contextPath}/JSP/searchmovie.jsp">Search movies</a>

</body>
</html>
