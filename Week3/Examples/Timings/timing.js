let timeout;
let interval;
let seconds = 0;
let timeoutButton = document.getElementById("timeout-btn").addEventListener('click', () => {
    timeout = window.setTimeout(()=> console.log("Timed out after 5 s"), 5000);
});

let stopTimeButton = document.getElementById("stop-time-btn").addEventListener('click', () => {
    window.clearTimeout(timeout);
});

let startIntButton = document.getElementById("start-interval").addEventListener('click', () => {
    interval = window.setInterval(()=>{
        seconds++;
        console.log(`${seconds} seconds have elapsed`);
    }, 1000);
});

let stopIntButton = document.getElementById("stop-interval").addEventListener('click', () => {
    seconds = 0;
    window.clearInterval(interval);
});