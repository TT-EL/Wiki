<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE">
<html">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name='viewport' content='width=device-width; initial-scale=1; maximum-scale=1; minimum-scale=1; user-scalable=no;'>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <style type="text/css">
        * {
            margin:0;
            padding:0;
        }
        .Ttext{
            height:5vh;
            display:flex;
            align-items:center;
            justify-content : center;
            font-size:5vw;

        }
        .header{
            height:20vh;
            display:flex;
            align-items:center;
            justify-content : center;
        }
        .main{
            margin-top: 1vh;
            width: 100vw;
            display: flex;
            align-items:center ;
            flex-direction:column;
            justify-content : center;
        }
        .center{
            height:10vh;
            display:flex;
            align-items:center;
        }
        .Ctext{
            font-size:6vw;
            width:55vw;
            margin-left:5vw;
        }
        .img1{
            max-height:20vh;
            max-width:90%;
        }
        .img2{
            height:8vh;
            width:8vh;
            margin-left:5vw;
            object-fit: cover;
        }
        .last{
            height:1vh;
            display:flex;
            align-items:center;
            justify-content: center;
        }
        .line {
            background:#CCCCCC;
            width:90vw;
            height:0.1vw;
        }
    </style>
    <title>我的课堂列表</title>
</head>
<body>
<div class="Ttext">
    我的课堂列表
</div>
<div class="header">
    <input type="text" name="studentId" id="studentId" style="display: none" value="${student_id}" readonly="readonly">
<%--    <input type="text" name="studentId" id="studentId" style="display: none" value="1805050223" readonly="readonly">--%>

    <img src="/image/welcome.jpg" class="img1"/>
</div>
<div class="main" id="Main">
</div>
<script type="text/javascript">
    //var json;
    var man = document.getElementById("Main");
    // window.onload = function() {
    //     var studentName = $('#studentId').val();
    //     var url = "/User/getCourseList?student_id="+studentName;/*json文件url，本地的就写本地的位置，如果是服务器的就写服务器的路径*/
    //     var request = new XMLHttpRequest();
    //     request.open("get", url);/*设置请求方法与路径*/
    //     request.send(null);/*不发送数据到服务器*/
    //     request.onload = function () {
    //         if (request.status == 200) {
    //             json = JSON.parse(request.responseText);
    //             showData(json)
    //         }
    //     }
    // }
    $.ajax({
        url:'${pageContext.request.contextPath}/User/getCourseList',
        type:'get',
        data:{'student_id':$('#studentId').val()},
        dataType:"json",
        success:function(data){
            showData(data);
        }
    });
    function showData(json) {
        for (let i = 0;i<json.length; i++) {
            var courseName = json[i].courseName
            var courseImg=json[i].courseImage
            var big=document.createElement("div")
            big.className="center"
            var img1=document.createElement("img")
            img1.src=courseImg
            img1.className="img2"
            var cen=document.createElement("div")
            cen.className="Ctext"
            cen.id="test"+i;
            cen.innerText=courseName
            var img2=document.createElement("img")
            img2.src="/image/right.png"
            img2.className="img2"
            var hre=document.createElement("a")
            hre.href="http://dgel.natapp1.cc/User/getTiePage?cotocl_num="+json[i].cotoclNum
            hre.appendChild(img2)
            big.appendChild(img1)
            big.appendChild(cen)
            big.appendChild(hre)
            console.log(courseName)
            var las = document.createElement("div")
            las.className="last"
            var lin=document.createElement("div")
            lin.className="line"
            las.appendChild(lin)
            man.appendChild(big)
            man.appendChild(las)
        }
    }
</script>
</body>
</html>