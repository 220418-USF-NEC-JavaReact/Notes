//This will give us access to the element in our events.html page with the id of "header"
var headerElement = document.getElementById("header");

console.log(headerElement);

var h1Text = headerElement.innerText;

console.log(h1Text);

headerElement.innerText = "I changed the text with JS";

console.log(headerElement.parentNode);

//Get the parent element in question
var parentElement = document.getElementById("lotsOfChildren");
console.log(parentElement);

//console.log(parentElement.firstChild);
//console.log(parentElement.firstChild.parentElement.firstChild);


function getNthChild(num){
    var child = parentElement.firstChild;
    if(num == 1){
        console.log("Inside of the num == 1");
        return child;
    }
    else{
        index = 1;
        while(index <= num){
            child = child.nextElementSibling;
            index++;
        }
    }

    return child;
}

console.log(getNthChild(5));


var children = document.getElementsByClassName("child");
console.log(children);
console.log(children[3]);