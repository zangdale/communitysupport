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

//确定回复
var dialog = document.getElementById('dialog_post');

dialog.addEventListener('confirm.mdui.dialog', function () {
    $.ajax({
        type:"post",
        url: "/addanswer",
        data: {
            qid:getQueryVariable("qid"),
            atext:$("#input_test").val()
        },
        dataType:"json",
        success(res) {
            //alert(res);
            console.log(res);
            if (res.code === 200){
                console.log("ok, next is pop");
                mdui.snackbar({
                    message: '回复成功',
                    timeout: 1500,
                    onClosed: function () {
                        window.location.reload();
                    }
                });
            } else {
                console.log("not ok, next is pop");
                mdui.snackbar({
                    message: '回复失败',
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
                var list = res.data;

                //问题
                $('#an_title').text(list.question.qtitle);
                $('#an_text').text(list.question.qtext);
                $('#an_name').text(list.question.uName);
                $('#an_date').text(renderTime(list.question.qdate));

                //答案
                for (var i = 0; i < list.answers.length ; i++) {
                    $('#list_answers').append(
                        " <div class=\"mdui-list\">\n" +
                        "                        <div class=\"mdui-p-l-2 mdui-p-r-2\">\n" +
                        "                            <p class=\"mycontent myquestioncard\">"+list.answers[i].atext+"</p>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"mdui-card-actions mdui-p-t-2 mdui-p-b-2 mdui-p-l-2 mdui-p-r-2 mycarddate\">\n" +
                        "                            <div class=\"mdui-card-primary-subtitle mdui-m-r-1 \">"+list.answers[i].uName+"</div>\n" +
                        "                            <div class=\"mdui-card-primary-subtitle \">"+renderTime(list.answers[i].adate)+"</div>\n" +
                        "                        </div>\n" +
                        "                    </div>"
                    );
                    if (i!=list.answers.length-1) {
                        $('#list_answers').append("<div class=\"mdui-divider mdui-m-y-0\"></div>");
                    }
                }

            }
        },
        error:function () {
            $('#list_answers').append("<div class=\"mdui-list-item-title mdui-text-center mdui-btn-bold mdui-m-t-2 mdui-m-b-2\">网络错误</div>");
        }
    })
};

/*
//debug
$(document).ready(function () {
    var list = {
        "question":{
            "uName":"1",
            "qid":0,
            "qtitle":"测试",
            "qtext":"测试",
            "quserid":1,
            "qdate":"2019-07-29T17:16:50.000+0000"
        },
        "answers":[
            {
                "uName":"1",
                "aid":0,
                "atext":"哈哈哈哈",
                "aquestionid":0,
                "auserid":1,
                "adate":"2019-07-29T17:17:59.000+0000"
            },
            {
                "uName":"1",
                "aid":1,
                "atext":"1",
                "aquestionid":0,
                "auserid":2,
                "adate":"2019-07-29T20:37:27.000+0000"
            }
        ]
    };

    //问题
    $('#an_title').text(list.question.qtitle);
    $('#an_text').text(list.question.qtext);
    $('#an_name').text(list.question.uName);
    $('#an_date').text(renderTime(list.question.qdate));

    //答案
    for (var i = 0; i < list.answers.length ; i++) {
        $('#list_answers').append(
           " <div class=\"mdui-list\">\n" +
            "                        <div class=\"mdui-p-l-2 mdui-p-r-2\">\n" +
            "                            <p class=\"mycontent myquestioncard\">"+list.answers[i].atext+"</p>\n" +
            "                        </div>\n" +
            "                        <div class=\"mdui-card-actions mdui-p-t-2 mdui-p-b-2 mdui-p-l-2 mdui-p-r-2 mycarddate\">\n" +
            "                            <div class=\"mdui-card-primary-subtitle mdui-m-r-1 \">"+list.answers[i].uName+"</div>\n" +
            "                            <div class=\"mdui-card-primary-subtitle \">"+renderTime(list.answers[i].adate)+"</div>\n" +
            "                        </div>\n" +
            "                    </div>"
        );
        if (i!=list.answers.length-1) {
            $('#list_answers').append("<div class=\"mdui-divider mdui-m-y-0\"></div>");
        }
    }
});
*/

//取url参数
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

function renderTime(date) {
    var date = new Date(date).toJSON();
    return new Date(+new Date(date) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
};