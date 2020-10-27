function AddOption() {
    var x = 999;
    var y = 1;
    var nums=parseInt(Math.random() * (x - y + 1) + y);
    var p="<P id=\'"+nums+"\'>" +
        "<INPUT name=\"options\" class=\"input-text\" type=\"text\">" +
        "<a href=\"JavaScript:RemoveOption("+nums+")\">删除</a>" +
        "</P>";
    $("#voteoptions").append(p);
}
function RemoveOption(ids) {
    $("#"+ids).remove();
}
function InsertSub() {
    var bool=true;
    var s_title=$("input[name=s_title]").val();
    var s_type=$("input[name=s_type]:checked").val();
    var arr=new Array();
    $.each($("input[name=options]"),function () {
         arr.push($(this).val())
    })
    for(var i=0;i<arr.length;i++){
        if(arr[i]==""||arr[i]==null){
            bool=false;
        }
    }
    if(s_title==""||s_title==null){
        alert("请填写标题")
        return false;
    }else if(bool!=true){
        alert("选项不能为空")
        return false;
    }else{
        $.getJSON("selectTitle",{s_title:s_title},function (data) {
             if(data>0){
                 alert("已存在该投票");
                 $("input[name=s_title]").val("");
             }else{
                 var flage=true;
                 var nary=arr.sort();
                 for(var i=0;i<arr.length;i++){
                     if (nary[i]==nary[i+1]){
                         flage=false;
                         break;
                     }
                 }
                 if(!flage){
                     alert("存在重复选项！")
                 }else{
                     $.getJSON("InserSubject",{arr:arr,s_title:s_title,s_type:s_type},function (data) {
                         if(data==0){
                             alert("添加失败")
                         }else if(data==1){
                             alert("选项有误")
                         }else{
                             alert("添加成功")
                             location.href='selectList/1/ordinary';
                         }
                     })
                 }
             }
        })
    }
}
