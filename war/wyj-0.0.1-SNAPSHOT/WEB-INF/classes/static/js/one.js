// pure JS

if ((sessionStorage.getItem("username"))==null){
    $("#gwc").css("display","none");
}
else {
    $("#gwc").css("display","inline");
    $('.kjdl').css("display","none")
}

var elem = document.getElementById('mySwipe');
window.mySwipe = Swipe(elem, {
    // startSlide: 4,
    auto: 3000,
    continuous: true,
    // disableScroll: true,
    // stopPropagation: true,
    callback: function(index, element) {
        //alert(index);
    },
    // transitionEnd: function(index, element) {}
});

// with jQuery
window.mySwipe = $('#mySwipe').Swipe().data('Swipe');
$(document).ready(function () {
    $("#spanone").html(sessionStorage.getItem("username")+",&nbsp;&nbsp;")
    test();
    console.log(sessionStorage.phone);
})
function test() {
    $.get("http://localhost:8080/selectByHot",function (data) {
        var obj = eval(data);
        console.log(obj);
        $.each(obj,function (index,item) {
            console.log("++++++"+item.goods_id)
            $(".pro_list:first").append(
                "<li data-id='"+item.goods_id+"'>"+
                "<a href='#'>"+
                "<div class='pro_pic'>"+
                "<img src='"+item.file_id+"'/>"+
                "<p class='pro_title'>"+item.goods_name+"</p>"+
                "</div>"+
                "<div class='pro_info'"+
                "<span class='xj'>￥"+item.price+"" +
                "<span class='yj'>￥"+item.discount+"</span>"+
                "</span>"+
                "<span class='sczg'></span>"+
                "</div>"+"</a>"+"</li>"
            );
            $(".fl_list li").each(function () {
                $(this).click(function () {
                    console.log(this.dataset.type);
                    sessionStorage.setItem("type",this.dataset.type);
                    window.location="http://localhost:8080/pro_list";
                })
            })
            $(".pro_list:first li").on("click",function () {
                alert("dddddd"+sessionStorage.goods_id);
                sessionStorage.goods_id=this.dataset.id;
                window.location="http://localhost:8080/pro_detail"
            })


        })
    })
    $(".nav_dd a").click(function () {
        if (sessionStorage.getItem("username")==null){
            alert("请先登录");

        }else {
            window.location="http://localhost:8080/wddd"
        }
    })
}

