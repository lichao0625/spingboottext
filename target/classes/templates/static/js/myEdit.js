function getPage(){
    return 2;
}
var stroy;
var hasBranch=false;
$("document").ready(function () {
    $("#branchCreate").click( function () {
        if(stroy!=null)
            window.parent.location.href="branchCreate.html?data="+stroy.id;
        else
            alert("请先保存故事!");
    })
    setTags()
    function saveBranch(isEnd) {
        var range = window.getSelection().getRangeAt(0);
        var note="";
        var title=$('#rich-editor').html();
        title=title.substring(range.startOffset,range.endOffset);
        var json={"title":title,"stroys":note,"tag":"","userId":stroy.createBy,"type":0,"showType":0,"createBy":stroy.createBy,"isBranch":true,"followId":stroy.id,"isEnd":isEnd};
        var cookies=$.cookie("stroy");

        $.post(url+"stroy/addBranch",json,function (data,status) {
            if(data.msg=="成功"){
                bool = document.execCommand("createLink",false, "stroy.html?data="+data.data.id);
                if(bool){}
                bool = document.execCommand("foreColor",false, "#00ccff");
                text=$("#rich-editor").html();
                if(text=="A"){}
                saveStroy();
            }else{
                alert("创建失败:"+data.msg);
            }
        })
    }
    function saveRole() {
        var range = window.getSelection().getRangeAt(0);
        var name=$('#rich-editor').html();
        name=name.substring(range.startOffset,range.endOffset);
        var json={"age":18,"name":name,"str":10,"gender":1,"type":0,"userId":stroy.createBy};
        var cookies=$.cookie("stroy");
        $.post(url+"role/add",json,function (data,status) {
            if(data.msg=="成功"){
                bool = document.execCommand("createLink",false, "role.html?data="+data.data.id);
                if(bool){}
                bool = document.execCommand("foreColor",false, "#ff5142");
                text=$("#rich-editor").html();
                if(text=="A"){}
                saveStroy();
            }else{
                alert("创建失败:"+data.msg);
            }
        })
    }
    function saveAddress() {
        var range = window.getSelection().getRangeAt(0);
        var name=$('#rich-editor').html();
        name=name.substring(range.startOffset,range.endOffset);
        var json={"dec":18,"name":name,"eco":10,"tec":1,"rel":0,"createBy":stroy.createBy};
        var cookies=$.cookie("stroy");
        $.post(url+"address/add",json,function (data,status) {
            if(data.msg=="成功"){
                bool = document.execCommand("createLink",false, "address.html?data="+data.data.id);
                if(bool){}
                bool = document.execCommand("foreColor",false, "#2873ff");
                text=$("#rich-editor").html();
                if(text=="A"){}
                saveStroy();
            }else{
                alert("创建失败:"+data.msg);
            }
        })
    }
    function saveProduct() {
        var range = window.getSelection().getRangeAt(0);
        var name=$('#rich-editor').html();
        name=name.substring(range.startOffset,range.endOffset);
        var json={"name":name,"type":10,"power":1,"createBy":stroy.createBy};
        var cookies=$.cookie("stroy");
        $.post(url+"product/add",json,function (data,status) {
            if(data.msg=="成功"){
                bool = document.execCommand("createLink",false, "product.html?data="+data.data.id);
                if(bool){}
                bool = document.execCommand("foreColor",false, "#b0ff13");
                text=$("#rich-editor").html();
                if(text=="A"){}
                saveStroy();
            }else{
                alert("创建失败:"+data.msg);
            }
        })
    }
    var startOffset;
    var endOffset;
    var linkName;
    $("#addDesc").on('show.bs.modal',function () {
        //var dialog=$("#addDesc");
        //dialog.modal('show');
        var name=$("#name");
        var range = window.getSelection().getRangeAt(0);
        var nameText=$('#rich-editor').html();
        startOffset=range.startOffset;
        endOffset=range.endOffset;
        linkName=nameText.substring(startOffset,endOffset);
        name.val(linkName);
    })
    $("#submit").click(function () {
        //var range = window.getSelection().getRangeAt(0);
        var name=$('#name').val();
        var des=$('#desc').val();
        var cookies=$.cookie("stroy");
        var userId=0;
        if(cookies!=null&&cookies.length>0){
            var user=JSON.parse(cookies);
            userId=user.id;
        }
        $("#addDesc").modal('hide');
        var linkVal="<a style='#2873ff' title=" +name+
            "            data-container='body' data-toggle='popover' data-placement='bottom'" +
            "            data-content="+des+">"+name+"</a>";
        var text=$('#rich-editor').html();
        var start=text.substring(0,startOffset);
        var end=text.substring(endOffset,text.length);
        text=start+linkVal+end;
        $("#rich-editor").html(text);
        text=$("#rich-editor").html();
        if(text=="A"){}
        $("[data-toggle='popover']").popover();
    });

    $("#addBranth").click(function () {
        var dialog = document.getElementById("dialog1");
        dialog.showModal();
        //checkText("请选择需要设置为分支的文字",saveBranch)
    });
    $("#addRole").click(function () {
        checkText("请选择需要设置为角色的文字",saveRole)
    });
    $("#addAddress").click(function () {
        checkText("请选择需要设置为位置的文字",saveAddress)
    })
    $("#addProduct").click(function () {
        checkText("请选择需要设置为道具的文字",saveProduct)
    })
    function checkText(note,saveFun) {
        var range = window.getSelection().getRangeAt(0);
        if(range.endOffset-range.startOffset<=0){
            alert(note);
            return;
        }
        if (stroy == null) {
            hasBranch=true;
            saveStroy();
        } else
            saveFun(false);
    }
    function updateStroy() {
        var note=$('#rich-editor').html();
        var title=$('#rich-title').html();
        var cookies=$.cookie("stroy");
        var userId=0;
        if(cookies!=null&&cookies.length>0){
            var user=JSON.parse(cookies);
            userId=user.id;
        }
        var stroyType = $('input[name=stroyType][checked]').val();
        var showType=$('input[name=showType][checked]').val();
        var addAble=$('input[name=showType][checked]').val();
        var datas={"title":title,"stroy":note,"id":stroy.id};
        $.post(url+"stroy/updateStroy",datas,function (data,status) {
            if(data.msg=="成功"){
                alert("更新成功");
                window.parent.location.href="index.html";
            }else{
                alert("更新失败:"+data.msg);
            }
        });
    }
    function saveStroy(){
        if(stroy!=null){
            updateStroy();
            return;
        }

        var title=$('#rich-title').html();
        var note=$('#rich-editor').html();
        var cookies=$.cookie("stroy");
        var userId=0;
        if(cookies!=null&&cookies.length>0){
            var user=JSON.parse(cookies);
            userId=user.id;
        }
        var stroyType = $('input[name=stroyType][checked]').val();
        var showType=$('input[name=showType][checked]').val();
        var addAble=$('input[name=showType][checked]').val();
        var json={"title":title,"stroys":note,"tag":choiseTag,"userId":userId,"type":stroyType,"showType":showType,"createBy":userId,"isBranch":false,"editType":addAble};
        $.post(url+"stroy/add",json,function (data,status) {
            if(data.msg=="成功") {
                stroy = data.data;
                if (hasBranch) {
                    saveBranch(false);
                    hasBranch = false;
                }
                window.parent.location.href="index.html";
            }else
                alert("创建失败:"+data.msg);
        });
    }
    $("#saveText").click(function () {
        saveStroy();
    })
    $("#storyTag").change(function(){
        var checkText=$("#storyTag").find("option:selected").text();
        if(choiseTag!=null&&choiseTag.indexOf(checkText)>-1)
            return;
        choiseTag+=checkText+",";
        $("#tags").append("<button type=\"button\" class=\"btn btn-default btn-sm\" id='"+checkText+"'>\n" +
            "<span style=\"color: rgb(212, 106, 64);\" onclick='remove(\""+checkText+"\")' class=\"glyphicon glyphicon-remove\" ></span> "+checkText+"\n" +
            "</button>")

    });
})

function remove(id) {
    $("#"+id).remove();
    choiseTag=choiseTag.replace(id+",","");
    console.log(choiseTag)
}
var choiseTag="";
function setTags() {
    $.get(url+"tag/getTags",function (data,status) {
        if(data.msg=="成功"){
            tags=data.data;
            for(var tag in tags){
                $("#select_id").append("<option value='"+tag.id+"'>tag.tag</option>");
            }
        }
    })
}

