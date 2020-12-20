package exception;

public class WrongOriginPwdException extends Exception {
    public WrongOriginPwdException() {
        super();
    }

    public WrongOriginPwdException(String message) {
        super(message);
    }
}
