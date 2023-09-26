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
    <title>Title</title>
</head>
<body>


<h1>Search Movie by Keyword in Name</h1>
<form action="searchmovie" method="get">
    <label for="keyword">Keyword:</label>
    <input type="text" name="keyword" id="keyword" required>
    <input type="submit" value="Search">
</form>

</body>
</html>