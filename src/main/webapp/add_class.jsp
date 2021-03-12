<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <style>
        .all{
            width:20%;
            margin:0 auto;
            margin-top:100px;
            text-align:center;}
    </style>
    <title>添加班级</title>

</head>
<body>

<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
    <li class="layui-nav-item "><a href="add_course.jsp">添加课程</a></li>
    <li class="layui-nav-item layui-this" ><a href="#">添加班级</a></li>
    <li class="layui-nav-item"><a href="add_cotocl.jsp">添加排课</a></li>
</ul>

<br><br><br><br>
<form class="layui-form" >
<div class="all">

    <h3>添加班级</h3>
    <br />
    <div class="layui-form-item">
        <label class="layui-form-label">班级代号：</label>
        <div class="layui-input-block">
            <input type="text" name="classId" id="class_id" lay-verify="title" required  lay-verify="required" maxlength="15" autocomplete="off" placeholder="请输入班级代号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">班级名称：</label>
        <div class="layui-input-block">
            <input type="text" name="className" id="class_name" placeholder="请输入班级名" required  lay-verify="required" maxlength="15" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">院系代码：</label>
        <div class="layui-input-block">
            <input type="text" name="departmentId" id="department_id" lay-verify="title" required  lay-verify="required" maxlength="15" autocomplete="off" placeholder="请输入该班院系代码" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">院系名称：</label>
        <div class="layui-input-block">
            <input type="text" name="departmentName" id="department_name" placeholder="请输入该班院系名称" required  lay-verify="required" maxlength="15" autocomplete="off" class="layui-input">
        </div>
    </div>
    <input type="button" class="layui-btn layui-btn-lg layui-btn-normal" lay-submit lay-filter="formDemo"  value="保存">
</div>
</form>

<script src="layui/layui.js" charset="utf-8"></script>
<script >
    //Demo
    layui.use('form', function(){
        var form = layui.form;

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.msg(JSON.stringify(data.field));
            layui.layer.load();
            postinfo(data);
            return false;
        });
    });

    function postinfo(data){
        $.ajax({
            url:'${pageContext.request.contextPath}/Manager/addClassInfo',
            type:'post',
            data:data.field,
            dataType:"json",
            success:function(data){

                layui.layer.closeAll();
                if(data.error_code===1){
                    layer.alert("提交成功！")
                }
                else{
                    layer.alert("提交失败！"+data.error_code)
                }
            },
            error:function(e){
                layui.layer.closeAll();
                layer.alert("提交失败！")
            },

        });
    }
</script>
</body>
</html>