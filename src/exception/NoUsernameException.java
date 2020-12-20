package exception;

public class NoUsernameException extends Exception {
    public NoUsernameException() {
        super();
    }

    public NoUsernameException(String message) {
        super(message);
    }

    public NoUsernameException(Throwable cause) {
        super(cause);
    }

    protected NoUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
