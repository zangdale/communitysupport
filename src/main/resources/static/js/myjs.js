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
                document.getElementById('show_account').innerText=data.uentity.uname;
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
    var a = $("#input_account");
    var p = $("#input_passwd");
    $.ajax({
        type:"post",
        url: "/login",
        data: {
            uaccount:a,
            upasswd:p
        },
        dataType:"json",
        success:function (data) {
            console.log(data.ok);
            alert(data);
            if (data.ok == 1){
                mdui.snackbar({
                    message: '登陆成功',
                    timeout: 2000,
                    onClosed: function () {
                        window.location.reload();
                    }
                });
            } else {
                mdui.snackbar({
                    message: '账号或密码错误',
                    timeout: 3000
                });
            }
        }
    })
    console.log('confirm');
});


