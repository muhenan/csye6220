<%--
  Created by IntelliJ IDEA.
  User: muhenan
  Date: 2/18/23
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>How many books</title>
</head>
<body>
<h1>How many books you want to add?</h1>

<form action="../HowManyServlet" method="post">
    <label for="number-of-books">Select the Number of Books:</label>
    <select name="numberOfBooks" id="number-of-books">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
    </select>

    <br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
