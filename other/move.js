var speed;

//获取非行间样式的方法
function getStyle(obj, name) {
    if (obj.currentStyle) {
        return obj.currentStyle[name];
    }
    else {
        return getComputedStyle(obj, false)[name];
    }
}

function startMove(obj, attr, iTarget) {
    clearInterval(obj.timer);
    obj.timer = setInterval(function () {
        var cur;
        if (attr == "opacity") {
            cur = Math.round(parseFloat(getStyle(obj, attr)) * 100);
        }
        else {
            cur = parseInt(getStyle(obj, attr));
        }
        //定义缓冲运动
        speed = (iTarget - cur) / 7;
        speed = speed > 0 ? Math.ceil(speed) : Math.floor(speed);
        if (cur == iTarget) {
            clearInterval(obj.timer);
        } else {
            //当框架需要处理透明度问题时，用判断的方式单独处理
            if (attr == "opacity") {
                obj.style.filter = "alpha(opacity:'+(cur + speed)+')";
                obj.style.opacity = (cur + speed) / 100;
            }
            else {
                obj.style[attr] = cur + speed + "px";
            }
        }
    }, 30);
}