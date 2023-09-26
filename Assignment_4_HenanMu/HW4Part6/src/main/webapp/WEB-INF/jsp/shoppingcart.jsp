<%--
  Created by IntelliJ IDEA.
  User: muhenan
  Date: 2/28/23
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="UTF-8">
    <title>MVC Shopping Cart</title>
</head>
<body>
<h1>Shopping Mall</h1>

<form action='add' method='post'>
    <input type='checkbox' name='item' value='\"Head First Java\" by Kathy Sierra and Bert Bates - $30.99'>\"Head First Java\" by Kathy Sierra and Bert Bates - $30.99<br/>
    <input type='checkbox' name='item' value='\"Java: A Beginner\"s Guide\" by Herbert Schildt - $44.99'>\"Java: A Beginner's Guide\" by Herbert Schildt - $44.99<br/>
    <input type='checkbox' name='item' value='\"Effective Java\" by Joshua Bloch - $47.99'>\"Effective Java\" by Joshua Bloch - $47.99<br/>
    <input type='checkbox' name='item' value='\"Java in a Nutshell\" by David Flanagan - $34.99'>\"Java in a Nutshell\" by David Flanagan - $34.99<br/>
    <input type='checkbox' name='item' value='\"Java Performance\" by Charlie Hunt - $49.99'>\"Java Performance\" by Charlie Hunt - $49.99<br/>
    <input type='checkbox' name='item' value='\"Java for Dummies\" by Barry Burd - $24.99'>\"Java for Dummies\" by Barry Burd - $24.99<br/>
    <input type='checkbox' name='item' value='\"Java Web Services: Up and Running\" by Martin Kalin - $39.99'>\"Java Web Services: Up and Running\" by Martin Kalin - $39.99<br/>
    <br/>
    <input type='submit' value='Add to Cart'>
    <input type='hidden' name='action' value='shopping-cart'>
</form>
<a href="mycart"> View My Cart</a>
</body>
</html>