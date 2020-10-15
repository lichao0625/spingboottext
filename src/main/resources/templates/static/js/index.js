
function getPage(){
    return 1;
}

$("document").ready(function () {
    isIndex=true;
    $.get(url+"stroy/findStroyByType?type=1&userId="+userId,function (data,status) {
        if(data.msg=="成功"){
            var json=data.data.list;
            var allpanel="";
            for(var i=0;i<json.length;i++){
                let pointIcon="glyphicon-heart-empty";
                let watchIcon="glyphicon-star-empty";
                if(json[i].hasWatch)
                    watchIcon="glyphicon-star";
                if(json[i].hasPoint)
                    pointIcon="glyphicon-heart";
                var userPortrait=json[i].portrait;
                if(userPortrait==null)
                    userPortrait="/spingboottext/templates/timg.jpg";
                else
                    userPortrait="/spingboottext/templates"+userPortrait;
                var panel="<div class='panel panel-default'  "+
                    "style='margin-left: 50pt;margin-right: 50pt ;margin-bottom: 10pt;margin-top: 10pt'>\n" +
                    "    <div class='panel-heading' >\n" +
                    " <a href='stroy.html?data="+json[i].id+"' class='panel-title'>"+json[i].title+"</a> "+
                    "   <a href='user.html?data="+json[i].createBy+"'  class=\"nav navbar-nav navbar-right\"  style='margin-right: 2px'><img src='"+userPortrait+"' class='img-circle' width='24px' height='24px'>"+json[i].nikeName +
                    " </a> \n" +
                    "    </div>\n" +
                    "    <div class='panel-body'>\n" +
                    json[i].stroys +

                    "    </div>\n" +
                    " <div class=\"btn-group\"> <button id='talk"+json[i].id+"' type=\"button\" onclick='talkClick("+json[i].id+",\""+json[i].title+"\")' class=\"btn btn-link\" style=\"font-size: 14px\">\n" +
                    "  <span  class=\"\glyphicon glyphicon-edit\"></span> "+json[i].talk+"\n" +
                    "</button>" +
                    "<button id='watch"+json[i].id+"' onclick='watchClick("+json[i].id+",\""+json[i].title+"\")' type=\"button\" class=\"btn btn-link\" style=\"font-size: 14px\">\n" +
                    "  <span  class=\"glyphicon "+watchIcon+"\"></span> "+json[i].watch+"\n" +
                    "</button>" +
                    "<button id='point"+json[i].id+"' onclick='pointClick("+json[i].id+",\""+json[i].title+"\")' type=\"button\" class=\"btn btn-link \" style=\"font-size: 14px\">\n" +
                    "  <span  class=\"glyphicon "+pointIcon+"\"></span> "+json[i].point+"\n" +
                    "</button> </div>   "+
                    "</div>";
                allpanel+=panel;
            }
            $("#list").html(allpanel);
            if(json.length==0)
                $("#note").html("没有故事");
        }else{
            $("#note").html("没有故事");
        }
        $("[data-toggle='popover']").popover();
    });

});

function stroyClick(data) {
    window.parent.location.href="stroy.html?data="+data;
}

