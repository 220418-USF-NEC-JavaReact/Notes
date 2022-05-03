
var form = document.getElementById("new-item-form");
var input = document.querySelector("body > form > input[type=text]");
var itemList = document.getElementById("item-list");

//But now we want to register an event listener for on submit of the form
form.addEventListener('submit', addTodo);

function printChange(e){
    //console.log("on change being called");
    console.log(e.target.value);
}

function addTodo(e){
    //We can prevent the html form from trying to send an http request by using
    e.preventDefault();
    console.log("The user inputed this data: ", input.value);
    appendElement(input.value);
    input.value = "";
}

function appendElement(task){

    var li = document.createElement("li");
    /*
    li.innerHTML = "<p>" + task + "</p>"
    */
    var div = document.createElement("div");
    div.setAttribute("class", "item");
    var p = document.createElement("p");
    p.innerText = task;
    div.appendChild(p);
    li.appendChild(div);
    
    itemList.appendChild(li);

}