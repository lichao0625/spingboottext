
$("document").ready(function () {
   showEdit(false);
   $("#nameNote").hide();
   $("#emailNote").hide();
   $("#phoneNote").hide();
   $("#signNote").hide();
    var user=null;
    var cookies=$.cookie("stroy");
    if(cookies!=null&&cookies.length>0){
        user=JSON.parse(cookies);
    }
    if(user!=null){
        $('#nikeNameText').html(user.nikeName);
        $('#emailText').html(user.email);
        $('#phoneText').html(user.phone);
        $('#signatureText').html(user.signature);
    }
    $('#edit').click(function () {
        showEdit(true);
    });
    $("#updateSelf").click(function () {
        updateSelfInfo();
    });

    $("#inputNikeName").change(function(){
        nameError=checkInput($("#inputNikeName"),$("#namebox"),$("#nameNote"),isSimpleText)
    });
    $("#inputEmail").change(function(){
        emailError=checkInput($("#inputEmail"),$("#emailbox"),$("#emailNote"),isEmail)
    });
    $("#inputPhone").change(function(){
        phoneError=checkInput($("#inputPhone"),$("#phonebox"),$("#phoneNote"),isPhone)
    });
    $("#inputSignature").change(function(){
        signError=checkInput($("#inputSignature"),$("#signbox"),$("#signNote"),isSignText)
    });
});
var nameError=false;
var emailError=false;
var phoneError=false;
var signError=false;

function updateSelfInfo() {
    if(!signError||!nameError||!phoneError||!signError)
        return;
    var nike = $('#inputNikeName').val();
    var email=$('#inputEmail').val();
    var phone=$('#inputPhone').val();
    sign=$('#inputSignature').val();
    var datas={"nikeName":nike,"signature":sign,"email":email,"phone":phone,"userId":userId};
    $.post(url+"user/setUserInfo",datas,function (data,status) {
        if(data.msg=="成功"){
            showEdit(false);
            $('#nikeNameText').html(nike);
            $('#emailText').html(email);
            $('#phoneText').html(phone);
            $('#signatureText').htmll(sign);
            $('#username').html(nike);
            $('#userTalk').html(sign);
            $.cookie("stroy",JSON.stringify(data.data),{ expires: 7 });
        }else{
            alert("更新失败:"+data.msg);
        }
    });
}
function showEdit(isShow) {
    if(isShow){
        $('#nikeNameText').hide();
        $('#emailText').hide();
        $('#phoneText').hide();
        $('#signatureText').hide();
        $('#inputNikeName').show();
        $('#inputEmail').show();
        $('#inputPhone').show();
        $('#inputSignature').show();
    }else{
        $('#nikeNameText').show();
        $('#emailText').show();
        $('#phoneText').show();
        $('#signatureText').show();
        $('#inputNikeName').hide();
        $('#inputEmail').hide();
        $('#inputPhone').hide();
        $('#inputSignature').hide();
    }
}