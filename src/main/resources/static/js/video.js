//获取标题栏展示的用户名
window.onload = function () {
    //DrawTable(null);
    console.log("do get user name");
    $.ajax({
        type: "get",
        url: "/getsession",
        dataType: "json",
        success: function (res) {
            console.log(res);
            //alert(res);
            if (res.code === 200) {
                document.getElementById('show_account').innerText = res.data.uname;
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
