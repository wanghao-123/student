function reg() {
   var username=$("input[name=username]").val();
   var password=$("input[name=password]").val();
   var confirmPassword=$("input[name=confirmPassword]").val();
   if(username==null||username==""){
       alert("请输入用户名")
   }else if(password==null||password==""){
       alert("请输入密码")
   }else if(confirmPassword==null||confirmPassword==""){
       alert("请再次输入密码")
   }else if(confirmPassword!=password){
       alert("两次输入的密码不正确")
   }else{
       $.getJSON("addUsers",{username:username,password:password},function (data) {
           if(data==1){
               alert("注册成功")
               location.href='/';
           }else{
               alert("注册失败")
           }
       })
   }
   
}
function inspect() {
    var username=$("input[name=username]").val();
    $.getJSON("inspectName",{username:username},function (data) {
            if(data==1){
                alert("用户名已存在");
                $("input[name=username]").val("");
            }
    })
}