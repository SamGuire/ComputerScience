export default interface IHomeTimeline {
  user_id: string;
  timeline: ITimeline[];
}

export interface ITimeline {
  sender_id: number;
  content: string;
  tweet_created_date: string;
}
