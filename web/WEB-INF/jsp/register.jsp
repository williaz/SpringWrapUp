<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: williaz
  Date: 12/19/16
  Time: 4:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New User</title>
</head>
<body>
<form:form id = "registerForm" method = "POST" action = "/users/register" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" /></td>
        </tr>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input path="name" /></td>
        </tr>
        <tr>
            <td><form:label path="phoneNumber">Phone Number</form:label></td>
            <td><form:input path="phoneNumber" /></td>
        </tr>
        <tr>
            <!--same as <input id="password" name="password" type="password" value=""/>-->
            <td><form:label path="password">Password</form:label></td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td><input type = "submit" value="submit"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
