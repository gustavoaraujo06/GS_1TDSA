let sideBar = document.getElementById("sideBar")
let navItem = document.getElementsByClassName("navItem")
let nav =  document.getElementById("sideBar")
nav.style.width = "0px";

function openNav() {
    nav.style.width = "250px";
    console.log(navItem)
    for(let i = 0; i < navItem.length; i++){
        navItem[i].style.display = "block";
    }
};

function closeNav() {
    nav.style.width = "0";
    for(let i = 0; i < navItem.length; i++){
        navItem[i].style.display = "none";
    }

};