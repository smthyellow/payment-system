<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: transilvania
  Date: 07/11/2019
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3>Cards</h3>
<c:choose>
    <c:when test="${cards == null}">
        <h4>You have no cards.</h4>
    </c:when>
    <c:when test="${cards != null}">
        <table>
            <tr>
                <th>Number</th>
                <th>Account</th>
            </tr>
            <c:forEach items="${cards}" var="card">
                <tr>
                    <td>${card.cardNumber}</td>
                    <td>${card.accountId}</td>
                </tr>
            </c:forEach>
        </table>
    </c:when>
</c:choose>
<h3>Add card</h3>
<p>${message}</p>
<form action="${pageContext.request.contextPath}/cardManagement" method="post">
    <label for="accountId">Account Id</label>
    <input id="accountId" type="text" name="accountId"><br/>
    <input type="submit">
</form>

