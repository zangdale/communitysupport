//获取标题栏展示的用户名
window.onload = function () {
    console.log("do get user name");
    $.ajax({
        type: "get",
        url: "/getsession",
        dataType: "json",
        success: function (res) {
            console.log(res);
            //alert(res);
            if (res.code === 1) {
                document.getElementById('show_account').innerText = data.user.uname;
            } else {
                document.getElementById('show_account').innerText = "请登录";
            }
        },
        error: function () {
            document.getElementById('show_account').innerText = "请登录";
        }
    })

}

//打开发帖对话框
var inst = new mdui.Dialog('#dialog_post');

document.getElementById('button_post').addEventListener('click', function () {
    inst.open();
});

//获得问题列表
window.onload = function () {
    console.log("do get question list");
    $.ajax({
        type: "get",
        url: "/getquestionlist",
        dataType: "json",
        success: function (res) {
            console.log(res);
            //alert(res);
            if (res.code === 200) {
                var list = res.data.questions;
                for (var i = 1; i <= list.length; i++) {
                    $('#select_id').append("<option value = '" + i + "'>" + i + "</option>");
                }

            } else {
                document.getElementById('show_account').innerText = "请登录";
            }
        },
        error: function () {
            document.getElementById('show_account').innerText = "请登录";
        }
    })
}

$(document).ready(function () {
    var list = [
        {
            "uName":"1",
            "qid":0,
            "qtitle":"测试",
            "qtext":"测试",
            "quserid":1,
            "qdate":"2019-07-29T17:16:50.000+0000"
        },
        {
            "uName":"1",
            "qid":1,
            "qtitle":"测试1",
            "qtext":"承德市",
            "quserid":1,
            "qdate":"2019-07-29T17:17:23.000+0000"
        }
    ];
    for (var i = 0; i < list.length; i++) {
        $('#list_questions').append(
            "<li class=\"mdui-list-item mdui-ripple\">\n" +
            "                                <div class=\"mdui-list-item-content\">\n" +
            "                                    <div class=\"mdui-list-item-title\">"+list[i].qtitle+"</div>\n" +
            "                                    <div class=\"mdui-list-item-text mdui-list-item-one-line\">\n" +
            "                                        <span class=\"mdui-text-color-theme-text\">"+list[i].qtext+"" +
            "                                        </span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                                <div class=\"mdui-list-item-content mdui-text-right\">\n" +
            "                                    <div class=\"mdui-list-item-text\">"+list[i].uName+"</div>\n" +
            "                                    <div class=\"mdui-list-item-text mdui-list-item-one-line\">\n" +
            "                                        <span class=\"mdui-text-color-theme-text\">"+list[i].qdate.getHours()+"</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </li>"
        );
    }
})