<%--
  Created by IntelliJ IDEA.
  User: transilvania
  Date: 16/10/2019
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <title>Personal page</title>
</head>

<body>

<p>User: ${name}</p>
<p>Email: ${email}</p>
<p>Phone: ${phone}</p>
<p>Id: ${id}</p>
<c:if test="${id == 1}">

    <p>You're first!</p>
</c:if>

<p><a href="${pageContext.request.contextPath}/datachange">Change personal data</a></p>

Here will be info about cards and accounts.

<p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>

</body>