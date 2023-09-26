<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<!DOCTYPE html>
<html>
<head>
    <title>HW 3 Part 3</title>
</head>
<body>
<h1><%= "HW 3 Part 3" %>
</h1>
<%--<a href="hello-servlet">Hello Servlet</a>--%>

<p>Create a JSP page that uses at least 3 JSTL tags from each tag library group, i.e.,3 tags from Core Tag Lib, 3 tags from Formatting Tag
    Lib, etc. You could use random content on the JSP page. </p>


<h2>Core Tag Library Examples</h2>
<!-- Core Tag Library Examples -->
<c:set var="name" value="Henan Mu" />
<p>Hello, this is  <c:out value="${name}" />!</p>

<c:if test="${1 == 1}">
    <p>1 is equal to 1.</p>
</c:if>

<c:forEach var="i" begin="1" end="5">
    <p>Iteration <c:out value="${i}" /></p>
</c:forEach>

<h2>Formatting Tag Library Examples</h2>
<!-- Formatting Tag Library Examples -->
<fmt:formatNumber value="1234567.89" pattern="#,##0.00" />
<br />

<fmt:parseDate var="date" value="2022-02-17" pattern="yyyy-MM-dd" />
<fmt:formatDate value="${date}" pattern="MM/dd/yyyy" />
<br />

<fmt:parseNumber var="num" type="number" value="100.00" />
<p>The value of num is <c:out value="${num}" />.</p>

<h2>Function Tag Library Examples</h2>
<!-- Function Tag Library Examples -->
<p>The length of the string "Hello, world!" is <c:out value="${fn:length('Hello, world!')}" />.</p>

<p>The substring of "Hello, world!" from index 2 to 5 is <c:out value="${fn:substring('Hello, world!', 2, 5)}" />.</p>

<c:set var="now" value="<%= new java.util.Date() %>" />
<p>The current date and time is <fmt:formatDate value="${now}" type="both" /></p>

<h2>SQL Tag Library Examples</h2>
<!-- SQL Tag Library Examples -->
<sql:setDataSource
        var="myDB"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://newton.neu.edu:3306/usersdb"
        user="student"
        password="p@ssw0rd" />

<sql:query dataSource="${myDB}" var="result">
    SELECT * FROM users;
</sql:query>

<table border="1">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Email</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.userId}" /></td>
            <td><c:out value="${row.fname}" /></td>
            <td><c:out value="${row.email}" /></td>
        </tr>
    </c:forEach>
</table>

<h2>XML Tag Library Examples</h2>
<!-- XML Tag Library Examples -->
<!-- x:parse tag: parses an XML document and stores it in a variable -->
<c:set var="books">
    <books>
        <book>
            <title>The Great Gatsby</title>
            <author>F. Scott Fitzgerald</author>
        </book>
        <book>
            <title>To Kill a Mockingbird</title>
            <author>Harper Lee</author>
        </book>
        <book>
            <title>Nineteen Eighty-Four</title>
            <author>George Orwell</author>
        </book>
    </books>
</c:set>

<x:parse xml="${books}" var="output"/>

<!-- x:out tag: outputs a string value and escapes any special characters -->
<p>First book title: <x:out select="$output/books/book[1]/title" /></p>

<!-- x:if tag: tests a condition and processes its body if the condition is true -->
<x:if select="$output/books/book[3]">
    <p>Third book author: <x:out select="$output/books/book[3]/author" /></p>
</x:if>

</body>
</html>