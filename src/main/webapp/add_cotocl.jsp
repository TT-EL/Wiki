<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <style>
        .all{
            width:20%;
            margin:0 auto;
            margin-top:100px;
            text-align:center;}
    </style>
    <title>添加页面</title>

</head>
<body>

<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
    <li class="layui-nav-item "><a href="add_course.jsp">添加课程</a></li>
    <li class="layui-nav-item"><a href="add_class.jsp">添加班级</a></li>
    <li class="layui-nav-item layui-this" ><a href="#">添加排课</a></li>
</ul>

<br><br><br><br>
<form class="layui-form">
<div class="all">

    <input type="text" name="classId"  id="classId"    class="layui-hide" readonly="readonly">
    <input type="text" name="courseId" id="courseId"   class="layui-hide" readonly="readonly">
    <input type="text" name="teacherId" id="teacherId" class="layui-hide" readonly="readonly">

    <h3>添加排课</h3>
    <br />
    <div class="layui-form-item">
        <label class="layui-form-label">课程名称：</label>
        <div class="layui-input-block">
            <input type="text" name="course_name" id="course_name" lay-verify="title" required  lay-verify="required" maxlength="15" autocomplete="off" placeholder="请输入课程名称" class="layui-input">
        </div>
        <p  id="class_messagea">  </p>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">教师名称：</label>
        <div class="layui-input-block">
            <input type="text" name="teacher_name" id="teacher_name" placeholder="请输入教师名称" required  lay-verify="required" maxlength="15" autocomplete="off" class="layui-input">
        </div>
        <p  id="class_messageb">  </p>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">班级名称：</label>
        <div class="layui-input-block">
            <input type="text" name="class_name" id="class_name" lay-verify="title" required  lay-verify="required" maxlength="15" autocomplete="off" placeholder="请输入班级名称" class="layui-input">
        </div>
        <p  id="class_messagec">  </p>
    </div>
    <div class="layui-row">
        <div class="layui-form-item">
            <label class="layui-form-label">开课年份</label>
            <div class="layui-input-block">
                <select  id="courseYear" name="enrolTime">
                    <option value="2018">2018</option>
                    <option value="2019">2019</option>
                    <option value="2020">2020</option>
                    <option value="2021">2021</option>
                </select>
            </div>
        </div>
    </div>

    <input type="button" class="layui-btn layui-btn-lg layui-btn-normal" lay-submit lay-filter="formDemo" value="保存">

</div>
</form>

<script src="layui/layui.js" charset="utf-8"></script>
<script src="layui/jquery-3.6.0.js" charset="utf-8"></script>
<script type="text/javascript">
    window.onload = function () {
        function $(id) {
            return document.getElementById(id)//获取ID函数
        }

        $("course_name").onblur = function fn() {//失去焦点用“onblur”事件
            if($("course_name").value !== ""){a();}//判断class_id 班级代号是否可用
            else{aa();}
        }
        $("teacher_name").onblur = function fn() {//失去焦点用“onblur”事件
            if($("teacher_name").value !== ""){b();}//判断class_name 班级名称是否可用
            else{bb();}
        }
        $("class_name").onblur = function fn() {//失去焦点用“onblur”事件
            if($("class_name").value !== ""){c();}//判断department_id 院系代码是否可用
            else{cc();}
        }
    }

    function a(){
        $.ajax({
            type: "GET",
            //url: "https://www.fastmock.site/mock/2208ae2a5753db0f5bb87550d4a9128f/wiki/getClassUseful",
            url:'${pageContext.request.contextPath}/Manager/searchCourseInfoByCourseName',
            data: {course_name:$("#course_name").val()},
            dataType: "json",
            success: function(res){
                if(res['code']===1){
                    $("#courseId").val(res['course_id']);
                    $("#class_messagea").css("color","green").html("该名称可用！");

                }
                else{
                    $("#class_messagea").css("color","red").html("不存在此课程名称！")

                }
            }
        });
    }
    function aa(){
        $("#class_messagea").html(" ");
    }
    function b(){
        $.ajax({
            type: "GET",
            //url: "https://www.fastmock.site/mock/2208ae2a5753db0f5bb87550d4a9128f/wiki/getClassUseful",
            url: "${pageContext.request.contextPath}/Manager/searchTeacherInfoByTeacherName",
            data: {teacher_name:$("#teacher_name").val()},
            dataType: "json",
            success: function(res){
                if(res['code']===1){
                    $("#teacherId").val(res['teacher_id']);
                    $("#class_messageb").css("color","green").html("该名称可用！");

                }
                else{
                    $("#class_messageb").css("color","red").html("不存在此教师名称！")

                }
            }
        });
    }
    function bb(){
        $("#class_messageb").html(" ");
    }
    function c(){
        $.ajax({
            type: "GET",
            //url: "https://www.fastmock.site/mock/2208ae2a5753db0f5bb87550d4a9128f/wiki/getClassUseful",
            url: "${pageContext.request.contextPath}/Manager/searchClassByClassName",
            data: {class_name:$("#class_name").val()},
            dataType: "json",
            success: function(res){
                if(res['code']===1){
                    $("#classId").val(res['class_id']);
                    $("#class_messagec").css("color","green").html("该名称可用！");

                }
                else{
                    $("#class_messagec").css("color","red").html("不存在此班级名称！")

                }
            }
        });
    }
    function cc(){
        $("#class_messagec").html(" ");
    }
</script>

<script>
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
            url:'${pageContext.request.contextPath}/Manager/addCoursePlanInfo',
            type:'post',
            data:data.field,
            dataType:"json",
            success:function(data){
                layui.layer.closeAll();
                if(data.code===1){
                    layer.alert("提交成功！")
                }
                else{
                    layer.alert("提交失败！"+data.code)
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