var SALT = "1a2b3c4d";

$("#id_submit_btn").on("click", function () {
    console.log("lalalaala");
    var inputPass = $("#inputPassword").val();

    //下面两行必须和MD5Util.java中的一致
    // var SALT = "1a2b3c4d";
    var str = "" + SALT.charAt(0) + SALT.charAt(2) +
        inputPass +
        SALT.charAt(5) + SALT.charAt(4);

    var password = md5(str);

    $.ajax({
        type: 'POST',
        url: '/login/do_login',
        data: { //可选。映射或字符串值。规定连同请求发送到服务器的数据。
            mobile: $("#inputMobile").val(),
            password: password
        },
        success: function (data) {//可选。请求成功时执行的回调函数。
            console.log("login 发送成功");
            console.log(data)
            // todo: 返回码判断,数据库放一个正确的试一下，下一课2-4
        },
        //dataType: dataType //可选。规定预期的服务器响应的数据类型。默认执行智能判断（xml、json、script 或 html）。
        error: function () {

        }
    });
});