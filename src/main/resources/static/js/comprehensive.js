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
            mdui.snackbar({
                message: '没有登录',
                timeout: 2000,
                onClosed: function () {
                    document.getElementById('show_account').innerText = "请登录";
                }
            });
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
        type: "post",
        url: "/addquestion",
        data: {
            qtitle: $("#input_title").val(),
            qtext: $("#input_test").val()
        },
        dataType: "json",
        success(res) {
            //alert(res);
            console.log(res);
            if (res.code === 200) {
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
        error: function (XMLHttpRequest, textStatus, errorThrown) {
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
                for (var i = list.length - 1; i >= 0; i--) {
                    $('#list_questions').append(
                        "<li class=\"mdui-list-item mdui-ripple\" id=\"question_list_child\" value=\"" + list[i].qid + "\">\n" +
                        "                                <div class=\"mdui-list-item-content\">\n" +
                        "                                    <div class=\"mdui-list-item-title\">" + list[i].qtitle + "</div>\n" +
                        "                                    <div class=\"mdui-list-item-text mdui-list-item-one-line\">\n" +
                        "                                        <span class=\"mdui-text-color-theme-text\">" + list[i].qtext + "" +
                        "                                        </span>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                                <div class=\"mdui-list-item-content mdui-text-right\">\n" +
                        "                                    <div class=\"mdui-list-item-text\">" + list[i].uName + "</div>\n" +
                        "                                    <div class=\"mdui-list-item-text mdui-list-item-one-line\">\n" +
                        "                                        <span class=\"mdui-text-color-theme-text\">" + renderTime(list[i].qdate) + "</span>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                            </li>"
                    );
                    if (i != 0) {
                        $('#list_questions').append("<li class=\"mdui-divider mdui-m-y-0\"></li>");
                    }
                }

            }
        },
        error: function () {
            $('#list_questions').append("<div class=\"mdui-list-item-title mdui-text-center mdui-btn-bold mdui-m-t-2 mdui-m-b-2\">网络错误</div>");
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
            "<li class=\"mdui-list-item mdui-ripple\" id=\"question_list_child\" value=\""+list[i].qid+"\">\n" +
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


//点击帖子进入详细信息
$('#list_questions').on("click", "#question_list_child", function () {
    console.log("this is " + $(this).val());
    window.location.href = "postdetail.html" + "?qid=" + $(this).val();
});

function renderTime(date) {
    var date = new Date(date).toJSON();
    return new Date(+new Date(date) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
};

//获得tab2的试卷
$(document).ready(function () {
    console.log("do get question list");
    $.ajax({
        type: "get",
        url: "/getonebank",
        dataType: "json",
        success: function (res) {
            console.log(res);
            //alert(res);
            if (res.code === 200) {
                var list = res.data.onebanks;
                for (var i = 0; i < list.length; i++) {
                    $('#exam_paper').append(
                        "<div class=\"mdui-m-b-4\"  name=\""+i+" \" id=\""+list[i].oid+"\">\n" +
                        "                            <p class=\"mdui-btn-bold mdui-m-r-3 mdui-text-color-grey-600\">"+(i+1)+". "+list[i].otitle+"</p>\n" +
                        "                            <form>\n" +
                        "                                <div class=\"mdui-row-xs-1\" style=\"margin-top: 5px\">\n" +
                        "                                    <div class=\"mdui-col\">\n" +
                        "                                        <label class=\"mdui-radio\">\n" +
                        "                                            <input type=\"radio\" name=\""+i+"\" value=\"1\" />\n" +
                        "                                            <i class=\"mdui-radio-icon\"></i>\n" + list[i].oanswer1 +
                        "                                        </label>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"mdui-col\">\n" +
                        "                                          <label class=\"mdui-radio\">\n" +
                        "                                            <input type=\"radio\" name=\""+i+"\" value=\"2\"/>\n" +
                        "                                            <i class=\"mdui-radio-icon\"></i>\n" + list[i].oanswer2 +
                        "                                        </label>\n" +
                        "                                    </div>\n" +
                        "                                    <div class=\"mdui-col\">\n" +
                        "                                        <label class=\"mdui-radio\">\n" +
                        "                                            <input type=\"radio\" name=\""+i+"\" value=\"3\"/>\n" +
                        "                                            <i class=\"mdui-radio-icon\"></i>\n" + list[i].oanswer3 +
                        "                                        </label>\n" +
                        "                                    </div>\n" +
                        "                                </div>\n" +
                        "                            </form>\n" +
                        "                        </div>"
                    );
                }

            }
        },
        error: function () {
            $('#exam_paper').append("<div class=\"mdui-list-item-title mdui-text-center mdui-btn-bold mdui-m-t-2 mdui-m-b-2\">网络错误</div>");
        }
    })
});


//提交tab2的试卷
$('#submit').click(function () {
    var userAn = "";
    for(var i=0; i<5;i++) {
        console.log("oid: "+$("input[name="+i+"]:checked").closest('div.mdui-m-b-4').attr("id"));
        console.log("oright: "+$("input[name="+i+"]:checked").val());
       userAn+='{"oid":'+'"'+$("input[name="+i+"]:checked").closest('div.mdui-m-b-4').attr("id")+'",'+'"oright":'+'"'+$("input[name="+i+"]:checked").val()+'"'+'}';
       if (i!=4) {
           userAn+=',';
       }
    }

    console.log(userAn);

    $.ajax({
        type: "post",
        url: "/submitonebank",
        data: {
            onebanks:userAn
        },
        dataType: "json",
        success(res) {
            //alert(res);
            console.log(res);
            if (res.code == 200) {
                console.log("ok, next is pop");
                mdui.snackbar({
                    message: '提交成功',
                    timeout: 1500,
                    onClosed: function () {
                        window.location.reload();
                    }
                });
                mdui.dialog({
                    title: '再接再厉',
                    content: '你的分数是: '+res.data.grade,
                    buttons: [
                        {
                            text: '确认',
                        }
                    ]
                });
            } else if (res.code == 200) {
                console.log("not ok, next is pop");
                mdui.snackbar({
                    message: '发布失败',
                    timeout: 1500
                });
            }
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            // 状态码
            console.log(XMLHttpRequest.status);
            // 状态
            console.log(XMLHttpRequest.readyState);
            // 错误信息
            console.log(textStatus);
        }
    })
})
/*
//debug get list
$(document).ready(function () {
    var list = [
        {
            "oid":1,
            "otitle":"所具备的可我就不付款",
            "oanswer1":"凄凄切切",
            "oanswer2":"快快快",
            "oanswer3":"快快快",
            "oright":1
        },
        {
            "oid":2,
            "otitle":"第三方看美女",
            "oanswer1":"离开了",
            "oanswer2":"2222",
            "oanswer3":"22",
            "oright":2
        },
        {
            "oid":3,
            "otitle":"经理看好你看见你",
            "oanswer1":"来看你了看见你",
            "oanswer2":"加快了节能",
            "oanswer3":"离开那里可能",
            "oright":2
        },
        {
            "oid":4,
            "otitle":"空间和个别地方警察吧",
            "oanswer1":"金花南路看见你",
            "oanswer2":"了看见那看来今年",
            "oanswer3":"看见那里看见",
            "oright":3
        },
        {
            "oid":5,
            "otitle":"尽可能看见你",
            "oanswer1":"看见那看来今年",
            "oanswer2":"看见你了;疬o",
            "oanswer3":"没了",
            "oright":2
        }
    ];
    for (var i = 0; i < list.length; i++) {
        $('#exam_paper').append(
            "<div class=\"mdui-m-b-4\"  name=\""+i+" \" id=\""+list[i].oid+"\">\n" +
            "                            <p class=\"mdui-btn-bold mdui-m-r-3 mdui-text-color-grey-600\">"+(i+1)+". "+list[i].otitle+"</p>\n" +
            "                            <form>\n" +
            "                                <div class=\"mdui-row-xs-1\" style=\"margin-top: 5px\">\n" +
            "                                    <div class=\"mdui-col\">\n" +
            "                                        <label class=\"mdui-radio\">\n" +
            "                                            <input type=\"radio\" name=\""+i+"\" value=\"1\" />\n" +
            "                                            <i class=\"mdui-radio-icon\"></i>\n" + list[i].oanswer1 +
            "                                        </label>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"mdui-col\">\n" +
            "                                          <label class=\"mdui-radio\">\n" +
            "                                            <input type=\"radio\" name=\""+i+"\" value=\"2\"/>\n" +
            "                                            <i class=\"mdui-radio-icon\"></i>\n" + list[i].oanswer2 +
            "                                        </label>\n" +
            "                                    </div>\n" +
            "                                    <div class=\"mdui-col\">\n" +
            "                                        <label class=\"mdui-radio\">\n" +
            "                                            <input type=\"radio\" name=\""+i+"\" value=\"3\"/>\n" +
            "                                            <i class=\"mdui-radio-icon\"></i>\n" + list[i].oanswer3 +
            "                                        </label>\n" +
            "                                    </div>\n" +
            "                                </div>\n" +
            "                            </form>\n" +
            "                        </div>"
        );
    }
})
 */
