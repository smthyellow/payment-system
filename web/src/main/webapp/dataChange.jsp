<%--
  Created by IntelliJ IDEA.
  User: transilvania
  Date: 17/10/2019
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form action="datachange" method="post">
    <label for="firstName">First Name</label>
    <input id="firstName" type="text" name="firstName"> <br/>
    <label for="lastName">Last Name</label>
    <input id="lastName" type="text" name="lastName"> <br/>
    <label for="email">Email</label>
    <input id="email" type="text" name="email"> <br/>
    <label for="phone">Phone</label>
    <input id="phone" type="text" name="phone"> <br/>
    <label for="password">Current password</label>
    <input id="currentpassword" type="password" name="password"><br/>
    <label for="password">New password</label>
    <input id="password" type="password" name="password"><br/>
    <label for="confirmpassword">Confirm new password</label>
    <input id="confirmPassword" type="password" name="confirmPassword"><br/>

    <input type="submit">

</form>
