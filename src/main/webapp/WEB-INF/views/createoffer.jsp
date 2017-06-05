<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 6/3/17
  Time: 12:31 PM
  To change this template use File | Settings | File Templates.
--%>

<html>
<link href="${pageContext.request.contextPath}/static/css/main.css" rel="stylesheet" type="text/css" />
<body>
    <sf:form method="post" action="${pageContext.request.contextPath}/docreate" commandName="offer" >

<table class="formtable">
    <tr><td class="label">Name: </td><td><sf:input class = "control" name= "name" type="text" path="name" /></td></tr>
    <tr><td class="label">Email: </td><td><sf:input class = "control" name= "email" type="text" path="email"/></td></tr>
    <tr><td class="label">Offer: </td><td><sf:textarea class = "control" name="text" rows="10" cols="10" path="text" /></td></tr>
    <tr><td class="label"> </td><td><input class = "control" value= "Create advert" type="submit" /></td></tr>
</table>

    </sf:form>
</body>
</html>
