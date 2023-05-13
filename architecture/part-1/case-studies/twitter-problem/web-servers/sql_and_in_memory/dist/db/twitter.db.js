"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.DB_NAME = void 0;
var mysql2 = require("mysql2");
var dotenv = require("dotenv");
dotenv.config();
exports.DB_NAME = "twitter_db";
var CONNECTION_LIMIT = 100;
var connectionPool = mysql2.createPool({
    connectionLimit: CONNECTION_LIMIT,
    host: process.env.MYSQL_HOST,
    user: process.env.MYSQL_USER,
    password: process.env.MYSQL_PASSWORD,
    database: exports.DB_NAME,
});
exports.default = connectionPool;
