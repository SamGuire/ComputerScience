export class TwitterServiceError extends Error {
  public err_msg: string;
  constructor(
    public message: string = "Error occured",
    public httpCode: number = 500
  ) {
    super(message);
    this.err_msg = message;
  }
}
