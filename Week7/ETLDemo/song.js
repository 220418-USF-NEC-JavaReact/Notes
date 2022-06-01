const mongoose = require('mongoose');

const Song = new mongoose.Schema({
    trackName: String,
    artistName: String,
    album: String,
    duration: String
});

module.exports.Song = mongoose.model('Song', Song);