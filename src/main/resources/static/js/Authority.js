function PageValidation() {
    $.getJSON("http://localhost:8080/PageValidation",{},function (data) {
        if(data!=1){
            alert("无此权限");
        }else{
            location.href='http://localhost:8080/selectList/1/maintain';
        }
    })
}