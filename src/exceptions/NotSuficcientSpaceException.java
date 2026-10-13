package exceptions;

public class NotSuficcientSpaceException extends RuntimeException {
    public NotSuficcientSpaceException(String message) {
        super(message);
    }
}
