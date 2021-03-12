<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name='viewport' content='width=device-width; initial-scale=1; maximum-scale=1; minimum-scale=1; user-scalable=no;'>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <title>发帖区</title>
    <style>
        *{
            margin:0px;
            padding:0px;
        }
        #all{
            height: 100%;
            width: 100%;
            display: flex;
            flex-direction: column;
        }
        .container{
            height:6vh;
            display:flex;
            align-items:center;
        }
        .textArea{
            width:95%;
            max-height:50vh;
            display:flex;
            align-items:center;
            justify-content : center;
            margin-bottom:1vh;
        }
        .center{
            max-height:50vh;
            width: 100%;
            display:flex;
            align-items:center;
            justify-content : center;
        }
        .footer{
            height:6vh;
            display:flex;
            align-items:center;
        }
        .linespace{
            height:1vh;
            width: 100vw;
            display:flex;
            justify-content : center;
            align-items:center;
        }
        .textContent{
            max-height:49vh;
            width:90%;
            font-size:1.5vh;
            text-align:left;
        }
        .img1{
            max-height:5vh;
            max-width:100%;
            margin-left:2vh;
        }
        .img2{
            max-height:49vh;
            width:90%;
            object-fit: cover;
        }
        .img3{
            max-height:3vh;
            max-width:10%;
            margin-left:4vh;
        }
        .Ttext{
            margin-left:2vh;
            font-size:2vh;
        }
        .Ftext{
            font-size:1.5vh;
            width:25vw;
        }
        .line {
            background:#CCCCCC;
            width: 96%;
            height:1vw;
            overflow:hidden;
        }
        a{
            height:3vh;
            width:10%;
            margin-left:4vh;
        }
        .img5{
            max-height: 100%;
            max-width:100%;
        }
    </style>
</head>

<body>
<%--<input type="text" name="cotoclNum" id="cotoclNum" style="display: none" value="7" readonly="readonly">--%>
<input type="text" name="cotoclNum" id="cotoclNum" style="display: none" value="${cotocl_num}" readonly="readonly">


<div id="all">
</div>
<script type="text/javascript">
    var json;
    var All= document.getElementById("all");

    $.ajax({
        url:'${pageContext.request.contextPath}/User/getTieList',
        type:'get',
        data:{'cotocl_num':$('#cotoclNum').val()},
        dataType:"json",
        success:function(data){
            showData(data);
        }
    });
    function showData(json) {
        for (let i = 0;i < json.length; i++) {
            var Name = json[i].name
            var wxImg=json[i].wxImage
            var int=json[i].tIntroduction
            var uImg=json[i].tUrlImage+"";
            var video=json[i].tUrlVideo+"";


            var Con=document.createElement("div")
            Con.className="container"
            var img1=document.createElement("img")
            img1.src=wxImg
            img1.className="img1"
            var text1=document.createElement("div")
            text1.className="Ttext"
            text1.innerText=Name
            Con.appendChild(img1)
            Con.appendChild(text1)

            var Area=document.createElement("div")
            Area.className="textArea"
            var content=document.createElement("div")
            content.className="textContent"
            content.innerText=int
            Area.appendChild(content)

            var Center = document.createElement("div")
            Center.className = "center"
            if(uImg === "undefined"||uImg === null||uImg === null) {
                var vid=document.createElement("video")
                vid.className="img2"
                vid.controls="controls"
                var sour=document.createElement("source")
                sour.src= video
                sour.type="video/mp4"
                vid.appendChild(sour)
                Center.appendChild(vid)
            }
            else{
                var img2 = document.createElement("img")
                img2.src = uImg
                img2.className="img2"
                Center.appendChild(img2)
            }

            var foot=document.createElement("div")
            foot.className="footer"
            var img3=document.createElement("img")
            img3.src="/image/icon-up.png"
            img3.className="img3"
            var text2=document.createElement("div")
            text2.className="Ftext"
            text2.innerText="点赞"
            var turn=document.createElement("a")

            var img4=document.createElement("img")
            img4.src="/image/icon-remark.png"
            img4.className="img5"
            var hre=document.createElement("a")
            var url="http://dgel.natapp1.cc/User/getRemarkPage?tie_id="+json[i].tId
            hre.href=url
            hre.appendChild(img4)
            var text3=document.createElement("div")
            text3.className="Ftext"
            text3.innerText="评论"

            var img5=document.createElement("img")
            img5.src="/image/icon-trans.png"
            img5.className="img3"
            var text4=document.createElement("div")
            text4.className="Ftext"
            text4.innerText="转发"


            foot.appendChild(img3)
            foot.appendChild(text2)
            foot.appendChild(hre)
            foot.appendChild(text3)
            foot.appendChild(img5)
            foot.appendChild(text4)

            var lins=document.createElement("div")
            lins.className="linespace"
            var lin=document.createElement("div")
            lin.className="line"
            lins.appendChild(lin)

            All.appendChild(Con)
            All.appendChild(Area)
            All.appendChild(Center)
            All.appendChild(foot)
            All.appendChild(lins)
        }
    }
</script>
</body>
</html>

