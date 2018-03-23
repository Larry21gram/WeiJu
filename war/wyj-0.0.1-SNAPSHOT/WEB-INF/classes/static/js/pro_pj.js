    $(document).ready(function () {
        console.log("++++++++"+sessionStorage.goods_id);
        test();
    })
function test() {
    $.get("http://localhost:8080/selectCommentById",{id:(Number)(sessionStorage.goods_id)},function (data) {
        $.each(data,function (index,item) {
                console.log(item)
                $(".pjlist").append(
                    "<li>"+
                    "<p class='pjr'><span class='plr'>"+item.comment_user+"</span><span class='pjlx' style='display:none'>好评</span></p>"+
                    "<p class='pjnr'>"+item.content+"</p>"+
                    "<p class='plsj'>"+item.comment_time+"  14:25</p>"+
                    "</li>"
                )
            }
        )
    })
}
