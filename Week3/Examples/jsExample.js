//To print to the console in the web browser we use console.log()
console.log("Hello JS");

//We can of course store things inside of variables

var num = 6;
var num2 = 7;

console.log(num + num2);

var obj = {
    name: "Ethan",
    title: "Senior Trainer",
    company: "Revature"
}

console.log(obj);

//Access properties of the object in 2 ways
console.log("Name: ", obj.name);

console.log("Title: ", obj["title"]);

//How we can change the properties of the object
obj.name = "Ethan McGill";

console.log("After name change", obj);

obj["company"] = "Apple";

console.log("After company change", obj);

//We can also add a new property
obj.salary = 5000000000;

console.log("Adding a salary", obj);

//We must call this explicitly otherwise nothing will happen
function returnAnything(x){
    console.log(x);
    if(x == 1){
        return 1;
    }
    if(x == 2){
        return "X is 2";
    }
    if(x == 3){
        return {
            input: x,
            message: "x is three"
        }
    }
}

console.log(returnAnything(1));
console.log(returnAnything(2));
console.log(returnAnything(3));

var obj2 = returnAnything(3);
console.log("We stored the return of the function in a var", obj2);