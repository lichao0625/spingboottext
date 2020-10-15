$("document").ready(function () {
    $("#nameNote").hide();
    $("#pwdNote").hide();
    $("#errorNote").hide();
    var cookies=$.cookie("stroy");
    if(cookies!=null&&cookies.length>0){
        user=JSON.parse(cookies);
    }
    $("#username").change(function(){
        nameError=checkInput($("#username"),$("#namebox"),$("#nameNote"),isRegisterUserName);
    });
    $("#pwd").change(function(){
        pwdError=checkInput($("#pwd"),$("#pwdbox"),$("#pwdNote"),isPwd);
    });

});

function login() {
    if(!pwdError||!nameError)
    return;
    $.get(url+"user/login?name="+$("#username").val()+"&pwd="+$("#pwd").val(),function (data,status) {
        if(data.msg=="成功"){
            var isSave=$("save").attr("checked");
            var day=1;
            if(isSave)
                day=7;
            $.cookie("stroy",JSON.stringify(data.data),{ expires: day });
            var s=$.cookie("stroy");
            window.parent.location.href="index.html";

            $("#note").html("");
        }else{
            $("#note").html("用户名密码错误");
        }
    });
}

var nameError=false;
var pwdError=false;


function getPage(){
    return 3;
}