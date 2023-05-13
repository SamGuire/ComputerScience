"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.DB_NAME = void 0;
var mysql2 = require("mysql2");
var dotenv = require("dotenv");
dotenv.config();
exports.DB_NAME = "twitter_db";
var connectionPool = mysql2.createPool({
    connectionLimit: 5,
    host: process.env.MYSQL_HOST,
    user: process.env.MYSQL_USER,
    password: process.env.MYSQL_PASSWORD,
    database: exports.DB_NAME,
});
connectionPool.on("connection", function (connection) {
    console.log("Connection has been made with connection_id=".concat(connection.threadId));
});
connectionPool.on("release", function (connection) {
    console.log("Connection has been released with connection_id=".concat(connection.threadId));
});
exports.default = connectionPool;
