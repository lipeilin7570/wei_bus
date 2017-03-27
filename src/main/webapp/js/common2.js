function writeCookie(name, value, hours){
        var expire = "";
        if(hours != null){
            expire = new Date((new Date()).getTime() + hours * 3600000);
            expire = "; expires=" + expire.toGMTString();
        }
        //写cookie时务必设置cookie保存目录，防止多个同名值的出现
        document.cookie = name + "=" + escape(value) + expire+";path=/";
    }
    function readCookie(name){
        var cookieValue = "";
        var search = name + "=";
        if(document.cookie.length > 0){
            var offset = document.cookie.indexOf(search);
            if (offset != -1){
                offset += search.length;
                var end = document.cookie.indexOf(";", offset);
                if (end == -1) end = document.cookie.length;
                cookieValue = unescape(document.cookie.substring(offset, end))
            }
        }
        return cookieValue;
    }