package ro.mihai.pocjava.domain.exception;

/**
 * Created by mihai on 16.10.2017.
 */

public class DefaultErrorBundle implements ErrorBundle {
    private final static String DEFAULT_ERROR_MSG = "Unknown error";
    private final Exception exception;

    public DefaultErrorBundle(Exception exception) {
        this.exception = exception;
    }

    @Override
    public String getErrorMessage() {
        return exception != null ? exception.getMessage() : DEFAULT_ERROR_MSG;
    }

    @Override
    public Exception getException() {
        return exception;
    }
}
