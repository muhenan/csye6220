<%--
  Created by IntelliJ IDEA.
  User: muhenan
  Date: 2/28/23
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Movie</title>
</head>

<body>
<h1>Add Movie</h1>
<form action="addmovie" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name"><br><br>
    <label for="director">Director:</label>
    <input type="text" id="director" name="director"><br><br>
    <input type="submit" value="Add Movie">
</form>
</body>
</html>
