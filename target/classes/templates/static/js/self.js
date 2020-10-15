function getPage(){
    return 3;
}
$("document").ready(function () {
    $.get(url+"user/getSelfById?id="+userId,function (data,status) {
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
            $('#followNum').text(user.follow);
            $('#followerNum').text(user.follower);
            var userPortrait=user.portrait;
            if(userPortrait==null)
                userPortrait="/spingboottext/templates/timg.jpg";
            else
                userPortrait="/spingboottext/templates"+userPortrait;
            $('#userImg').attr('src', userPortrait);
        }else{
            alert("无法获取用户信息");
        }
    })
    getUserInfo();
});
function selfInfoClick() {
    changeClickClass("selfInfo");
    getUserInfo();
}
function selfCollectClick() {
    changeClickClass("selfCollect");
    getCollect();
}
function selfPortraitClick() {
    changeClickClass("selfPortrait");
    getPortrait();
}
function selfPwdClick() {
    changeClickClass("selfPwd");
    getPwd();
}
function userfollowClick() {
    changeClickClass("userfollow");
    $("#infoBox").load('userfollow.html');
}
function userfollowerClick() {
    changeClickClass("userfollower");
    $("#infoBox").load('userfollower.html');
}
function selfDiscussClick() {
    changeClickClass("selfDiscuss");
    getDiscuss();
}
function selfStoryClick() {
    changeClickClass("selfStory");
    getStory();
}
function selfMsgClick() {
    changeClickClass("selfMsg");
    $("#infoBox").load('selfMsg.html');
}
function changeClickClass(click) {
    $("#selfInfo").removeAttr("class");
    $("#selfPortrait").removeAttr("class");
    $("#selfPwd").removeAttr("class");
    $("#selfCollect").removeAttr("class");
    $("#selfStory").removeAttr("class");
    $("#selfDiscuss").removeAttr("class");
    $("#userfollow").removeAttr("class");
    $("#userfollower").removeAttr("class");
    $("#selfMsg").removeAttr("class");
    $("#"+click).attr("class","active");
}
function getUserInfo() {
    $("#infoBox").load('selfInfo.html');
}
function getPwd() {
    $("#infoBox").load('changePWD.html');
}
function getPortrait() {
    $("#infoBox").load('upload.html');
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