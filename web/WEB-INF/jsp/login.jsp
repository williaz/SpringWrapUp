<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: williaz
  Date: 12/19/16
  Time: 4:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<!-- Each of these fields specifies a path attribute – this must correspond to a getter / setter of the model attribute-->
<form:form id = "loginForm" method = "POST" action = "/users/login" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="id">Id</form:label></td>
            <td><form:input path="id" /></td>
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
<a href="register"> Register now! </a>
</body>
</html>
