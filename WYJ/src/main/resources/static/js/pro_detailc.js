$(document).ready(function () {
    console.log("type:"+sessionStorage.type)
    test();
})
function test() {
    $.get("http://localhost:8080/selectById",{id:(Number)(sessionStorage.goods_id)},function (data) {
        console.log("id:"+data.goods_id)

        console.log(data.goods_name)
        $(".main").append(
            "<div class='images'>"+
            "<img src='"+data.file_id+"'/>"+
            "</div>"
        )

    })
}