import { QueryError } from "mysql2";
import { getCachedTimeline, updateFollowerTimeline } from "../db/in.memory.db";
import pool, { DB_NAME } from "../db/twitter.db";
import { TwitterServiceError } from "../error/error";
import { IFollow } from "../models/follow.model";
import IHomeTimeline, { ITweet } from "../models/home.timeline.model";
import { IUser } from "../models/user.model";

export async function getAllUsers(): Promise<IUser[]> {
  try {
    const query_statement = `SELECT * FROM ${DB_NAME}.users`;
    const [rows, _]: [IUser[], any[]] = await pool
      .promise()
      .query(query_statement);
    return rows;
  } catch (err) {
    console.error(err);
    throw new TwitterServiceError(err.code, 500);
  }
}

export async function getAllFollowers(id: number): Promise<IFollow[]> {
  try {
    const query_statement = `SELECT follower_id,followee_id FROM ${DB_NAME}.follows WHERE followee_id = ?`;
    const [rows, _]: [IFollow[], any[]] = await pool
      .promise()
      .query(query_statement, [id]);
    return rows;
  } catch (err) {
    console.error(err);
    const error = new TwitterServiceError(err.code, 500);
    throw error;
  }
}

export async function getUserById(id: number): Promise<IUser> {
  try {
    const query_statement = `SELECT * FROM ${DB_NAME}.users WHERE id= ?`;
    const [rows, _]: [IUser[], any[]] = await pool
      .promise()
      .query(query_statement, [id]);
    return rows[0];
  } catch (err) {
    console.error(err);
    const error = new TwitterServiceError(err.code, 500);
    throw error;
  }
}
export async function getUserHomeTimelineFromDB(
  id: number
): Promise<IHomeTimeline> {
  try {
    const user_table = `${DB_NAME}.users`;
    const follows_table = `${DB_NAME}.follows`;
    const tweets_table = `${DB_NAME}.tweets`;
    const query_statement: string =
      `SELECT ${user_table}.*,  ${tweets_table}.* FROM ` +
      `${user_table} JOIN ${follows_table} ON ${user_table}.id = ${follows_table}.followee_id ` +
      `JOIN ${tweets_table} on ${tweets_table}.sender_id = ${follows_table}.followee_id ` +
      `WHERE ${follows_table}.follower_id = ? ` +
      `ORDER BY ${tweets_table}.tweet_created_date DESC`;
    const [rows, _]: [any[], any[]] = await pool
      .promise()
      .query(query_statement, [id]);

    const returnedData: IHomeTimeline = {
      user_id: id,
      timeline: rows.map((v) => {
        const { sender_id, content, tweet_created_date }: ITweet = v;
        return { sender_id, content, tweet_created_date };
      }),
    };
    return returnedData;
  } catch (err) {
    console.error(err);
    const error = new TwitterServiceError(err.code, 500);
    throw error;
  }
}
export async function getUserHomeTimeline(id: number): Promise<IHomeTimeline> {
  try {
    const timeline = await getCachedTimeline(id);
    return timeline;
  } catch (err) {
    console.error(err);
    const error = new TwitterServiceError(err.code, 500);
    throw error;
  }
}

export async function postTweet(id: number, tweet: string) {
  try {
    const tweets_table = `${DB_NAME}.tweets`;
    const tweet_created_date: string = new Date()
      .toISOString()
      .slice(0, 19)
      .replace("T", " ");
    const newTweet: ITweet = {
      sender_id: id,
      content: tweet,
      tweet_created_date: tweet_created_date,
    };
    const query_statement = `INSERT INTO ${tweets_table} (sender_id,content,tweet_created_date) values (?,?,?)`;
    const [{ insertedId }, _]: [any, any[]] = await pool
      .promise()
      .query(query_statement, [id, tweet, tweet_created_date]);
    await updateFollowerTimeline(id, newTweet);
    return insertedId;
  } catch (err) {
    console.error(err);
    const error = new TwitterServiceError(err.code, 500);
    throw error;
  }
}
