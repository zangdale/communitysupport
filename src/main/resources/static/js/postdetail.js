//获取标题栏展示的用户名
window.onload=function(){
    console.log("do get user name");
    $.ajax({
        type:"get",
        url: "/getsession",
        dataType:"json",
        success:function (res) {
            console.log(res);
            //alert(res);
            if (res.code === 200){
                document.getElementById('show_account').innerText=res.data.uname;
            } else {
                document.getElementById('show_account').innerText="请登录";
            }
        },
        error:function () {
            document.getElementById('show_account').innerText="请登录";
        }
    })

}

//打开回帖对话框
var inst = new mdui.Dialog('#dialog_post');

document.getElementById('button_post').addEventListener('click', function () {
    inst.open();
});

//获得回帖列表
window.onload = function () {
    console.log("do get answer list");
    $.ajax({
        type: "get",
        url: "/getquestion",
        data: {
            qid:getQueryVariable("qid")
        },
        dataType: "json",
        success: function (res) {
            console.log(res);
            //alert(res);
            if (res.code === 200) {
                var list = res.data.questions;
                for (var i = list.length-1; i >= 0 ; i--) {
                    $('#list_answers').append(
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
                        $('#list_answers').append("<li class=\"mdui-divider mdui-m-y-0\"></li>");
                    }
                }

            }
        },
        error:function () {
            $('#list_answers').append("<div class=\"mdui-list-item-title mdui-text-center mdui-btn-bold mdui-m-t-2 mdui-m-b-2\">网络错误</div>");
        }
    })
};

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
        $('#list_answers').append(
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
            $('#list_answers').append("<li class=\"mdui-divider mdui-m-y-0\"></li>");
        }
    }
});

function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}

$(document).ready(function () {
    console.log("this: "+window.location.search.substring(1));
})