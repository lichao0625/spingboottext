function getPage(){
    return 1;
}
var json;
var b;
$("domument").ready(function () {
    $("#branchEdit").click(function() {
        window.parent.location.href="edit.html?data="+json[0].id;
    })
    $("#branchCreate").click( function () {
        window.parent.location.href="branchCreate.html?data="+json[0].id;
    })
    var a=window.location.href.split("?")[1];
    b=a.split("=")[1];
    $.get(url+"stroy/getStroyById?id="+b+"&userId="+userId,function (data,status) {
        if(data.msg=="成功"){
            json=data.data ;
            var pointIcon="glyphicon-heart-empty";
            var watchIcon="glyphicon-star-empty";
            if(json[0].hasWatch)
                watchIcon="glyphicon-star";
            if(json[0].hasPoint)
                pointIcon="glyphicon-heart";
            var panel="<div class=\"panel panel-default\" style='margin-top: 10pt'>\n" +
                "    <div class=\"panel-heading\" >\n" +
                "        <h3 class=\"panel-title\">"+json[0].title+"</h3>\n" +
                "    </div>\n" +
                "    <div class=\"panel-body\">\n" +
                json[0].stroys +
                "    </div>\n" +
                " <div class=\"btn-group\"> <button id='talk"+json[0].id+"' type=\"button\" onclick='talkClick("+json[0].id+",\""+json[0].title+"\")' class=\"btn btn-link\" style=\"font-size: 14px\">\n" +
                "  <span  class=\"\glyphicon glyphicon-edit\"></span> "+json[0].talk+"\n" +
                "</button>" +
                "<button id='watch"+json[0].id+"' onclick='watchClick("+json[0].id+",\""+json[0].title+"\")' type=\"button\" class=\"btn btn-link\" style=\"font-size: 14px\">\n" +
                "  <span  class=\"glyphicon "+watchIcon+"\"></span> "+json[0].watch+"\n" +
                "</button>" +
                "<button id='point"+json[0].id+"' onclick='pointClick("+json[0].id+",\""+json[0].title+"\")' type=\"button\" class=\"btn btn-link\" style=\"font-size: 14px\">\n" +
                "  <span  class=\"glyphicon "+pointIcon+"\"></span> "+json[0].point+"\n" +
                "</button> </div>   "+
                "</div>";
            $("#list").html(panel);
            if(json[0].end==false)
                showBranch();
            else{
                $("#branchBox").html(branchEdit);

            }
            if(json.length==0)
                $("#note").html("没有故事");
            else
                getTalks(b);
        }else{
            $("#note").html("没有故事");
        }
        $("[data-toggle='popover']").popover();

    });
    $("#deleteSubmit").click(function () {
        var data={"id":+b,"userId":userId};
        $.post(url+"stroy/deleteStroy",data,function (data,status) {
            if(data.msg=="成功") {
                window.parent.location.href="index.html";
                $("#deleteModal").modal('hide');
            }
        })
    });
})

function getTalks(b) {
    $.get(url+"talk/getStoryTalks?storyId="+b,function (data,status) {
        if(data.msg=="成功"){
            json=data.data.list ;
            var allPanel="";
            for(var i=0;i<json.length;i++){
                var userPortrait=json[i].userPortrait;
                if(userPortrait==null)
                    userPortrait="/spingboottext/templates/timg.jpg";
                var panel="<div class=\"panel panel-default\" style='margin-top: 10pt'>\n" +
                    "    <div class=\"panel-heading\" >\n" +
                    "        <h3 class='panel-title'><img src='"+userPortrait+"' class='img-circle' width='24px' height='24px'>"+json[i].username +
                    "<a id='talkEdit"+json[i].id+"' style='margin-right: 5px' onclick='getUserTalk("+json[i].id+","+json[i].userID+","+json[i].storyName+")' class=\"nav navbar-nav navbar-right\"><span class='glyphicon glyphicon-edit'></span></a>"+"</h3>\n"+
                    "    </div>\n" +
                    "    <div class=\"panel-body\">\n" +
                    json[i].text +
                    "    </div>\n" +
                    "<div>"+setUserTalkList(json[i])+"</div>"
                    "</div>";
                allPanel+=panel;
            }
            $("#userTalkList").html(allPanel);
        }
    });
}
function setUserTalkList(json) {
    var allPanel="";
    var jsonList=json.userTalks.list;
    for(var i=0;i<jsonList.length;i++){
        var userPortrait=json.userPortrait;
        var userInfo=getUserInfo(json,jsonList[i].tUserID);
        if(userPortrait==null)
            userPortrait="/spingboottext/templates/timg.jpg";
        var panel="<div class=\"panel panel-default\" style='margin-top: 10pt;margin-left: 10pt'>\n" +
            "    <div class=\"panel-heading\" >\n" +
            "        <h3 class='panel-title'><img src='"+userInfo.userPortrait+"' class='img-circle' width='24px' height='24px'>"+userInfo.username +" 对<img src='"+userPortrait+"' class='img-circle' width='24px' height='24px'>"+jsonList[i].username +"说"+
            "<a id='talkEdit"+jsonList[i].id+"' style='margin-right: 5pt' onclick='getUserTalk("+jsonList[i].id+","+jsonList[i].userID+","+jsonList[i].storyName+")' class=\"nav navbar-nav navbar-right\"><span class='glyphicon glyphicon-edit'></span></a>"+"</h3>\n"+
            "    </div>\n" +
            "    <div class=\"panel-body\">\n" +
            jsonList[i].text +
            "    </div>\n" +
            "</div>";
        allPanel+=panel;
    }
    return allPanel;
}
function getUserInfo(json,userId) {
    var portrait;
    if(json.userID==userId){
        if(json.portrait==null)
            portrait="/spingboottext/templates/timg.jpg";
        return {"username":json.username,"userPortrait":portrait};
    }else{
        var jsonList=json.userTalks.list;
        for(var i=0;i<jsonList.length;i++){
            if(jsonList[i].userID==userId){
                if(jsonList[i].portrait==null)
                    portrait="/spingboottext/templates/timg.jpg";
                return {"username":jsonList[i].username,"userPortrait":portrait};
            }
        }
    }
    return {"username":"未知","userPortrait":"/spingboottext/templates/timg.jpg"};
}
function getUserTalk(id,tUId,sName) {
    sId=id;
    var cookies=$.cookie("stroy");
    if(cookies!=null&&cookies.length>0){
        var user=JSON.parse(cookies);
        userId=user.id;
        tUserId=tUId;
        portrait=user.portrait;
        username=user.name;
        storyName=sName;
        dialog=$("#addTalk");
        dialog.modal('show');
        userTalk=true;
    }else{ alert("请登录");}
}

function showBranch() {
    var allBranch="";
    for(var i=1;i<json.length;i++){
        var branch="    <button type=\"button\" id=\"branch"+json[i].id+"\" onclick='stroyClick("+json[i].id+")'  class=\"btn btn-success\">"+json[i].title+"</button>"
        allBranch+=branch;
    }
    var cookies=$.cookie("stroy");
    var userId=0;
    if(cookies!=null&&cookies.length>0){
        var user=JSON.parse(cookies);
        userId=user.id;
    }
    if(json[0].createBy!=userId)
        $("branchEdit").hide();
    $("#branchBox").html(allBranch);
}
function stroyClick(data) {
    window.parent.location.href="stroy.html?data="+data;
}
