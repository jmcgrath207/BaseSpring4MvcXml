<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/3/17
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/docreate">

<table>
    <tr><td>Name: </td><td><input name= "name" type="text" /></td></tr>
    <tr><td>Email: </td><td><input name= "email" type="text" /></td></tr>
    <tr><td>Offer: </td><td><textarea name="text" rows="10" cols="10"></textarea></td></tr>
    <tr><td> </td><td><input value= "Create advert" type="submit" /></td></tr>
</table>

    </form>
</body>
</html>
