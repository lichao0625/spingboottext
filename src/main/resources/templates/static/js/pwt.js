function pointClick(stroyId,title) {
    var cookies=$.cookie("stroy");
    var userId=0;
    storyName=title;
    if(cookies!=null&&cookies.length>0){
        var user=JSON.parse(cookies);
        userId=user.id;
        portrait=user.portrait;
        username=user.name;
        var json={"userId":userId,"stroyId":stroyId, "username":username,"userPortrait":portrait,"storyName":storyName};
        $.post(url+"point/add",json,function (data,status) {
            if(data.msg=="成功"){
                var jsobject = JSON.parse(data.data);
                if(jsobject.isAdd){
                    $("#point"+stroyId).html( "  <span  class=\"glyphicon glyphicon-heart\"></span> "+jsobject.size);
                }else{
                    $("#point"+stroyId).html( "  <span  class=\"glyphicon glyphicon-heart-empty\"></span> "+jsobject.size);
                }
            }else{
                alert("创建失败:"+data.msg);
            }
        })
    }else
        alert("请登录");

}
function watchClick(stroyId,title) {
    var cookies=$.cookie("stroy");
    var userId=0;
    storyName=title;
    if(cookies!=null&&cookies.length>0){
        var user=JSON.parse(cookies);
        userId=user.id;
        portrait=user.portrait;
        username=user.name;
        var json={"userId":userId,"stroyId":stroyId, "username":username,"userPortrait":portrait,"storyName":storyName};
        $.post(url+"watch/add",json,function (data,status) {
            if(data.msg=="成功"){
                var watchButton=$("#watch"+stroyId);
                var jsobject = JSON.parse(data.data);
                if(jsobject.isAdd){
                    watchButton.html( "  <span  class=\"glyphicon glyphicon-star\"></span> "+jsobject.size);
                }else{
                    watchButton.html( "  <span  class=\"glyphicon glyphicon-star-empty\"></span> "+jsobject.size);
                }

            }else{
                alert("创建失败:"+data.msg);
            }
        })
    }else
        alert("请登录");
}
var sId;
var userId;
var portrait;
var username;
var storyName;
var dialog;
var userTalk=false;
var tUserId;
var isIndex;
function talkClick(stroyId,title) {
    sId=stroyId;
    var cookies=$.cookie("stroy");
    storyName=title;
    if(cookies!=null&&cookies.length>0){
        var user=JSON.parse(cookies);
        userId=user.id;
        portrait=user.portrait;
        username=user.name;
        dialog=$("#addTalk");
        dialog.modal('show');
    }else{ alert("请登录");}

}
function submitClick() {
    dialog.modal('hide');
    var text = $('#tack').val();
    var postUrl=url+"talk/add";
    var json = {"userId": userId, "stroyId": sId, "username":username,"userPortrait":portrait,"text": text,"storyName":storyName};
    if(userTalk){
        json = {"userId": userId, "talkId": sId, "username":username,"userPortrait":portrait,"text": text,"tUserID":tUserId,"storyID":b,"storyName":storyName};
        postUrl=url+"userTalk/add";
    }

    $.post(postUrl, json, function (data, status) {
        if (data.msg == "成功") {
            var name="#talk"+sId;
            $(name).html("  <span  class=\"\glyphicon glyphicon-edit\"></span> "+data.data);
            if(isIndex==false)
                getTalks(b);
            else
                alert("提交成功:" + data.msg);
        } else {
            alert("评论失败:" + data.msg);
        }
        userTalk=false;
    })

}
