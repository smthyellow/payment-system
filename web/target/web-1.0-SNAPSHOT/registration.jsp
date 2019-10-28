<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3>Registration</h3>

<form action="registration" method="post">
    <label for="firstName">First Name</label>
    <input id="firstName" type="text" name="firstName"> <br/>
    <label for="lastName">Last Name</label>
    <input id="lastName" type="text" name="lastName"> <br/>
    <label for="email">Email</label>
    <input id="email" type="text" name="email"> <br/>
    <label for="phone">Phone</label>
    <input id="phone" type="text" name="phone"> <br/>
    <label for="password">Password</label>
    <input id="password" type="password" name="password"><br/>
    <label for="confirmPassword">Confirm Password</label>
    <input id="confirmPassword" type="password" name="confirmPassword"><br/>

    <p style="color: red">${error}</p>

    <input type="submit">



</form>

