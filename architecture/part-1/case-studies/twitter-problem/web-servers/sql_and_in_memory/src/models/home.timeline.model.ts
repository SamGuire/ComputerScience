export default interface IHomeTimeline {
  user_id: number;
  timeline: ITweet[];
}

export interface ITweet {
  sender_id: number;
  content: string;
  tweet_created_date: string;
}
