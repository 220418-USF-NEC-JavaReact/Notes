/*
Hip hop and rap:
https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=0&limit=100
https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=100&limit=100
https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=200&limit=100
https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=300&limit=100
https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=400&limit=100
https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=500&limit=100
https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=600&limit=100
https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=700&limit=100

This fire:
https://api.spotify.com/v1/playlists/22h7UbYTTQxtQ3gtOmnAGe

Country:
https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM

CSV Rock and Other
https://api.spotify.com/v1/playlists/6d2IfkN1R6p6mrXppqvgSp/tracks?offset=0&limit=100
https://api.spotify.com/v1/playlists/6d2IfkN1R6p6mrXppqvgSp/tracks?offset=100&limit=100

Make a call to the chinook database for more
*/

const axios = require('axios');
const {Client} = require('pg');
const mongoose = require('mongoose');
const fs = require('fs');
const csv = require('csv-parser');
const {Song} = require('./song.js');

const token = 'BQDvaF5KsZSYoqO2QHXeIZgdaodXGgOrIK53uSdUqrHxf4dbdvO2aOeE7ovuM7kd4FR_vGl7YNUWGFj8_5jCDWUVMXd5GEtZZ5TYW91m3bK6fwYza7d7Dkw32zUAhFnsbsb_-vHu9E00NqmY8ElIqBZS8rw8LN7TA99W90s';

const mongoURI = 'mongodb+srv://revauser:p4ssw0rd@revcluster.flgkt.mongodb.net/?retryWrites=true&w=majority';

async function makeSpotifyCall(url){
    return axios.get(url, {
        headers: {
            'Authorization': `Bearer ${token}`
        }
    });
}

/* Extract */

async function extractChinookData(){

    let results = [];

    const client = new Client({
        user: 'chinook',
        host: 'localhost',
        database: 'chinook',
        password: 'password',
        port: 5432
    });

    client.connect();

    const query = 'select t.trackid as id, t.name, t.composer, t.milliseconds, a3.albumid as albumid, a3.title as albumname, a3.name as artist from track t inner join (select * from album a inner join artist a2 on a.artistid = a2.artistid) as a3 on t.albumid = a3.albumid';

    try{
        results = await client.query(query);
    } catch(e){
        console.log(e);
    }

    console.log(results.rows);

    client.end();

    return results.rows;
}

async function extractHipHopData(){

    const allHipHop = Promise.all([
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=0&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=100&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=200&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=300&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=400&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=500&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=600&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/6UfAWyAXNtl6QLd3TN4aGa/tracks?offset=700&limit=100')
    ]);

    const [req1, req2, req3, req4, req5, req6, req7, req8] = await allHipHop;

    let data = [
        ...req1.data.items,
        ...req2.data.items,
        ...req3.data.items,
        ...req4.data.items,
        ...req5.data.items,
        ...req6.data.items,
        ...req7.data.items,
        ...req8.data.items
    ];

    console.log(data);

    return data;
}

//extractHipHopData();

async function extractThisFire(){
    const allThisFire = Promise.all([
        makeSpotifyCall('https://api.spotify.com/v1/playlists/22h7UbYTTQxtQ3gtOmnAGe/tracks?offset=0&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/22h7UbYTTQxtQ3gtOmnAGe/tracks?offset=100&limit=100')
    ]);

    const [req1, req2] = await allThisFire;

    let data = [
        ...req1.data.items,
        ...req2.data.items
    ];

    console.log(data);

    return data;
}

//extractThisFire();

async function extractCountry(){
    const allCountry = Promise.all([
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=0&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=100&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=200&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=300&limit=100'),
        makeSpotifyCall('https://api.spotify.com/v1/playlists/5dAG5sZ5IN8yDwGqOQqrNM/tracks?offset=400&limit=100')
    ]);

    const [req1, req2, req3, req4, req5] = await allCountry;

    let data = [
        ...req1.data.items,
        ...req2.data.items,
        ...req3.data.items,
        ...req4.data.items,
        ...req5.data.items
    ];

    console.log(data);

    return data;
}

//extractCountry();

async function extractCSVData(){
    let data = [];

    await fs.createReadStream('rock.csv')
        .pipe(csv())
        .on('data', (row) => {
            let track = {
                id: row.id,
                name: row.name,
                artist: row.artist,
                album: row.title,
                duration: row.duration,
                trackNumber: row.trackNumber,
                releaseDate: row.releaseDate,
                trackUrl: row.trackUrl
            };
            data.push(track);
        }).on('end', () => {
            console.log(data);
        });

    return data;
}

//extractCSVData();

async function extractAllData(){
    let extract = Promise.all([
        extractChinookData(),
        extractHipHopData(),
        extractThisFire(),
        extractCountry(),
        extractCSVData()
    ]);

    const [chinook, hiphop, thisfire, country, csv] = await extract;

    let data = [...chinook, ...hiphop, ...thisfire, ...country, ...csv];

    console.log(data.length);

    return data;
}

//extractAllData();

/* Transform */

async function transformData(data){

    //Strip away unneeded data
    let transformed = data.map((track) => {

        //Our data from the database has an artist and milliseconds field
        if(track.artist && track.milliseconds){
            return {
                trackName: track.name,
                artistName: track.artist,
                album: track.albumname,
                duration: track.milliseconds
            }
        }

        //Our CSV data has an artist field and a duration field
        if(track.artist && track.duration){
            return {
                trackName: track.name,
                artistName: track.artist,
                album: track.title,
                duration: track.duration
            }
        }

        //Finally, our spotify data has a track object which store info
        if(track.track){
            return {
                trackName: track.track.name,
                artistName: track.track.artists[0].name,
                album: track.track.album.name,
                duration: track.track.duration_ms
            }
        }

    });

    let transformedDuration = transformed.map((track) => {
        let minutes = Math.floor(track.duration/60000);
        let seconds = ((track.duration/60000) - Math.floor(track.duration/60000))*60;

        if(seconds < 10){
            seconds = `0${Math.floor(seconds)}`;
        } else {
            seconds = Math.floor(seconds);
        }

        let duration = `${minutes}:${seconds}`;

        return {
            trackName: track.trackName,
            artistName: track.artistName,
            album: track.album,
            duration
        }
    });

    console.log(transformedDuration);

    return transformedDuration;

}

/* Load Data */

async function loadData(data){
    let numberOfLoaded = 0;

    await mongoose.connect(mongoURI, {useNewUrlParser: true, useUnifiedTopology: true});

    for(let track of data){
        console.log('Processing: ', track);
        
        let song = new Song(track);

        await song.save();

        numberOfLoaded++;

        console.log(`Processed: ${numberOfLoaded}`);
    }

    mongoose.connection.close();
}

async function etl(){
    let data = await extractAllData();

    let transformedData = await transformData(data);

    await loadData(transformedData);
}

etl();