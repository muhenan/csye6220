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
  <meta charset="UTF-8">
  <title>Add Multiple Movies</title>
</head>
<body>
<h1>Add Multiple Movies</h1>
<form action="addmultiplemovies" method="post">
  <table>
    <tr>
      <td>Movie 1:</td>
      <td><input type="text" name="name1"></td>
      <td><input type="text" name="director1"></td>
    </tr>
    <tr>
      <td>Movie 2:</td>
      <td><input type="text" name="name2"></td>
      <td><input type="text" name="director2"></td>
    </tr>
    <tr>
      <td>Movie 3:</td>
      <td><input type="text" name="name3"></td>
      <td><input type="text" name="director3"></td>
    </tr>
  </table>
  <input type="submit" value="Add Movies">
</form>
</body>
</html>
