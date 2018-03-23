$(document).ready(function () {
        console.log("+++"+sessionStorage.type)
        test();
    })
function test() {
    $.get("http://localhost:8080/selectByType",{type:(Number)(sessionStorage.getItem("type"))},function (data) {
        console.log("+++"+data[0].goods_id)
        $.each(data,function (index,item) {
            console.log(item.goods_name)
            $(".pro_list").append(
                "<li data-id='"+item.goods_id+"'>"+
                "<a href='#'>"+
                "<div class='pro_pic'>"+
                "<img src='"+item.file_id+"' height='180px' width='100%'/>"+
                "<p class='pro_title'>"+item.goods_name+"</p>"+
                "</div>"+
                "<div class='pro_info'>"+
                "<span class='xj'>￥"+item.price+"<span class='yj'>￥"+item.discount+"</span></span>"+
                "<span class='sczg'> </span>"+
                "</div>"+
                "</a>"+
                "</li>"
            )
        })
        $(".pro_list:first li").on("click",function () {
            console.log("dddddd"+sessionStorage.goods_id);
            sessionStorage.goods_id=this.dataset.id;
            window.location="http://localhost:8080/pro_detail"
        })
    })
}
