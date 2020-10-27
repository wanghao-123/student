function sub() {
    var username=$("input[name=username]").val();
    var password=$("input[name=password]").val();
    if(username==null||username==""){
        alert("请输入用户名")
    }else if(password==null||password==""){
        alert("请输入密码")
    }else{
        $.getJSON("logon",{username:username,password:password},function (data) {
                if(data.length==0){
                    alert("用户名或密码错误！");
                    $("input[name=username]").val("");
                    $("input[name=password]").val("");
                }else{
                    alert("登录成功！");
                    location.href='selectList/1/ordinary';
                }
        })
    }
}