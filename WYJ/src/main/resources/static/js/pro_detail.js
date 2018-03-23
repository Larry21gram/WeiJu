$(document).ready(function () {
    console.log("type:"+sessionStorage.type)
    test();
});
function test() {
    $.get("http://localhost:8080/selectById",{id:(Number)(sessionStorage.goods_id)},function (data) {
        console.log("6++++++"+data.goods_id);
        $("#mySwipe").append(
            "<div class='swipe-wrap'>"+
            "<div>" +
            "<img src='"+data.file_id+"' height='180px' width='100%'/>" +
            "</div>"+
            "</div>"
        );
        $(".main").append(
            "<div class='jj_title'>"+data.goods_name+"</div>" +
            "     <ul class='jj_list' style='margin-bottom:48px;'>" +
            "        <li data-id='"+data.goods_id+"'>" +
            "           <ul class='jj_info'>" +
            "              <li><span class='label'>商品售价：</span><span class='red'>￥"+data.price+"</span></li>" +
            "              <li><span class='label'>商品原价：</span><span style=' color:#ccc; text-decoration:line-through'>￥"+data.discount+"</span></li>" +
            "              <li style='padding:4px 3px; overflow:hidden' class='numbar'><span class='label'>选购数量：</span>" +
            "               <input value='—' type='button' class='plus'/><input value='1' type='text' class='in' id='setnum'/>" +
            "               <input value='+' type='button' class='add'/></li>" +
            "              <li><span class='label'>赞助商：</span><span>"+data.sponsor+"</span></li>" +
            "              <li><span class='label'>商品数量：</span><span>"+data.goods_count+"</span></li>" +
            "           </ul>\n" +
            "        </li>\n" +
            "     </ul>"
        );
        var d =parseInt($("#setnum").val())
        $(".plus").click(function () {
            if(d<=1){
                alert("不能在减了")
            }else {
                console.log(d)
                d-=1
                $("#setnum").val(d)
            }
        })
        $(".add").click(function () {
            d+=1
            $("#setnum").val(d)
        })

        $(".b_nav a").on("click",function () {

            $.get("http://localhost:8080/insertOrder",{
                    aname:(data.goods_name),acount:(data.goods_count),price:(data.price),uid:(Number)(sessionStorage.getItem("uid")),count:d},
                function (key) {
                    alert(key?"添加成功":"添加失败")
                })
        })
    })
}
