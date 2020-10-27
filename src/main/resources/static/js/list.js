function del(id) {
    if(confirm("确定删除?")){
        $.getJSON("http://localhost:8080/delSubject",{sid:id},function (data) {
            if(data>0){
                alert("删除成功")
                location.href='http://localhost:8080/selectList/1/maintain';
            }else{
                alert("删除失败")
            }
        })
    }
}