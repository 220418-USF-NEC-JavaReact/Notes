console.log(a, b);

var a;

a = "I am global scope, and my declaration was hoisted";

var b = "Hoist me too";

console.log(a, b);


function hoistMeCaptain(){

    console.log("C is hoisted:", c);

    var c = "I cannot be hoisted out of function scope";


    if(0){
        //To prevent d from being pulled out of block scope, we must use let or const
        let d = "I am block scope, am I safe from hoisting?";
        console.log(d);
    }

    console.log("Can I access d outside of the if?", d);
}

hoistMeCaptain();

//We wont be able to access c, because it has function scope
//console.log(c);