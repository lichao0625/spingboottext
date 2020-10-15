function chooseImage() {
    $("#upfile").change(function(e) {
        var imgBox = e.target;
        uploadImg($('#bcd'), imgBox)
    });

    function uploadImg(element, tag) {
        var file = tag.files[0];
        var imgSrc;
        if (!/image\/\w+/.test(file.type)) {
            alert("看清楚，这个需要图片！");
            return false;
        }
        var reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = function() {
            console.log(this.result);
            imgSrc = this.result;
            var imgs = document.createElement("img");
            $(imgs).attr("src", imgSrc);
            element.append(imgs);
        };
    }
}
function upLoad(){
    var fd = new FormData();
    fd.append("upload", 1);
    fd.append("file", $("#upfile").get(0).files[0]);
    fd.append("userId", userId);
    $.ajax({
        url: "http://localhost:8080/upload",
        type: "POST",
        processData: false,
        contentType: false,
        data: fd,
        success: function(d) {
            $.cookie("stroy",JSON.stringify(d.data),{ expires: 7 });
            $('#userImg').attr('src', "/spingboottext/templates"+d.data.portrait);
            var s=$.cookie("stroy");
            console.log(d);
        }
    });
}

function getPage(){
    return 13;
}