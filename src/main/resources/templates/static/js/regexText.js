function isPhone(str) {
    var regex = /^1[3456789]\d{9}$/;
    if(!regex.test(str)){
        return false;
    }
    return true;
}
function isMail(str) {
    var regex = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    if(!regex.test(str)){
        return false;
    }
    return true;
}
function isSimpleText(str) {
    var regex = /^([\u0391-\uFFE5]|[a-zA-Z0-9]){5,20}$/;
    if(!regex.test(str)){
        return false;
    }
    return true;
}
function isSignText(str) {
    var regex = /^([\u0391-\uFFE5]|[a-zA-Z0-9]){5,60}$/;
    if(!regex.test(str)){
        return false;
    }
    return true;
}
function isChinese(str) {
    var regex = /^[\u0391-\uFFE5]+$/;
    if(!regex.test(str)){
        return false;
    }
    return true;
}
//校验登录名：只能输入5-20个以字母开头、可带数字、“_”、“.”的字串
 function isRegisterUserName(s) {
    var patrn=/^[a-zA-Z]{1}([a-zA-Z0-9]|[._]){4,19}$/;
    if (!patrn.exec(s))
        return false
    return true
}

//校验密码：只能输入6-20个字母、数字、下划线
function isPwd(s) {
    var patrn=/^(\w){8,20}$/;
    if (!patrn.exec(s))
        return false
    return true
}

function isEmail(str) {
    var patrn = /^([a-zA-Z]|[0-9])(\w|\-)+@[a-zA-Z0-9]+\.([a-zA-Z]{2,4})$/;
    if(!patrn.test(str)){
        return false;
    }
    return true;
}
function checkInput(input,inputBox,errorNote,checkFun) {
    var text=input.val();
    var error=false;
    if(!checkFun(text)){
        inputBox.addClass("has-error");
        inputBox.removeClass("has-success");
        errorNote.show();
        error=false;
    }else{
        inputBox.removeClass("has-error");
        inputBox.addClass("has-success");
        errorNote.hide();
        error=true;
    }
    return error;
}