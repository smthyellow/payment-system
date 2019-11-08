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
<p>Phone: ${phone}</p>
<p>Id: ${id}</p>

<p><a href="${pageContext.request.contextPath}/cardManagement">My cards</a></p>
<p><a href="${pageContext.request.contextPath}/accountManagement">My accounts</a></p>
<p><a href="${pageContext.request.contextPath}/cardManagement">Services</a></p>
<p><a href="${pageContext.request.contextPath}/datachange">Change personal data</a></p>

<p><a href="${pageContext.request.contextPath}/logout">Logout</a></p>

</body>