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
    <title>绑定微信信息</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>
<form action="${pageContext.request.contextPath}/User/register" method="POST">

    <input type="text" name="wxImage" value="${wx_image}" style="display:none" readonly="readonly">
    <input type="text" name="wxId" value="${wx_id}" style="display:none" readonly="readonly"/>

    <table border="2" align="center">
        <tr>
            <th>微信头像</th>
            <td>
                <img src="${wx_image}"/>
            </td>
        </tr>
        <tr>
            <th>学号</th>
            <td><input type="text" name="userId"></td>
        </tr>
        <tr>
            <th>昵称</th>
            <td><input type="text" name="name"></td>
        </tr>


        <tr>
            <th>微信昵称</th>
            <td><input type="text" name="wxUsername" value="${wx_name}" readonly="readonly"/></td>
        </tr>
        <tr>
            <th>选择身份</th>
            <td>
                <input type="checkbox" checked="checked" name="power" value="0"/>
                <input type="checkbox" name="power" value="1"/>
            </td>
        </tr>
        <tr>
            <th>班级名称（学生）</th>
            <td><input type="text" name="classId" id="class_name"/></td>
        </tr>
        <tr>
            <th>入学年份（学生）</th>
            <td><input type="text" name="enrolTime" id="enrol_time"/></td>
        </tr>
        <tr>
            <th>院系名称（老师）</th>
            <td><input type="text" name="class_name" id="department_name"/></td>
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
