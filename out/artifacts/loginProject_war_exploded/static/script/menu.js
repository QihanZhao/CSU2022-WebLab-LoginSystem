let items = document.querySelectorAll(".menu a");
let buttonToLeft = document.querySelector(".menu .buttonToLeft");
let buttonToRight = document.querySelector(".menu .buttonToRight");

let state = "short"
for (let i = 0; i < items.length; i++) {
    items[i].onmouseover = () => {
        items[i].className = "hover"
    }
    items[i].onmouseout = () => {
        items[i].className = state
    }
}

function animate({ timing, draw, duration }) {

    let start = performance.now();

    requestAnimationFrame(function animate(time) {
        // timeFraction 从 0 增加到 1
        let timeFraction = (time - start) / duration;
        if (timeFraction > 1) timeFraction = 1;

        // 计算当前动画状态
        let progress = timing(timeFraction);

        draw(progress); // 绘制

        if (timeFraction < 1) {
            requestAnimationFrame(animate);
        }

    });
}


buttonToLeft.addEventListener('click', () => {


    for (let i = 0; i < items.length; i++) {

        state = "long";
        items[i].className = state;

        // V0 无动画
        // items[i].style = "right:80px";
        // items[i].setAttribute('style', 'right:80px')

        // V1 setInterval
        // let delay = 1000 / 50;
        // let start = Date.now();
        // let timer = setInterval(() => {
        //     let timePassed = Date.now() - start;
        //     if (timePassed >= 500) {
        //         clearInterval(timer);
        //         return;
        //     }
        //     items[i].style.right = (80 / 500) * timePassed + 'px'

        // V2 requestAnimationFrame
        // animate({
        //     duration: 1000,
        //     timing(timeFraction) {
        //         return timeFraction;
        //     },
        //     draw(progress) {
        //         items[i].style.right = progress * 80 + 'px'
        //     }
        // })

        // }, delay)

    }

    buttonToRight.hidden = false
    buttonToLeft.hidden = true
})

buttonToRight.addEventListener('click', () => {

    let start = null
    for (let i = 0; i < items.length; i++) {
        state = "short";
        items[i].className = state;

        // items[i].style = "right:0px";
        // items[i].style.right = "0px";
        // items[i].setAttribute('style', 'right:0px')
    }

    buttonToRight.hidden = true
    buttonToLeft.hidden = false
})