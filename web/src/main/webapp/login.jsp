<%--
  Created by IntelliJ IDEA.
  User: transilvania
  Date: 16/10/2019
  Time: 22:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3>Login</h3>
<form action="login" method="post">

    <label for="email">Email</label>
    <input id="email" type="text" name="email"> <br/>
    <label for="password">Password</label>
    <input id="password" type="password" name="password"><br/>
    <p style="color: red">${error}</p>

    <input type="submit">