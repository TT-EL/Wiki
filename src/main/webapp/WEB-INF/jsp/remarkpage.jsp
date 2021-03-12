<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name='viewport' content='width=device-width; initial-scale=1; maximum-scale=1; minimum-scale=1; user-scalable=no;'>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <title>帖子评论区</title>
    <style type="text/css">
        * {
            margin: 0;
            padding: 0;
        }
        #all {
            height: 100%;
            width: 100%;
            position: fixed;
        }
        .container {
            height: 100%;
            width: 100%;
            display: flex;
            flex-direction: column;
        }
        .fixed {
            width: 100%;
            max-height: 60vh;
            flex-direction: column;
            align-items: center;
            justify-content: center;
        }
        .scroll {
            width: 100%;
            max-height: 80vh;
            overflow: scroll;
            align-items: flex-start;
        }
        .footer{
            width: 100%;
            max-height: 20vh;
            align-items: center;
            justify-content: center;
            margin-left: 1vw;
            margin-bottom: 0.5vh;
        }
        .header {
            height: 7vh;
            display: flex;
            align-items: center;
        }
        .topArea {
            width: 100%;
            max-height: 80vh;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            margin-bottom: 1vh;
        }
        .linespace {
            height: 1vh;
            display: flex;
            align-items: center;
        }
        .comment {
            height: 4vh;
            display: flex;
            align-items: center;
        }
        .linespace2 {
            height: 0.5vh;
            display: flex;
            align-items: center;
        }
        .main {
            width: 95%;
            max-height: 50vh;
            display: flex;
            align-items: flex-start;
        }
        .img1 {
            border-radius: 5vh;
            max-height: 5vh;
            max-width: 20%;
            margin-left: 1vh;
        }
        .img2 {

            max-height: 79vh;
            width: 95%;
            margin-top: 1vh;
        }
        .Ttext {
            margin-left: 2vh;
            font-size: 2vh;
        }
        .content1 {
            max-height: 79vh;
            width: 95%;
            font-size: 1.5vh;
            text-align: left;
        }
        .content2 {
            max-height: 79vh;
            width: 95%;
            font-size: 1.5vh;
            margin-top: 1vh;
        }
        .line {
            background: #cccccc;
            height: 1vw;
            overflow: hidden;
        }
        .cText {
            margin-left: 1vh;
            font-size: 2vh;
            text-align: left;
        }
        .line2 {
            background: #cccccc;
            height: 0.2vw;
            overflow: hidden;
        }
        .mainC {
            margin-top: 1vh;
            margin-left: 1vh;
            width: 60%;
            max-height: 50vh;
            display: flex;
            align-items: flex-start;
            flex-direction: column;
        }
        .mainTop {
            max-height: 49vh;
            width: 90%;
            font-size: 1.2vh;
            text-align: left;
        }
        .mainText {
            max-height: 49vh;
            width: 90%;
            font-size: 2vh;
            text-align: left;
        }
        .mainRight {
            width: 20%;
            height: 10%;
            display: flex;
            align-items: center;
            justify-content: flex-end;
        }
        .rightText {
            text-decoration: underline;
            margin-top: 1vh;
            font-size: 1.2vh;
            text-align: left;
        }
        .img3 {
            max-height: 49vh;
            max-width: 50%;

            margin-left: 0.5vh;
            margin-top: 1vh;
        }
        .img4 {
            max-height: 5vh;
            max-width: 20%;
            margin-left: 0.5vh;
            margin-top: 1vh;
        }
        .ftext{
            width: 50vw;
            height: 4vh;
            border-radius: 5vh;
        }
        button {
            background: #eb94d0;
            /* 创建渐变 */
            background-image: -webkit-linear-gradient(top, #eb94d0, #2079b0);
            background-image: -moz-linear-gradient(top, #eb94d0, #2079b0);
            background-image: -ms-linear-gradient(top, #eb94d0, #2079b0);
            background-image: -o-linear-gradient(top, #eb94d0, #2079b0);
            background-image: linear-gradient(to bottom, #eb94d0, #2079b0);
            /* 给按钮添加圆角 */
            border-radius: 5vw;
            width: 10vw;
            height: 4vh;
            margin-left: 1vw;
            font-family: Arial;
            color: #fafafa;
            text-decoration: none;
        }
        /* 悬停样式 */
        button:hover {
            background: #2079b0;
            background-image: -webkit-linear-gradient(top, #2079b0, #eb94d0);
            background-image: -moz-linear-gradient(top, #2079b0, #eb94d0);
            background-image: -ms-linear-gradient(top, #2079b0, #eb94d0);
            background-image: -o-linear-gradient(top, #2079b0, #eb94d0);
            background-image: linear-gradient(to bottom, #2079b0, #eb94d0);
            text-decoration: none;
        }
    </style>
</head>

<body>
<div id="all"></div>
<%--<input type="text" name="tieId" id="tieId" style="display: none" value="123134313" readonly="readonly">--%>
<input type="text" name="tieId" id="tieId" style="display: none" value="${tie_id}" readonly="readonly">
<script type="text/javascript">
    var json;
    var All= document.getElementById("all");
    var data1;
    var data2;
    var flag = false;
    $.ajax({
        url:'${pageContext.request.contextPath}/User/getTie',
        type:'get',
        data:{'tie_id':$('#tieId').val()},
        dataType:"json",
        success:function(data){
            data1 = data;
            showData(data1,data2);
        }
    });
    $.ajax({
        url:'${pageContext.request.contextPath}/User/getRemarkList',
        type:'get',
        data:{'tie_id':$('#tieId').val()},
        dataType:"json",
        success:function(data){
            data2 = data;
            showData(data1,data2);
        }
    });

    function showData(json1,json2) {
        if (flag){
            var Name = json1.name
            var wxImg=json1.wxImage
            var int=json1.tIntroduction
            var uImg=json1.tUrlImage+"";
            var video=json1.tUrlVideo+"";

            var con=document.createElement("div")
            con.className="container"

            var fix=document.createElement("div")
            fix.className="fixed"

            var hea=document.createElement("div")
            hea.className="header"
            var img1=document.createElement("img")
            img1.className="img1"
            img1.src=wxImg
            var text1=document.createElement("div")
            text1.className="Ttext"
            text1.innerText=Name
            hea.appendChild(img1)
            hea.appendChild(text1)

            var top=document.createElement("div")
            top.className="topArea"
            var tent=document.createElement("div")
            tent.className="content1"
            tent.innerText=int
            top.appendChild(tent)
            if(uImg!="undefined") {
                var img2 = document.createElement("img")
                img2.src = uImg
                img2.className="img2"
                top.appendChild(img2)
            }
            else{
                var vid=document.createElement("video")
                vid.className="content2"
                vid.controls="controls"
                var sour=document.createElement("source")
                sour.src=video
                sour.type="video/mp4"
                vid.appendChild(sour)
                top.appendChild(vid)
            }

            var lins1=document.createElement("div")
            lins1.className="linesapce"
            var lin1=document.createElement("div")
            lin1.className="line"
            lins1.appendChild(lin1)

            var com=document.createElement("div")
            com.className="comment"
            var text2=document.createElement("div")
            text2.className="cText"
            text2.innerText="评论"
            com.appendChild(text2)

            var lins2=document.createElement("div")
            lins2.className="linesapce2"
            var lin2=document.createElement("div")
            lin2.className="line2"
            lins2.appendChild(lin2)

            var scr=document.createElement("div")
            scr.className="scroll"

            for (let i = 0;i<json2.length; i++) {
                var username = json2[i].userName
                var Img=json2[i].wxImage
                var remark=json2[i].remarkText
                var remarkimg=json2[i].remarkImage
                var time=json2[i].remarkTime
                var upnum=json2[i].remarkUpNum

                var mai=document.createElement("div")
                mai.className="main"
                var img2=document.createElement("img")
                img2.className="img1"
                img2.src=Img

                var maic=document.createElement("div")
                maic.className="mainC"
                var mait=document.createElement("div")
                mait.className="mainTop"
                mait.innerText=username
                var maix=document.createElement("div")
                maix.className="mainText"
                maix.innerText=remark
                var img3=document.createElement("img")
                img3.src=remarkimg
                img3.className="img3"
                maic.appendChild(mait)
                maic.appendChild(maix)
                maic.appendChild(img3)

                var mair=document.createElement("div")
                mair.className="mainRight"
                var rit=document.createElement("div")
                rit.className="rightText"
                rit.innerText="点赞"
                var img4=document.createElement("img")
                img4.src="/image/icon-up.png"
                img4.className="img4"
                mair.appendChild(rit)
                mair.appendChild(img4)
                mai.appendChild(img2)
                mai.appendChild(maic)
                mai.appendChild(mair)
                scr.appendChild(mai)
            }

            var foot=document.createElement("div")
            foot.className="footer"
            var put=document.createElement("input")
            put.type="text"
            put.placeholder="说点皮的"
            put.className="ftext"
            var but=document.createElement("button")
            but.type="button"
            but.innerText="发布"
            foot.appendChild(put)
            foot.appendChild(but)

            fix.appendChild(hea)
            fix.appendChild(top)
            fix.appendChild(lins1)
            fix.appendChild(com)
            fix.appendChild(lins2)
            con.appendChild(fix)
            con.appendChild(scr)
            con.appendChild(foot)
            All.appendChild(con)
        }
        else{
            flag = true;
        }

    }
</script>
</body>
</html>
