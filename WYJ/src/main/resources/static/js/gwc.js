var a=0;
$(document).ready(function () {
    findAddress()
    test();
});

function findAddress() {
    var id = sessionStorage.getItem("uid");
     $.get("http://localhost:8080/selectUserAddressById",{user_id:(Number)(id)},function (data) {
             console.log(data);
             $('.name').text("姓名: "+data.user_name);
             $('.addr').text("地址: "+data.address);
             $('.tel').text("电话: "+data.phone)
         }
     )
}
function test() {

    $.get("http://localhost:8080/selectOrderByUid", {uid: (Number)(sessionStorage.getItem("uid"))}, function (data) {
        $.each(data,function (index,item) {
            var b =item.price;
            var c= item.count;
            a += b*c;
            $(".gwc_list").append(
                "<li id='a' style='position:relative'>"+
                "<a href='#' class='sc' data-oid='"+item.oid+"'><img src='images/scdz.png'/></a>" +
                " <div class='gwc_title'>"+item.aname+"</div>\n" +
                " <ul class='gwc_info'>\n" +
                "        <li><span class='label'>当前售价：</span><span class='red'>￥"+item.price+"</span></li>" +
                "        <li><span class='label'>商品数量：</span><span>"+item.acount+"</span></li>" +
                "        <li style='border:none;overflow:hidden'>" +
                "        <span class='label' style='display:inline-block; float:left'>选购数量：</span>" +
                "        <input value='—' type='button' class='plus' data-count='"+item.count+"' data-oid='"+item.oid+"'/>" +
                "        <input value='"+item.count+"' type='text' class='in'/>" +
                "        <input value='+' type='button' class='add' data-count='"+item.count+"' data-oid='"+item.oid+"'/></li>" +
                " </ul></li>"+
                " <li style='position:relative'>" +
                "          <textarea style='min-height:80px; width:96%; line-height:22px; margin:4px auto; background:#fff; border:none'>请输入备注信息</textarea>\n" +
                "</li>"
            )

        })
        $(".b_nav").append("<span class='gwc_zj'>总价：￥"+a+"元</span><span><a href='#' class='gwc_js'>结算</a></span>")


        //删除
        $("#a a").click(function () {
            $.get("http://locahost:8080/removed", {oid: (Number)(this.dataset.oid)}, function (data) {
                console.log(data)
                window.location="http://localhost:8080/gwc"
            })
        })

        //更新商品数量
        $(".add").click(function () {
            var ct=parseInt(this.dataset.count)
            ct+=1;

            console.log("ct&add:"+ct);
            console.log("oid&add:"+this.dataset.oid);
            $.get("http://localhost:8080/updataOrder",{count:ct,oid:this.dataset.oid},function (data) {
                console.log("count:"+ct);
                window.location="http://localhost:8080/gwc"
            })
        })
        $(".plus").click(function () {
            var oid=this.dataset.oid
            var ct=parseInt(this.dataset.count)
            ct-=1;
            console.log(ct)
            $.get("http://localhost:8080/updataOrder",{count:ct,oid:oid},function (data) {
                if(ct<1){
                    $.get("http://localhost:8080/remove", {oid: oid}, function (data) {
                       alert("+++"+data);
                        window.location="http://localhost:8080/gwc"
                    })
                }else {
                    data?window.location="http://localhost:8080/gwc":"更新失败";
                }
            })
        })

        //结算
        $('.gwc_js').click(function () {
            sessionStorage.setItem("gwc_js",a);
            window.location = "http://localhost:8080/";
        })
    })
}
