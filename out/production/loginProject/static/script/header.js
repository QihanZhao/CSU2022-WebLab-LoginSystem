// function animate({ timing, draw, duration }) {

//     let start = performance.now();

//     requestAnimationFrame(function animate(time) {
//         // timeFraction 从 0 增加到 1
//         let timeFraction = (time - start) / duration;
//         if (timeFraction > 1) timeFraction = 1;

//         // 计算当前动画状态
//         let progress = timing(timeFraction);

//         draw(progress); // 绘制

//         if (timeFraction < 1) {
//             requestAnimationFrame(animate);
//         }

//     });
// }

// let dropdownContent = document.querySelector(".topFix .dropdown .dropdownContent");
// let topdropdown = document.querySelector(".topFix .dropdown");

// dropdownContent.style.visibility = "hidden"
// dropdownContent.style.display = "grid"
// let hVal = dropdownContent.offsetHeight;
// // let hVal = h.substring(0, h.length - 2)
// dropdownContent.style.offsetHeight = 0
// // dropdownContent.style.display = "none"
// dropdownContent.style.visibility = "visible"


// topdropdown.onmouseover = () => {
//     // dropdownContent.setAttribute("state", "show");
//     //
//     // dropdownContent.style.height = 0
//     // dropdownContent.style.display = "grid";

//     animate({
//         duration: 1000,
//         timing(timeFraction) {
//             return timeFraction;
//         },
//         draw(progress) {

//             dropdownContent.offsetHeight = progress * hVal + 'px';

//         }
//     })

//     // dropdownContent.style.display = "grid"

// }

// topdropdown.onmouseout = () => {
//     // dropdownContent.setAttribute("state", "hide")

//     animate({
//         duration: 1000,
//         timing(timeFraction) {
//             return timeFraction;
//         },
//         draw(progress) {
//             dropdownContent.offsetHeight = (1 - progress) * hVal + 'px';


//         }
//     })

//     // dropdownContent.style.display = "none";

//     // dropdownContent.style.height = "auto"
// }
