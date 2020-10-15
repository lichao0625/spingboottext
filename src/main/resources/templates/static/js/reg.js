
$("#submit").click(
    function () {
        if(!nameError||!pwdError)
            return;
        var username=$("#username").val();
        var pwd=$("#pwd").val();
        var data={name:username,pwd:pwd};
        $.post(url+"user/add",data,function (data,status) {
            if(data.msg=="成功"){
                $.cookie("stroy",JSON.stringify(data.data),{ expires: 7 });
                var s=$.cookie("stroy");
                window.parent.location.href="index.html";
                $("#errorNote").hide();
            }else{
                $("#errorNote").show();
            }
        });
    }
);
function getPage(){
    return 4;
}