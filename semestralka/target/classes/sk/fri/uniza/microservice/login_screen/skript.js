
<script>
function startTime() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();
    var day = today.getDate();
    var month = today.getMonth()+1;
    var year = today.getYear() + 1900;
    var dni = ["Nedeľa" , "Pondelok" , "Utorok" , "Streda" , "Štvrtok" , "Piatok" , "Sobota"];
    m = checkTime(m);
    s = checkTime(s);
    document.getElementsByClassName('cas')[0].innerHTML =
        h + " : " + m + " : " + s;
    document.getElementsByClassName('datum')[0].innerHTML = dni[today.getDay()] + ", " +
        day + ". " + month + ". " + year;
    var t = setTimeout(startTime, 500);
}



function checkTime(i) {
    if (i < 10) {i = "0" + i};  // add zero in front of numbers < 10
    return i;
}

function blikaj(){
    setInterval(function () {
        $(".cas").fadeOut(1250);
        $(".cas").fadeIn(1250);
    },2500);

}

function jump() {
    var x = Math.random();
    var y = Math.random();
    $(".beam").animate({
        top : x*100 + "%",
        left : y*100 + "%",
    },1000);

}

function behaj(){

    setInterval(function () {
        var x = Math.random();
        var y = Math.random();
        $(".beam1").animate({
            top : x*100 + "%",
            left : y*100 + "%",
        },10000);
    },100);

    setInterval(function () {
        var x = Math.random();
        var y = Math.random();
        $(".beam2").animate({
            top : x*100 + "%",
            left : y*100 + "%",
        },10000);
    },200);

    setInterval(function () {
        var x = Math.random();
        var y = Math.random();
        $(".beam3").animate({
            top : x*100 + "%",
            left : y*100 + "%",
        },10000);
    },300);

    setInterval(function () {
        var x = Math.random();
        var y = Math.random();
        $(".beam4").animate({
            top : x*100 + "%",
            left : y*100 + "%",
        },10000);
    },400);

    setInterval(function () {
        var klon = $(".lietajucamacka").clone();
        $(".lietajucamacka").animate({
                top: "20%",
                left: "-20%",
            }, 5000,
            function () {$(".lietajucamacka").replaceWith(klon);});
    },10000);

    setInterval(function () {
        $(".stojacamacka").animate({
            bottom: "15%",
        }, 2000, function () {
            $(".stojacamacka").animate({
                bottom: "-21%",
            });
    });
    }, 30000);
}

$(document).ready(function(){
    blikaj();
    behaj();
});
</script>