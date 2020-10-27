function CastVote() {
    var v_sid=$("#title").attr("value");
    var v_uid=$("input[name=userid]").val();
    var array=new Array();
    $.each($("input[name=options]:checked"),function () {
        array.push($(this).val())
    })
    if(array==null||array==""){
        alert("请选择至少一项")
    }else{
        $.getJSON("http://localhost:8080/CheckTheVote",{"subject.sid":v_sid,"users.userid":v_uid},function (data) {
           if(data>0){
               alert("当前用户已投过该题目的选票")
               location.href='http://localhost:8080/selectList/1/ordinary';
           }else{
               $.getJSON("http://localhost:8080/addVote",{array:array,"subject.sid":v_sid,"users.userid":v_uid},function (data) {
                   if(data>0){
                       alert("投票成功")
                       location.href='http://localhost:8080/selectList/1/ordinary';
                   }else{
                       alert("投票失败")
                   }
               })
           }
        })
    }

}