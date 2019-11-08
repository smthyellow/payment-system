<%--
  Created by IntelliJ IDEA.
  User: transilvania
  Date: 07/11/2019
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3>Add account</h3>
<p>${message}</p>
<form action="${pageContext.request.contextPath}/accountManagement" method="post">
    <label for="accountId">Account Id</label>
    <input id="accountId" type="text" name="accountId"><br/>

    <input type="submit" name = "Create acccount">
</form>
