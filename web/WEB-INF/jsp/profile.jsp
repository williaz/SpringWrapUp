<%--
  Created by IntelliJ IDEA.
  User: williaz
  Date: 12/19/16
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>
<table>
    <tr>
        <td>Id</td> <td>Name</td> <td>Mobile</td>
    </tr>
    <tr>
        <td>${user.id}</td> <td>${user.name}</td> <td>${user.phoneNumber}</td>
    </tr>
</table>
<a href="/users/home">back home</a>
</body>
</html>
