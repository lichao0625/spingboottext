$("document").ready(function () {
    $("#oldNote").hide();
    $("#newNote").hide();
    $("#note").hide();
    var cookies=$.cookie("stroy");
    if(cookies!=null&&cookies.length>0){
        user=JSON.parse(cookies);
    }
    $("#oldPWD").change(function(){
        var oldPwd=$("#oldPWD").val();
        if(user.pwd!=oldPwd){
            $("#oldBox").addClass("has-error");
            $("#oldBox").removeClass("has-success");
            $("#oldNote").show();
            pwdError=false;
        }else{
            $("#oldBox").removeClass("has-error");
            $("#oldBox").addClass("has-success");
            $("#oldNote").hide();
            pwdError=true;
        }
    });
    $("#newPWD").change(function(){
        var pwd=$("#newPWD").val();
        if(isPwd(pwd)==false){
            $("#newBox").addClass("has-error");
            $("#newBox").removeClass("has-success");
            $("#note").show();
            reNewPwdError=false;
        }else{
            $("#newBox").removeClass("has-error");
            $("#newBox").addClass("has-success");
            $("#note").hide();
            reNewPwdError=true;
        }
    });
    $("#reNewPWD").change(function () {
        var newPwd=$("#newPWD").val();
        var reNewPwd=$("#reNewPWD").val();
        if(reNewPwd==newPwd&&reNewPwd!=null){
            $("#reNewBox").removeClass("has-error");
            $("#reNewBox").addClass("has-success");
            $("#newNote").hide();
            newPwdError=true;
        }else{
            $("#reNewBox").addClass("has-error");
            $("#reNewBox").removeClass("has-success");
            $("#newNote").show();
            newPwdError=false;
        }
    })
});

var user=null;
var pwdError=false;
var newPwdError=false;
var reNewPwdError=false;
function updatePwd() {
    if(!newPwdError||!pwdError||!reNewPwdError)
        return;
    var newPwd = $('#newPWD').val();
    var datas={"pwd":newPwd,"userId":user.id};
    $.post(url+"user/setPwd",datas,function (data,status) {
        if(data.msg=="成功"){
            $.cookie("stroy",JSON.stringify(data.data),{ expires: 7 });
            alert("修改成功");
        }else{
            alert("更新失败:"+data.msg);
        }
    });
}
