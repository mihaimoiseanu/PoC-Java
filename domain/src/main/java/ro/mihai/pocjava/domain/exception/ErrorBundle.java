package ro.mihai.pocjava.domain.exception;

/**
 * Created by mihai on 16.10.2017.
 */

public interface ErrorBundle {
    String getErrorMessage();

    Exception getException();
}
