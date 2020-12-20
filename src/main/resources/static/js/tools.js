//获取指定名称的cookie的值
function getCookie(objName) {
    var cookie = document.cookie;
    var arrStr = cookie.split("; ");
    for (var i = 0; i < arrStr.length; i++) {
        var temp = arrStr[i].split("=");

        if (temp[0] == objName) return unescape(temp[1]);
    }

    return "";
}