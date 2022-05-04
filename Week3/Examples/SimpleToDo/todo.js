
var form = document.getElementById("new-item-form");
var input = document.querySelector("body > form > input[type=text]");
var itemList = document.getElementById("item-list");

//But now we want to register an event listener for on submit of the form
form.addEventListener('submit', addTodo);

itemList.addEventListener('click', removeTodo);

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

    li.setAttribute("class", "item");

    var p = document.createElement("p");
    p.innerText = task;
    li.append(p);
    var btn = document.createElement("button");
    btn.setAttribute("class", "delete-btn");
    btn.innerText = "Delete Task";

    li.append(btn);
    
    itemList.appendChild(li);

}

function removeTodo(e){
    var todo = e.target.parentElement;
    itemList.removeChild(todo);
}

/* There is a better way to this
function appendElement(task){

    var li = document.createElement("li");

    li.setAttribute("class", "item");

    var p = document.createElement("p");
    p.innerText = task;
    li.append(p);
    var btn = document.createElement("button");
    btn.setAttribute("class", "delete-btn");
    btn.innerText = "Delete Task";

    btn.addEventListener('click', removeTodo);

    li.append(btn);
    
    itemList.appendChild(li);

}

function removeTodo(e){
    var todo = e.target.parentElement;
    itemList.removeChild(todo);
}
*/