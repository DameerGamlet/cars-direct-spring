package car.direct.exception;

public class UserNotVerifiedYetException extends RuntimeException {

    public UserNotVerifiedYetException(String message) {
        super(message);
    }
}