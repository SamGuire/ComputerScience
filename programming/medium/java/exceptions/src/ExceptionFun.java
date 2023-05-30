public class ExceptionFun extends Exception {

    public enum HTTPCODE {
        NOTFOUND ("Page not found",404),
                SERVERERROR ("Server Error",500);

        public final String description;
        private final int code;

        HTTPCODE(String description,int code) {
            this.description = description;
            this.code = code;
        }
    }

    private HTTPCODE code;
    public ExceptionFun(String msg,HTTPCODE code)  {
        super(msg);
        this.code = code;
    }

    @Override
    public String getMessage() {
        return String.format("Exception in making an HTTP Request, Error code: %d",this.code.code);
    }
}
