
<!--函数封装-->
//第一个参数为获取父容器，第二个参数为className值
function getByClass(oParent, aClass) {
    //获取该父元素下所有的相同元素
    var aEle = oParent.getElementsByTagName("*");
    //定义一个空的数组存放找到的相同className
    var aResult = [];
    for (var i = 0; i < aEle.length; i++) {
        if (aEle[i].className == aClass) {
            //找到符合条件的className就存放进数组
            aResult.push(aEle[i]);
        }
    }
    //返回数组内容
    return aResult;
}

window.onload = function () {
    var oDiv = document.getElementById("main");
    var oBtnLeft = getByClass(oDiv, "left")[0];
    var oBtnRight = getByClass(oDiv, "right")[0];

    var oUlBig = getByClass(oDiv, "main_pic")[0];
    var aLiBig = oUlBig.getElementsByTagName("li");
    var nowZIndex = 2;
    var now = 0;

    oBtnLeft.onmouseover = function () {
        startMove(oBtnLeft, "opacity", 100);
    };
    oBtnLeft.onmouseout = function () {
        startMove(oBtnLeft, "opacity", 0);
    };
    oBtnRight.onmouseover = function () {
        startMove(oBtnRight, "opacity", 100);
    };
    oBtnRight.onmouseout = function () {
        startMove(oBtnRight, "opacity", 0);
    };


//    for (var i = 0; i < aLiBig.length; i++) {
//        aLiBig[i].index = i;
//        aLiBig[i].onclick = function () {
//            if (this.index == now) return;
//            now = this.index;
//
//            tab();
//        };
//    }

    function tab() {
        aLiBig[now].style.zIndex = nowZIndex++;
         aLiBig[now].style.height = 0;
         startMove(aLiBig[now], "height", 356);
    }

    oBtnLeft.onclick = function () {
        now--;
        if (now == -1) {
            now = aLiBig.length - 1;
        }
        tab();
    };
    oBtnRight.onclick = function () {
        now++;
        if (now == aLiBig.length) {
            now = 0;
        }
        tab();
    }
    var timer = setInterval(oBtnRight.onclick, 2000);
    oDiv.onmouseover = function () {
        oDiv.style.cursor = "pointer";
        clearInterval(timer);
    };
    oDiv.onmouseout = function () {
        timer = setInterval(oBtnRight.onclick, 2000);
    };
};