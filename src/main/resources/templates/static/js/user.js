function getPage(){
    return 5;
}
var userId;
var nikeName;
var portrait;
var user;
var selfUser;
$("document").ready(function () {
    var a=window.location.href.split("?")[1];
    var b=a.split("=");
    userId=b[1];
    nikeName=b[3];
    portrait=b[5];
    var cookies=$.cookie("stroy");
    if(cookies!=null&&cookies.length>0){
        selfUser=JSON.parse(cookies);
    }
    $.get(url+"user/getUserById?id="+userId+"&followId="+selfUser.id,function (data,status) {
        if(data.msg=="成功") {
            user=data.data;
            var name=user.nikeName;
            if(name==null)
                name="未知";
            var sign=user.signature;
            if(sign==null)
                sign="无";
            $('#username').html(name);
            $('#userTalk').html(sign);
            $('#followNum').text(user.follower);
            var isFollow="关注";
            if(user.followd)
                isFollow="取消关注"
            $('#followText').text(isFollow);
            var userPortrait=user.portrait;
            if(userPortrait==null)
                userPortrait="/spingboottext/templates/timg.jpg";
            else
                userPortrait="/spingboottext/templates"+userPortrait;
            $('#userImg').attr('src', userPortrait);
        }  else{
            alert("无法获取用户信息");
        }
    })
    selfStoryClick();
    $("#follow").click(function () {
        var json={"userId":user.id,"followId":selfUser.id,"followName":user.nikeName,"followerName":selfUser.nikeName,"followPortrait":user.portrait,"followerPortrait":selfUser.portrait};
        $.post(url+"userFollower/addFollow",json,function (data,status) {
            if(data.msg=="成功") {
                var num = data.data;
                $('#followNum').text(num);
                user.followd=!user.followd;
                var isFollow="关注";
                if(user.followd)
                    isFollow="取消关注"
                $('#followText').text(isFollow);
            }else
                alert("失败:"+data.msg);
        });
    })
});

function selfCollectClick() {
    changeClickClass("selfCollect");
    getCollect();
}

function selfDiscussClick() {
    changeClickClass("selfDiscuss");
    getDiscuss();
}
function selfStoryClick() {
    changeClickClass("selfStory");
    getStory();
}
function changeClickClass(click) {
    $("#selfCollect").removeAttr("class");
    $("#selfStory").removeAttr("class");
    $("#selfDiscuss").removeAttr("class");
    $("#"+click).attr("class","active");
}


function getCollect() {
    $("#infoBox").load('myCollect.html');
}
function getDiscuss() {
    $("#infoBox").load('myDiscuss.html');
}
function getStory() {
    $("#infoBox").load('myStory.html');
}