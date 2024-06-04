let sideBar = document.getElementById("sideBar")
let navItem = document.getElementsByClassName("navItem")



function openNav() {
    document.getElementById("sideBar").style.width = "250px";
    console.log(navItem)
    for(let i = 0; i < navItem.length; i++){
        navItem[i].style.display = "block";
    }
};

function closeNav() {
    document.getElementById("sideBar").style.width = "0";
    for(let i = 0; i < navItem.length; i++){
        navItem[i].style.display = "none";
    }

};