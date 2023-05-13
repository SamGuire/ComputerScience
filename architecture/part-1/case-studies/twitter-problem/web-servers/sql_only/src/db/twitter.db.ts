import * as mysql2 from "mysql2";
import { Pool } from "mysql2";
import { IUser } from "../models/user.model";
import * as dotenv from "dotenv";
import Connection = require("mysql2/typings/mysql/lib/Connection");
dotenv.config();
export const DB_NAME: string = "twitter_db";
const CONNECTION_LIMIT: number = 100;
const connectionPool: Pool = mysql2.createPool({
  connectionLimit:CONNECTION_LIMIT,
  host: process.env.MYSQL_HOST,
  user: process.env.MYSQL_USER,
  password: process.env.MYSQL_PASSWORD,
  database: DB_NAME,
});


export default connectionPool;
