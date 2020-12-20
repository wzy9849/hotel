package exception;

public class WrongPwdException extends Exception {
    public WrongPwdException() {
        super();
    }

    public WrongPwdException(String message) {
        super(message);
    }

    public WrongPwdException(Throwable cause) {
        super(cause);
    }

    protected WrongPwdException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
