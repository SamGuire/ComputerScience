import * as express from "express";
import { Express, Request, Response } from "express";
import Db from "./db/twitter.db";
import IHomeTimeline from "./models/home.timeline.model";
import * as dotenv from "dotenv";

dotenv.config();
import {
  getAllUsers,
  getUserById,
  getUserHomeTimeline,
  postTweet,
} from "./services/twitter.services";

const app: Express = express();
const PORT: number = 3000;
app.use(express.json());
app.get("/", (req: Request, res: Response) => {
  res.send("Hello from express");
});

app.get("/users", async (req: Request, res: Response) => {
  const data = await getAllUsers().catch((err) => {
    res.json(err);
  });
  res.json(data);
});

app.get("/users/:id", async (req: Request, res: Response) => {
  const { id, _ } = req.params;
  const data = await getUserById(id).catch((err) => {
    res.json(err);
  });
  res.json(data);
});
app.get("/timeline/:id", async (req: Request, res: Response) => {
  const { id, _ } = req.params;
  const data = await getUserHomeTimeline(id).catch((err) => {
    res.json(err);
  });
  res.json(data);
});

app.post("/post_tweet/:id", async (req: Request, res: Response) => {
  console.log(req.body);
  const { id, _ } = req.params;
  const { tweet } = req.body;
  const data = await postTweet(id, tweet).catch((err) => {
    res.json(err);
  });
  res.json(data);
});

app.listen(PORT, "127.0.0.1", () => {
  console.log(`Server listening on port ${PORT} in ${process.env.NODE_ENV}`);
});
