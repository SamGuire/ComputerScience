import IHomeTimeline, { ITweet } from "../models/home.timeline.model";
import { IUser } from "../models/user.model";
import {
  getAllFollowers,
  getAllUsers,
  getUserHomeTimeline,
  getUserHomeTimelineFromDB,
} from "../services/twitter.services";
import { createClient } from "redis";
import { TwitterServiceError } from "../error/error";
import { IFollow } from "../models/follow.model";

let redisClient;
export async function initInMemoryDB() {
  redisClient = createClient();

  redisClient.on("error", (error) => console.error(`Error : ${error}`));

  await redisClient.connect();
  if (redisClient.isReady) {
    console.log("ready");
    await initalizedHomeTimelineCache(redisClient);
    return redisClient;
  } else {
    throw new TwitterServiceError("Could not connect to redis...", 500);
  }
}

async function initalizedHomeTimelineCache(redisClient) {
  try {
    const users: IUser[] = await getAllUsers();
    for (const user of users) {
      console.log(`creating timeline for user ${user.id}`);
      const userTimeline: IHomeTimeline = await getUserHomeTimelineFromDB(
        user.id
      );
      await redisClient.json.set(
        user.id.toString(),
        "$",
        JSON.stringify(userTimeline)
      );
    }
  } catch (err) {
    if (err instanceof TwitterServiceError) throw err;
    console.error("ERRROR", err);
    throw new TwitterServiceError("Error with redis", 500);
  }
}

export async function updateFollowerTimeline(
  followee_id: number,
  new_tweet: ITweet
) {
  try {
    const follows: IFollow[] = await getAllFollowers(followee_id);
    for (const follow of follows) {
      const { follower_id, _ }: IFollow = follow;
      const cacheData: string = await redisClient.json.get(
        follower_id.toString()
      );
      const jsonCachedData: IHomeTimeline = JSON.parse(cacheData);
      jsonCachedData.timeline.pop();
      jsonCachedData.timeline.unshift(new_tweet);
      await redisClient.json.set(
        follower_id.toString(),
        "$",
        JSON.stringify(jsonCachedData)
      );
    }
  } catch (err) {
    if (err instanceof TwitterServiceError) throw err;
    throw new TwitterServiceError("Error with redis", 500);
  }
}

export async function getCachedTimeline(id: number): Promise<IHomeTimeline> {
  try {
    const cachedTimeline: string = await redisClient.json.get(id.toString());
    return JSON.parse(cachedTimeline);
  } catch (err) {
    if (err instanceof TwitterServiceError) throw err;
    throw new TwitterServiceError("Error with redis", 500);
  }
}
