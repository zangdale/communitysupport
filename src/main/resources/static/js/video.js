//获取标题栏展示的用户名
window.onload = function () {
    //DrawTable(null);
    console.log("do get user name");
    $.ajax({
        type: "get",
        url: "/getvideo",
        dataType: "json",
        success: function (res) {
            console.log(res);
            //alert(res);
            if (res.code === 200) {
                var list = res.data.videos;

                for(var i = 0;i < list.length;i++){
                    $('#allbox').append(
                        " <div class=\"mdui-card video mdui-center box\">\n" +
                        "            <video class=\"video mdui-center\" src=\" "+ list[i].vurl+" \" controls>\n" +
                        "\n" +
                        "            </video>\n" +
                        "            <div class=\"mdui-text-center\">\n" +
                        "                <div class=\"mdui-typo-title mdui-color-blue-grey title\">\n" +
                        "                    <h3 class=\"mdui-text-color-amber-a700 \">\"" +list[i].vname+"\"</h3>\n" +
                        "                </div>\n" +
                        "               <span class=\"mdui-text-color-orange-800 \">视频类型：</span>\n" +
                        "                <div class=\"mdui-chip video-type \">\n" +
                        "                <span class=\"mdui-chip-title \">少儿</span>\n" +
                        "\n" +
                        "                </div>\n" +
                        "                <div class=\"mdui-chip  video-type \">\n" +
                        "                    <span class=\"mdui-chip-title \">\"" +list[i].vtype+"\"</span>\n" +
                        "\n" +
                        "                </div>\n" +
                        "                <div class=\"mdui-chip  video-type \">\n" +
                        "                    <span class=\"mdui-chip-title \">健康</span>\n" +
                        "\n" +
                        "                </div>\n" +
                        "                <div><h4>\n" +
                        "                    <span class=\"mdui-text-color-pink-700\">播放数：</span>\n" +
                        "                    <span class=\"mdui-text-color-purple-200\">\"" +(600+i)+"\"</span><br><br>\n" +
                        "                    <span class=\"mdui-text-color-orange-200\">评论：</span>\n" +
                        "                    <span class=\"mdui-text-color-red-a700\">\"" +(500+i)+"\"</span>\n" +
                        "                </h4></div>\n" +
                        "            </div>\n" +
                        "            <!-- 视频页面-->\n" +
                        "        </div>"

                    );
                }
            } else {

            }
        },
        error: function () {
            document.getElementById('show_account').innerText = "请登录";
        }
    });
    $.ajax({
        type: "get",
        url: "/getvideo",
        dataType: "json",
        success: function (res) {
            console.log(res);
            if (res.code === 200) {
                DrawVideo(res.data);
            } else {
                document.getElementById('show_account').innerText = "请登录";
                mdui.snackbar({
                    message: '没有登录',
                    timeout: 2000,
                    onClosed: function () {
                        document.getElementById('show_account').innerText = "请登录";
                    }
                });
            }
        },
        error: function () {
            document.getElementById('show_account').innerText = "请登录";
        }
    });
};
function DrawVideo(data) {
    //获取video的数组
    var videos=data.videos;


}
