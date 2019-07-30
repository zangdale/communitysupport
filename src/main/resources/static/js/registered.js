$(document).ready(function () {
    var inst = new mdui.Select('#select_id');
    for (var i = 1; i <= 100; i++) {
        $('#select_id').append("<option value = '" + i + "'>" + i + "</option>");
    }
    inst.handleUpdate();

})

mdui.JQ('#submit').click(function () {
    $.ajax({
        type: "post",
        url: "/register",
        data: {
            uaccount: $('#account').val(),
            upasswd: $('#password').val(),
            uname: $('#name').val(),
            uage: $('#select_id option:selected').val(),
            utel: $('#tel').val(),
            uoldtype: $("input[name='group1']:checked").val(),
            utype: $("imput[name='group2']:checked").val()
        },
        dataType: "json",
        success: function (res) {
            console.log(res.code==200);
            //alert(data);
            if (res.code == 200) {
                mdui.snackbar({
                    message: '注册成功！返回首页中...',
                    timeout: 3000,
                    onClosed: function () {
                        $(location).attr("href", "index.html");
                    }
                });
            } else {
                mdui.snackbar({
                    message: '注册失败！',
                    timeout: 3000,
                    onClosed: function () {
                        window.location.reload();
                    }
                });
            }
        }
    });
})