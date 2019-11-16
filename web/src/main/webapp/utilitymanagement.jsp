<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: transilvania
  Date: 09/11/2019
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<h3>My utilities</h3>




<h3>Add utility</h3>
<form action="utulitymanagement" method="post">
    <label for="billId">Choose utility</label>
    <input id="billId" type="text" name="billId">
    <input type="submit">
</form>

<p>${message}</p>

</body>

