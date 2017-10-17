package ro.mihai.pocjava.presentation.views;

/**
 * Created by mihai on 17.10.2017.
 */

public interface ActionHandler<T> {
    void onItemClick(T item);
}
