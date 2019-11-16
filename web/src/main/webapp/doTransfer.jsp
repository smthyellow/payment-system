<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: transilvania
  Date: 08/11/2019
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Money transfer</title>
</head>

<form action="doTransfer" method="post">
    </select></p>
    <label for="fromCard">Transfer from card</label>
    <input id="fromCard" type="text" name="fromCard"> <br/>
    <label for="fromAccount">or from account</label>
    <input id="fromAccount" type="text" name="fromAccount"> <br/>

<h3>Choose recipient</h3>

    <label for="toCard">Transfer to card</label>
    <input id="toCard" type="text" name="toCard"> <br/>
    <label for="toAccount">or to account</label>
    <input id="toAccount" type="text" name="toAccount"> <br/>

    <h3>Enter sum</h3>

    <label for="sum">or to account</label>
    <input id="sum" type="text" name="sum"> <br/>
    <p><input type="submit" value="Select"></p>
</form>


