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
    <meta name='viewport' content='width=device-width; initial-scale=1; maximum-scale=1; minimum-scale=1; user-scalable=no;'>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.mobile.css">
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
%>

<div class="layui-container" >
    <form class="layui-form">
        <input type="text" name="wxImage" class="layui-hide" value="${wx_image}" readonly="readonly">
        <input type="text" name="wxId" value="${wx_id}" class="layui-hide" readonly="readonly"/>
        <div class="layui-row layui-col-md12" style="height: 100px;margin-top: 40px;">
            <div style="text-align: center">
                <img src="${wx_image}" style="height: 100px;width: 100px" class="layui-circle"/>
            </div>

        </div>
        <div class="layui-row" style="margin-bottom: 50px"></div>
        <div class="layui-row">
            <div class="layui-form-item">
                <label class="layui-row ">学号/工号</label>
                <div class="layui-row">
                    <input type="text" name="userId" required  lay-verify="required" placeholder="请输入学号/工号" autocomplete="off" class="layui-input">
                </div>
            </div>

        </div>

    <div class="layui-row">
        <div class="layui-form-item">
            <label class="layui-row">姓名</label>
            <div class="layui-rowv">
                <input type="text" name="name" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>

        <div class="layui-row">
            <div class="layui-form-item">
                <label class="layui-row">微信昵称</label>
                <div class="layui-row">
                    <input type="text" name="wxUsername" readonly="readonly" value="${wx_name}" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-row">

            <div class="layui-form-item">
                <label class="layui-row">选择身份</label>
                <div class="layui-row">
                    <input type="radio" name="power" value="0" title="学生" checked>
                    <input type="radio" name="power" value="1" title="教师">
                </div>
            </div>
        </div>

        <div class="layui-row">
            <div class="layui-form-item">
                <label class="layui-row">班级（学生）</label>
                <div class="layui-rowv">
                    <select  id="classsltradioList" name="classId" >
                        <option   value="">--请选择--</option>
                    </select>
                </div>
            </div>
        </div>

        <div class="layui-row">
            <div class="layui-form-item">
                <label class="layui-row">入学年份</label>
                <div class="layui-row">
                    <select  id="enroltimeList" name="enrolTime">
                        <option value="2018">2018</option>
                        <option value="2019">2019</option>
                        <option value="2020">2020</option>
                        <option value="2021">2021</option>
                    </select>
                </div>
            </div>


        </div>


        <div class="layui-row">
            <div class="layui-form-item">
                <label class="layui-row">院系（老师）</label>
                <div class="layui-row">
                    <input type="text" name="department_name" placeholder="请输入院系名称" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-row">
                <button type="button" class="layui-btn layui-bg-green layui-btn-fluid layui-col-md5" lay-submit lay-filter="formRrigister">注册</button>
<%--                <input type="button" class="layui-btn layui-bg-green layui-btn-fluid layui-col-md5 layui-btn-lg layui-btn-normal" lay-submit lay-filiter="formRrigister" value="注册">--%>
            </div>
        </div>


    </form>
</div>

<script>
    layui.use('form',function (){
        var form = layui.form;

        //监听提交
        form.on('submit(formRrigister)', function(data){
            layui.layer.load();
            postInfo(data);
            return false;
        });
    });
    function postInfo(data){
        $.ajax({
            url:'${pageContext.request.contextPath}/User/register',
            type:'post',
            data:data.field,
            dataType:"json",
            success:function(data){

                layui.layer.closeAll();
                if(data.code===1){
                    layer.msg("注册成功！")
                }
                else{
                    layer.msg("注册失败！")
                }
            },
            error:function(e){
                layer.msg("提交失败！")
            },
        });
    }
</script>
<script>
    function init() {
        layui.use('form', function () {
            var form = layui.form;
            form.render();
        })
    }
</script>
<script>
    $.ajax({
        type: "GET",
        url: 'http://dgel.natapp1.cc/User/getClassList',//处理逻辑的后台路径
        //传递的参数,用，隔开；action方法名的参数要与“：”前的名字一致
        dataType:"json",
        success: function(data) {
            console.log(data.toString());
            var item = data;
            if (item.length === 0) {
                alert("单选列表获取失败");
            } else {

                var html = '<option selected="selected" value="0">--请选择--</option>';
                $('#classsltradioList').empty();//加载列表前先清掉子项，防止重复累计叠加
                for (var i = 0; i < item.length; i++) {
                    html += '<option name="classId" value = "' + item[i].classId + '">' + item[i].className + '</option>';
                }
                $('#classsltradioList').append(html);
                init();
            }
        }
    });



</script>
</body>
</html>
