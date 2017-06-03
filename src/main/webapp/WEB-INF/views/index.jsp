<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 5/23/17
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>



<html>
<head>
    <title>Title</title>
</head>
<body>
<%--
 JSTL example of SQL

 <sql:query var="rs" dataSource="jdbc/spring">
   select id, name, email from offers
</sql:query>

<c:forEach var="row" items="${rs.rows}">
   id ${row.id}<br/>
   name ${row.name}<br/>
   email ${row.email}<br/>

</c:forEach>






--%>

<c:forEach var="row" items="${offers}">
    id ${row.id}<br/>
    name ${row.name}<br/>
    email ${row.email}<br/>
</c:forEach>

</body>
</html>
