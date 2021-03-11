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
<%--    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" type="text/css" />--%>
<%--    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" />--%>

    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
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
            <!--下拉列表-->
            <div class="form-group">
                <select class="form-control" id="slt-radioList"></select>
            </div>

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
    <div>
        <select  id="sltradioList" style="width: 100px"></select>
    </div>
</form>

<div>
    <button id="send">获取</button>
</div>

<script>

        $('send').click(function(){
            $.ajax({
                type: "GET",
                url: '${pageContext.request.contextPath}/User/getClassList',//处理逻辑的后台路径
                //传递的参数,用，隔开；action方法名的参数要与“：”前的名字一致
                dataType:"json",
                success: function(data) {
                    if (data.code === 0) {
                        var html = '<option selected="selected" value="0">--请选择--</option>';
                        $('#sltradioList').empty();//加载列表前先清掉子项，防止重复累计叠加
                        for (var i = 0; i < data.rt.length; i++) {
                            html += '<option value = "' + data.rt[i].classId + '">' + data.rt[i].className + '</option>';
                        }
                        $('#sltradioList').append(html);
                    } else {
                        alert("单选列表获取失败");
                    }
                }
            });
        });



</script>
</body>
</html>
