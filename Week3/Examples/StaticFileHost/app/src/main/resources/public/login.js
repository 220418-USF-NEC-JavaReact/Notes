let loginForm = document.getElementById("login-form");

//Lets do our event listener
loginForm.addEventListener('submit', handleLogin);

function handleLogin(e){

    e.preventDefault();
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    console.log(`Logging in user: ${username} with password ${password}`);

}