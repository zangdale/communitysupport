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