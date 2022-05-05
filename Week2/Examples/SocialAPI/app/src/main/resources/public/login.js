let loginForm = document.getElementById("login-form");

//Lets do our event listener
loginForm.addEventListener('submit', handleLogin);

function handleLogin(e){

    e.preventDefault();
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    let login = {
        email: username,
        password
    };

    //1. Create our object
    let xhr = new XMLHttpRequest();

    //2. Open the connection
    xhr.open("POST", "http://localhost:8000/users/login");

    //Telling the server, this request is going to contain json
    xhr.setRequestHeader("Content-Type", "application/json");

    //3. set the onreadystatechange
    xhr.onreadystatechange = function () {
        if(this.readyState === 4){
            let res = this.responseText;
            let status = this.status;
            console.log("res:", res);
            console.log("status:", status);
            if(status == 200){
                let user = JSON.parse(res);
                console.log(user);
                window.location.href = "http://localhost:8000/feed.html"
            }
            else {
                document.getElementById("error").innerText = "Username or password incorrect";
            }
        }
    }

    //4. Send the request and wait
    xhr.send(JSON.stringify(login));

}