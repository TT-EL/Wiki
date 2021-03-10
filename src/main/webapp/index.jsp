<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="css/layui.css"  media="all">
    <style>
        .all{
            width:15%;
            margin:0 auto;
            margin-top:100px;
            text-align:center;}
    </style>
    <title>添加页面</title>

</head>
<body>

<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item"><a>首页</a></li>
    <li class="layui-nav-item "><a>我的</a></li>
    <li class="layui-nav-item layui-this"><a href="#">添加课程</a></li>
    <li class="layui-nav-item"><a href="">联系我们</a></li>
</ul>

<br><br><br><br>
<div class="all">

    <h3>添加课程</h3>
    <br />
    <form action="/Manager/addCourseInfo" method="post" >
        <div class="layui-form-item">
            <label class="layui-form-label">课程名：</label>
            <div class="layui-input-block">
                <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入学院名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">教师名称：</label>
            <div class="layui-input-block">
                <input type="password" name="password" placeholder="请输入该课程老师名" autocomplete="off" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">班级名称：</label>
            <div class="layui-input-block">
                <input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入课程名" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">选择框</label>
            <div class="layui-input-block">
                <select name="city" lay-verify="required">
                    <option value=""></option>
                    <option value="0">北京</option>
                    <option value="1">上海</option>
                    <option value="2">广州</option>
                    <option value="3">深圳</option>
                    <option value="4">杭州</option>
                </select>
            </div>
        </div>
        <button type="button" class="layui-btn layui-btn-lg layui-btn-normal">保存</button>
    </form>

</div>
</body>
</html>
