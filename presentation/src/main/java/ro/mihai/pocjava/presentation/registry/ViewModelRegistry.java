package ro.mihai.pocjava.presentation.registry;

import android.support.annotation.NonNull;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import ro.mihai.pocjava.presentation.ui.base.BaseViewModel;

/**
 * Created by mihai on 17.10.2017.
 */

public class ViewModelRegistry {
    private final Map<String, BaseViewModel> VIEW_MODEL_CACHE = new ConcurrentHashMap<>();

    public <P extends BaseViewModel> P get(@NonNull Class<P> viewModelClass) {
        Objects.requireNonNull(viewModelClass);
        try {
            final String presenterKey = viewModelClass.getName();
            if (!VIEW_MODEL_CACHE.containsKey(presenterKey)) {
                VIEW_MODEL_CACHE.put(presenterKey, viewModelClass.newInstance());
            }
            //noinspection unchecked
            return (P) VIEW_MODEL_CACHE.get(presenterKey);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new IllegalStateException("unable to instantiate viewModel of class: " + viewModelClass.getName() + ". forgot default constructor?", e);
        }
    }

    public void clear() {
        VIEW_MODEL_CACHE.clear();
    }

    public <P extends BaseViewModel> void remove(@NonNull Class<P> viewModelClass) {
        VIEW_MODEL_CACHE.remove(viewModelClass.getName());
    }
}
