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

};

//打开发帖对话框
var inst = new mdui.Dialog('#dialog_post');

document.getElementById('button_post').addEventListener('click', function () {
    inst.open();
});

//点击对话框发布按钮
var dialog = document.getElementById('dialog_post');

dialog.addEventListener('confirm.mdui.dialog', function () {
    $.ajax({
        type:"post",
        url: "/addquestion",
        data: {
            qtitle:$("#input_title").val(),
            qtext:$("#input_test").val()
        },
        dataType:"json",
        success(res) {
            //alert(res);
            console.log(res);
            if (res.code === 200){
                console.log("ok, next is pop");
                mdui.snackbar({
                    message: '发布成功',
                    timeout: 1500,
                    onClosed: function () {
                        window.location.reload();
                    }
                });
            } else {
                console.log("not ok, next is pop");
                mdui.snackbar({
                    message: '发布失败',
                    timeout: 1500
                });
            }
        },
        error:function (XMLHttpRequest, textStatus, errorThrown) {
            // 状态码
            console.log(XMLHttpRequest.status);
            // 状态
            console.log(XMLHttpRequest.readyState);
            // 错误信息
            console.log(textStatus);
        }
    })
    console.log('confirm');
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
                        "                                        <span class=\"mdui-text-color-theme-text\">"+renderTime(list[i].qdate)+"</span>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                            </li>"
                    );
                    if (i!=list.length-1) {
                        $('#list_questions').append("<li class=\"mdui-divider mdui-m-y-0\"></li>");
                    }
                }

            }
        }
    })
};

/*
//debug
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
    for (var i = list.length-1; i >= 0 ; i--) {
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
            "                                        <span class=\"mdui-text-color-theme-text\">"+renderTime(list[i].qdate)+"</span>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </li>"
        );
        if (i!=0) {
            $('#list_questions').append("<li class=\"mdui-divider mdui-m-y-0\"></li>");
        }
    }
});
*/

function renderTime(date) {
    var dateee = new Date(date).toJSON();
    return new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
};
