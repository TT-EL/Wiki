<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html >
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
        .course_desc{
            height:100px;
        }
    </style>

    <title>添加课程</title>

</head>
<body>

<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
    <li class="layui-nav-item layui-this"><a href="#">添加课程</a></li>
    <li class="layui-nav-item"><a href="add_class.jsp">添加班级</a></li>
    <li class="layui-nav-item"><a href="add_cotocl.jsp">添加排课</a></li>
</ul>

<br><br><br><br>
<form class="layui-form" action="/User/addCourseInfo" method="post">
<div class="all">

    <h3>添加课程</h3>
    <br />
    <div class="layui-form-item">
        <label class="layui-form-label">课程编号：</label>
        <div class="layui-input-block">
            <input type="text" name="courseId" lay-verify="title" maxlength="15" required  lay-verify="required" autocomplete="off" placeholder="请输入课程编号" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">课程名：</label>
        <div class="layui-input-block">
            <input type="text" name="courseName" placeholder="请输入课程名"  required  lay-verify="required" maxlength="15" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">课程描述：</label>
        <div class="layui-input-block" style="height:120px;">
            <textarea  name="courseDesc" placeholder="请输入该课程描述,限制80个字符之内"  required  lay-verify="required"class="layui-input" style="height:120px;  resize: none;" maxlength="120" cols="8"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">课程图片：</label>
        <div class="layui-input-block">

            <input id="upload-input" style="position: absolute; top: 0; bottom: 0; left: 0;right: 0; opacity: 0;" type="file" accept="image/gif, image/jpg, image/png,image/jpeg" onchange="showImg(this)" />
            <!-- 自定义按钮效果 -->
            <div style="text-align: left">
                <img id="upload" name="courseImage" src="/layui/images/upload.jpeg" style=" height: 120px; vertical-align: middle;" />
            </div>
        </div>
    </div>
    <br><br>
    <button type="button" class="layui-btn layui-btn-lg layui-btn-normal" lay-submit lay-filter="formDemo">保存</button>
</div>
</form>

<script src="layui/layui.js" charset="utf-8"></script>
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
            url:'${pageContext.request.contextPath}/Manager/addCourseInfo',
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

<script type="text/javascript">
    function showImg(input) {
        var file = input.files[0];
        var reader = new FileReader()
        // 图片读取成功回调函数
        reader.onload = function(e) {
            document.getElementById('upload').src=e.target.result
        }
        reader.readAsDataURL(file)
    }
</script>
</body>
</html>