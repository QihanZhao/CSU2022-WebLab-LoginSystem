let buttonLeft = document.querySelector(".buttonLeft");
let buttonRight = document.querySelector(".buttonRight");
// let images = document.getElementsByClassName("images");
let images = document.querySelector(".images");
let thumbnail = document.getElementsByClassName("thumbnail");


let dropdown = 0;
// images.style.left = '-' + index + '00%'
console.log(images.children.length)
// console.log(images.style.left)

function reposition() {
    images.style.left = '-' + dropdown + '00%'
    console.log(images.style.left)
}
// reposition();

let timer
function autoPlay() {
    timer = setInterval(() => {
        dropdown = (dropdown + 1) % images.children.length;
        reposition();
    }, 3000)
}

buttonLeft.addEventListener('click', () => {
    dropdown = (dropdown + 1) % images.children.length
    clearInterval(timer);
    reposition();
    autoPlay();
})

buttonRight.addEventListener('click', () => {
    dropdown = (dropdown - 1 + images.children.length) % images.children.length
    clearInterval(timer);
    reposition();
    autoPlay();
})

for (let i = 0; i < thumbnail[0].children.length; i++) {
    thumbnail[0].children[i].addEventListener('click', () => {
        dropdown = i;
        console.log(dropdown)
        clearInterval(timer);
        reposition();
        autoPlay();
    })
}

autoPlay()
