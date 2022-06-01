const express = require('express');
const cors = require('cors');
const generate = require('./random-string.js');
const querystring = require('querystring');
const puppeteer = require('puppeteer');
const axios = require('axios');

const CLIENT_ID = process.env.SP_CLIENT_ID;
const CLIENT_SECRET = process.env.SP_CLIENT_SECRET;
const REDIRECT = 'http://localhost:8080/callback';
const STATE = generate(16);
const PASS = process.env.PASS;

let refresh;

const app = express();

app.use(cors());

app.get('/login', async (req, res) => {
    let scope = 'user-read-private user-read-email playlist-read-collaborative';
    let tokenURL = 'https://accounts.spotify.com/authorize?' +
    querystring.stringify({
      response_type: 'code',
      client_id: process.env.SP_CLIENT_ID,
      scope: scope,
      redirect_uri: REDIRECT,
      state: STATE
    });

    const browser = await puppeteer.launch({headless: false});
    const page = await browser.newPage();

    await page.goto(tokenURL);

    await page.focus('#login-username');
    await page.keyboard.type('ethanlmcgill@gmail.com');
    
    await page.focus('#login-password');
    await page.keyboard.type(PASS);

    //await page.screenshot({path: 'screenshot.png'});

    await page.click('#login-button');

    await page.waitForSelector('pre', { visible: true, timeout: 0 });

    let text = await page.$eval('pre', el => el.textContent);

    await browser.close();

    let data = JSON.parse(text);

    refresh = data.refresh_token;

    console.log(refresh);
    
    res.json(data);

});

app.get('/callback', async (req, res) => {

    console.log("made it to callback");

    let code = req.query.code;

    console.log(code);

    let url = 'https://accounts.spotify.com/api/token';

    
    let request = await axios({
        method: 'POST',
        url,
        data: querystring.stringify({
            code,
            redirect_uri: REDIRECT,
            grant_type: 'authorization_code'
        }),
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Authorization': 'Basic ' + (new Buffer(CLIENT_ID + ':' + CLIENT_SECRET).toString('base64'))
        }
    });

    let data = await request.data;
    
    res.json(data);

});

app.get('/refresh', async (req, res) => {

    let url = 'https://accounts.spotify.com/api/token'

    let request = await axios({
        method: 'POST',
        url,
        data: querystring.stringify({
            grant_type: 'refresh_token',
            refresh_token: refresh
        }),
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
            'Authorization': 'Basic ' + (new Buffer(CLIENT_ID + ':' + CLIENT_SECRET).toString('base64'))
        }
    });

    res.json(request.data);

});

app.listen(8080, () => {
    console.log("Server started on port 8080")
});