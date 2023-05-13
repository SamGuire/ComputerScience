import { RowDataPacket } from "mysql2";

export interface IFollow extends RowDataPacket {
  follower_id: number;
  followee_id: number;
}
