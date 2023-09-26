<%--
  Created by IntelliJ IDEA.
  User: muhenan
  Date: 2/18/23
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>

<h1>Let's add ${numberOfBooks} books</h1>

<form method="post" action="AddBooksServlet">
    <table border="1">
        <thead>
        <tr>
            <th>ISBN</th>
            <th>Title</th>
            <th>Authors</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach begin="1" end="${numberOfBooks}" var="i">
            <tr>
                <td><input type="text" name="isbn${i}" /></td>
                <td><input type="text" name="title${i}" /></td>
                <td><input type="text" name="authors${i}" /></td>
                <td><input type="number" step="any" name="price${i}" /></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="hidden" name="numberOfBooks" value="${numberOfBooks}">
    <input type="submit" value="Add Books" />
</form>


</body>
</html>
