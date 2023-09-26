<%--
  Created by IntelliJ IDEA.
  User: muhenan
  Date: 2/28/23
  Time: 21:08
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
<a href="movies?action=adda">Add a movie</a><br><br>
<a href="movies?action=addmul">Add multiple movies</a><br><br>
<a href="movies?action=searchmovie">Search movies</a>

</body>
</html>