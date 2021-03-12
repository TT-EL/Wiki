<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>首页</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <style>
        .bg{
            width:70%;
            margin:0 auto;}
    </style>
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<ul class="layui-nav" lay-filter="">
    <li class="layui-nav-item layui-this"><a href="#">首页</a></li>
    <li class="layui-nav-item"><a href="add_course.jsp">添加课程</a></li>
    <li class="layui-nav-item"><a href="add_class.jsp">添加班级</a></li>
    <li class="layui-nav-item"><a href="add_cotocl.jsp">添加排课</a></li>
</ul>

<br><br><br><br>

<div class="bg">
    <div class="demoTable">
        搜索课程：
        <div class="layui-inline">
            <input class="layui-input" name="id" id="demoReload" autocomplete="off">
        </div>
        <button class="layui-btn" data-type="reload">搜索</button>
        <button class="layui-btn"><a href="add_cotocl.jsp" style="color:#FFF">添加排课</a></button>
    </div>

    <table class="layui-hide" id="LAY_table_user" lay-filter="user"></table>
</div>



<script src="layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->

<script>
    //注意：导航 依赖 element 模块，否则无法进行功能性操作
    layui.use('element', function(){
        var element = layui.element;

        //…
    });
</script>

<script>
    layui.use('table', function(){
        var table = layui.table;

        //方法级渲染
        table.render({
            elem: '#LAY_table_user'
            //,url: 'https://www.fastmock.site/mock/2208ae2a5753db0f5bb87550d4a9128f/wiki/api/getmanagelist'
            ,url: 'http://dgel.natapp1.cc/Manager/getHomePage'
            ,parseData:function(res){//res即为原始返回的数据
                return {
                    "code" : 0, //解析接口状态
                    "msg" : "ok", //解析提示文本
                    "count":1000,//解析数据长度
                    "data" : res.list //解析数据列表
                };
            }
            ,cols: [[
                {checkbox: true, fixed: true}
                ,{field: 'cotocl_num', title: '排课编号', width:110, sort: true, fixed: 'left',minWidth:110}
                ,{field: 'course_id', title: '课程编号', width:180, minWidth:180,sort: true}
                ,{field: 'course_name', title: '课程名', width:130,minWidth:130, sort: true}
                ,{field: 'year', title: '年级', width:80, minWidth:80,sort: true}
                ,{field: 'teacher_name', title: '老师名', width: 100, sort: true,minWidth:100}
                ,{field: 'class_name', title: '班级名', width: 130, sort: true,minWidth:130}
                ,{field: 'course_desc', title: '课程描述', width: 120,minWidth:120}
                ,{field: 'student_count', title: '学生人数', width:100, sort: true,minWidth:100}
            ]]
            ,id: 'testReload'
            ,page: false
            ,height: 450
        });

        table.on('row(user)', function(obj){
            var data = obj.data.cotocl_num;
            postinfo(data);
            layer.alert(JSON.stringify(data), {
                title: '当前行数据：'
            });
            //标注选中样式
            obj.tr.addClass('layui-table-click').siblings().removeClass('layui-table-click');
        });

        function postinfo(data){
            $.ajax({
                url:'${pageContext.request.contextPath}/Manager/',
                type:'post',
                data:data.cotocl_num,
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
                    layer.alert("提交失败！")
                },

            });
        }

        var $ = layui.$, active = {
            reload: function(){
                var demoReload = $('#demoReload');

                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    ,where: {
                        key: {
                            id: demoReload.val()
                        }
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function(){
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });
    });
</script>

</body>
</html>