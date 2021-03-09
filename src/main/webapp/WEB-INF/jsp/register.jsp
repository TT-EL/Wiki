<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 2021/3/4
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>员工注册</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/User/register" method="POST">
    <table border="2" align="center">
        <tr>
            <th>编号</th>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <th>姓名</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="注册"/>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
