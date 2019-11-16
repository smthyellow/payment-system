<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: transilvania
  Date: 07/11/2019
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3>Accounts</h3>
<c:choose>
    <c:when test="${accounts == null}">
        <h4>You have no accounts.</h4>
    </c:when>
    <c:when test="${accounts != null}">
        <table>
            <c:forEach items="${accounts}" var="account">
                <tr>
                    <td>${account.accountNumber}</td>
                </tr>
            </c:forEach>
        </table>
        <c:forEach begin="1" end="${pageCount}" var="pageNumber">
            <a href="${pageContext.request.contextPath}/accountManagement?pageNumber=${pageNumber}">${pageNumber}</a>
        </c:forEach>
    </c:when>
</c:choose>

<p><a href="${pageContext.request.contextPath}/personalpage">To personal page</a></p>
<form action="accountManagement" method="post">
    <p>${message}</p>
    <button type = submit>Add new account</button>
</form>


