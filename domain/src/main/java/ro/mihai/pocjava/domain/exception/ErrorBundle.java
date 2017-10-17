package ro.mihai.pocjava.domain.exception;

/**
 * Created by mihai on 16.10.2017.
 */

/**
 * Interface to represent a wrapper around an {@link Exception} to manage errors.
 */
public interface ErrorBundle {
    String getErrorMessage();

    Exception getException();
}
