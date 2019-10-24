window.onload = initLinkStyle;
function initLinkStyle() {
    if(document.getElementsByName('myset')){
        var arrLink = document.getElementsByName('myset');
        for(i = 0; i < arrLink.length; i++) {
            var link = arrLink[i];
            link.className='ts_sel';       
            link.onclick = clickNav;   
        }
    }
}

/**
 * 执行点击事件
 * @param {Object} event 鼠标事件
 */

function clickNav(event) {
    var target = event.currentTarget;   
    //上次选择的a的样式
    if(document.getElementsByName('myset')){
        var arrLink = document.getElementsByName('myset');
        for(i = 0; i < arrLink.length; i++) {
            var link = arrLink[i];
            if(link.className == 'ts_seled') {
                link.className = 'ts_sel';
            }
        }
    }
    target.className = 'ts_seled';
    return false;//阻止浏览器默认事件

}