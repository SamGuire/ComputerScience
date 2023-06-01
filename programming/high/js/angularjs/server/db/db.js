let sqlite3 = require("sqlite3");
const db = new sqlite3.Database("./db/my_db.db");
module.exports = db;
