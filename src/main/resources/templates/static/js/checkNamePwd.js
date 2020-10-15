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
var nameError=false;
var pwdError=false;