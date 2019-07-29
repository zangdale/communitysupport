var inst = new mdui.Dialog('#dialog_login');

// method
document.getElementById('button_login').addEventListener('click', function () {
    inst.open();
});

window.onload=function(){
    console.log("do get user name");
    $.ajax({
        type:"get",
        url: "/getsession",
        dataType:"json",
        success:function (data) {
            console.log(data.ok);
            alert(data);
            if (data.ok == 1){
                document.getElementById('show_account').innerText=data.user.uname;
            } else {
                document.getElementById('show_account').innerText="请登录";
            }
        },
        error:function () {
            document.getElementById('show_account').innerText="请登录";
        }
    })

}

// event
var dialog = document.getElementById('dialog_login');

dialog.addEventListener('open.mdui.dialog', function () {
    console.log('open');
});

dialog.addEventListener('opened.mdui.dialog', function () {
    console.log('opened');
});

dialog.addEventListener('close.mdui.dialog', function () {
    console.log('close');
});

dialog.addEventListener('closed.mdui.dialog', function () {
    console.log('closed');
});

dialog.addEventListener('cancel.mdui.dialog', function () {
    console.log('cancel');
});

//登录时向后台传递信息
dialog.addEventListener('confirm.mdui.dialog', function () {
    $.ajax({
        type:"post",
        url: "/login",
        data: {
            uaccount:$("#input_account").val(),
            upasswd:$("#input_passwd").val(),
        },
        dataType:"json",
        success:function (data) {
            console.log(data.ok);
            alert(data);
            if (data.ok == 1){
                console.log("ok, next is pop");
                mdui.snackbar({
                    message: '登陆成功',
                    timeout: 2000,
                    onClosed: function () {
                        window.location.reload();
                    }
                });
            } else {
                console.log("not ok, next is pop");
                mdui.snackbar({
                    message: '账号或密码错误',
                    timeout: 3000
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


