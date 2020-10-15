$("document").ready(function () {
    draw();
})

function draw() {
    var canvas=document.getElementById("avgCanvas");
    if(!canvas.getContext)return;
    var ctx=canvas.getContext("2d");
    ctx.fillStyle="#FF0000";
    ctx.strokeRect(0,0,800,600);
    
}
