var a1='#';
var a2="#";
var a3="#";
var a4="#";
var url="http://localhost:8080/";
var baseUrl=url;
var tags;
function setAction(page1,page2,page3,page4){
    a1=page1;
    a2=page2;
    a3=page3;
    a4=page4;
}
var userId=0;

$("document").ready(function () {
    var cookies=$.cookie("stroy");
    var page=window.parent.getPage();
    switch (page) {
        case 1:
            setAction("active","normal","normal","normal");
            break;
        case 2:
            setAction("normal","active","normal","normal");
            break;
        case 3:
            setAction("normal","normal","active","normal");
            break;
        case 4:
            setAction("normal","normal","normal","active");
            break;
    }
    if(cookies!=null&&cookies.length>0&&cookies!="null"){
        var user=JSON.parse(cookies);
        userId=user.id;
    }
    var headDataLeft="<nav class=\"navbar navbar-default\" role=\"navigation\">"+
        "<div class=\"container-fluid\">"+
        "<div class=\"navbar-header\">"+
        " <ul class=\"nav nav-tabs\" role=\"tablist\" id=\"user\">"+
        "<li class="+a1+" > <a id='index' href=\"#\" class=\"navbar-brand\">故事</a></li>"+
        "<li class="+a2+" ><a id='myEdit' href=\"#\" class=\"navbar-brand\">创建故事</a></li></ul>\n" +
        "        </div>";


    if(cookies!=null&&cookies!=""){
        datas=cookies.split(';');
        //document.getElementById("username").innerHtml=datas[0];
        var data=headDataLeft+ "<ul class=\"nav navbar-nav navbar-right\" id=\"rightbutton\">"+

            "<li><a href=\"#\" id='self'><span class=\"glyphicon glyphicon-user\"></span> 我的</a></li>" +
            "<li><a href=\"#\" id='logout'><span class=\"glyphicon glyphicon-log-in\"></span> 退出</a></li>"+
            "</ul>\n" +
            "        </div>\n" +
            "        </nav>";
        $("#user").html(data)
    }else{
        var litext=headDataLeft+ "<ul class=\"nav navbar-nav navbar-right\" id=\"rightbutton\">"+
            "<li><a href=\"#\" id='reg'><span class=\"glyphicon glyphicon-user\"></span> 注册</a></li>"+
            "<li><a href=\"#\" id='login'><span class=\"glyphicon glyphicon-log-in\"></span> 登录</a></li></ul>\n" +
            "        </div>\n" +
            "        </nav>";
        $("#user").html(litext);
    }

    $("#index").click(function () {
        window.parent.location.href="index.html";}
    );
    $("#myEdit").click(function () {
        window.parent.location.href="myEdit.html";}
    );
    $("#self").click(function () {
        window.parent.location.href="self.html";
    });
    $("#login").click(function () {
        window.parent.location.href="login.html";
    });
    $("#reg").click(function () {
        window.parent.location.href="reg.html";
    });
    $("#logout").click(function () {
        $.cookie("stroy","");
        window.parent.location.href="index.html";
    });

});